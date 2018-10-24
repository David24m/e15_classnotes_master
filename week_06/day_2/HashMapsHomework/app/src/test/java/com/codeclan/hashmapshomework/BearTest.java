package com.codeclan.hashmapshomework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by stewartmackenzie-leigh on 06/09/2017.
 */

public class BearTest {
    @Test
    public void bearIncrementsDayTotalWhenEating() {
        // arrange
        Bear bear = new Bear();
        Fish fish = new Fish();
        // act
        bear.eat(fish, "Monday");
        // assert
        int total = bear.getTotalForDay("Monday");
        assertEquals(1, total);
    }
}
