package com.sirma.finalexam.matchanalyzer.dtos.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlayerDTO {

    private Long teamNumber;

    private String fullName;

    private Long teamId;

    private String position;
}
