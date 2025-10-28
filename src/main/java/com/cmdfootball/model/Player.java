package com.cmdfootball.model;

import java.util.List;

public class Player {

    private Long id;
    private String name;
    private String position;
    private int age;
    private double effortScore;
    private List<String> badges;

    // Constructors
    public Player() {}

    public Player(Long id, String name, String position, int age, double effortScore, List<String> badges) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.age = age;
        this.effortScore = effortScore;
        this.badges = badges;
        
    }
    

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getEffortScore() { return effortScore; }
    public void setEffortScore(double effortScore) { this.effortScore = effortScore; }

    public List<String> getBadges() { return badges; }
    public void setBadges(List<String> badges) { this.badges = badges; }
}
