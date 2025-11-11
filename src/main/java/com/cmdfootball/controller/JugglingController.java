package com.cmdfootball.controller;

import com.cmdfootball.dto.JugglingDTO;
import com.cmdfootball.service.JugglingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/juggling")
@CrossOrigin(origins = "*") // Optional: allows frontend access from any domain
public class JugglingController {

    private final JugglingService jugglingService;

    public JugglingController(JugglingService jugglingService) {
        this.jugglingService = jugglingService;
    }

    // GET: Return all juggling levels (from JSON or DB)
    @GetMapping
    public List<JugglingDTO> getAllJugglingLevels() {
        return jugglingService.getAllJugglingLevels();
    }

    // POST: Accept new juggling level or freestyle entry
    @PostMapping
    public ResponseEntity<String> createJugglingLevel(@RequestBody JugglingDTO juggling) {
        // You can later persist this to a DB or in-memory store
        System.out.println("Received juggling level: " + juggling.getTitle());
        return ResponseEntity.ok("Juggling level \"" + juggling.getTitle() + "\" saved successfully.");
    }
}

