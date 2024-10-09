package com.sirma.finalexam.matchanalyzer.controllers;

import com.sirma.finalexam.matchanalyzer.dtos.create.CreatePlayerDTO;
import com.sirma.finalexam.matchanalyzer.entities.Player;
import com.sirma.finalexam.matchanalyzer.exceptions.TeamNotFoundException;
import com.sirma.finalexam.matchanalyzer.services.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/players")
@RestController
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<Player>> getPlayers()
    {
        List<Player> players = this.playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long playerId)
    {
        Player player = this.playerService.getPlayerById(playerId);
        if(player == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(player);
    }

    @PostMapping()
    public ResponseEntity<Player> createPlayer(@RequestBody CreatePlayerDTO playerDTO)
    {
        Player player = this.playerService.createPlayer(playerDTO);
        if(player!=null) {
            return ResponseEntity.ok(player);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{playerId}")
    //Reusing the same DTO since i do not want repeating code, created a TeamResponseDTO because its weird to use the creation one
    public ResponseEntity<Player> updatePlayer(@PathVariable Long playerId, @RequestBody CreatePlayerDTO updatedPlayer)
    {
        Player player = null;
        try {
            player = this.playerService.updatePlayer(playerId, updatedPlayer);
        } catch (TeamNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        if(player!=null)
        {
            return ResponseEntity.ok(player);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<Player> deletePlayer(@PathVariable Long playerId)
    {
        boolean isDeleted = playerService.deletePlayerById(playerId);

        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
