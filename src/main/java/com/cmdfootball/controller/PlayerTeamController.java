package com.cmdfootball.controller;

import com.cmdfootball.model.Player;
import com.cmdfootball.model.Team;
import com.cmdfootball.service.PlayerService;
import com.cmdfootball.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
