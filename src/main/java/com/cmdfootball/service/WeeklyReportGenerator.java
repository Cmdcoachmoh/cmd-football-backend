package com.cmdfootball.service;

import com.cmdfootball.model.Team;
import com.cmdfootball.service.CSVExporter;
import com.cmdfootball.service.PDFReportGenerator;
import com.cmdfootball.service.ReportBundler;
import com.itextpdf.text.DocumentException;


import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class WeeklyReportGenerator {

    private static final String OUTPUT_DIR = "weekly-reports/";

    public File generateWeeklyCsv(Team team) throws IOException {
        ensureOutputDirectory();
        String csv = CSVExporter.exportPlayers(team.getPlayers());
        String filename = "squad-" + resolveTeamId(team) + ".csv";
        String path = OUTPUT_DIR + filename;
        Files.write(Paths.get(path), csv.getBytes());
        return new File(path);
    }

    public File generateWeeklyPdf(Team team) throws IOException, DocumentException {
        ensureOutputDirectory();
        byte[] pdf = PDFReportGenerator.generateTeamReport(team);
        String filename = "report-" + resolveTeamId(team) + ".pdf";
        String path = OUTPUT_DIR + filename;
        try (FileOutputStream out = new FileOutputStream(path)) {
            out.write(pdf);
        }
        return new File(path);
    }

    public File generateWeeklyZip(Team team) throws IOException, DocumentException {
        ensureOutputDirectory();
        byte[] zip = ReportBundler.bundleTeamReports(team);
        String filename = "bundle-" + resolveTeamId(team) + ".zip";
        String path = OUTPUT_DIR + filename;
        try (FileOutputStream out = new FileOutputStream(path)) {
            out.write(zip);
        }
        return new File(path);
    }

    // 🔹 Utility: ensure directory exists
    private void ensureOutputDirectory() throws IOException {
        Files.createDirectories(Paths.get(OUTPUT_DIR));
    }

    // 🔹 Utility: fallback if team ID is null
    private String resolveTeamId(Team team) {
        return (team.getId() != null) ? team.getId().toString() : team.getName().replaceAll("\\s+", "_");
    }
}