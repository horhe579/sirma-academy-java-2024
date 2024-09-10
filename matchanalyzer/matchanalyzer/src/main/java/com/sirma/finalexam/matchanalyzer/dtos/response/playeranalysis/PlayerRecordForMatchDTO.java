package com.sirma.finalexam.matchanalyzer.dtos.response.playeranalysis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRecordForMatchDTO {
    private Long playerId;

    private Long fromMinutes;

    private Long toMinutes;
}
