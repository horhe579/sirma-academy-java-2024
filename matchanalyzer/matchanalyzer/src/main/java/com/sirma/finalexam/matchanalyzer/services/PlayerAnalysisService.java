package com.sirma.finalexam.matchanalyzer.services;

import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerPairDTO;
import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerRecordForMatchDTO;
import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.ResponseRecordDTO;
import com.sirma.finalexam.matchanalyzer.repositories.RecordRepository;
import com.sirma.finalexam.matchanalyzer.util.PlayerPairTimeCalculator;
import org.springframework.stereotype.Service;

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

    public List<ResponseRecordDTO> getAllRecords()
    {
//        //add edge case handling
//        List<Object[]> records = this.recordRepository.getAllPlayerRecords();
//
//        List<ResponseRecordDTO> response = records.stream()
//                .map(r ->
//                        new ResponseRecordDTO(
//                                ((Number) r[0]).longValue(),
//                                ((Number) r[1]).longValue(),
//                                ((Number) r[2]).longValue(),
//                                ((Number) (r[3] == null ? 90 : r[3])).longValue()
//                        )).toList();
//
//        return response;
        return null;
    }

    private Map<Long, List<PlayerRecordForMatchDTO>> getPlayerTimeForAllMatches()
    {
        //records in the format       matchId -> List<{ playerId, from, to }>
        List<Object[]> records = this.recordRepository.getAllPlayerRecords();

        Map<Long, List<PlayerRecordForMatchDTO>> response = records.stream()
                .collect(Collectors.groupingBy
                        (this::getMatchId, Collectors.mapping(this::getPlayerRecordForMatchDTO, Collectors.toList())));

        return response;
    }

    public Map<PlayerPairDTO, Long> getTimeTogetherMapTestFunctionToBeRemoved()
    {
        //make it accept a repo or something
        Map<Long, List<PlayerRecordForMatchDTO>> arg1 = getPlayerTimeForAllMatches();

        this.timeCalculator.processMatchRecords(arg1);

        return this.timeCalculator.getPlayerPairTimeTogetherMap();
    }

    private Long getMatchId(Object[] record)
    {
        //assuming a record is correct and follows the format
        Long matchId = ((Number) record[0]).longValue();
        return matchId;
    }

    private PlayerRecordForMatchDTO getPlayerRecordForMatchDTO(Object[] record)
    {
        //again assuming the record is correct and in the right structure
         Long playerId = ((Number) record[1]).longValue();
         Long fromMinutes = ((Number) record[2]).longValue();
         Long toMinutes = ((Number) (record[3] == null ? 90 : record[3])).longValue();

         return new PlayerRecordForMatchDTO(playerId, fromMinutes, toMinutes);
    }
}
