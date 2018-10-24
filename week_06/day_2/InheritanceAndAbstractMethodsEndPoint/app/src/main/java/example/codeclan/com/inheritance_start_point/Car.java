package example.codeclan.com.inheritance_start_point;

/**
 * Created by user on 28/08/2017.
 */

public class Car extends Vehicle {
    public Car() {
        super(4);
    }

    @Override
    public String warn() {
        return "Beep Beep";
    }
}
