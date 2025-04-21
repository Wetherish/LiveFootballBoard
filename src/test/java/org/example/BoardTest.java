package org.example;

import org.example.model.Game;
import org.example.storage.Board;
import org.example.storage.Storage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BoardTest {

    @Test
    public void addGame() {
        ArrayList<Game> gamesList = prepareGames();
        Storage board = new Board();

        assertEquals(0, board.summary().size());
        board.addGame(gamesList.get(0));
        board.addGame(gamesList.get(1));
        assertEquals(2, board.summary().size());
    }

    @Test
    public void removeGame() {
        ArrayList<Game> gamesList = prepareGames();
        Storage board = new Board();

        board.addGame(gamesList.get(0));
        board.addGame(gamesList.get(1));
        board.removeGame(gamesList.get(1));

        assertEquals(1, board.summary().size());
    }

    @Test
    public void summary() {

        Storage board = PrepareBoard();
        assertEquals(5, board.summary().size());

        assertEquals("Uruguay", board.summary().get(0).getHomeName());
        assertEquals("Italy", board.summary().get(0).getAwayName());
        assertEquals("Spain", board.summary().get(1).getHomeName());
        assertEquals("Brazil", board.summary().get(1).getAwayName());
        assertEquals("Mexico", board.summary().get(2).getHomeName());
        assertEquals("Canada", board.summary().get(2).getAwayName());
        assertEquals("Argentina", board.summary().get(3).getHomeName());
        assertEquals("Australia", board.summary().get(3).getAwayName());
        assertEquals("Germany", board.summary().get(4).getHomeName());
        assertEquals("France", board.summary().get(4).getAwayName());
    }

    @Test
    public void dynamicSummaryChanges() {
        Storage board = PrepareBoard();

        assertEquals("Uruguay", board.summary().get(0).getHomeName());
        assertEquals("Spain", board.summary().get(1).getHomeName());
        board.summary().get(1).scoreAway();
        assertEquals("Uruguay", board.summary().get(1).getHomeName());
        assertEquals("Spain", board.summary().get(0).getHomeName());
    }

    @Test
    public void boardToString() {
        Storage board = PrepareBoard();
        assertEquals(
                        "Uruguay 6 - 6 Italy\n" +
                        "Spain 10 - 2 Brazil\n" +
                        "Mexico 0 - 5 Canada\n" +
                        "Argentina 3 - 1 Australia\n" +
                        "Germany 2 - 2 France\n", board.toString());
    }

    private void setScore(int score, Runnable scoreSetter) {
        for (int i = 0; i < score; i++) {
            scoreSetter.run();
        }
    }

    private Storage PrepareBoard() {
        ArrayList<Game> gamesList = prepareGames();
        Storage board = new Board();
        for (Game game : gamesList) {
            board.addGame(game);
        }
        return board;
    }

    private ArrayList<Game> prepareGames() {
        ArrayList<Game> gamesList = new ArrayList<>();

        Game gameMxC = new Game("Mexico", "Canada");
        setScore(5, gameMxC::scoreAway);

        Game gameSxB = new Game("Spain", "Brazil");
        setScore(10, gameSxB::scoreHome);
        setScore(2, gameSxB::scoreAway);

        Game gameGxF = new Game("Germany", "France");
        setScore(2, gameGxF::scoreHome);
        setScore(2, gameGxF::scoreAway);

        Game gameUxI = new Game("Uruguay", "Italy");
        setScore(6, gameUxI::scoreHome);
        setScore(6, gameUxI::scoreAway);

        Game gameAxA = new Game("Argentina", "Australia");
        setScore(3, gameAxA::scoreHome);
        setScore(1, gameAxA::scoreAway);

        gamesList.add(gameMxC);
        gamesList.add(gameSxB);
        gamesList.add(gameGxF);
        gamesList.add(gameUxI);
        gamesList.add(gameAxA);
        return gamesList;
    }
}
