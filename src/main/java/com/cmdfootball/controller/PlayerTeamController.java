package com.cmdfootball.controller;

import com.cmdfootball.dto.PlayerGrowthDTO;
import com.cmdfootball.model.Player;
import com.cmdfootball.model.Team;
import com.cmdfootball.service.PlayerService;
import com.cmdfootball.service.TeamService;
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

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    // 🆕 Individual player growth for charting
    @GetMapping("/player/{id}/growth")
    public PlayerGrowthDTO getPlayerGrowth(@PathVariable Long id) {
        Player player = playerService.getPlayerById(id);
        return PlayerMapper.toDTO(player);
    }

    // 🆕 Step 1: Team-level growth chart data
    @GetMapping("/players/growth")
    public List<PlayerGrowthDTO> getAllPlayerGrowth() {
        return playerService.getAllPlayers()
                .stream()
                .map(PlayerMapper::toDTO)
                .collect(Collectors.toList());
    }
}
