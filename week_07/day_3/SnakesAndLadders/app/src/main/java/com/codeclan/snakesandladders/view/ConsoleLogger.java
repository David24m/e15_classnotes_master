package com.codeclan.snakesandladders.view;

import com.codeclan.snakesandladders.model.Logger;

import java.util.ArrayList;

/**
 * Created by stewartmackenzie-leigh on 13/09/2017.
 */

public class ConsoleLogger implements Logger {
    @Override
    public void logMessage(String message) {
        System.out.println(message);
    }
}
