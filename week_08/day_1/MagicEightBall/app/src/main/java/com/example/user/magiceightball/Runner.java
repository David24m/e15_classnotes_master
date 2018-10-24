package com.example.user.magiceightball;

import java.util.ArrayList;

/**
 * Created by user on 14/09/2017.
 */

public class Runner {
    public static void main(String[] args) {
        NumberGenerating randomNumberGenerator
                = new RandomNumberGenerator();

        ArrayList<String> customAnswers = new ArrayList<>();
        customAnswers.add("Classic Harrison.");
        customAnswers.add("You've been Robb'd!");
        customAnswers.add("puts(gets.chomp())");
        customAnswers.add("No more salmon.");

        Answering answerProvider
                = new Answers(customAnswers);

        String randomAnswer = answerProvider
                .getRandomAnswer(randomNumberGenerator);

        System.out.println(randomAnswer);
    }
}
