package example.codeclan.com.athlete;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RunTest {
    @Test
    public void has_distance_altitude_time(){
        Run run = new Run(10.00, 5.00, 20.10);
        assertEquals(10.00, run.getDistance(), 1e-6);
        assertEquals(5.00, run.getAltitudeGain(), 1e-6);
        assertEquals(20.10, run.getTime(), 1e-6);
    }
}