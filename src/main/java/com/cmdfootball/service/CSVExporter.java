package com.cmdfootball.service;

import com.cmdfootball.model.Player;
import com.cmdfootball.model.Team;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

public class CSVExporter {
    // your export logic here

    public static String exportPlayers(List<Player> players) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        // Header
        writer.println("ID,Name,Position,Age,Effort Score,Badges");

        // Rows
        for (Player p : players) {
            writer.printf("%d,%s,%s,%d,%.2f,%s%n",
                p.getId(),
                escape(p.getName()),
                p.getPosition(),
                p.getAge(),
                p.getEffortScore(),
                String.join("|", p.getBadges())
            );
        }

        writer.flush();
        return stringWriter.toString();
    }

    public static String exportTeams(List<Team> teams) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        // Header
        writer.println("Team ID,Team Name,Coach,Average Effort Score,Player Count");

        // Rows
        for (Team t : teams) {
            writer.printf("%d,%s,%s,%.2f,%d%n",
                t.getId(),
                escape(t.getName()),
                escape(t.getCoach()),
                t.getAverageEffortScore(),
                t.getPlayers().size()
            );
        }

        writer.flush();
        return stringWriter.toString();
    }

    private static String escape(String value) {
        if (value == null) return "";
        if (value.contains(",") || value.contains("\"")) {
            return "\"" + value.replace("\"", "\"\"") + "\"";
        }
        return value;
    }
}