package com.sirma.finalexam.matchanalyzer.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerPairDTO {

    private Long playerAID;
    private Long playerBID;
    private Long timeTogether;
    private List<MatchTimeDTO> matchTimes;
}
