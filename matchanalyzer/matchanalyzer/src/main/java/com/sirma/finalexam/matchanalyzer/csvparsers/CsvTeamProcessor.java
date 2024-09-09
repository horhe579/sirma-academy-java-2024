package com.sirma.finalexam.matchanalyzer.csvparsers;

import com.sirma.finalexam.matchanalyzer.entities.Team;
import com.sirma.finalexam.matchanalyzer.exceptions.InvalidTeamFormatException;
import com.sirma.finalexam.matchanalyzer.interfaces.CsvParser;
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
import java.util.Locale;

@Component
public class CsvTeamProcessor implements CsvParser<Team> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvMatchProcessor.class);
    private static final int BATCH_SIZE = 10;
    private TeamRepository teamRepository;

    public CsvTeamProcessor(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void parseCsv(String fileName) throws IOException {
        List<Team> teams = new ArrayList<>();
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
                Team team = parseEntry(line);
                if(team != null)
                {
                    teams.add(team);
                }
                if(teams.size() == BATCH_SIZE)
                {
                    //LOGGER.info("Saving batch of teams with a size of {}", teams.size());
                    saveBatch(teams);
                    teams.clear();//
                }
            }
            if(!teams.isEmpty())
            {
                //LOGGER.info("Saving batch of teams with a size of {}", teams.size());
                saveBatch(teams);
            }
        }
    }

    @Override
    public Team parseEntry(String csvLine) {
        // Line format: ID,Name,ManagerFullName,Group
        // Example: 1,Germany,Julian Nagelsmann,A
        String[] teamFields = csvLine.split(",");
        Long teamId = null;

        try {
            teamId = Long.parseLong(teamFields[0]);
            String teamName = teamFields[1];
            String managerFullName = teamFields[2];

            if (managerFullName.length() < 2) {
                throw new InvalidTeamFormatException("Invalid length for field 'managerFullName', minimal length: 2, current length: " + managerFullName.length());
            }

            String teamGroup = teamFields[3].toUpperCase(Locale.ROOT);
            if (teamGroup.length() != 1) {
                throw new InvalidTeamFormatException("Invalid length for field 'group', length must be 1, current length: " + teamGroup.length());
            }

            return new Team(teamId, teamName, managerFullName, teamGroup.charAt(0));

        } catch (NumberFormatException e) {
            LOGGER.warn("Skipping team with invalid number format in line {}: {}", csvLine, e.getMessage());
        } catch (RuntimeException e) {
            LOGGER.warn("Skipping team with ID {}: {}", teamId, e.getMessage());
        }

        return null;
    }


    @Transactional
    @Override
    public void saveBatch(List<Team> entries) {
        //LOGGER.info("Saving...");
        this.teamRepository.saveAll(entries);
        //LOGGER.info("Saved.");
    }
}
