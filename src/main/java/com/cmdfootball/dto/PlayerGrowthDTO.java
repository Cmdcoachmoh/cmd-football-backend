package com.cmdfootball.dto;

public class PlayerGrowthDTO {

    private String name;
    private int score;

    public PlayerGrowthDTO() {
        // Default constructor for serialization/deserialization
    }

    public PlayerGrowthDTO(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    public void setVo2Max(Object vo2Max) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVo2Max'");
    }

    public void setTitle(Object title) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTitle'");
    }

    public void setAge(int age) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAge'");
    }

    public void setJugglingLevel(Object jugglingLevel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setJugglingLevel'");
    }

    public void setElite(Object elite) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setElite'");
    }
}


