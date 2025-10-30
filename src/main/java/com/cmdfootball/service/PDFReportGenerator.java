package com.cmdfootball.service;

import com.cmdfootball.model.Team;
import com.cmdfootball.model.Player;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayOutputStream;

public class PDFReportGenerator {

    public static byte[] generateTeamReport(Team team) {
        try {
            Document document = new Document();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, outputStream);

            document.open();

            // 🔹 Title
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph title = new Paragraph("CMD Football Weekly Report", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // 🔹 Team Info
            Font infoFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            document.add(new Paragraph("Team: " + team.getName(), infoFont));
            document.add(new Paragraph("Coach: " + (team.getCoach() != null ? team.getCoach() : "N/A"), infoFont));
            document.add(new Paragraph("Average Effort Score: " + team.getAverageEffortScore(), infoFont));
            document.add(Chunk.NEWLINE);

            // 🔹 Player Table
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            addTableHeader(table, "Player Name", "Position", "Effort Score");

            for (Player player : team.getPlayers()) {
                table.addCell(player.getName());
                table.addCell(player.getPosition());
                table.addCell(String.valueOf(player.getEffortScore()));
            }

            document.add(table);
            document.close();

            return outputStream.toByteArray();

        } catch (DocumentException e) {
            throw new RuntimeException("❌ PDF generation failed: " + e.getMessage(), e);
        }
    }

    private static void addTableHeader(PdfPTable table, String... headers) {
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
        }
    }
}
