package com.cmdfootball.dto;

public class PlayerSummaryDTO {

    private Long playerId;
    private String name;
    private double vo2Max;
    private boolean elite;

    // Getters and Setters

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVo2Max() {
        return vo2Max;
    }

    public void setVo2Max(double vo2Max) {
        this.vo2Max = vo2Max;
    }

    public boolean isElite() {
        return elite;
    }

    public void setElite(boolean elite) {
        this.elite = elite;
    }
}

