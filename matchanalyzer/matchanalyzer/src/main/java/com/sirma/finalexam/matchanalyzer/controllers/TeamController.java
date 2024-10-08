package com.sirma.finalexam.matchanalyzer.controllers;

import com.sirma.finalexam.matchanalyzer.dtos.create.CreateTeamDTO;
import com.sirma.finalexam.matchanalyzer.entities.Team;
import com.sirma.finalexam.matchanalyzer.exceptions.TeamNotFoundException;
import com.sirma.finalexam.matchanalyzer.services.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//IF I HAVE TIME LEFT IMPLEMENT AUTHORIZATION

@RequestMapping("/teams")
@RestController
public class TeamController {

    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<Team>> getTeams()
    {
        List<Team> teams = this.teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<Team> getUserById(@PathVariable Long teamId)
    {
        Team team = this.teamService.getTeamById(teamId);
        if(team == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(team);
    }

    @PostMapping()
    public ResponseEntity<Team> createTeam(@RequestBody CreateTeamDTO teamDTO)
    {
        Team team = this.teamService.createTeam(teamDTO);
        if(team!=null)
        {
            return ResponseEntity.ok(team);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{teamId}")
    //Reusing the same DTO since i do not want repeating code, created a TeamResponseDTO because its weird to use the creation one
    public ResponseEntity<Team> updateTeam(@PathVariable Long teamId, @RequestBody CreateTeamDTO updatedTeam)
    {
        Team team = null;
        try {
            team = this.teamService.updateTeam(teamId, updatedTeam);
        } catch (TeamNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        if(team!=null)
        {
            return ResponseEntity.ok(team);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{teamId}")
    public ResponseEntity<Team> deleteTeam(@PathVariable Long teamId)
    {
        boolean isDeleted = teamService.deleteTeamById(teamId);

        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
