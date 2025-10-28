package com.cmdfootball.util;

import com.cmdfootball.model.Player;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

public class CSVSquadBuilder {

    public static String buildSquadCSV(List<Player> players) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        // Header
        writer.println("ID,Name,Position,Age,EffortScore,Badges");

        // Rows
        for (Player player : players) {
            writer.printf("%d,%s,%s,%d,%.2f,%s%n",
                player.getId(),
                escape(player.getName()),
                player.getPosition(),
                player.getAge(),
                player.getEffortScore(),
                String.join("|", player.getBadges())
            );
        }

        writer.flush();
        return stringWriter.toString();
    }

    private static String escape(String value) {
        if (value.contains(",") || value.contains("\"")) {
            return "\"" + value.replace("\"", "\"\"") + "\"";
        }
        return value;
    }
}
