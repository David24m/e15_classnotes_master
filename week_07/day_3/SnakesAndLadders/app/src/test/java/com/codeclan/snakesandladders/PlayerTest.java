package com.codeclan.snakesandladders;

import com.codeclan.snakesandladders.model.Player;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by stewartmackenzie-leigh on 13/09/2017.
 */
public class PlayerTest {
    @Test
    public void positionStartsAtZero() {
        // arrange
        Player player = new Player("test");
        // act
        int position = player.getPosition();
        // assert
        assertEquals(0, position);
    }

    @Test
    public void setPosition() {
        // arrange
        Player player = new Player("test");
        // act
        player.setPosition(5);
        // assert
        assertEquals(5, player.getPosition());
    }

    @Test
    public void advancePosition() throws Exception {
        // arrange
        Player player = new Player("test");
        player.setPosition(3);
        // act
        player.advancePosition(4);
        // assert
        assertEquals(7, player.getPosition());
    }

    @Test
    public void getName() throws Exception {
        // arrange
        Player player = new Player("test");
        // act
        String name = player.getName();
        // assert
        assertEquals("test", name);
    }

}