package com.sirma.finalexam.matchanalyzer.csvparsers;

import com.sirma.finalexam.matchanalyzer.entities.Match;
import com.sirma.finalexam.matchanalyzer.entities.Team;
import com.sirma.finalexam.matchanalyzer.exceptions.TeamNotFoundException;
import com.sirma.finalexam.matchanalyzer.interfaces.CsvParser;
import com.sirma.finalexam.matchanalyzer.repositories.MatchRepository;
import com.sirma.finalexam.matchanalyzer.repositories.TeamRepository;

import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CsvMatchProcessor implements CsvParser<Match> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvMatchProcessor.class);
    private static final int BATCH_SIZE = 100;
    //private String fileName;
    private MatchRepository matchRepository;
    private TeamRepository teamRepository;

    public CsvMatchProcessor(TeamRepository teamRepository, MatchRepository matchRepository)
    {
        //this.fileName = fileName;
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
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
                //Skip the header
                if(linesRead == 0)
                {
                    linesRead++;
                    continue;
                }
                linesRead++;
                Match match = parseEntry(line);
                matches.add(match);
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
        //Line format
        //ID,ATeamID,BTeamID,Date,Score
        //1,1,2,6/14/2024,5-1
        String [] matchFields = csvLine.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        Long matchId = Long.parseLong(matchFields[0]);
        Long aTeamId = Long.parseLong(matchFields[1]);
        Long bTeamId = Long.parseLong(matchFields[2]);
        LocalDate matchDate = LocalDate.parse(matchFields[3], formatter);
        String score = matchFields[4];

        try{
            Team teamA = teamRepository.findById(aTeamId)
                    .orElseThrow(() -> new TeamNotFoundException("Team with ID " + aTeamId + " not found."));
            Team teamB = teamRepository.findById(aTeamId)
                    .orElseThrow(() -> new TeamNotFoundException("Team with ID " + bTeamId + " not found."));

            return new Match(matchId, teamA, teamB, matchDate, score);
        }
        catch (RuntimeException e)
        {
            LOGGER.warn("Skipping match with ID {} due to missing team: {}", matchId, e.getMessage());
            return null;
        }
    }

    @Transactional
    @Override
    public void saveBatch(List<Match> entries) {
        this.matchRepository.saveAll(entries);
    }

    //Reusing code, not really needed to initialize a file if it is not there
    //Think of a way to make this work without given files
//    private void initializeFile()
//    {
//        File file = new File(this.fileName);
//        if (!file.exists()) {
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                throw new RuntimeException("Error initializing file: " + this.fileName, e);
//            }
//        }
//    }
}
