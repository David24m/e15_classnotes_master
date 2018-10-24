package example.codeclan.com.athlete.scorer;

import example.codeclan.com.athlete.Athlete;
import example.codeclan.com.athlete.Run;
import example.codeclan.com.athlete.scorer.Scorer;

/**
 * Created by jaychetty on 12/09/2017.
 */

public class DistanceScorer implements Scorer {
    public double scoreForAthlete(Athlete athlete){
        double totalDistance = 0;
        for (Run run: athlete.getRuns()) {
            totalDistance += run.getDistance();
        }
        return totalDistance;
    }
}
