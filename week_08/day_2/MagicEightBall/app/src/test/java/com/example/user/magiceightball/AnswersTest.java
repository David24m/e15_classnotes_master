package com.example.user.magiceightball;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by user on 14/09/2017.
 */

public class AnswersTest {
    Answers answers;

    @Before
    public void before() {
        answers = new Answers();
    }

    @Test
    public void canGetAnswers() {
        assertNotNull(answers.getAnswers());
    }

    @Test
    public void canSetUpAnswers() {
        answers.setUpAnswers();

        assertEquals(2, answers.getLength());
    }

    @Test
    public void canGetAnswerByIndex() {
        answers.setUpAnswers();

        String indexedAnswer = answers.getAnswerByIndex(0);

        assertEquals("Yes!", indexedAnswer);
    }

    @Test
    public void canAcceptCustomAnswers() {
        ArrayList<String> customAnswers = new ArrayList<>();
        customAnswers.add("I dunno dawg, make up your own mind.");
        customAnswers.add("That'd be totally lit.");
        customAnswers.add("Discouraging silence.");

        Answers answersWithCustomAnswers = new Answers(customAnswers);

        assertEquals(3, answersWithCustomAnswers.getLength());
        assertEquals("I dunno dawg, make up your own mind.",
                answersWithCustomAnswers.getAnswers().get(0));
    }

    @Test
    public void canGetRandomAnswer() {
        NumberGenerating zeroGenerator;
        zeroGenerator = Mockito.mock(NumberGenerating.class);
        Mockito.when(zeroGenerator.generateNumber(Mockito.anyInt()))
                .thenReturn(0);
        answers.setUpAnswers();

        String randomAnswer = answers.getRandomAnswer(zeroGenerator);

        assertEquals("Yes!", randomAnswer);
    }

}


















