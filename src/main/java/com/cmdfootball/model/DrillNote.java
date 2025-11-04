package com.cmdfootball.model;

public class DrillNote {
    private String playerName;
    private String drillName;
    private int score; // +1 for Bonus, -1 for Malus
    private String comment;

    // Default constructor (required for deserialization)
    public DrillNote() {}

    // Parameterized constructor
    public DrillNote(String playerName, String drillName, int score, String comment) {
        this.playerName = playerName;
        this.drillName = drillName;
        this.score = score;
        this.comment = comment;
    }

    // Getters
    public String getPlayerName() {
        return playerName;
    }

    public String getDrillName() {
        return drillName;
    }

    public int getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    // Setters
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setDrillName(String drillName) {
        this.drillName = drillName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
