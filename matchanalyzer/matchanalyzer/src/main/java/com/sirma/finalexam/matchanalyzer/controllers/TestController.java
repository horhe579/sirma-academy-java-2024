package com.sirma.finalexam.matchanalyzer.controllers;

import com.sirma.finalexam.matchanalyzer.csvparsers.CsvMatchProcessor;
import com.sirma.finalexam.matchanalyzer.csvparsers.CsvPlayerProcessor;
import com.sirma.finalexam.matchanalyzer.csvparsers.CsvRecordProcessor;
import com.sirma.finalexam.matchanalyzer.csvparsers.CsvTeamProcessor;
import com.sirma.finalexam.matchanalyzer.repositories.RecordRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    private CsvMatchProcessor csvMatchProcessor;
    private CsvPlayerProcessor csvPlayerProcessor;
    private CsvTeamProcessor csvTeamProcessor;
    private CsvRecordProcessor csvRecordProcessor;
    private RecordRepository recordRepository;

    public TestController(CsvMatchProcessor csvMatchProcessor, CsvPlayerProcessor csvPlayerProcessor,
                          CsvTeamProcessor csvTeamProcessor, CsvRecordProcessor csvRecordProcessor,
                          RecordRepository recordRepository) {
        this.csvMatchProcessor = csvMatchProcessor;
        this.csvPlayerProcessor = csvPlayerProcessor;
        this.csvTeamProcessor = csvTeamProcessor;
        this.csvRecordProcessor = csvRecordProcessor;
        this.recordRepository = recordRepository;
    }

    @Transactional
    @GetMapping("/parseMatches")
    public void parseMatches() throws IOException {
        csvTeamProcessor.parseCsv("C:\\Users\\Gesha\\Documents\\GitHub\\sirma-academy-java-2024\\matchanalyzer\\matchanalyzer\\src\\main\\resources\\data\\teams.csv");
        csvPlayerProcessor.parseCsv("C:\\Users\\Gesha\\Documents\\GitHub\\sirma-academy-java-2024\\matchanalyzer\\matchanalyzer\\src\\main\\resources\\data\\players.csv");
        csvMatchProcessor.parseCsv("C:\\Users\\Gesha\\Documents\\GitHub\\sirma-academy-java-2024\\matchanalyzer\\matchanalyzer\\src\\main\\resources\\data\\matches.csv");
        csvRecordProcessor.parseCsv("C:\\Users\\Gesha\\Documents\\GitHub\\sirma-academy-java-2024\\matchanalyzer\\matchanalyzer\\src\\main\\resources\\data\\records.csv");
    }

    @GetMapping("/allrecords")
    public ResponseEntity<List<Object[]>> getAllRecords()
    {
        return ResponseEntity.ok(this.recordRepository.getAllPlayerRecords());
    }

}
