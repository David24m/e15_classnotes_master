package com.codeclan.snakesandladders.model;

import java.util.Random;

/**
 * Created by stewartmackenzie-leigh on 13/09/2017.
 */

public class Die implements NumberGenerator {
    private Random random;
    private int numberOfSides;

    public Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        this.random = new Random();
    }

    @Override
    public int getNumber() {
     return this.random.nextInt(this.numberOfSides) + 1;
    }
}
