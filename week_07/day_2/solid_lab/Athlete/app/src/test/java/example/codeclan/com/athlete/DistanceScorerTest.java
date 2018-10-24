package example.codeclan.com.athlete;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.athlete.scorer.DistanceScorer;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jaychetty on 12/09/2017.
 */

public class DistanceScorerTest {
    Athlete runner;
    DistanceScorer scorer;
    @Before
    public void before(){
        runner = new Athlete();
        runner.addRun( new Run(20.00, 0.3, 61.24));
        runner.addRun( new Run(25.00, 0.5, 70.24));
        scorer = new DistanceScorer();
    }

    @Test
    public void score_is_total_distance(){
        double score = scorer.scoreForAthlete(runner);
        assertEquals(45.00, score, 1e-6);
    }

}
