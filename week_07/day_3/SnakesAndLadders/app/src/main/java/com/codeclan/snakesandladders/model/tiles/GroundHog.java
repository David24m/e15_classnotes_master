package com.codeclan.snakesandladders.model.tiles;

import com.codeclan.snakesandladders.model.GameState;

/**
 * Created by stewartmackenzie-leigh on 13/09/2017.
 */

public class GroundHog implements Tile {
    @Override
    public void doEffect(GameState state) {
        int index = state.getCurrentPlayerIndex() - 1;

        if (index < 0) {
            index += state.getPlayers().size();
        }

        state.setCurrentPlayerIndex(index);
        state.getLogger().logMessage("It's Groundhog Day! Take another turn.");
    }
}
