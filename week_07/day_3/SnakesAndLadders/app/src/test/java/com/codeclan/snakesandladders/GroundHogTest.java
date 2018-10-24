package com.codeclan.snakesandladders;

import com.codeclan.snakesandladders.model.Game;
import com.codeclan.snakesandladders.model.Logger;
import com.codeclan.snakesandladders.model.tiles.GroundHog;
import com.codeclan.snakesandladders.model.NumberGenerator;
import com.codeclan.snakesandladders.model.Player;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by stewartmackenzie-leigh on 13/09/2017.
 */
public class GroundHogTest {
    @Test
    public void doEffect() throws Exception {
        // arrange
        GroundHog tile = new GroundHog();
        Game game = new Game(100, mock(NumberGenerator.class), mock(Logger.class));
        game.setCurrentPlayerIndex(0);

        Player player1 = new Player("player 1");
        game.addPlayer(player1);

        Player player2 = new Player("player 2");
        game.addPlayer(player2);

        // act
        tile.doEffect(game);

        // assert
        assertEquals(1, game.getCurrentPlayerIndex());
    }

}