package com.cmdfootball.controller;

import com.cmdfootball.dto.DrillDTO;
import com.cmdfootball.service.DrillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drills")
@CrossOrigin(origins = "*") // Optional: allows frontend access from any domain
public class DrillController {

    private final DrillService drillService;

    public DrillController(DrillService drillService) {
        this.drillService = drillService;
    }

    // GET: Return all drills (from JSON or DB)
    @GetMapping
    public List<DrillDTO> getAllDrills() {
        return drillService.getAllDrills();
    }

    // POST: Accept new drill from frontend
    @PostMapping
    public ResponseEntity<String> createDrill(@RequestBody DrillDTO drill) {
        // You can later persist this to a DB or in-memory store
        System.out.println("Received drill: " + drill.getName());
        return ResponseEntity.ok("Drill \"" + drill.getName() + "\" saved successfully.");
    }
}

