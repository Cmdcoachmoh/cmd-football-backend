package com.cmdfootball.dto;

public class JugglingDTO {
    private int level;
    private String title;
    private String description;
    private String category;     // "juggling", "fitness", etc.
    private boolean isTrackable; // true for VO₂ or sprint-based tests

    // No-arg constructor
    public JugglingDTO() {}

    // Full constructor
    public JugglingDTO(int level, String title, String description, String category, boolean isTrackable) {
        this.level = level;
        this.title = title;
        this.description = description;
        this.category = category;
        this.isTrackable = isTrackable;
    }

    // Getters and Setters
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isTrackable() {
        return isTrackable;
    }

    public void setTrackable(boolean trackable) {
        isTrackable = trackable;
    }
}
