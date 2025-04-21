package org.example;

import org.example.model.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    public void NewGame() {
        Game game = new Game("Chelsea", "Manchester United");
        int homeScore = game.getHomeScore();
        int awayScore = game.getAwayScore();

        assertEquals(awayScore, homeScore);
        assertEquals(0, homeScore);
        assertEquals(0, awayScore);

        assertEquals("Chelsea", game.getHomeName());
        assertEquals("Manchester United", game.getAwayName());
    }

    @Test
    public void ScoreGoal() {

        Game game = new Game("Mexico", "Canada");
        game.scoreHome();
        game.scoreAway();

        assertEquals(1, game.getHomeScore());
        assertEquals(1, game.getAwayScore());

        for (int i = 0; i < 10; i++) {
            game.scoreHome();
            game.scoreAway();
        }
        assertEquals(11, game.getHomeScore());
        assertEquals(11, game.getAwayScore());
    }

    @Test
    public void GameToString() {
        Game game = new Game("Chelsea", "Manchester United");
        assertEquals("Chelsea 0 - 0 Manchester United", game.toString());
    }

}
