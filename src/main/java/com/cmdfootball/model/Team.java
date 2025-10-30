package com.cmdfootball.model;

import java.util.Collections;
import java.util.List;

public class Team {

    private Long id;
    private String name;
    private String coach;
    private List<Player> players;
    private double averageEffortScore;

    // Default constructor
    public Team() {}

    // Full constructor
    public Team(Long id, String name, String coach, List<Player> players) {
        this.id = id;
        this.name = name;
        this.coach = coach;
        this.players = players;
        this.averageEffortScore = calculateAverageEffort(players);
    }

    // Convenience constructor (no ID, no coach)
    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = players;
        this.averageEffortScore = calculateAverageEffort(players);
    }

    // Convenience constructor (with coach, no ID)
    public Team(String name, String coach, List<Player> players) {
        this.name = name;
        this.coach = coach;
        this.players = players;
        this.averageEffortScore = calculateAverageEffort(players);
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCoach() { return coach; }
    public void setCoach(String coach) { this.coach = coach; }

    public List<Player> getPlayers() {
        return players != null ? players : Collections.emptyList();
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
        this.averageEffortScore = calculateAverageEffort(players);
    }

    public double getAverageEffortScore() { return averageEffortScore; }
    public void setAverageEffortScore(double score) { this.averageEffortScore = score; }

    // Utility method
    private double calculateAverageEffort(List<Player> players) {
        if (players == null || players.isEmpty()) return 0.0;
        return players.stream()
                      .mapToDouble(Player::getEffortScore)
                      .average()
                      .orElse(0.0);
    }

    // Optional: for logging/debugging
    @Override
    public String toString() {
        return "Team{name='" + name + "', coach='" + coach + "', avgEffort=" + averageEffortScore + "}";
    }
}