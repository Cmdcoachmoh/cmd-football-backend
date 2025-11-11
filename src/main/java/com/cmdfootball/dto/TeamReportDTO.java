package com.cmdfootball.dto;

import java.util.List;

public class TeamReportDTO {

    private Long teamId;
    private String teamName;
    private double averageVo2Max;
    private int eliteCount;
    private int trainingCount;
    private List<PlayerSummaryDTO> players;

    // Getters and Setters

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public double getAverageVo2Max() {
        return averageVo2Max;
    }

    public void setAverageVo2Max(double averageVo2Max) {
        this.averageVo2Max = averageVo2Max;
    }

    public int getEliteCount() {
        return eliteCount;
    }

    public void setEliteCount(int eliteCount) {
        this.eliteCount = eliteCount;
    }

    public int getTrainingCount() {
        return trainingCount;
    }

    public void setTrainingCount(int trainingCount) {
        this.trainingCount = trainingCount;
    }

    public List<PlayerSummaryDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerSummaryDTO> players) {
        this.players = players;
    }
}

