package com.example.user.card_game_lab_solution;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 07/09/2017.
 */
public class PlayerTest {
    Player player;

    @Before
    public void before(){
        player = new Player("Steve");
    }

    @Test
    public void canGetName(){
        assertEquals("Steve", player.getName());
    }

    @Test
    public void startsWithNoPoints(){
        assertEquals(0, player.getPoints());
    }

    @Test
    public void startsWithNoCard(){
        assertNull(player.getCard());
    }

    @Test
    public void canSetCard(){
        Card card = new Card(2, Suit.CLUBS);

        player.setCard(card);

        Card result = player.getCard();
        assertEquals(2, result.getValue());
        assertEquals(Suit.CLUBS, result.getSuit());
    }

    @Test
    public void canIncrementPoints(){
        player.incrementPoints();

        assertEquals(1, player.getPoints());
    }
}












