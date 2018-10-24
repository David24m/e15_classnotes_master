package com.example.user.card_game_lab_solution;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 07/09/2017.
 */
public class CardTest {
    Card card;

    @Before
    public void before(){
        card = new Card(2, Suit.CLUBS);
    }

    @Test
    public void canGetValue(){
        assertEquals(2, card.getValue());
    }

    @Test
    public void canGetSuit(){
        assertEquals(Suit.CLUBS, card.getSuit());
    }
}












