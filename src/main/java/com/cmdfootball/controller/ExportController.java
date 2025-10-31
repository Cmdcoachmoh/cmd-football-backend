package com.cmdfootball.controller;

import com.cmdfootball.model.Player;
import com.cmdfootball.model.Team;
import com.cmdfootball.service.ExportService;
import com.itextpdf.text.DocumentException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/export")
@Tag(name = "Export", description = "Endpoints for exporting team reports")
public class ExportController {

    @Autowired
    private ExportService exportService;

    // 🔹 Sample team generator (replace with real data source later)
    private Team mockTeam() {
        List<Player> players = Arrays.asList(
            new Player("Ali", "Midfielder", 92),
            new Player("Sara", "Forward", 88)
        );
        return new Team(null, "team-001", "U14 Elite", players);
    }

    @Operation(summary = "Export team report as CSV")
    @GetMapping("/csv")
    public ResponseEntity<Resource> exportCsv() {
        try {
            Team team = mockTeam(); // Replace with real team loading logic
            File file = exportService.generateWeeklyCsv(team);
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

            return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName())
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(resource);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Export team report as PDF")
    @GetMapping("/pdf")
    public ResponseEntity<Resource> exportPdf() {
        try {
            Team team = mockTeam(); // Replace with real team loading logic
            File file = exportService.generateWeeklyPdf(team);
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

            return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName())
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
        } catch (IOException | DocumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}