package com.cmdfootball.model;

import java.util.List;

public class Coach {

    private Long id;
    private String name;
    private String email;
    private String federationId;
    private List<Long> drillIds;

    public Coach(Long id, String name, String email, String federationId, List<Long> drillIds) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.federationId = federationId;
        this.drillIds = drillIds;
    }

    // 🔹 Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getFederationId() {
        return federationId;
    }

    public List<Long> getDrillIds() {
        return drillIds;
    }

    // 🔹 Setters (optional, if you plan to modify coach data)
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFederationId(String federationId) {
        this.federationId = federationId;
    }

    public void setDrillIds(List<Long> drillIds) {
        this.drillIds = drillIds;
    }

    // 🔹 Optional: toString for logging/debug
    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", federationId='" + federationId + '\'' +
                ", drillIds=" + drillIds +
                '}';
    }
}