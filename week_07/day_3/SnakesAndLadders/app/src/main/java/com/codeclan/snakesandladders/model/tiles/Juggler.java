package com.codeclan.snakesandladders.model.tiles;

import com.codeclan.snakesandladders.model.GameState;
import com.codeclan.snakesandladders.model.Player;

import java.util.List;

/**
 * Created by stewartmackenzie-leigh on 13/09/2017.
 */

public class Juggler implements Tile {
    @Override
    public void doEffect(GameState state) {
        Player frontPlayer = this.findFrontPlayer(state.getPlayers());
        Player currentPlayer = state.getCurrentPlayer();
        String message;

        if (currentPlayer.getPosition() != frontPlayer.getPosition()) {
            int frontPlayerPosition = frontPlayer.getPosition();
            frontPlayer.setPosition(currentPlayer.getPosition());
            currentPlayer.setPosition(frontPlayerPosition);

            message = String.format("You landed on a juggler, and swapped places with %s - you are now in the lead!",
                    frontPlayer.getName());

        } else {
            message = String.format("You landed on a juggler, but you are already in the lead.");
        }

        state.getLogger().logMessage(message);
    }

    private Player findFrontPlayer(List<Player> players) {
        int maxTile = 0;
        Player frontPlayer = null;

        for (Player player: players) {
            int position = player.getPosition();

            if (position > maxTile) {
                maxTile = position;
                frontPlayer = player;
            }
        }

        return frontPlayer;
    }
}
