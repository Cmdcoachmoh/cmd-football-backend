package com.cmdfootball.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @GetMapping("/metrics")
    public ResponseEntity<Map<String, Object>> getMetrics() {
        List<PlayerGrowth> growth = List.of(
            new PlayerGrowth(),
            new PlayerGrowth(),
            new PlayerGrowth(),
            new PlayerGrowth()
        );

        Map<String, Object> metrics = Map.of(
            "effortScore", 92,
            "growth", growth
        );

        return ResponseEntity.ok(metrics);
    }
}



