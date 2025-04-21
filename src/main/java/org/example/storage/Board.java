package org.example.storage;

import org.example.model.Game;
import org.example.model.GameComparator;

import java.util.LinkedList;

public class Board implements Storage {
    private final LinkedList<Game> games;

    public Board() {
        games = new LinkedList<>();
    }

    public void addGame(Game game) {
        games.add(0, game);
    }

    public void removeGame(Game game) {
        games.remove(game);
    }

    public LinkedList<Game> summary() {
        games.sort(new GameComparator());
        return games;
    }
}
