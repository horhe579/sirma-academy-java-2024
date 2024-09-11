package com.sirma.finalexam.matchanalyzer.services;

import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerPairDTO;
import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerPairTotalTimeTogetherDTO;
import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerRecordForMatchDTO;
import com.sirma.finalexam.matchanalyzer.repositories.RecordRepository;
import com.sirma.finalexam.matchanalyzer.util.PlayerPairTimeCalculator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PlayerAnalysisService {

    private RecordRepository recordRepository;
    private PlayerPairTimeCalculator timeCalculator;

    public PlayerAnalysisService(RecordRepository recordRepository, PlayerPairTimeCalculator calculator) {
        this.recordRepository = recordRepository;
        this.timeCalculator = calculator;
    }

    public List<Map.Entry<PlayerPairDTO, PlayerPairTotalTimeTogetherDTO>> getPairsWithMostTime()
    {
        Map<PlayerPairDTO, PlayerPairTotalTimeTogetherDTO> playerPairMap = this.getTimeTogetherMapTestFunctionToBeChanged();
        List<Map.Entry<PlayerPairDTO, PlayerPairTotalTimeTogetherDTO>> pairsWithMostTime = new ArrayList<>();
        Long maxTimeTogether = 0L;

        for(var pairTime : playerPairMap.values())
        {
            if(pairTime.getTotalTimeTogether() > maxTimeTogether)
            {
                maxTimeTogether = pairTime.getTotalTimeTogether();
            }
        }

        for(var pairWithTime : playerPairMap.entrySet())
        {
            if(pairWithTime.getValue().getTotalTimeTogether() == maxTimeTogether)
            {
                pairsWithMostTime.add(pairWithTime);
            }
        }

        return pairsWithMostTime;

    }

    //Returns a Map where the key is a Match ID, and the value is a PlayerRecordForMatchDTO
    //That holds information about a record associated with a match including the Player ID, fromMinutes and toMinutes
    private Map<Long, List<PlayerRecordForMatchDTO>> getPlayerTimeForAllMatches()
    {
        //records in the format       matchId -> List<{ playerId, from, to }>
        List<Object[]> records = this.recordRepository.getAllPlayerRecords();

        Map<Long, List<PlayerRecordForMatchDTO>> response = records.stream()
                .collect(Collectors.groupingBy
                        (this::getMatchId, Collectors.mapping(this::getPlayerRecordForMatchDTO, Collectors.toList())));

        return response;
    }

    //Returns a Map where the key is a PlayerPairDTO, consisting of 2 player IDs.
    // The value is the time each pair
    //Played together in common matches,
    // no duplicate pairs because of the overridden methods of class Object in the DTO
    private Map<PlayerPairDTO, PlayerPairTotalTimeTogetherDTO> getTimeTogetherMapTestFunctionToBeChanged()
    {
        //make it accept a repo or something
        Map<Long, List<PlayerRecordForMatchDTO>> arg1 = getPlayerTimeForAllMatches();

        this.timeCalculator.processMatchRecords(arg1);

        return this.timeCalculator.getPlayerPairTimeTableMap();
    }

    //Helper method to make the grouping by in the getPlayerTimeForAllMatches() function easier to understand
    //Casts a field of an Object born from an SQL query that corresponds to the ID of the match
    private Long getMatchId(Object[] record)
    {
        //assuming a record is correct and follows the format
        Long matchId = ((Number) record[0]).longValue();
        return matchId;
    }

    //Helper method to make the grouping by in the getPlayerTimeForAllMatches() function easier to understand
    //Casts an Object born from an SQL Query to a PlayerRecordForMatchDTO, taking into accounting
    //That NULL means 90 minutes
    private PlayerRecordForMatchDTO getPlayerRecordForMatchDTO(Object[] record)
    {
        //again assuming the record is correct and in the right structure
         Long playerId = ((Number) record[1]).longValue();
         Long fromMinutes = ((Number) record[2]).longValue();
         Long toMinutes = ((Number) (record[3] == null ? 90 : record[3])).longValue();

         return new PlayerRecordForMatchDTO(playerId, fromMinutes, toMinutes);
    }
}
