package com.codeclan.interfacesandpolymorphism;

/**
 * Created by stewartmackenzie-leigh on 06/09/2017.
 */

public class Salmon implements Edible {
    private int calories;

    public Salmon() {
        calories = 1000;
    }

    public int getCalories() {
        return calories;
    }
}
