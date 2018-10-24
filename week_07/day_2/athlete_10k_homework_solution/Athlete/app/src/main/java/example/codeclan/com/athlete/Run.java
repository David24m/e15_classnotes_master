package example.codeclan.com.athlete;

/**
 * Created by jaychetty on 11/09/2017.
 */

public class Run {
    private double distance;
    private double altitudeGain;
    private double time;

    public Run(double distance, double altitudeGain, double time){
        this.distance = distance;
        this.altitudeGain = altitudeGain;
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public double getAltitudeGain() {
        return altitudeGain;
    }

    public double getTime() {
        return time;
    }
}
