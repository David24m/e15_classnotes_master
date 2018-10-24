package com.codeclan.snakesandladders.model.tiles;

import com.codeclan.snakesandladders.model.GameState;

/**
 * Created by stewartmackenzie-leigh on 13/09/2017.
 */

public class Jaguar implements Tile {
    @Override
    public void doEffect(GameState state) {
        state.getCurrentPlayer().setPosition(0);
        state.getLogger().logMessage("You were eaten by a jaguar.  You are now back at the start.");
    }
}
