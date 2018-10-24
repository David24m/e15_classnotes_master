package example.codeclan.com.athlete;

import java.util.ArrayList;

import example.codeclan.com.athlete.scorer.Scorer;

/**
 * Created by jaychetty on 12/09/2017.
 */

public class Competition {
    private ArrayList<Athlete> athletes;
    private Scorer scorer;


    public Competition(Scorer scorer){
        this.athletes = new ArrayList<Athlete>();
        this.scorer = scorer;

    }

    public void addAthlete(Athlete athlete){
        athletes.add(athlete);
    }

    public ArrayList<Athlete> getAthletes(){
        return athletes;
    }


    public Athlete winner(){
        Athlete currentWinner = athletes.get(0);
        for (Athlete athlete: athletes) {
            double challengerScore = scorer.scoreForAthlete(athlete);
            double winningScore = scorer.scoreForAthlete(currentWinner);
            if(challengerScore > winningScore){
                currentWinner = athlete;
            }
        }

        return currentWinner;
    }

}
