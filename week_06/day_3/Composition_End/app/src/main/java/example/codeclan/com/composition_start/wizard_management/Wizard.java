package example.codeclan.com.composition_start.wizard_management;

/**
 * Created by user on 28/08/2017.
 */

public class Wizard {
    String name;
    Flyable ride;

    public Wizard(String name, Flyable ride){
        this.name = name;
        this.ride = ride;
    }

    public String getName(){
        return this.name;
    }

    public Flyable getRide(){
        return this.ride;
    }

    public void setRide(Flyable ride) {
        this.ride = ride;
    }

    public String fly(){
        return this.ride.fly();
    }

}
