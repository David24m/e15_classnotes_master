package example.codeclan.com.olympics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import example.codeclan.com.olympics.medal.MedalCount;
import example.codeclan.com.olympics.medal.MedalTable;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jaychetty on 18/09/2017.
 */

public class MedalTableTest {
    @Test
    public void can_return_medal_counts(){
        Event event = new Event();
        Contender usain = new Athlete("Usain", Country.JAMAICA);
        Contender sarah = new Athlete("Sarah", Country.FRANCE);
        Contender david = new Athlete("David", Country.KENYA);

        event.addContender(usain, 2);
        event.addContender(sarah, 10);
        event.addContender(david, 6);

        Event event2 = new Event();

        event2.addContender(usain, 2);
        event2.addContender(sarah, 10);
        event2.addContender(david, 6);

        ArrayList<Event> events = new ArrayList<Event>();
        events.add(event);
        events.add(event2);


        HashMap<Country, MedalCount> medalTable = MedalTable.generate(events);
        assertEquals(0, medalTable.get(Country.JAMAICA).getGoldCount());
        assertEquals(0, medalTable.get(Country.JAMAICA).getSilverCount());
        assertEquals(2, medalTable.get(Country.JAMAICA).getBronzeCount());

        assertEquals(2, medalTable.get(Country.FRANCE).getGoldCount());
        assertEquals(0, medalTable.get(Country.FRANCE).getSilverCount());
        assertEquals(0, medalTable.get(Country.FRANCE).getBronzeCount());

        assertEquals(0, medalTable.get(Country.KENYA).getGoldCount());
        assertEquals(2, medalTable.get(Country.KENYA).getSilverCount());
        assertEquals(0, medalTable.get(Country.KENYA).getBronzeCount());

    }
}
