package com.codeclan.snakesandladders.model.tiles;

import com.codeclan.snakesandladders.model.GameState;

/**
 * Created by stewartmackenzie-leigh on 13/09/2017.
 */

public interface Tile {
    void doEffect(GameState state);
}
