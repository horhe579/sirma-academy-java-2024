package com.sirma.finalexam.matchanalyzer.dtos.response.playeranalysis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRecordDTO {

    private Long playerId;
    private Long matchId;
    private Long fromMinutes;
    private Long toMinutes;


}
