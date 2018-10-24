package com.example.user.magiceightball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class AnswerActivity extends AppCompatActivity {

    TextView questionText;
    TextView answerText;
    Answering answers;
    NumberGenerating randomNumberGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        questionText = (TextView) findViewById(R.id.question_text);
        answerText = (TextView) findViewById(R.id.answer_text);

        ArrayList<String> customAnswers = new ArrayList<>();
        customAnswers.add("Classic Harrison");
        customAnswers.add("Should've been a Jaguar");
        customAnswers.add("Wow. - Dan");
        customAnswers.add("Wow. - Robb");

        answers = new Answers(customAnswers);
        randomNumberGenerator = new RandomNumberGenerator();

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String question = extras.getString("question");
        String answer = answers.getRandomAnswer(randomNumberGenerator);

        questionText.setText(question);
        answerText.setText(answer);
    }
}











