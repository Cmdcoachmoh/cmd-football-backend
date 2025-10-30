package com.cmdfootball.export;

import com.cmdfootball.model.Team;
import com.cmdfootball.model.Player;
import com.cmdfootball.service.CSVExporter;
import com.cmdfootball.service.PDFReportGenerator;

import com.itextpdf.text.DocumentException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ReportBundler {

    /**
     * Bundles CSV and PDF reports into a single ZIP archive.
     *
     * @param team the team to generate reports for
     * @return byte array of ZIP content
     * @throws IOException if bundling fails
     * @throws DocumentException if PDF generation fails
     */
    public static byte[] bundleTeamReports(Team team) throws IOException, DocumentException {
        try (ByteArrayOutputStream zipStream = new ByteArrayOutputStream();
             ZipOutputStream zipOut = new ZipOutputStream(zipStream)) {

            // CSV report
            String csv = CSVExporter.exportPlayers(team.getPlayers());
            addZipEntry(zipOut, "squad.csv", csv.getBytes(StandardCharsets.UTF_8));

            // PDF report
            byte[] pdf = PDFReportGenerator.generateTeamReport(team);
            addZipEntry(zipOut, "report.pdf", pdf);

            zipOut.finish();
            return zipStream.toByteArray();
        }
    }

    /**
     * Bundles multiple teams into a ZIP of CSV summaries.
     *
     * @param teams list of teams
     * @return byte array of ZIP content
     * @throws IOException if bundling fails
     */
    public static byte[] bundleTeamSummaries(List<Team> teams) throws IOException {
        try (ByteArrayOutputStream zipStream = new ByteArrayOutputStream();
             ZipOutputStream zipOut = new ZipOutputStream(zipStream)) {

            for (Team team : teams) {
                String csv = CSVExporter.exportPlayers(team.getPlayers());
                String filename = "team_" + team.getId() + "_" + team.getName().replaceAll("\\s+", "_") + ".csv";
                addZipEntry(zipOut, filename, csv.getBytes(StandardCharsets.UTF_8));
            }

            zipOut.finish();
            return zipStream.toByteArray();
        }
    }

    // 🔹 Utility method to add entries to ZIP
    private static void addZipEntry(ZipOutputStream zipOut, String name, byte[] content) throws IOException {
        zipOut.putNextEntry(new ZipEntry(name));
        zipOut.write(content);
        zipOut.closeEntry();
    }
}