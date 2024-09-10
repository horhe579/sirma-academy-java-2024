package com.sirma.finalexam.matchanalyzer.csvparsers;

import com.sirma.finalexam.matchanalyzer.entities.Match;
import com.sirma.finalexam.matchanalyzer.entities.Player;
import com.sirma.finalexam.matchanalyzer.entities.Record;
import com.sirma.finalexam.matchanalyzer.entities.Team;
import com.sirma.finalexam.matchanalyzer.exceptions.*;
import com.sirma.finalexam.matchanalyzer.interfaces.CsvParser;
import com.sirma.finalexam.matchanalyzer.repositories.MatchRepository;
import com.sirma.finalexam.matchanalyzer.repositories.PlayerRepository;
import com.sirma.finalexam.matchanalyzer.repositories.RecordRepository;
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
public class CsvRecordProcessor implements CsvParser<Record> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvMatchProcessor.class);
    private static final int BATCH_SIZE = 100;
    private RecordRepository recordRepository;
    private MatchRepository matchRepository;
    private PlayerRepository playerRepository;

    public CsvRecordProcessor(RecordRepository recordRepository, MatchRepository matchRepository, PlayerRepository playerRepository) {
        this.recordRepository = recordRepository;
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public void parseCsv(String fileName) throws IOException {
        List<Record> records = new ArrayList<>();
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
                Record record = parseEntry(line);
                if(record != null)
                {
                    records.add(record);
                }
                if(records.size() == BATCH_SIZE)
                {
                    saveBatch(records);
                    records.clear();
                }
            }
            if(!records.isEmpty())
            {
                saveBatch(records);
            }
        }
    }

    @Override
    public Record parseEntry(String csvLine) {
        // Line format: ID,PlayerID,MatchID,fromMinutes,toMinutes
        // Example: 1,1,1,0,NULL
        String[] recordFields = csvLine.split(",");
        Long recordId = null;

        try {
            recordId = Long.parseLong(recordFields[0]);
            Long playerId = Long.parseLong(recordFields[1]);
            Long matchId = Long.parseLong(recordFields[2]);
            Integer fromMinutes = Integer.parseInt(recordFields[3]);
            Integer toMinutes = "NULL".equals(recordFields[4].toUpperCase()) ? null : Integer.parseInt(recordFields[4]);

            if (fromMinutes < 0 || fromMinutes > 90 || fromMinutes == null) {
                throw new InvalidRecordFormatException("Invalid value for 'fromMinutes', must be between 0 and 90");
            }

            if (toMinutes != null ) {
                //ugly nested if, but ide is arguing with me about a null pointer exception
                if(toMinutes > 90)
                {
                    throw new InvalidRecordFormatException("Invalid value for 'toMinutes', cannot be greater than 90");

                }
            }

            Player player = playerRepository.findById(playerId)
                    .orElseThrow(() -> new PlayerNotFoundException("Player with ID " + playerId + " not found."));
            Match match = matchRepository.findById(matchId)
                    .orElseThrow(() -> new MatchNotFoundException("Match with ID " + matchId + " not found."));


            return new Record(recordId, player, match, fromMinutes, toMinutes);

        } catch (NumberFormatException e) {
            LOGGER.warn("Skipping record with invalid number format in line {}: {}", csvLine, e.getMessage());
        } catch (RuntimeException e) {
            LOGGER.warn("Skipping record with ID {}: {}", recordId, e.getMessage());
        }

        return null;
    }


    @Transactional
    @Override
    public void saveBatch(List<Record> entries) {
        List<Long> ids = entries.stream().map(Record::getId).toList();
        List<Long> existingIds = this.recordRepository.getExistingIds(ids);
        List<Record> records = entries.stream()
                .filter(t -> !existingIds.contains(t.getId()))
                .toList();
        if(!records.isEmpty()) {
            this.recordRepository.saveAll(records);
        }
    }
}
