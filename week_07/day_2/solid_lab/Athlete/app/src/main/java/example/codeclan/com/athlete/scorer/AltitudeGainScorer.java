package example.codeclan.com.athlete.scorer;

import example.codeclan.com.athlete.Athlete;
import example.codeclan.com.athlete.Run;
import example.codeclan.com.athlete.scorer.Scorer;

/**
 * Created by jaychetty on 12/09/2017.
 */

public class AltitudeGainScorer implements Scorer {
    public double scoreForAthlete(Athlete athlete){
        double totalAltitudeGain = 0;
        for (Run run: athlete.getRuns()) {
            totalAltitudeGain += run.getAltitudeGain();
        }
        return totalAltitudeGain;
    }
}
