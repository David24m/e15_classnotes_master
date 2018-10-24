package com.example.sandy.overloadingexamples;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MethodOverloadingExampleTest {
    private MethodOverloadingExample testClass;

    @Before
    public void setUp() {
        this.testClass = new MethodOverloadingExample();
    }

    @Test
    public void addingTwoInts() {
        String result = testClass.add(1, 2);
        assertEquals("Result of adding 2 ints is 3", result);
    }

    @Test
    public void addingThreeInts() {
        String result = testClass.add(1, 2, 3);
        assertEquals("Result of adding 3 ints is 6", result);
    }

    @Test
    public void addingFourInts() {
        String result = testClass.add(1, 2, 3, 4);
        assertEquals("Result of adding 4 ints is 10", result);
    }

    @Test
    public void subtractDoubleFromDouble() {
        String result = testClass.subtract(2.5, 1.2);
        assertEquals("Subtracting double from double. Result is 1.3", result);
    }

    @Test
    public void subtractIntFromDouble() {
        String result = testClass.subtract(4.5, 2);
        assertEquals("Subtracting int from double. Result is 2.5", result);
    }

    @Test
    public void subtractDoubleFromInt() {
        String result = testClass.subtract(5, 1.2);
        assertEquals("Subtracting double from int. Result is 3.8", result);
    }
}
