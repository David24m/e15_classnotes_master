package example.codeclan.com.athlete;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.athlete.scorer.AltitudeGainScorer;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jaychetty on 12/09/2017.
 */


public class AltitudeGainScorerTest {
    Athlete runner;
    AltitudeGainScorer scorer;
    @Before
    public void before(){
        runner = new Athlete();
        runner.addRun( new Run(20.00, 1.3, 61.24));
        runner.addRun( new Run(25.00, 0.5, 70.24));
        scorer = new AltitudeGainScorer();
    }

    @Test
    public void score_is_total_distance(){
        double score = scorer.scoreForAthlete(runner);
        assertEquals(1.8, score, 1e-6);
    }

}
