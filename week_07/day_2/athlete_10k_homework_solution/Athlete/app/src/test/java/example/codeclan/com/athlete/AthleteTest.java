package example.codeclan.com.athlete;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jaychetty on 11/09/2017.
 */

public class AthleteTest {
    Athlete athlete;
    @Before
    public void before(){
        //arrange
        athlete = new Athlete();
    }
    @Test
    public void starts_with_no_runs(){
        assertEquals(0, athlete.getRuns().size());
    }
    @Test
    public void can_add_run(){
        //act
        Run jog = new Run(2.0, 0.1, 20.0);
        athlete.addRun(jog);
        //assert
        assertEquals(1, athlete.getRuns().size());
    }
}
