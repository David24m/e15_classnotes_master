package com.codeclan.craigmorton.forloops;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by craig on 15/09/2017.
 */

public class LoopsTest {

    @Test
    public void primitiveArray() {
        String[] names = {
                "Craig",
                "Iain",
                "David",
                "Allyson"
        };

        String[] inCaps = Loops.allCaps(names);
        String[] expected = {"CRAIG", "IAIN", "DAVID", "ALLYSON"};
        assertEquals(expected, inCaps);
    }

    @Test
    public void arrayList() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Craig");
        names.add("Daniel");

        ArrayList<String> uppercaseNames = Loops.allCapsArrayList(names);

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("CRAIG");
        expected.add("DANIEL");


        assertEquals(expected, uppercaseNames);


    }

    @Test
    public void accessArray() {
        ArrayList<String> places = new ArrayList<String>();


        places.add("Edinburgh");
        places.add("Glasgow");
        places.add("Aberdeen");

        Loops.accessArray(places);


    }
}
