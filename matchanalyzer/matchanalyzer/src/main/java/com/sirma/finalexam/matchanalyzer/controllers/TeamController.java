package com.sirma.finalexam.matchanalyzer.controllers;

import com.sirma.finalexam.matchanalyzer.dtos.CreateTeamDTO;
import com.sirma.finalexam.matchanalyzer.entities.Team;
import com.sirma.finalexam.matchanalyzer.services.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/teams")
@RestController
public class TeamController {

    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping()
    public ResponseEntity<Team> createTeam(@RequestBody CreateTeamDTO teamDTO)
    {
        Team team = this.teamService.createTeam(teamDTO);
        return ResponseEntity.ok(team);
    }

}
