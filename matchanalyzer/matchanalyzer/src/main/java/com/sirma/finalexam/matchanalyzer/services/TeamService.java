package com.sirma.finalexam.matchanalyzer.services;

import com.sirma.finalexam.matchanalyzer.dtos.create.CreateTeamDTO;
import com.sirma.finalexam.matchanalyzer.entities.Team;
import com.sirma.finalexam.matchanalyzer.exceptions.TeamManagerException;
import com.sirma.finalexam.matchanalyzer.exceptions.TeamNameException;
import com.sirma.finalexam.matchanalyzer.exceptions.TeamNotFoundException;
import com.sirma.finalexam.matchanalyzer.repositories.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService {
    //ID,Name,ManagerFullName,Group

    private static final Logger LOGGER = LoggerFactory.getLogger(TeamService.class);
    private TeamRepository teamRepository;
    private IdGenerationService<Team> idGenerationService;
    private NewLongIdGenerationService newLongIdGenerationService;

    public TeamService(TeamRepository teamRepository, IdGenerationService<Team> idGenerationService, NewLongIdGenerationService newLongIdGenerationService) {
        this.teamRepository = teamRepository;
        this.idGenerationService = idGenerationService;
        this.newLongIdGenerationService = newLongIdGenerationService;
    }

    //implement returning responses if needed
    public List<Team> getAllTeams()
    {
        List<Team> teams = this.teamRepository.findAll();
        return teams;
    }

    public Team getTeamById(Long teamId)
    {
        try {
            return this.teamRepository.findById(teamId)
                    .orElseThrow(() -> new TeamNotFoundException("Team with ID: " + teamId + " not found."));
        } catch (TeamNotFoundException e) {
            LOGGER.warn(e.getMessage());
            return null;
        }
    }

    public Team createTeam(CreateTeamDTO teamDTO)
    {
        //add validation to see if manager already has a team
        //logic to get a unique id
        //save

        char groupName = teamDTO.getGroupName();
        String teamName = teamDTO.getName();
        String managerFullName = teamDTO.getManagerFullName();

        boolean managerHasTeam = this.teamRepository.existsByManagerFullName(managerFullName);
        boolean teamWithNameExists = this.teamRepository.existsByName(teamName);

        try {
            if(managerHasTeam)
            {
                throw new TeamManagerException("Manager with name " + managerFullName + " already associated with a team.");
            }
            if(teamWithNameExists)
            {
                throw new TeamNameException("Team with name " + teamName + " already exists.");
            }

            Team team = new Team();
            team.setId(generateUniqueId());
            team.setGroupName(groupName);
            team.setName(teamName);
            team.setManagerFullName(managerFullName);
            return this.teamRepository.save(team);
        } catch (RuntimeException e) {
            LOGGER.warn(e.getMessage());
            return null;
        }
    }

    @Transactional
    public Team updateTeam(Long teamId, CreateTeamDTO updatedTeam)
    {
        //implement logic similar to creation of team
        //add validation to see if manager already has a team
        char groupName = updatedTeam.getGroupName();
        String teamName = updatedTeam.getName();
        String managerFullName = updatedTeam.getManagerFullName();

        try {
            Team team = this.teamRepository.findById(teamId)
                    .orElseThrow(() -> new TeamNotFoundException("Team with ID " + teamId + " not found."));

            boolean managerHasTeam = teamRepository.existsByManagerFullNameAndIdNot(managerFullName, teamId);
            boolean teamWithNameExists = teamRepository.existsByNameAndIdNot(teamName, teamId);

            if(managerHasTeam)
            {
                throw new TeamManagerException("Manager with name " + managerFullName + " is already associated with another team.");
            }
            if(teamWithNameExists)
            {
                throw new TeamNameException("Team with name " + teamName + " already exists.");
            }

            team.setGroupName(updatedTeam.getGroupName());
            team.setName(updatedTeam.getName());
            team.setManagerFullName(updatedTeam.getManagerFullName());
            return this.teamRepository.save(team);
        } catch (TeamNotFoundException e) {
            throw new TeamNotFoundException(e.getMessage());
        } catch (TeamManagerException e) {
            LOGGER.warn(e.getMessage());
            return null;
        } catch (TeamNameException e) {
            LOGGER.warn(e.getMessage());
            return null;
        }

    }

    //add authorization so only admins can delete
    public boolean deleteTeamById(Long teamId)
    {
        try {
            Team team = this.teamRepository.findById(teamId).orElseThrow(() -> new TeamNotFoundException("Team with ID "
                    + teamId + " not found."));
            this.teamRepository.delete(team);
            return true;
        } catch (TeamNotFoundException e) {
            return false;
        }
    }

    private Long generateUniqueId()
    {
        return this.newLongIdGenerationService.generateUniqueId("teams");
    }
}
