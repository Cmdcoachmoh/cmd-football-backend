package com.cmdfootball.controller;

import com.cmdfootball.dto.PlayerGrowth;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @GetMapping("/metrics")
    public ResponseEntity<Map<String, Object>> getMetrics() {
        List<PlayerGrowth> growth = List.of(
            new PlayerGrowth("Ali", 65),
            new PlayerGrowth("Zara", 72),
            new PlayerGrowth("Leo", 78),
            new PlayerGrowth("Maya", 85)
        );

        Map<String, Object> metrics = Map.of(
            "effortScore", 92,
            "growth", growth
        );

        return ResponseEntity.ok(metrics);
    }
}



