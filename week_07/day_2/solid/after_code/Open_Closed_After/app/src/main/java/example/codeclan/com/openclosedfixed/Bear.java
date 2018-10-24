package example.codeclan.com.openclosedfixed;

/**
 * Created by user on 27/06/2017.
 */

import java.util.ArrayList;

public class Bear{

    private ArrayList<Edible> belly = new ArrayList<Edible>();

    public String eat(Edible food){
        if (!isBellyFull()){
            belly.add(food);
            return "Yum Yum";
        }
        return "I'm too full";
    }

    public int foodCount(){
        return belly.size();
    }

    public boolean isBellyFull(){
        return (foodCount() >= 10);
    }
}
