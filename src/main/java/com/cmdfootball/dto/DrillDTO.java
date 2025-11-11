package com.cmdfootball.dto;

public class DrillDTO {
    private String name;
    private String description;
    private int bonus;
    private int malus;
    private int minLevel;
    private String category;     // "drill", "fitness", etc.
    private boolean isTrackable; // true for VO₂ or sprint-based drills

    // No-arg constructor
    public DrillDTO() {}

    // Full constructor
    public DrillDTO(String name, String description, int bonus, int malus, int minLevel, String category, boolean isTrackable) {
        this.name = name;
        this.description = description;
        this.bonus = bonus;
        this.malus = malus;
        this.minLevel = minLevel;
        this.category = category;
        this.isTrackable = isTrackable;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getMalus() {
        return malus;
    }

    public void setMalus(int malus) {
        this.malus = malus;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
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
