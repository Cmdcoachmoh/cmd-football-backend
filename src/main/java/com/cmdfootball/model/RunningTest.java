package com.cmdfootball.model;

public class RunningTest {
    private String playerName;
    private String day; // "Tuesday", "Wednesday", "Thursday"
    private int weekNumber; // e.g. 3 for Week 3
    private String sessionId; // e.g. "Week3-Tuesday"
    private int lapsCompleted;
    private int totalDistance; // meters
    private int minutes; // duration in minutes
    private double speed; // meters per minute
    private double vo2Estimate; // ml/kg/min

    // Default constructor (required for Spring/Jackson)
    public RunningTest() {}

    // Parameterized constructor
    public RunningTest(String playerName, String day, int weekNumber, String sessionId,
                       int lapsCompleted, int totalDistance, int minutes, double speed, double vo2Estimate) {
        this.playerName = playerName;
        this.day = day;
        this.weekNumber = weekNumber;
        this.sessionId = sessionId;
        this.lapsCompleted = lapsCompleted;
        this.totalDistance = totalDistance;
        this.minutes = minutes;
        this.speed = speed;
        this.vo2Estimate = vo2Estimate;
    }

    // Getters
    public String getPlayerName() {
        return playerName;
    }

    public String getDay() {
        return day;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public String getSessionId() {
        return sessionId;
    }

    public int getLapsCompleted() {
        return lapsCompleted;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public int getMinutes() {
        return minutes;
    }

    public double getSpeed() {
        return speed;
    }

    public double getVo2Estimate() {
        return vo2Estimate;
    }

    // Setters
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setLapsCompleted(int lapsCompleted) {
        this.lapsCompleted = lapsCompleted;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setVo2Estimate(double vo2Estimate) {
        this.vo2Estimate = vo2Estimate;
    }
}
