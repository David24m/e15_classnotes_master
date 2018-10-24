package example.codeclan.com.interfacesegregationfixed;

/**
 * Created by user on 27/06/2017.
 */

import java.util.ArrayList;

public class PolarBear implements Fisher, Eater, Sleeper, Climber{

    private ArrayList<Edible> belly = new ArrayList<Edible>();

    public Edible fish(){
        return new Seal();
    }

    public String climb(){
        return "I can climb icebergs, now go buy some Glacier Mints or something.";
    }

    public String sleep(){
        return "Zzzzz...";
    }

    public int foodCount(){
        return belly.size();
    }

    public boolean isBellyFull(){
        return (foodCount() >= 5);
    }

    public void eat(Edible food){
        if (!isBellyFull()){
            belly.add(food);
        }
    }

}

