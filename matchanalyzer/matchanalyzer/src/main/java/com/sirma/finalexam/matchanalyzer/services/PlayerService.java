package com.sirma.finalexam.matchanalyzer.services;

import com.sirma.finalexam.matchanalyzer.dtos.create.CreatePlayerDTO;
import com.sirma.finalexam.matchanalyzer.entities.Player;
import com.sirma.finalexam.matchanalyzer.entities.Team;
import com.sirma.finalexam.matchanalyzer.enums.PlayerPosition;
import com.sirma.finalexam.matchanalyzer.exceptions.PlayerAlreadyExistsException;
import com.sirma.finalexam.matchanalyzer.exceptions.PlayerNotFoundException;
import com.sirma.finalexam.matchanalyzer.exceptions.TeamNotFoundException;
import com.sirma.finalexam.matchanalyzer.repositories.PlayerRepository;
import com.sirma.finalexam.matchanalyzer.repositories.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerService {
    //ID,TeamNumber,Position,FullName,TeamID

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerService.class);
    private PlayerRepository playerRepository;
    private TeamRepository teamRepository;
    private IdGenerationService<Player> idGenerationService;
    private NewLongIdGenerationService newLongIdGenerationService;

    public PlayerService(PlayerRepository playerRepository,
                         TeamRepository teamRepository,
                         IdGenerationService<Player> idGenerationService,
                         NewLongIdGenerationService newLongIdGenerationService) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.idGenerationService = idGenerationService;
        this.newLongIdGenerationService = newLongIdGenerationService;
    }

    public List<Player> getAllPlayers()
    {
        List<Player> players = this.playerRepository.findAll();
        return players;
    }

    public Player getPlayerById(Long playerId)
    {
        try {
            return this.playerRepository.findById(playerId)
                    .orElseThrow(() -> new PlayerNotFoundException("Player with ID: " + playerId + " not found."));
        } catch (PlayerNotFoundException e) {
            LOGGER.warn(e.getMessage());
            return null;
        }
    }

    @Transactional
    public Player createPlayer(CreatePlayerDTO playerDTO)
    {
        //add validation to see if manager already has a team
        //logic to get a unique id
        //save
        //check if player name already exists
        //check if player with the number in this team already exists
        //check if team exists
        //check if player position is valid
        String fullName = playerDTO.getFullName();
        Long teamId = playerDTO.getTeamId();
        Long teamNumber = playerDTO.getTeamNumber();
        String position = playerDTO.getPosition();

        try {
            Team team = teamRepository.findById(teamId)
                    .orElseThrow(() -> new TeamNotFoundException("Team with ID "
                            + teamId + " does not exist."));

            boolean existsByName = playerRepository.existsByFullNameAndTeamId(fullName, teamId);
            if(existsByName)
            {
                throw new PlayerAlreadyExistsException("Player with name "
                        + fullName + " already exists on team with ID " + teamId);
            }

            boolean existsByNumber = playerRepository.existsByTeamNumberAndTeamId(teamNumber, teamId);
            if(existsByNumber)
            {
                throw new PlayerAlreadyExistsException("Player with team number "
                        + teamNumber + " already exists on team with ID " + teamId);
            }

            PlayerPosition playerPosition = PlayerPosition.fromString(position);

            Player player = new Player();
            player.setId(generateUniqueId());
            player.setPosition(playerPosition);
            player.setTeam(team);
            player.setFullName(fullName);
            player.setTeamNumber(teamNumber);
            return this.playerRepository.save(player);
        } catch (RuntimeException e) {
            LOGGER.warn(e.getMessage());
            //if time left make global exc handler
            return null;
        }
    }

    @Transactional
    public Player updatePlayer(Long playerId, CreatePlayerDTO updatedPlayer)
    {

        String fullName = updatedPlayer.getFullName();
        Long teamId = updatedPlayer.getTeamId();
        Long teamNumber = updatedPlayer.getTeamNumber();
        String position = updatedPlayer.getPosition();

        try {
            Player player = this.playerRepository.findById(playerId)
                    .orElseThrow(() -> new PlayerNotFoundException("Player with ID " + playerId + " does not exist."));


            Team team = teamRepository.findById(teamId)
                    .orElseThrow(() -> new TeamNotFoundException("Team with ID "
                            + teamId + " does not exist."));

            boolean existsByName = playerRepository.existsByFullNameAndTeamIdAndIdNot(fullName, teamId, playerId);
            if (existsByName) {
                throw new PlayerAlreadyExistsException("Player with name " + fullName + " already exists on team with ID " + teamId);
            }


            boolean existsByNumber = playerRepository.existsByTeamNumberAndTeamIdAndIdNot(teamNumber, teamId, playerId);
            if (existsByNumber) {
                throw new PlayerAlreadyExistsException("Player with team number " + teamNumber + " already exists on team with ID " + teamId);
            }


            PlayerPosition playerPosition = PlayerPosition.fromString(position);

            player.setPosition(playerPosition);
            player.setTeam(team);
            player.setFullName(fullName);
            player.setTeamNumber(teamNumber);
            return this.playerRepository.save(player);
        }catch (PlayerNotFoundException e)
        {
            throw new PlayerNotFoundException(e.getMessage());
        }
        catch (PlayerAlreadyExistsException e) {
            //if time left make global exc handler
            LOGGER.warn(e.getMessage());
            return null;
        }
        catch (TeamNotFoundException e)
        {
            LOGGER.warn(e.getMessage());
            return null;
        }
    }

    //add authorization so only admins can delete
    public boolean deletePlayerById(Long playerId)
    {
        try {
            Player player = this.playerRepository.findById(playerId)
                    .orElseThrow(() -> new PlayerNotFoundException("Player with ID "
                    + playerId + " not found."));
            this.playerRepository.delete(player);
            return true;
        } catch (PlayerNotFoundException e) {
            return false;
        }
    }

    private Long generateUniqueId()
    {
        return this.newLongIdGenerationService.generateUniqueId("players");
    }

}
