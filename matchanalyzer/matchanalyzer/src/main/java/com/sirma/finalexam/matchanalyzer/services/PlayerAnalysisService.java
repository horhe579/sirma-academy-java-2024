package com.sirma.finalexam.matchanalyzer.services;

import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerPairDTO;
import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerPairTotalTimeTogetherDTO;
import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerRecordForMatchDTO;
import com.sirma.finalexam.matchanalyzer.util.PlayerPairTimeCalculator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PlayerAnalysisService {
    //as a service this should have mostly methods that the end user will use , not good abstraction right now

    private RecordService recordService;
    private PlayerPairTimeCalculator timeCalculator;

    public PlayerAnalysisService(RecordService recordService, PlayerPairTimeCalculator timeCalculator) {
        this.recordService = recordService;
        this.timeCalculator = timeCalculator;
    }

    //Return max time pairs
    //Return all pairs

    //Returns a Map where the key is a PlayerPairDTO, consisting of 2 player IDs.
    //The value is a DTO, consisting of the total time they spent on the field and a list of common matches
    //with overlap times,
    // no duplicate pairs because of the overridden methods of class Object in the DTO

    public Map<PlayerPairDTO, PlayerPairTotalTimeTogetherDTO> getPairsWithTimeTogether()
    {
        Map<Long, List<PlayerRecordForMatchDTO>> recordsByMatch = this.recordService.getPlayerRecordsByMatch();

        return this.timeCalculator.extractPairsWithTimeTogether(recordsByMatch, false);
    }


    //A function to get player pairs with the most time in common matches (could be more than one)
    //Returns a list of entries, each entry having a player pair key
    //And a value that stores info about common matches and time together
    public Map<PlayerPairDTO, PlayerPairTotalTimeTogetherDTO> getPairsWithMostTimeTogether()
    {
        Map<Long, List<PlayerRecordForMatchDTO>> recordsByMatch = this.recordService.getPlayerRecordsByMatch();

        return this.timeCalculator.extractPairsWithTimeTogether(recordsByMatch, true);
    }

}
