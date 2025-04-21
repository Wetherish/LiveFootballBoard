package org.example.model;

import java.util.Comparator;

public class GameComparator implements Comparator<Game> {
    @Override
    public int compare(Game g1, Game g2) {
        int sumScore1 = g1.getHomeScore() + g1.getAwayScore();
        int sumScore2 = g2.getHomeScore() + g2.getAwayScore();
        if (sumScore1 == sumScore2) {
            return g2.getStartTime().compareTo(g1.getStartTime());
        }
        return Integer.compare(sumScore2, sumScore1);
    }
}
