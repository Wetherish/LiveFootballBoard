package org.example.storage;

import org.example.model.Game;

import java.util.LinkedList;

public interface Storage {
    void addGame(Game game);

    void removeGame(Game game);

    LinkedList<Game> summary();
}
