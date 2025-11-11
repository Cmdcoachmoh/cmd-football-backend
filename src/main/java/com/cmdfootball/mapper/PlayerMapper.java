package com.cmdfootball.mapper;

import com.cmdfootball.dto.PlayerGrowthDTO;
import com.cmdfootball.model.Player;

public class PlayerMapper {

    public static PlayerGrowthDTO toDTO(Player player) {
        PlayerGrowthDTO dto = new PlayerGrowthDTO();
        dto.setId(player.getId());
        dto.setName(player.getName());
        dto.setTitle(player.getTitle());
        dto.setAge(player.getAge());
        dto.setJugglingLevel(player.getJugglingLevel());
        dto.setVo2Max(player.getVo2Max());
        dto.setElite(BadgeUtil.isElite(player.getVo2Max()));
        return dto;
    }
}
