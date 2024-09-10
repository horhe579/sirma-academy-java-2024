package com.sirma.finalexam.matchanalyzer.dtos.response;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTeamDTO {

    private String name;

    private String managerFullName;

    private char groupName;
}
