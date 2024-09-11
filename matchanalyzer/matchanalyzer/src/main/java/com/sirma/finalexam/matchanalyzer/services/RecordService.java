package com.sirma.finalexam.matchanalyzer.services;

import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerRecordForMatchDTO;
import com.sirma.finalexam.matchanalyzer.repositories.RecordRepository;
import com.sirma.finalexam.matchanalyzer.util.helpers.RecordRepositoryRawResponseParser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RecordService {

    private RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    //Returns a Map where the key is a Match ID, and the value is a PlayerRecordForMatchDTO
    //That holds information about a record associated with a match including the Player ID, fromMinutes and toMinutes
    //            ____ DTO1:{1, 0, 90}
    //           /
    // MatchId:1 ----- DTO2:{2, 30, 60}
    //           \
    //            ‾‾‾‾ DTO3:{3, 0, 10}
    public Map<Long, List<PlayerRecordForMatchDTO>> getPlayerRecordsByMatch()
    {
        //Custom query that gets all records from the DB in the format |matchId -> List<{ playerId, from, to }>|
        List<Object[]> records = this.recordRepository.getAllPlayerRecords();

        Map<Long, List<PlayerRecordForMatchDTO>> response = records.stream()
                .collect(Collectors.groupingBy
                        (RecordRepositoryRawResponseParser::getMatchId,
                                Collectors.mapping(RecordRepositoryRawResponseParser::getPlayerRecordForMatchDTO,
                                        Collectors.toList())));

        return response;
    }

}
