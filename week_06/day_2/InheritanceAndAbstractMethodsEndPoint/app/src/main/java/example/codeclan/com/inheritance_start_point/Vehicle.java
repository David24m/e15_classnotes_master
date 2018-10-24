package example.codeclan.com.inheritance_start_point;

/**
 * Created by user on 28/08/2017.
 */

public abstract class Vehicle {
    int numWheels = 4;

    public Vehicle(int numWheels) {
        this.numWheels = numWheels;
    }

    public int getNumWheels() {
        return this.numWheels;
    }

    public String startEngine() {
        return "Vrrrm";
    }

    public abstract String warn();
}
