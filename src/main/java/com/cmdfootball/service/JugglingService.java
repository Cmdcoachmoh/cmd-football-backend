package com.cmdfootball.service;

import com.cmdfootball.dto.JugglingDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class JugglingService {

    public List<JugglingDTO> getAllJugglingLevels() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getResourceAsStream("/juggling.json");
            return mapper.readValue(is, new TypeReference<List<JugglingDTO>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to load juggling levels", e);
        }
    }
}

