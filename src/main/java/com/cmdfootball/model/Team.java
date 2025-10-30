package com.cmdfootball.model;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private Long id;
    private String name;
    private String coach;
    private List<Player> players = new ArrayList<>();
    private double averageEffortScore;

    // 🔹 Constructors
    public Team() {}

    public Team(Long id, String name, String coach, List<Player> players) {
        this.id = id;
        this.name = name;
        this.coach = coach;
        setPlayers(players); // ensures effort score is calculated safely
    }

    // 🔹 Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCoach() { return coach; }
    public void setCoach(String coach) { this.coach = coach; }

    public List<Player> getPlayers() { return players; }
    public void setPlayers(List<Player> players) {
        this.players = (players != null) ? players : new ArrayList<>();
        this.averageEffortScore = calculateAverageEffort(this.players);
    }

    public double getAverageEffortScore() { return averageEffortScore; }

    // 🔹 Utility method
    private double calculateAverageEffort(List<Player> players) {
        return players.stream()
                      .mapToDouble(Player::getEffortScore)
                      .average()
                      .orElse(0.0);
    }
}