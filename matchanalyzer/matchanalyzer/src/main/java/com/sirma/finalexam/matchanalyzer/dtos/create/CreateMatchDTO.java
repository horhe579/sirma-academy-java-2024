package com.sirma.finalexam.matchanalyzer.dtos.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMatchDTO {

    private Long aTeamId;

    private Long bTeamId;

    private String date;

    private String score;
}
