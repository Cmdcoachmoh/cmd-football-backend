package com.cmdfootball.service;

import com.cmdfootball.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    public List<Player> getAllPlayers() {
        // Stub data for testing — replace with real data source later
        return List.of(
            new Player(1L, "Amadou Diallo", "Midfielder", 14, 82.5, List.of("Effort", "Vision")),
            new Player(2L, "Lina Kassem", "Forward", 13, 91.2, List.of("Speed", "Finisher"))
        );
    }
}
