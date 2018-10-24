package com.codeclan.snakesandladders.model;

/**
 * Created by stewartmackenzie-leigh on 13/09/2017.
 */

public class Player {
    private int position;
    private String name;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void advancePosition(int amount) {
        this.position += amount;
    }

    public String getName() {
        return name;
    }
}
