package com.codeclan.craigmorton.forloops;

import java.util.ArrayList;

/**
 * Created by craig on 15/09/2017.
 */

public class Loops {
    public static String[] allCaps(String[] names) {

        String[] allCaps = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            String allCapsName = names[i].toUpperCase();
            allCaps[i] = allCapsName;
        }

        return allCaps;

    }

    public static ArrayList<String> allCapsArrayList(ArrayList<String> names) {

        ArrayList<String> allCaps = new ArrayList<String>();

        for (String name : names) {
            String nameInCaps = name.toUpperCase();
            allCaps.add(nameInCaps);
        }

        return allCaps;
    }

    public static void accessArray(ArrayList<String> places) {

        for (String place : places) {
            System.out.println(place);
        }

        for (int i = 0; i < places.size(); i++) {
            String place = places.get( i );
            System.out.println( place );
        }




    }
}
