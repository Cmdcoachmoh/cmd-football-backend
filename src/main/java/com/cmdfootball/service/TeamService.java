package com.cmdfootball.service;

import com.cmdfootball.model.Team;
import com.cmdfootball.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    public List<Team> getAllTeams() {
        // Stub team with embedded players
        List<Player> players = List.of(
            new Player(1L, "Amadou Diallo", "Midfielder", 14, 82.5, List.of("Effort", "Vision")),
            new Player(2L, "Lina Kassem", "Forward", 13, 91.2, List.of("Speed", "Finisher"))
        );

        return List.of(
            new Team(101L, "CMD U14", "Coach Mohamad", players)
        );
    }
}