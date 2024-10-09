package com.sirma.finalexam.matchanalyzer.controllers;

import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerPairDTO;
import com.sirma.finalexam.matchanalyzer.dtos.playeranalysis.PlayerPairTotalTimeTogetherDTO;
import com.sirma.finalexam.matchanalyzer.services.PlayerAnalysisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/player-analysis")
public class PlayerAnalysisController {
    private final PlayerAnalysisService playerAnalysisService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerAnalysisController.class);

    public PlayerAnalysisController(PlayerAnalysisService playerAnalysisService) {
        this.playerAnalysisService = playerAnalysisService;
    }

    @GetMapping("/player-pairs/most-time-together")
    public ResponseEntity<Map<PlayerPairDTO, PlayerPairTotalTimeTogetherDTO>> getPlayerPairMostTimeTogether()
    {
        return ResponseEntity.ok(this.playerAnalysisService.getPairsWithMostTimeTogether());
    }

    @GetMapping("/player-pairs/time-together")
    public ResponseEntity<Map<PlayerPairDTO, PlayerPairTotalTimeTogetherDTO>> getPlayerPairTimeTogether()
    {
        return ResponseEntity.ok(this.playerAnalysisService.getPairsWithTimeTogether());
    }

}
