package com.cmdfootball.service;

import com.cmdfootball.model.Player;
import com.cmdfootball.model.Team;
import com.cmdfootball.service.PDFReportGenerator;

import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfReportService {

    /**
     * Generates a PDF report for a given team.
     *
     * @param team the team to generate the report for
     * @return byte array of the PDF content
     */
    public byte[] generateTeamPdf(Team team) {
        return PDFReportGenerator.generateTeamReport(team);
    }

    public byte[] createPdfReport(List<Player> players) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPdfReport'");
    }
}
