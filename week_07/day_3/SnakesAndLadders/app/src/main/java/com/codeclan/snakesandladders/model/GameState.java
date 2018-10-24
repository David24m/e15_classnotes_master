package com.codeclan.snakesandladders.model;

import com.codeclan.snakesandladders.model.tiles.Tile;

import java.util.List;
import java.util.Map;

/**
 * Created by stewartmackenzie-leigh on 13/09/2017.
 */

public interface GameState {
    List<Player> getPlayers();
    Player getCurrentPlayer();
    Map<Integer, Tile> getBoard();
    int getCurrentPlayerIndex();
    void setCurrentPlayerIndex(int index);
    Logger getLogger();
}
