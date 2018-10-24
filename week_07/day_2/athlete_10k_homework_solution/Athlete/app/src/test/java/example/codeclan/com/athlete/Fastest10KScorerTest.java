package example.codeclan.com.athlete;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.athlete.scorer.DistanceScorer;
import example.codeclan.com.athlete.scorer.Fastest10KScorer;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jaychetty on 13/09/2017.
 */

public class Fastest10KScorerTest {
    Athlete runner;
    Fastest10KScorer scorer;
    @Before
    public void before(){
        runner = new Athlete();
        runner.addRun( new Run(20.00, 0.3, 61.24));
        runner.addRun( new Run(10.00, 0.5, 40.00));
        scorer = new Fastest10KScorer();
    }

    @Test
    public void score_is_fastest_10k(){
        double score = scorer.scoreForAthlete(runner);
        assertEquals(0.25, score, 1e-6);
    }

//    @Test
//    public void score_is_fastest_10k(){
//        double score = scorer.scoreForAthlete(runner);
//        assertEquals(0.25, score, 1e-6);
//    }

}
