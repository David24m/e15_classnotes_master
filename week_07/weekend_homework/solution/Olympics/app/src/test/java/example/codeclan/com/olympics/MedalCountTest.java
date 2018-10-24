package example.codeclan.com.olympics;

import org.junit.Test;

import example.codeclan.com.olympics.medal.Medal;
import example.codeclan.com.olympics.medal.MedalCount;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jaychetty on 18/09/2017.
 */

public class MedalCountTest {
    @Test
    public void starts_with_no_medals(){
        MedalCount medalCount = new MedalCount();
        assertEquals(0, medalCount.getGoldCount());
        assertEquals(0, medalCount.getSilverCount());
        assertEquals(0, medalCount.getBronzeCount());
    }

    @Test
    public void can_add_medal(){
        MedalCount medalCount = new MedalCount();
        medalCount.incrementCount(Medal.GOLD);
        assertEquals(1, medalCount.getGoldCount());
    }
}
