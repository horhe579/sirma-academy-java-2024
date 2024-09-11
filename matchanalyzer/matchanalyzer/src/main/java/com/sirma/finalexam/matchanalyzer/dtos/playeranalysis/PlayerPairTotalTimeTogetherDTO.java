package com.sirma.finalexam.matchanalyzer.dtos.playeranalysis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PlayerPairTotalTimeTogetherDTO {

    private Long totalTimeTogether = 0L;

    private final List<PlayerPairMatchOverlapDTO> matchOverlapList = new ArrayList<>();

    public PlayerPairTotalTimeTogetherDTO(Long totalTimeTogether, Long matchId) {
        this.totalTimeTogether = totalTimeTogether;
        this.matchOverlapList.add(new PlayerPairMatchOverlapDTO(matchId, totalTimeTogether));
    }

    public void addMatchOverlap(Long matchId, Long overlapTime)
    {
        PlayerPairMatchOverlapDTO pairMatchOverlap = new PlayerPairMatchOverlapDTO(matchId, overlapTime);
        this.matchOverlapList.add(pairMatchOverlap);
        this.totalTimeTogether += overlapTime;
    }

}
