package com.cmdfootball.util;

import com.cmdfootball.model.Team;
import com.cmdfootball.model.Player;

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
        ByteArrayOutputStream zipStream = new ByteArrayOutputStream();
        ZipOutputStream zipOut = new ZipOutputStream(zipStream);

        // CSV report
        String csv = CSVExporter.exportPlayers(team.getPlayers());
        zipOut.putNextEntry(new ZipEntry("squad.csv"));
        zipOut.write(csv.getBytes(StandardCharsets.UTF_8));
        zipOut.closeEntry();

        // PDF report
        byte[] pdf = PDFReportGenerator.generateTeamReport(team);
        zipOut.putNextEntry(new ZipEntry("report.pdf"));
        zipOut.write(pdf);
        zipOut.closeEntry();

        zipOut.finish();
        zipOut.close();

        return zipStream.toByteArray();
    }

    /**
     * Bundles multiple teams into a ZIP of CSV summaries.
     *
     * @param teams list of teams
     * @return byte array of ZIP content
     * @throws IOException if bundling fails
     */
    public static byte[] bundleTeamSummaries(List<Team> teams) throws IOException {
        ByteArrayOutputStream zipStream = new ByteArrayOutputStream();
        ZipOutputStream zipOut = new ZipOutputStream(zipStream);

        for (Team team : teams) {
            String csv = CSVExporter.exportPlayers(team.getPlayers());
            String filename = "team_" + team.getId() + "_" + team.getName().replaceAll("\\s+", "_") + ".csv";
            zipOut.putNextEntry(new ZipEntry(filename));
            zipOut.write(csv.getBytes(StandardCharsets.UTF_8));
            zipOut.closeEntry();
        }

        zipOut.finish();
        zipOut.close();

        return zipStream.toByteArray();
    }
}