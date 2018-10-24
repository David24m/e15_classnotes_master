package com.codeclan.snakesandladders.model.tiles;

import com.codeclan.snakesandladders.model.GameState;
import com.codeclan.snakesandladders.model.Player;

/**
 * Created by stewartmackenzie-leigh on 13/09/2017.
 */

public class Jump implements Tile {
    private int target;

    public Jump(int target) {
        this.target = target;
    }

    @Override
    public void doEffect(GameState state) {
        Player player = state.getCurrentPlayer();
        int position = player.getPosition();
        String message;

        player.setPosition(this.target);

        if (position < this.target) {
            message = String.format("You landed on a ladder and climbed to position %d.", this.target);

        } else {
            message = String.format("You landed on a snake and slid down to position %d.", this.target);
        }

        state.getLogger().logMessage(message);
    }
}
