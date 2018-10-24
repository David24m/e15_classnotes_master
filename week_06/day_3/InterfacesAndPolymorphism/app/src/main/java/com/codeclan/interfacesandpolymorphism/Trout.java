package com.codeclan.interfacesandpolymorphism;

/**
 * Created by stewartmackenzie-leigh on 06/09/2017.
 */

public class Trout implements Edible {
    private int calories;

    public Trout() {
        calories = 500;
    }

    public int getCalories() {
        return calories;
    }
}
