package example.codeclan.com.inheritance_start_point;

public class MotorBike extends Vehicle {
    public MotorBike() {
        super(2);
    }

    public String startEngine() {
        return super.startEngine() + "! HELL YEAH!";
    }

    @Override
    public String warn() {
        return "GET OUT THE WAY!! HELL YEAH!";
    }
}
