package com.sirma.finalexam.matchanalyzer.csvparsers;

import com.sirma.finalexam.matchanalyzer.entities.Player;
import com.sirma.finalexam.matchanalyzer.entities.Team;
import com.sirma.finalexam.matchanalyzer.enums.PlayerPosition;
import com.sirma.finalexam.matchanalyzer.exceptions.InvalidPlayerFormatException;
import com.sirma.finalexam.matchanalyzer.exceptions.TeamNotFoundException;
import com.sirma.finalexam.matchanalyzer.interfaces.CsvParser;
import com.sirma.finalexam.matchanalyzer.repositories.PlayerRepository;
import com.sirma.finalexam.matchanalyzer.repositories.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvPlayerProcessor implements CsvParser<Player> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvMatchProcessor.class);
    private static final int BATCH_SIZE = 100;
    //private String fileName;
    private PlayerRepository playerRepository;
    private TeamRepository teamRepository;

    public CsvPlayerProcessor(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public void parseCsv(String fileName) throws IOException {
        List<Player> players = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            int linesRead = 0;
            while((line = br.readLine()) != null)
            {
                if(linesRead == 0)
                {
                    linesRead++;
                    continue;
                }
                linesRead++;
                Player player = parseEntry(line);
                if(player != null)
                {
                    players.add(player);
                }
                if(players.size() == BATCH_SIZE)
                {
                    saveBatch(players);
                    players.clear();
                }
            }
            if(!players.isEmpty())
            {
                saveBatch(players);
            }
        }
    }

    @Override
    public Player parseEntry(String csvLine) {
        // Line format: ID,TeamNumber,Position,FullName,TeamID
        // Example: 1,1,GK,Manuel Neuer,1
        String[] playerFields = csvLine.split(",");
        Long playerId = null;

        try {
            playerId = Long.parseLong(playerFields[0]);
            Long teamNumber = Long.parseLong(playerFields[1]);
            PlayerPosition position = PlayerPosition.fromString(playerFields[2]);
            String fullName = playerFields[3];
            Long teamId = Long.parseLong(playerFields[4]);

            if (fullName.length() < 2) {
                throw new InvalidPlayerFormatException("Invalid length for field 'fullName', minimal length: 2, current length: " + fullName.length());
            }

            Team team = teamRepository.findById(teamId)
                    .orElseThrow(() -> new TeamNotFoundException("Team with ID " + teamId + " not found."));

            return new Player(playerId, teamNumber, fullName, team, position);

        } catch (NumberFormatException e) {
            LOGGER.warn("Skipping player with invalid number format in line {}: {}", csvLine, e.getMessage());
        } catch (RuntimeException e) {
            LOGGER.warn("Skipping player with ID {}: {}", playerId, e.getMessage());
        }

        return null;
    }

    @Transactional
    @Override
    public void saveBatch(List<Player> entries) {
        this.playerRepository.saveAll(entries);
    }
}
