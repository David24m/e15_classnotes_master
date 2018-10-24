package example.codeclan.com.athlete;

import java.util.ArrayList;

/**
 * Created by jaychetty on 11/09/2017.
 */

public class Athlete {
    private ArrayList<Run> runs;

    public Athlete(){
        this.runs = new ArrayList<Run>();
    }

    public ArrayList<Run> getRuns() {
        return runs;
    }

    public void addRun(Run runToAdd){
        this.runs.add(runToAdd);
    }
}
