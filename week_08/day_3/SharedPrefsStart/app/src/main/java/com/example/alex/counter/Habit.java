package com.example.alex.counter;

public class Habit {

    private int counter;
    private String title;
    private boolean isGoodHabit;

    public Habit(String title, boolean isGoodHabit) {
        this.counter = 0;
        this.title = title;
        this.isGoodHabit = isGoodHabit;
    }

    public String getFeedback() {
        if (this.counter >= 5) {
            if (this.isGoodHabit) {
                return "You're doing great";
            } else {
                return "Must try harder";
            }
        }
        return "";
    }

    public void addToCounter() {
        this.counter++;
    }

    public void subtractFromCounter() {
        if (this.counter != 0) this.counter--;
    }

    public void resetCounter() {
        this.counter = 0;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int newCounter) {
        this.counter = newCounter;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public boolean getIsGoodHabit() {
        return this.isGoodHabit;
    }

}
