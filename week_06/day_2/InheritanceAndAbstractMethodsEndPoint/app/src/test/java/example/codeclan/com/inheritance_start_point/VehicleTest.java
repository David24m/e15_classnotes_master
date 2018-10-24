package example.codeclan.com.inheritance_start_point;

/**
 * Created by user on 28/08/2017.
 */
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class VehicleTest {
    Car car;
    MotorBike motorbike;

    @Before
    public void before(){
        car = new Car();
        motorbike = new MotorBike();
    }

    @Test
    public void testCarHasFourWheels(){
        assertEquals(4, car.getNumWheels());
    }

    @Test
    public void testMotorbikeHasTwoWheels(){
        assertEquals(2, motorbike.getNumWheels());
    }

    @Test
    public void testCarGoesVrrrm() {
        String result = car.startEngine();
        assertEquals("Vrrrm", result);
    }

    @Test
    public void testMotorbikeIsObnoxious() {
        String result = motorbike.startEngine();
        assertEquals("Vrrrm! HELL YEAH!", result);
    }
}
