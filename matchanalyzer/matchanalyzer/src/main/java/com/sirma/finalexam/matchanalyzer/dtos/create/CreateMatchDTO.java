package com.sirma.finalexam.matchanalyzer.dtos.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMatchDTO {

    @JsonProperty("aTeamId")
    private Long aTeamId;

    @JsonProperty("bTeamId")
    private Long bTeamId;

    private String date;

    private String score;
}
