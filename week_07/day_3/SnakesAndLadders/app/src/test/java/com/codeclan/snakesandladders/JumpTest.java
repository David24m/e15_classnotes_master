package com.codeclan.snakesandladders;

import com.codeclan.snakesandladders.model.Game;
import com.codeclan.snakesandladders.model.Logger;
import com.codeclan.snakesandladders.model.tiles.Jump;
import com.codeclan.snakesandladders.model.NumberGenerator;
import com.codeclan.snakesandladders.model.Player;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by stewartmackenzie-leigh on 13/09/2017.
 */
public class JumpTest {
    @Test
    public void testLadder() {
        // arrange
        Jump tile = new Jump(6);
        Game game = new Game(100, mock(NumberGenerator.class), mock(Logger.class));
        game.setCurrentPlayerIndex(0);

        Player player = new Player("test");
        game.addPlayer(player);
        // act
        tile.doEffect(game);
        // assert
        assertEquals(6, player.getPosition());
    }


    @Test
    public void testSnake() {
        // arrange
        Jump tile = new Jump(6);
        Game game = new Game(100, mock(NumberGenerator.class), mock(Logger.class));
        game.setCurrentPlayerIndex(0);

        Player player = new Player("test");
        player.setPosition(10);
        game.addPlayer(player);
        // act
        tile.doEffect(game);
        // assert
        assertEquals(6, player.getPosition());
    }
}