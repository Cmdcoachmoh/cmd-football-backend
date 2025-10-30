package com.cmdfootball.service;

import com.cmdfootball.model.Team;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class ExportService {

    @Autowired
    private WeeklyReportGenerator reportGenerator;

    public File generateWeeklyCsv(Team team) throws IOException {
        return reportGenerator.generateWeeklyCsv(team);
    }

    public File generateWeeklyPdf(Team team) throws IOException, DocumentException {
        return reportGenerator.generateWeeklyPdf(team);
    }

    public File generateWeeklyZip(Team team) throws IOException, DocumentException {
        return reportGenerator.generateWeeklyZip(team);
    }
}