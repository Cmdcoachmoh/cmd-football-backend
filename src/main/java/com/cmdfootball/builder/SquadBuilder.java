package com.cmdfootball.builder;

import com.cmdfootball.model.Team;
import com.cmdfootball.model.Player;

import java.util.List;

public class SquadBuilder {

    /**
     * Builds a Team object from basic inputs.
     *
     * @param id     team ID (nullable)
     * @param name   team name
     * @param coach  coach name
     * @param players list of players
     * @return a fully initialized Team object
     */
    public static Team buildTeam(Long id, String name, String coach, List<Player> players) {
        Team team = new Team();
        team.setId(id);
        team.setName((name != null) ? name : "Unnamed Team");
        team.setCoach((coach != null) ? coach : "Unknown Coach");
        team.setPlayers(players); // triggers effort score calculation
        return team;
    }

    /**
     * Builds a Team with auto-generated ID and default coach.
     *
     * @param name    team name
     * @param players list of players
     * @return a Team object with default values
     */
    public static Team buildAnonymousTeam(String name, List<Player> players) {
        return buildTeam(null, name, "AutoCoach", players);
    }
}