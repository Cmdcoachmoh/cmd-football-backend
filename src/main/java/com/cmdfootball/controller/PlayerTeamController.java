package com.cmdfootball.controller;

import com.cmdfootball.dto.PlayerGrowthDTO;
import com.cmdfootball.model.Player;
import com.cmdfootball.model.Team;
import com.cmdfootball.service.PlayerService;
import com.cmdfootball.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PlayerTeamController {

    private final PlayerService playerService;
    private final TeamService teamService;

    public PlayerTeamController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    // ✅ Health check endpoint
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("CMD Football backend is healthy");
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        System.out.println("Fetching all players...");
        return playerService.getAllPlayers();
    }

    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        System.out.println("Fetching all teams...");
        return teamService.getAllTeams();
    }

    @GetMapping("/player/{id}/growth")
    public PlayerGrowthDTO getPlayerGrowth(@PathVariable Long id) {
        System.out.println("Fetching growth for player ID: " + id);
        Player player = playerService.getPlayerById(id);
        return PlayerMapper.toDTO(player);
    }

    @GetMapping("/players/growth")
    public List<PlayerGrowthDTO> getAllPlayerGrowth() {
        System.out.println("Fetching growth for all players...");
        return playerService.getAllPlayers()
                .stream()
                .map(PlayerMapper::toDTO)
                .collect(Collectors.toList());
    }
}
