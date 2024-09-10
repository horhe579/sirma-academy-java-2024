package com.sirma.finalexam.matchanalyzer.dtos.create;

import com.sirma.finalexam.matchanalyzer.entities.Team;
import com.sirma.finalexam.matchanalyzer.enums.PlayerPosition;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
