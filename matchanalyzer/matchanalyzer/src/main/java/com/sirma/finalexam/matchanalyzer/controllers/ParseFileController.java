package com.sirma.finalexam.matchanalyzer.controllers;

import com.sirma.finalexam.matchanalyzer.csvparsers.CsvMatchProcessor;
import com.sirma.finalexam.matchanalyzer.csvparsers.CsvPlayerProcessor;
import com.sirma.finalexam.matchanalyzer.csvparsers.CsvRecordProcessor;
import com.sirma.finalexam.matchanalyzer.csvparsers.CsvTeamProcessor;
import com.sirma.finalexam.matchanalyzer.dtos.CsvFilePathsDTO;
import com.sirma.finalexam.matchanalyzer.services.PlayerAnalysisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/parse-files")
public class ParseFileController {
    private CsvMatchProcessor csvMatchProcessor;
    private CsvPlayerProcessor csvPlayerProcessor;
    private CsvTeamProcessor csvTeamProcessor;
    private CsvRecordProcessor csvRecordProcessor;
    private PlayerAnalysisService playerAnalysisService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ParseFileController.class);

    public ParseFileController(CsvMatchProcessor csvMatchProcessor, CsvPlayerProcessor csvPlayerProcessor,
                               CsvTeamProcessor csvTeamProcessor, CsvRecordProcessor csvRecordProcessor,
                               PlayerAnalysisService playerAnalysisService) {
        this.csvMatchProcessor = csvMatchProcessor;
        this.csvPlayerProcessor = csvPlayerProcessor;
        this.csvTeamProcessor = csvTeamProcessor;
        this.csvRecordProcessor = csvRecordProcessor;
        this.playerAnalysisService = playerAnalysisService;
    }

    //TODO make this parsing automatic everytime app boots and think of how the app will work
    //TODO since i have CRUD for all the entities it might not be necessary to terminate the app
    //TODO maybe make a controller action post method with a request body with file paths so
    //TODO some frontend person can map this to a form in case the user wants to parse files
    @Transactional
    @PostMapping("/csv")
    public ResponseEntity<String> parseCsvFiles(@RequestBody CsvFilePathsDTO csvFilePaths)
    {

        try {
            csvTeamProcessor.parseCsv(csvFilePaths.getTeamsFilePath());
            csvPlayerProcessor.parseCsv(csvFilePaths.getPlayersFilePath());
            csvMatchProcessor.parseCsv(csvFilePaths.getMatchesFilePath());
            csvRecordProcessor.parseCsv(csvFilePaths.getRecordsFilePath());
        } catch (IOException e) {
            LOGGER.warn("An error occurred when looking for a file: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok("CSV files processed successfully.");
    }


}
