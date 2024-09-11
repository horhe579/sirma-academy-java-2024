package com.sirma.finalexam.matchanalyzer.csvparsers;

import com.sirma.finalexam.matchanalyzer.entities.Match;
import com.sirma.finalexam.matchanalyzer.entities.Team;
import com.sirma.finalexam.matchanalyzer.exceptions.InvalidMatchFormatException;
import com.sirma.finalexam.matchanalyzer.exceptions.TeamNotFoundException;
import com.sirma.finalexam.matchanalyzer.interfaces.CsvParser;
import com.sirma.finalexam.matchanalyzer.interfaces.PatternValidator;
import com.sirma.finalexam.matchanalyzer.repositories.MatchRepository;
import com.sirma.finalexam.matchanalyzer.repositories.TeamRepository;

import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sirma.finalexam.matchanalyzer.util.MatchDatePatternValidator;
import com.sirma.finalexam.matchanalyzer.util.MatchScorePatternValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CsvMatchProcessor implements CsvParser<Match> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvMatchProcessor.class);
    private static final int BATCH_SIZE = 20;
    //private String fileName;
    private MatchRepository matchRepository;
    private TeamRepository teamRepository;
    private final MatchScorePatternValidator matchScoreValidator;
    private final MatchDatePatternValidator matchDateValidator;


    public CsvMatchProcessor(TeamRepository teamRepository, MatchRepository matchRepository, MatchScorePatternValidator matchScoreValidator, MatchDatePatternValidator matchDateValidator)
    {
        //this.fileName = fileName;
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
        this.matchScoreValidator = matchScoreValidator;
        this.matchDateValidator = matchDateValidator;
    }

    @Override
    public void parseCsv(String fileName) throws IOException {
        List<Match> matches = new ArrayList<>();
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
                Match match = parseEntry(line);
                if(match != null)
                {
                    matches.add(match);
                }
                if(matches.size() == BATCH_SIZE)
                {
                    saveBatch(matches);
                    matches.clear();
                }
            }
            if(!matches.isEmpty())
            {
                saveBatch(matches);
            }
        }
    }

    //Returns null if a team ID is invalid
    @Override
    public Match parseEntry(String csvLine) {
        // Line format: ID,ATeamID,BTeamID,Date,Score
        // Example: 1,1,2,6/14/2024,5-1
        String[] matchFields = csvLine.split(",");
        if(matchFields.length != 5)
        {
            return null;
        }
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        //Pattern matchScorePatter = Pattern.compile("((0|[1-9]\\d*)(\\((0|[1-9]\\d*)\\))?-(0|[1-9]\\d*)(\\((0|[1-9]\\d*)\\))?)");
        Long matchId = null;

        try {
            matchId = Long.parseLong(matchFields[0]);
            Long aTeamId = Long.parseLong(matchFields[1]);
            Long bTeamId = Long.parseLong(matchFields[2]);
            String date = matchFields[3];
            LocalDate matchDate = matchDateValidator.validate(date);
            String score = matchFields[4].trim();
            //Matcher matcher = matchScorePatter.matcher(score);

            if(matchScoreValidator.validate(score) == null)
            {
                throw new InvalidMatchFormatException("Match score is not formatted correctly or invalid.");
            }
            if(matchDate == null)
            {
                throw new InvalidMatchFormatException("Match date is not formatted correctly or invalid.");
            }

            Team teamA = teamRepository.findById(aTeamId)
                    .orElseThrow(() -> new TeamNotFoundException("Team with ID " + aTeamId + " not found."));
            Team teamB = teamRepository.findById(bTeamId)
                    .orElseThrow(() -> new TeamNotFoundException("Team with ID " + bTeamId + " not found."));

            return new Match(matchId, teamA, teamB, matchDate, score);


        } catch (NumberFormatException e) {
            LOGGER.warn("Skipping match with invalid number format in line {}: {}", csvLine, e.getMessage());
        } catch (RuntimeException e) {
            LOGGER.warn("Skipping match with ID {}: {}", matchId, e.getMessage());
        }

        return null;
    }


    //Used just for saving a batch from the csv files upon startup (for all the other saveBatch functions as well)
    //once the csv files are loaded and this function is called, it only saves new entries in the csv, meaning these
    //whose id is not present in the database, if a change on any field of for example record with id 1 has been made
    //and this method is called, the record will remain unchanged since there is already an existing entry with this id
    //to update existing entries I have to use the corresponding update method in the controller.
    @Transactional
    @Override
    public void saveBatch(List<Match> entries) {
        List<Long> ids = entries.stream().map(Match::getId).toList();
        List<Long> existingIds = this.matchRepository.getExistingIds(ids);
        List<Match> matches = entries.stream()
                .filter(t -> !existingIds.contains(t.getId()))
                .toList();
        if(!matches.isEmpty()) {
            this.matchRepository.saveAll(matches);
        }    }
}
