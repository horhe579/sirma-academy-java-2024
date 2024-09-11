package com.sirma.finalexam.matchanalyzer.controllers;

import com.sirma.finalexam.matchanalyzer.dtos.create.CreateMatchDTO;
import com.sirma.finalexam.matchanalyzer.entities.Match;
import com.sirma.finalexam.matchanalyzer.entities.Team;
import com.sirma.finalexam.matchanalyzer.exceptions.TeamNotFoundException;
import com.sirma.finalexam.matchanalyzer.services.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/matches")
@RestController
public class MatchController {

    private MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public ResponseEntity<List<Match>> getMatches()
    {
        List<Match> matches = this.matchService.getAllMatches();
        return ResponseEntity.ok(matches);
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long matchId)
    {
        Match match = this.matchService.getMatchById(matchId);
        if(match == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(match);
    }

    @PostMapping()
    public ResponseEntity<Match> createMatch(@RequestBody CreateMatchDTO matchDTO)
    {
        Match match = this.matchService.createMatch(matchDTO);
        if(match!=null)
        {
            return ResponseEntity.ok(match);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{matchId}")
    //Reusing the same DTO since i do not want repeating code, created a TeamResponseDTO because its weird to use the creation one
    public ResponseEntity<Match> updateMatch(@PathVariable Long matchId, @RequestBody CreateMatchDTO updatedMatch)
    {
        Match match = null;
        try {
            match = this.matchService.updateMatch(matchId, updatedMatch);
        } catch (TeamNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        if(match!=null)
        {
            return ResponseEntity.ok(match);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{matchId}")
    public ResponseEntity<Match> deleteMatch(@PathVariable Long matchId)
    {
        boolean isDeleted = matchService.deleteMatchById(matchId);

        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
