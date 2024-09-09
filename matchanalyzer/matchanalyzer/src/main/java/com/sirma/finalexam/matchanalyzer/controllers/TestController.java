package com.sirma.finalexam.matchanalyzer.controllers;

import com.sirma.finalexam.matchanalyzer.csvparsers.CsvMatchProcessor;
import com.sirma.finalexam.matchanalyzer.csvparsers.CsvTeamProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/test")
public class TestController {
    private CsvMatchProcessor csvMatchProcessor;
    private CsvTeamProcessor csvTeamProcessor;

    public TestController(CsvMatchProcessor csvMatchProcessor, CsvTeamProcessor csvTeamProcessor)
    {
        this.csvMatchProcessor = csvMatchProcessor;
        this.csvTeamProcessor = csvTeamProcessor;
    }

    @GetMapping("/parseMatches")
    public void parseMatches() throws IOException {
        csvTeamProcessor.parseCsv("C:\\Users\\Gesha\\Documents\\GitHub\\sirma-academy-java-2024\\matchanalyzer\\matchanalyzer\\src\\main\\resources\\data\\teams.csv");
        csvMatchProcessor.parseCsv("C:\\Users\\Gesha\\Documents\\GitHub\\sirma-academy-java-2024\\matchanalyzer\\matchanalyzer\\src\\main\\resources\\data\\matches.csv");
    }
}
