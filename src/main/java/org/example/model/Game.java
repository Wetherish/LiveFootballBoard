package org.example.model;

import java.time.LocalTime;

public class Game {
    private final String home;
    private final String away;
    private int homeScore;
    private int awayScore;
    private final LocalTime startTime;

    public Game(String home, String away) {
        this.home = home;
        this.away = away;
        this.homeScore = 0;
        this.awayScore = 0;
        this.startTime = LocalTime.now();
    }

    public LocalTime getStartTime() {
        return startTime;
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
