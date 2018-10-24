package example.codeclan.com.olympics;

import java.util.ArrayList;
import java.util.Collections;

import example.codeclan.com.olympics.medal.Medal;

/**
 * Created by jaychetty on 18/09/2017.
 */

public class Event {

    private ArrayList<ContenderEntry> contenderEntries;
    public Event(){
        contenderEntries = new ArrayList<ContenderEntry>();
    }

    public void addContender(Contender contender){
        ContenderEntry contenderEntry = new ContenderEntry(0, contender);
        contenderEntries.add(contenderEntry);
        sortEntries();
    }

    public void addContender(Contender contender, int score){
        ContenderEntry contenderEntry = new ContenderEntry(score, contender);
        contenderEntries.add(contenderEntry);
        sortEntries();
    }


    public ArrayList<ContenderEntry> getContenderEntries() {
        return contenderEntries;
    }

    public void sortEntries(){
        Collections.sort(contenderEntries);
        Collections.reverse(contenderEntries);
    }

    public Contender getMedalWinner(Medal medal){
        int index = 0;
        switch (medal){
            case GOLD:
                index = 0;
                break;
            case SILVER:
                index = 1;
                break;
            case BRONZE:
                index = 2;
                break;
        }
        return contenderEntries.get(index).getContender();
    }

}
