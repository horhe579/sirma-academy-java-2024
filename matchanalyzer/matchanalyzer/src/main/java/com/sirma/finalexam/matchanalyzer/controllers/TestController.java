package com.sirma.finalexam.matchanalyzer.controllers;

import com.sirma.finalexam.matchanalyzer.csvparsers.CsvMatchProcessor;
import com.sirma.finalexam.matchanalyzer.csvparsers.CsvPlayerProcessor;
import com.sirma.finalexam.matchanalyzer.csvparsers.CsvRecordProcessor;
import com.sirma.finalexam.matchanalyzer.csvparsers.CsvTeamProcessor;
import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerPairDTO;
import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerRecordForMatchDTO;
import com.sirma.finalexam.matchanalyzer.services.PlayerAnalysisService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {
    private CsvMatchProcessor csvMatchProcessor;
    private CsvPlayerProcessor csvPlayerProcessor;
    private CsvTeamProcessor csvTeamProcessor;
    private CsvRecordProcessor csvRecordProcessor;
    private PlayerAnalysisService playerAnalysisService;

    public TestController(CsvMatchProcessor csvMatchProcessor, CsvPlayerProcessor csvPlayerProcessor,
                          CsvTeamProcessor csvTeamProcessor, CsvRecordProcessor csvRecordProcessor,
                          PlayerAnalysisService playerAnalysisService) {
        this.csvMatchProcessor = csvMatchProcessor;
        this.csvPlayerProcessor = csvPlayerProcessor;
        this.csvTeamProcessor = csvTeamProcessor;
        this.csvRecordProcessor = csvRecordProcessor;
        this.playerAnalysisService = playerAnalysisService;
    }

    @Transactional
    @GetMapping("/parseMatches")
    public void parseMatches() throws IOException {
        csvTeamProcessor.parseCsv("C:\\Users\\Gesha\\Documents\\GitHub\\sirma-academy-java-2024\\matchanalyzer\\matchanalyzer\\src\\main\\resources\\data\\test\\teams_test.csv");
        csvPlayerProcessor.parseCsv("C:\\Users\\Gesha\\Documents\\GitHub\\sirma-academy-java-2024\\matchanalyzer\\matchanalyzer\\src\\main\\resources\\data\\test\\players_test.csv");
        csvMatchProcessor.parseCsv("C:\\Users\\Gesha\\Documents\\GitHub\\sirma-academy-java-2024\\matchanalyzer\\matchanalyzer\\src\\main\\resources\\data\\test\\matches_test.csv");
        csvRecordProcessor.parseCsv("C:\\Users\\Gesha\\Documents\\GitHub\\sirma-academy-java-2024\\matchanalyzer\\matchanalyzer\\src\\main\\resources\\data\\test\\records_test.csv");
    }

//    @GetMapping("/allRecords")
//    public ResponseEntity<Map<Long, List<PlayerRecordForMatchDTO>>> getAllRecords()
//    {
//        return ResponseEntity.ok(this.playerAnalysisService.getPlayerTimeForAllMatches());
//    }

    @GetMapping("/hopeThisWorks")
    public ResponseEntity<List<Map.Entry<PlayerPairDTO, Long>>> getPlayerPairTimeTogether()
    {
        return ResponseEntity.ok(this.playerAnalysisService.getPairsWithMostTime());
    }

}
