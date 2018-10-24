package com.example.user.card_game_lab_solution;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by user on 08/09/2017.
 */
public class GameTest {
    Dealer dealer;
    ArrayList<Player> players;
    Game game;

    @Before
    public void before(){
        players = new ArrayList<>(); // => []
        players.add(new Player("Robb")); // => [Robb]
        players.add(new Player("Jaguar")); // => [Robb, Jaguar]
    }

    @Test
    public void canGetPlayers(){
        // ARRANGE
        Dealer fakeDealer = Mockito.mock(Dealer.class);
        game = new Game(fakeDealer, players); // players => [Robb, Jaguar]

        // ACT
        ArrayList<Player> result = game.getPlayers();

        // ASSERT
        assertEquals("Robb", result.get(0).getName());
        assertEquals("Jaguar", result.get(1).getName());
    }

    @Test
    public void highestCardWins(){
        // ARRANGE
        Dealer fakeDealer = Mockito.mock(Dealer.class);

        Mockito.when(fakeDealer.deal())
                .thenReturn(new Card(3, Suit.CLUBS)) // First time it's called
                .thenReturn(new Card(10, Suit.CLUBS)); // Second time it's called

        game = new Game(fakeDealer, players);

        // ACT
        game.playRound();

        // ASSERT
        ArrayList<Player> returnedPlayers = game.getPlayers();
        Player robbPlayer = returnedPlayers.get(0);
        Player jaguarPlayer = returnedPlayers.get(1);

        assertEquals(1, jaguarPlayer.getPoints());
        assertEquals(0, robbPlayer.getPoints());
    }
}


















