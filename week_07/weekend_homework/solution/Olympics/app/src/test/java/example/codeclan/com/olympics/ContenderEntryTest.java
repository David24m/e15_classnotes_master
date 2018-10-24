package example.codeclan.com.olympics;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jaychetty on 18/09/2017.
 */

public class ContenderEntryTest {
    @Test
    public void has_athlete(){
        Athlete athlete = new Athlete("Usain", Country.JAMAICA);
        ContenderEntry contenderEntry = new ContenderEntry(0, athlete);

        assertEquals(athlete, contenderEntry.getContender());
    }

    @Test
    public void has_score(){
        Athlete athlete = new Athlete("Usain", Country.JAMAICA);
        ContenderEntry contenderEntry = new ContenderEntry(0, athlete);

        assertEquals(0, contenderEntry.getScore());
    }
}
