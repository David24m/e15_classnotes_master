package example.codeclan.com.athlete.scorer;

import example.codeclan.com.athlete.Athlete;
import example.codeclan.com.athlete.Run;

/**
 * Created by jaychetty on 13/09/2017.
 */

public class Fastest10KScorer implements Scorer {

    private boolean is10K(Run run){
        return Math.round(run.getDistance()) == 10;
//        return Math.abs(run.getDistance() - 10) < 0.01;
    }

    public double scoreForAthlete(Athlete athlete){
        Double best10KSpeed = 0.0;

        for (Run run: athlete.getRuns()) {
            if( is10K(run) ){
                Double speed = run.getDistance() / run.getTime();
                if( speed > best10KSpeed){
                    best10KSpeed = speed;
                }
            }
        }

        return best10KSpeed;
    }
}
