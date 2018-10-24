package example.codeclan.com.athlete.scorer;

import example.codeclan.com.athlete.Athlete;
import example.codeclan.com.athlete.Run;
import example.codeclan.com.athlete.scorer.Scorer;

/**
 * Created by jaychetty on 12/09/2017.
 */

public class AverageSpeedScorer implements Scorer {
    public double scoreForAthlete(Athlete athlete){
        double totalDistance = 0;
        double totalTime = 0;
        for (Run run: athlete.getRuns()) {
            totalDistance += run.getDistance();
            totalTime += run.getTime();

        }
        if(totalTime == 0){
            return 0;
        }else{
            return totalDistance / totalTime;
        }
    }
}
