package example.codeclan.com.olympics;

import org.junit.Test;

import example.codeclan.com.olympics.medal.Medal;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jaychetty on 18/09/2017.
 */

public class EventTest {
    @Test
    public void can_add_entry(){
        Event event = new Event();
        Contender athlete = new Athlete("Usain", Country.JAMAICA);
        event.addContender(athlete);
        assertEquals(1, event.getContenderEntries().size());
    }

    @Test
    public void can_return_medals(){
        Event event = new Event();
        Contender usain = new Athlete("Usain", Country.JAMAICA);
        Contender sarah = new Athlete("Sarah", Country.FRANCE);
        Contender david = new Athlete("David", Country.KENYA);

        event.addContender(usain, 2);
        event.addContender(sarah, 10);
        event.addContender(david, 6);

        assertEquals(sarah, event.getMedalWinner(Medal.GOLD));
        assertEquals(david, event.getMedalWinner(Medal.SILVER));
        assertEquals(usain, event.getMedalWinner(Medal.BRONZE));
    }


}
