package com.cmdfootball.dto;

public class PlayerGrowth {
    private String name;
    private int score;

    public PlayerGrowth(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

