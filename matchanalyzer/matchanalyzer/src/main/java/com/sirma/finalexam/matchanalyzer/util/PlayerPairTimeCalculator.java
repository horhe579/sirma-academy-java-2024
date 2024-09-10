package com.sirma.finalexam.matchanalyzer.util;

import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerPairDTO;
import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerRecordForMatchDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlayerPairTimeCalculator {

    //A map
    private Map<PlayerPairDTO, Long> playerPairTimeTogetherMap = new HashMap<>();

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
                        PlayerPairDTO playerPair = new PlayerPairDTO(playerRecordA.getPlayerId(),
                                playerRecordB.getPlayerId());
                        playerPairTimeTogetherMap.merge(playerPair, timeTogetherInGame, Long::sum);
                    }
                }
            }
        }
    }

    public Map<PlayerPairDTO, Long> getPlayerPairTimeTogetherMap() {
        return playerPairTimeTogetherMap;
    }

    private long calculateMinutesTogether(PlayerRecordForMatchDTO playerRecordA, PlayerRecordForMatchDTO playerRecordB)
    {
        long togetherFromMinute = Math.max(playerRecordA.getFromMinutes(), playerRecordB.getFromMinutes());
        long togetherToMinute = Math.min(playerRecordA.getToMinutes(), playerRecordB.getToMinutes());
        return (togetherToMinute > togetherFromMinute) ? (togetherToMinute - togetherFromMinute) : 0;
    }

}
