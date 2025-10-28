package com.cmdfootball.controller;

import com.cmdfootball.model.Player;
import com.cmdfootball.service.PdfReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/report")
public class PdfExportController {

    @Autowired
    private PdfReportService pdfReportService;

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> exportPdf() {
        try {
            // Replace with actual player service or mock data
            List<Player> players = List.of(
                new Player(1L, "Amir Salah", "Midfielder", 14, 72.5, List.of("Pro")),
                new Player(2L, "Lina K.", "Defender", 13, 85.0, List.of("Elite", "Captain")),
                new Player(3L, "Jayden M.", "Forward", 12, 60.0, List.of("Rising"))
            );

            byte[] pdf = pdfReportService.createPdfReport(players);
            String filename = "coach-report-" + LocalDate.now() + ".pdf";

            return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(pdf.length))
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
                .body(("PDF generation failed: " + e.getMessage()).getBytes());
        }
    }
}