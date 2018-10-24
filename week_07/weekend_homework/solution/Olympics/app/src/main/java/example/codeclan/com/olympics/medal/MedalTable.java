package example.codeclan.com.olympics.medal;

import java.util.ArrayList;
import java.util.HashMap;

import example.codeclan.com.olympics.Contender;
import example.codeclan.com.olympics.Country;
import example.codeclan.com.olympics.Event;
import example.codeclan.com.olympics.medal.Medal;
import example.codeclan.com.olympics.medal.MedalCount;

/**
 * Created by jaychetty on 18/09/2017.
 */

public class MedalTable {

    public static HashMap<Country, MedalCount> generate(ArrayList<Event> events){
        HashMap<Country, MedalCount> table = new HashMap<Country, MedalCount>();
        for (Country country: Country.values()){
            table.put(country, new MedalCount());
        }
        for (Event event: events) {
            for(Medal medal: Medal.values()){
                Contender contender = event.getMedalWinner(medal);
                MedalCount countryMedalCount = table.get(contender.getCountry());
                countryMedalCount.incrementCount(medal);
            }
        }

        return table;
    }




}
