package com.sirma.finalexam.matchanalyzer.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sirma.finalexam.matchanalyzer.dtos.PlayerPairDTO;

@RestController
@RequestMapping("/pair")
public class PlayerAnalysisController {

    @GetMapping("/most-time-together")
    public ResponseEntity<PlayerPairDTO> getPairOfPlayersWithMostTimeTogether()
    {
        return ResponseEntity.ok(new PlayerPairDTO());
    }
}
