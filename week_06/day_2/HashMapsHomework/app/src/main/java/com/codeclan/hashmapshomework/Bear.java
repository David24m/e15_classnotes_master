package com.codeclan.hashmapshomework;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by stewartmackenzie-leigh on 06/09/2017.
 */

public class Bear {
    private ArrayList<Fish> belly;
    private HashMap<String, Integer> journal;

    public Bear() {
        // initialise the fields
        belly = new ArrayList<>();
        journal = new HashMap<>();
        // set up the journal
        initJournal();
    }

    private void initJournal() {
        // get an array of weekdays
        String[] days = DateFormatSymbols.getInstance().getWeekdays();

        // loop through them and initialise the
        // corresponding journal entry to 0
        for (String day: days) {
            journal.put(day, 0);
        }
    }

    public void eat(Fish fish, String day) {
        // add the fish to the belly
        belly.add(fish);

        // check if the day is valid
        if (journal.containsKey(day)) {
            // increment the count for that day
            int count = journal.get(day);
            journal.put(day, count + 1);
        }
    }

    public void resetJournal() {
        // loop through the set of keys in the journal
        // i.e., the days, and set each to 0
        // a set is sort of like an ArrayList with no duplicates
        for (String day: journal.keySet()) {
            journal.put(day, 0);
        }
    }

    public int getTotalForDay(String day) {
        return journal.get(day);
    }
}
