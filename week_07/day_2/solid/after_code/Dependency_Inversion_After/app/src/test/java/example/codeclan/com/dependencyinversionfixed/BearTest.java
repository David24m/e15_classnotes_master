package example.codeclan.com.dependencyinversionfixed;

/**
 * Created by user on 27/06/2017.
 */

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class BearTest{

    Bear bear;
    Macbook macbook;

    @Before
    public void setup(){
        macbook = new Macbook();
        bear = new Bear(macbook);
    }

    @Test
    public void hasJournal(){
        bear.getJournal().write("Dear diary, mood: apathetic...");
        assertEquals("Dear diary, mood: apathetic...", bear.getJournal().readLast());
    }

}
