package com.sirma.finalexam.matchanalyzer.util;

import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerPairDTO;
import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerPairMatchOverlapDTO;
import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerPairTotalTimeTogetherDTO;
import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerRecordForMatchDTO;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlayerPairTimeCalculator {

    //A map
    // Map<{player1Id, player2Id}, {totalTimeTogether, List<PlayerPairMatchOverlap>}>
    @Getter
    private Map<PlayerPairDTO, PlayerPairTotalTimeTogetherDTO> playerPairTimeTableMap = new HashMap<>();
    private Map<PlayerPairDTO, Long> playerPairTimeTogetherMap = new HashMap<>();

    //Receives a Map with the key being a Match ID and the value being a player with the from and to minutes
    public void processMatchRecords(Map<Long, List<PlayerRecordForMatchDTO>> matchRecordsMap)
    {
        for (var entry : matchRecordsMap.entrySet()) {
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
                        PlayerPairDTO playerPair = new PlayerPairDTO(playerRecordA.getPlayerId(),
                                playerRecordB.getPlayerId());
                        playerPairTimeTableMap.merge(playerPair,
                                new PlayerPairTotalTimeTogetherDTO(timeTogetherInGame, matchId), this::addMatch);
                        //playerPairTimeTogetherMap.merge(playerPair, timeTogetherInGame, Long::sum);
                    }
                }
            }
        }
    }
    public PlayerPairTotalTimeTogetherDTO addMatch(PlayerPairTotalTimeTogetherDTO a, PlayerPairTotalTimeTogetherDTO b) {
        //a - timeTogether: 0; List<MatchOverlap> = {empty}
        //b - timeTogether: 10; List<MatchOverlap> = {{1, 10};}
        //BAD METHOD PLEASE REFACTOR
        a.addMatchOverlap(b.getMatchOverlapList().get(0).getMatchID(), b.getTotalTimeTogether());
        return a;
    }

    private long calculateMinutesTogether(PlayerRecordForMatchDTO playerRecordA, PlayerRecordForMatchDTO playerRecordB)
    {
        long togetherFromMinute = Math.max(playerRecordA.getFromMinutes(), playerRecordB.getFromMinutes());
        long togetherToMinute = Math.min(playerRecordA.getToMinutes(), playerRecordB.getToMinutes());
        return (togetherToMinute > togetherFromMinute) ? (togetherToMinute - togetherFromMinute) : 0;
    }

}
