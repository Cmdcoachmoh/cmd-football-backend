package com.cmdfootball.controller;

import com.cmdfootball.dto.PlayerGrowthDTO;
import com.cmdfootball.model.Player;

public class PlayerMapper {

    public static PlayerGrowthDTO toDTO(Player player) {
        PlayerGrowthDTO dto = new PlayerGrowthDTO();

        // Safely map basic fields
        dto.setId(player.getId());
        dto.setName(player.getName());
        dto.setPosition(player.getPosition());

        // Safely compute growth score
        try {
            dto.setScore(player.calculateGrowthScore());
        } catch (Exception e) {
            dto.setScore(0.0); // fallback value
        }

        // Safely map team name
        if (player.getTitle() != null && ((PlayerGrowthDTO) player.getTitle()).getName() != null) {
            dto.setTeamName(((PlayerGrowthDTO) player.getTitle()).getName());
        } else {
            dto.setTeamName("Unassigned");
        }

        return dto;
    }
}
