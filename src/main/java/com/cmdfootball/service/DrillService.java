package com.cmdfootball.service;

import com.cmdfootball.dto.DrillDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class DrillService {

    public List<DrillDTO> getAllDrills() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getResourceAsStream("/drills.json");
            return mapper.readValue(is, new TypeReference<List<DrillDTO>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to load drills", e);
        }
    }
}
