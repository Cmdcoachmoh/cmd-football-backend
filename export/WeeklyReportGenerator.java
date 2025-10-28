package com.cmdfootball.service;

import com.cmdfootball.model.Team;
import com.cmdfootball.util.CSVExporter;
import com.cmdfootball.util.PDFReportGenerator;
import com.cmdfootball.util.ReportBundler;

import com.itextpdf.text.DocumentException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WeeklyReportGenerator {

    private static final String OUTPUT_DIR = "weekly-reports/";

    public static void generateWeeklyReport(Team team) {
        try {
            // Ensure output directory exists
            Files.createDirectories(Paths.get(OUTPUT_DIR));

            // Generate CSV
            String csv = CSVExporter.exportPlayers(team.getPlayers());
            String csvPath = OUTPUT_DIR + "squad-" + team.getId() + ".csv";
            Files.write(Paths.get(csvPath), csv.getBytes());

            // Generate PDF
            byte[] pdf = PDFReportGenerator.generateTeamReport(team);
            String pdfPath = OUTPUT_DIR + "report-" + team.getId() + ".pdf";
            try (FileOutputStream pdfOut = new FileOutputStream(pdfPath)) {
                pdfOut.write(pdf);
            }

            // Bundle ZIP
            byte[] zip = ReportBundler.bundleTeamReports(team);
            String zipPath = OUTPUT_DIR + "bundle-" + team.getId() + ".zip";
            try (FileOutputStream zipOut = new FileOutputStream(zipPath)) {
                zipOut.write(zip);
            }

            System.out.println("✅ Weekly report generated for team: " + team.getName());

        } catch (IOException | DocumentException e) {
            System.err.println("❌ Failed to generate weekly report: " + e.getMessage());
        }
    }
}