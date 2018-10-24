package com.example.sandy.overloadingexamples;

public class MethodOverloadingExample {

    // different numbers of arguments
    public String addTwoInts(int number1, int number2) {
        int result = number1 + number2;
        return "Result of adding 2 ints is " + result;
    }

    public String addThreeInts(int number1, int number2, int number3) {
        int result = number1 + number2 + number3;
        return "Result of adding 3 ints is " + result;
    }

    public String addFourInts(int number1, int number2, int number3, int number4) {
        int result = number1 + number2 + number3 + number4;
        return "Result of adding 4 ints is " + result;
    }

    // different types of arguments
    public String subtractDoubleFromDouble(double number1, double number2) {
        double result = number1 - number2;
        return "Subtracting double from double. Result is " + result;
    }

    public String subtractIntFromDouble(double number1, int number2) {
        double result = number1 - number2;
        return "Subtracting int from double. Result is " + result;
    }

    public String subtractDoubleFromInt(int number1, double number2) {
        double result = number1 - number2;
        return "Subtracting double from int. Result is " + result;
    }
}
