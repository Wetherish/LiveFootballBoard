package org.example.model;

public class Game {
    private final String home;
    private final String away;
    private int homeScore;
    private int awayScore;

    public Game(String home, String away) {
        this.home = home;
        this.away = away;
        this.homeScore = 0;
        this.awayScore = 0;
    }

    public String getHomeName() {
        return home;
    }

    public String getAwayName() {
        return away;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void scoreHome() {
        this.homeScore++;
    }
    public void scoreAway() {
        this.awayScore++;
    }
}
