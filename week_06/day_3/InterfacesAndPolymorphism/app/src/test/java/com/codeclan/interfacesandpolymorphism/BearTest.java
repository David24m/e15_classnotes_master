package com.codeclan.interfacesandpolymorphism;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by stewartmackenzie-leigh on 06/09/2017.
 */

public class BearTest {
    @Test
    public void bearCanEatSalmon() {
        // arrange
        Bear bear = new Bear();
        Salmon fishy = new Salmon();
        // act
        bear.eat(fishy);
        // assert
        assertEquals(1000, bear.getEnergy());
    }

    @Test
    public void bearCanEatTrout() {
        // arrange
        Bear bear = new Bear();
        Trout fishy = new Trout();
        // act
        bear.eat(fishy);
        // assert
        assertEquals(500, bear.getEnergy());
    }
}
