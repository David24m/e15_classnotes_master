package example.codeclan.com.olympics;

import java.util.ArrayList;

/**
 * Created by jaychetty on 18/09/2017.
 */

public class Team implements Contender{
    private ArrayList<Athlete> members;

    public Team(){
        members = new ArrayList<Athlete>();
    }

    public void addMember(Athlete member){
        members.add(member);
    }

    public Country getCountry(){
        return members.get(0).getCountry();
    }

}
