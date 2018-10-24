package example.codeclan.com.athlete;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.athlete.scorer.AltitudeGainScorer;
import example.codeclan.com.athlete.scorer.AverageSpeedScorer;
import example.codeclan.com.athlete.scorer.DistanceScorer;
import example.codeclan.com.athlete.scorer.Fastest10KScorer;
import example.codeclan.com.athlete.scorer.Scorer;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CompetitionTest {
    Athlete usain;
    Athlete dibaba;
    Competition distanceComp;
    Competition speedComp;
    Competition climbComp;
    Competition tenKComp;


    @Before
    public void before(){
        usain = new Athlete();
        usain.addRun(new Run(0.1, 0.0, 0.14 ));
        usain.addRun(new Run(0.2, 0.0, 0.31 ));

        dibaba = new Athlete();
        dibaba.addRun( new Run(20.00, 0.3, 61.24));
        dibaba.addRun( new Run(25.00, 0.5, 61.24));
        dibaba.addRun( new Run(10.00, 0.5, 40.24));

        Scorer distanceScorer = new DistanceScorer();
        distanceComp = new Competition(distanceScorer);

        Scorer speedScorer = new AverageSpeedScorer();
        speedComp = new Competition(speedScorer);

        Scorer climbScorer = new AltitudeGainScorer();
        climbComp = new Competition(climbScorer);

        Scorer fastest10KScorer = new Fastest10KScorer();
        tenKComp = new Competition(fastest10KScorer);


    }
    @Test
    public void starts_with_no_athletes(){
        assertEquals( 0, distanceComp.getAthletes().size() );
    }
    @Test
    public void can_add_athletes(){
        distanceComp.addAthlete(usain);
        assertEquals( 1, distanceComp.getAthletes().size() );
    }

    @Test
    public void gives_winner_based_on_distance_scorer(){
        distanceComp.addAthlete(usain);
        distanceComp.addAthlete(dibaba);
        assertEquals( dibaba, distanceComp.winner() );
    }

    @Test
    public void gives_winner_based_on_speed_scorer(){
        speedComp.addAthlete(usain);
        speedComp.addAthlete(dibaba);
        assertEquals( usain, speedComp.winner() );
    }

    @Test
    public void gives_winner_based_on_altitude_scorer(){
        climbComp.addAthlete(usain);
        climbComp.addAthlete(dibaba);
        assertEquals( dibaba, climbComp.winner() );
    }

    @Test
    public void gives_winner_based_on_10k_scorer(){
        tenKComp.addAthlete(usain);
        tenKComp.addAthlete(dibaba);
        assertEquals( dibaba, tenKComp.winner() );
    }
}