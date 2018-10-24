package com.codeclan.snakesandladders;

import com.codeclan.snakesandladders.model.Game;
import com.codeclan.snakesandladders.model.Logger;
import com.codeclan.snakesandladders.model.tiles.Juggler;
import com.codeclan.snakesandladders.model.NumberGenerator;
import com.codeclan.snakesandladders.model.Player;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by stewartmackenzie-leigh on 13/09/2017.
 */
public class JugglerTest {
    @Test
    public void doEffectShouldSwapWithFrontPlayer() {
        // arrange
        Juggler tile = new Juggler();
        Game game = new Game(100, mock(NumberGenerator.class), mock(Logger.class));
        game.setCurrentPlayerIndex(0);

        Player player1 = new Player("player 1");
        game.addPlayer(player1);

        Player player2 = new Player("player 2");
        player2.setPosition(4);
        game.addPlayer(player2);

        Player player3 = new Player("player 3");
        player3.setPosition(10);
        game.addPlayer(player3);

        // act
        tile.doEffect(game);

        // assert
        assertEquals(10, player1.getPosition());
        assertEquals(4, player2.getPosition());
        assertEquals(0, player3.getPosition());
    }

    @Test
    public void doEffectShouldNotDoAnythingIfThePlayerIsAlreadyInTheLead() {
        // arrange
        Juggler tile = new Juggler();
        Game game = new Game(100, mock(NumberGenerator.class), mock(Logger.class));
        game.setCurrentPlayerIndex(0);

        Player player1 = new Player("player 1");
        player1.setPosition(10);
        game.addPlayer(player1);

        Player player2 = new Player("player 2");
        player2.setPosition(4);
        game.addPlayer(player2);

        Player player3 = new Player("player 3");
        player3.setPosition(10);
        game.addPlayer(player3);

        // act
        tile.doEffect(game);

        // assert
        assertEquals(10, player1.getPosition());
        assertEquals(4, player2.getPosition());
        assertEquals(10, player3.getPosition());
    }
}