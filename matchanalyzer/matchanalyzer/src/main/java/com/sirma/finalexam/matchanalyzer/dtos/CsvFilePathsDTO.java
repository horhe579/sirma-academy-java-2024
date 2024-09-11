package com.sirma.finalexam.matchanalyzer.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CsvFilePathsDTO {

    private String teamsFilePath;
    private String playersFilePath;
    private String matchesFilePath;
    private String recordsFilePath;

}
