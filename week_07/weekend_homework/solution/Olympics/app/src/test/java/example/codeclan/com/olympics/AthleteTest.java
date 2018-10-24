package example.codeclan.com.olympics;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jaychetty on 18/09/2017.
 */

public class AthleteTest {

    @Test
    public void has_name(){
        Athlete athlete = new Athlete("Usain", Country.JAMAICA);
        assertEquals("Usain", athlete.getName());
    }

    @Test
    public void has_country(){
        Athlete athlete = new Athlete("Usain", Country.JAMAICA);
        assertEquals(Country.JAMAICA, athlete.getCountry());
    }
}
