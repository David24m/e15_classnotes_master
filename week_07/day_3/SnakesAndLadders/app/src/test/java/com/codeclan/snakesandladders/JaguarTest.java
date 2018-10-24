package com.codeclan.snakesandladders;

import com.codeclan.snakesandladders.model.Game;
import com.codeclan.snakesandladders.model.Logger;
import com.codeclan.snakesandladders.model.tiles.Jaguar;
import com.codeclan.snakesandladders.model.NumberGenerator;
import com.codeclan.snakesandladders.model.Player;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by stewartmackenzie-leigh on 13/09/2017.
 */
public class JaguarTest {
    @Test
    public void doEffectShouldSetPositionToZero() {
        // arrange
        Jaguar tile = new Jaguar();
        Game game = new Game(100, mock(NumberGenerator.class), mock(Logger.class));
        Player player = new Player("test");
        game.addPlayer(player);
        game.setCurrentPlayerIndex(0);
        // act
        tile.doEffect(game);
        // assert
        assertEquals(0, player.getPosition());
    }
}