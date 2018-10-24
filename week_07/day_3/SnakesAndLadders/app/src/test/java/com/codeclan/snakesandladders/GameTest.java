package com.codeclan.snakesandladders;

import com.codeclan.snakesandladders.model.Game;
import com.codeclan.snakesandladders.model.Logger;
import com.codeclan.snakesandladders.model.tiles.Jump;
import com.codeclan.snakesandladders.model.NumberGenerator;
import com.codeclan.snakesandladders.model.Player;
import com.codeclan.snakesandladders.model.tiles.Tile;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by stewartmackenzie-leigh on 13/09/2017.
 */
public class GameTest {
    @Test
    public void addPlayer() throws Exception {
        // arrange
        Game game = new Game(100, null, mock(Logger.class));
        // act
        game.addPlayer(new Player("player 1"));
        // assert
        List<Player> players = game.getPlayers();
        assertEquals(1, players.size());
        assertEquals("player 1", players.get(0).getName());
    }

    @Test
    public void addTile() throws Exception {
        // arrange
        Game game = new Game(100, null, mock(Logger.class));
        Tile tile = mock(Tile.class);
        // act
        game.addTile(3, tile);
        // assert
        Map<Integer, Tile> board = game.getBoard();
        assertEquals(1, board.size());
        assertEquals(tile, board.get(3));
    }

    @Test
    public void getCurrentPlayer() throws Exception {
        // arrange
        Game game = new Game(100, null, mock(Logger.class));
        game.setCurrentPlayerIndex(0);

        Player player = new Player("player 1");
        game.addPlayer(player);
        // act
        Player result = game.getCurrentPlayer();
        // assert
        assertEquals(result, player);
    }

    @Test
    public void playTurnAlternatesBetweenPlayers() throws Exception {
        // arrange
        NumberGenerator numbers = mock(NumberGenerator.class);
        Game game = new Game(100, numbers, mock(Logger.class));
        game.addPlayer(new Player("player 1"));
        game.addPlayer(new Player("player 2"));

        // act / assert, we're testing more advanced behaviour...
        game.playTurn();
        assertEquals("player 1", game.getCurrentPlayer().getName());
        game.playTurn();
        assertEquals("player 2", game.getCurrentPlayer().getName());
        game.playTurn();
        assertEquals("player 1", game.getCurrentPlayer().getName());
    }

    @Test
    public void playReturnsFalseWhenGameIsNotWon() {
        // arrange
        NumberGenerator numbers = mock(NumberGenerator.class);
        when(numbers.getNumber()).thenReturn(1);

        Game game = new Game(10, numbers, mock(Logger.class));
        game.addPlayer(new Player("player 1"));

        // act
        boolean result = game.playTurn();

        // assert
        assertFalse(result);
    }

    @Test
    public void playReturnsTrueWhenGameIsWon() {
        // arrange
        NumberGenerator numbers = mock(NumberGenerator.class);
        when(numbers.getNumber()).thenReturn(10);

        Game game = new Game(10, numbers, mock(Logger.class));
        game.addPlayer(new Player("player 1"));

        // act
        boolean result = game.playTurn();

        // assert
        assertTrue(result);
    }

    @Test
    public void playCallsTileEffect() {
        // arrange
        NumberGenerator numbers = mock(NumberGenerator.class);
        when(numbers.getNumber()).thenReturn(2);

        Game game = new Game(10, numbers, mock(Logger.class));
        Player player = new Player("player 1");
        game.addPlayer(player);
        game.addTile(2, new Jump(6));

        // act
        game.playTurn();

        // assert
        assertEquals(6, player.getPosition());
    }

}