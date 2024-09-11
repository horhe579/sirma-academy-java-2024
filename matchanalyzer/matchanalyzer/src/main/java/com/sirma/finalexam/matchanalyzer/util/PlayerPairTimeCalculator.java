package com.sirma.finalexam.matchanalyzer.util;

import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerPairDTO;
import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerPairTotalTimeTogetherDTO;
import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerRecordForMatchDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlayerPairTimeCalculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerPairTimeCalculator.class);
    // Map<{player1Id, player2Id}, {totalTimeTogether, List<PlayerPairMatchOverlap>}>

    //Receives a Map with the key being a Match ID and the value being a player with the from and to minutes
    //            ____ DTO1:{1, 0, 90}
    //           /
    // MatchId:1 ----- DTO2:{2, 30, 60}
    //           \
    //            ‾‾‾‾ DTO3:{3, 0, 10}
    //Returns a map of all the pairs with total time together and matches
    public Map<PlayerPairDTO, PlayerPairTotalTimeTogetherDTO> extractPairsWithTimeTogether(Map<Long, List<PlayerRecordForMatchDTO>> recordsByMatch, boolean getMostTime)
    {
        Map<PlayerPairDTO, PlayerPairTotalTimeTogetherDTO> playerPairTimeTableMap = new HashMap<>();
        for (var entry : recordsByMatch.entrySet()) {
            Long matchId = entry.getKey();
            List<PlayerRecordForMatchDTO> playerRecordsForMatch = entry.getValue();

            for(int i = 0; i < playerRecordsForMatch.size(); i++)
            {
                PlayerRecordForMatchDTO playerRecordA = playerRecordsForMatch.get(i);
                for(int j = i + 1; j < playerRecordsForMatch.size(); j++)
                {
                    PlayerRecordForMatchDTO playerRecordB = playerRecordsForMatch.get(j);

                    long timeTogetherInGame = calculateMinutesTogether(playerRecordA, playerRecordB);
                    if(timeTogetherInGame > 0)
                    {
                        //When a pair has at least 1 minute together on the field, create a pair to be stored
                        PlayerPairDTO playerPair = new PlayerPairDTO(
                                playerRecordA.getPlayerId(),
                                playerRecordB.getPlayerId());

                        playerPairTimeTableMap.putIfAbsent(playerPair, new PlayerPairTotalTimeTogetherDTO());
                        playerPairTimeTableMap.get(playerPair).addMatchOverlap(matchId, timeTogetherInGame);
                    }
                }
            }
        }
        if(getMostTime)
        {
            Long maxTimeTogether = 0L;

            //Goes through all the pairs to see what is the max time together on the field of a pair
            for(var pairTime : playerPairTimeTableMap.values())
            {
                if(pairTime.getTotalTimeTogether() > maxTimeTogether)
                {
                    maxTimeTogether = pairTime.getTotalTimeTogether();
                }
            }
            LOGGER.info("Max time together: " + maxTimeTogether);
            //Adds all the entries to the list to be returned
            var iterator = playerPairTimeTableMap.entrySet().iterator();
            while (iterator.hasNext()) {
                var entry = iterator.next();
                if (!entry.getValue().getTotalTimeTogether().equals(maxTimeTogether)) {
                    iterator.remove();
                }
            }
        }
        return playerPairTimeTableMap;
    }

    private long calculateMinutesTogether(PlayerRecordForMatchDTO playerRecordA, PlayerRecordForMatchDTO playerRecordB)
    {
        long togetherFromMinute = Math.max(playerRecordA.getFromMinutes(), playerRecordB.getFromMinutes());
        long togetherToMinute = Math.min(playerRecordA.getToMinutes(), playerRecordB.getToMinutes());
        return (togetherToMinute > togetherFromMinute) ? (togetherToMinute - togetherFromMinute) : 0;
    }

}
