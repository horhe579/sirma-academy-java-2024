package com.sirma.finalexam.matchanalyzer.controllers;

import com.sirma.finalexam.matchanalyzer.csvparsers.CsvMatchProcessor;
import com.sirma.finalexam.matchanalyzer.csvparsers.CsvPlayerProcessor;
import com.sirma.finalexam.matchanalyzer.csvparsers.CsvRecordProcessor;
import com.sirma.finalexam.matchanalyzer.csvparsers.CsvTeamProcessor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/test")
public class TestController {
    private CsvMatchProcessor csvMatchProcessor;
    private CsvPlayerProcessor csvPlayerProcessor;
    private CsvTeamProcessor csvTeamProcessor;
    private CsvRecordProcessor csvRecordProcessor;

    public TestController(CsvMatchProcessor csvMatchProcessor, CsvPlayerProcessor csvPlayerProcessor,
                          CsvTeamProcessor csvTeamProcessor, CsvRecordProcessor csvRecordProcessor) {
        this.csvMatchProcessor = csvMatchProcessor;
        this.csvPlayerProcessor = csvPlayerProcessor;
        this.csvTeamProcessor = csvTeamProcessor;
        this.csvRecordProcessor = csvRecordProcessor;
    }

    @Transactional
    @GetMapping("/parseMatches")
    public void parseMatches() throws IOException {
        csvTeamProcessor.parseCsv("C:\\Users\\Gesha\\Documents\\GitHub\\sirma-academy-java-2024\\matchanalyzer\\matchanalyzer\\src\\main\\resources\\data\\teams.csv");
        csvPlayerProcessor.parseCsv("C:\\Users\\Gesha\\Documents\\GitHub\\sirma-academy-java-2024\\matchanalyzer\\matchanalyzer\\src\\main\\resources\\data\\players.csv");
        csvMatchProcessor.parseCsv("C:\\Users\\Gesha\\Documents\\GitHub\\sirma-academy-java-2024\\matchanalyzer\\matchanalyzer\\src\\main\\resources\\data\\matches.csv");
        csvRecordProcessor.parseCsv("C:\\Users\\Gesha\\Documents\\GitHub\\sirma-academy-java-2024\\matchanalyzer\\matchanalyzer\\src\\main\\resources\\data\\records.csv");
    }
}
