package com.cmdfootball.export;

import java.time.LocalDateTime;

public class DrillAttempt {

    private Long id;
    private Long playerId;
    private String drillName;
    private int score;
    private boolean successful;
    private LocalDateTime timestamp;

    // Constructors
    public DrillAttempt() {}

    public DrillAttempt(Long id, Long playerId, String drillName, int score, boolean successful, LocalDateTime timestamp) {
        this.id = id;
        this.playerId = playerId;
        this.drillName = drillName;
        this.score = score;
        this.successful = successful;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPlayerId() { return playerId; }
    public void setPlayerId(Long playerId) { this.playerId = playerId; }

    public String getDrillName() { return drillName; }
    public void setDrillName(String drillName) { this.drillName = drillName; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public boolean isSuccessful() { return successful; }
    public void setSuccessful(boolean successful) { this.successful = successful; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
