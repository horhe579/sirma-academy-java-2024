package com.sirma.finalexam.matchanalyzer.dtos.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTeamDTO {

    private String name;

    private String managerFullName;

    private char groupName;
}
