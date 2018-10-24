package example.codeclan.com.athlete;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.athlete.scorer.AverageSpeedScorer;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jaychetty on 12/09/2017.
 */

public class AverageSpeedScorerTest {

    Athlete runner;
    AverageSpeedScorer scorer;
    @Before
    public void before(){
        runner = new Athlete();
        runner.addRun( new Run(6.00, 0.0, 10.00));
        runner.addRun( new Run(4.00, 0.0, 10.00));
        scorer = new AverageSpeedScorer();
    }

    @Test
    public void score_is_average_speed(){
        double score = scorer.scoreForAthlete(runner);
        assertEquals(0.5, score, 1e-6);
    }

    @Test
    public void handles_zero_time(){
        Athlete lazyRunner = new Athlete();
        double score = scorer.scoreForAthlete(lazyRunner);
        assertEquals(0.0, score, 1e-6);
    }
}
