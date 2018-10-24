package com.example.user.magiceightball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class EightBallActivity extends AppCompatActivity {

    EditText questionEditText;
    TextView answerText;
    Button shakeButton;
    Answering answers;
    NumberGenerating randomNumberGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_ball);

        questionEditText = (EditText) findViewById(R.id.question_text);
        answerText = (TextView) findViewById(R.id.answer_text);
        shakeButton = (Button) findViewById(R.id.shake_button);
        
        ArrayList<String> customAnswers = new ArrayList<>();
        customAnswers.add("Classic Harrison");
        customAnswers.add("Should've been a Jaguar");
        customAnswers.add("Wow. - Dan");
        customAnswers.add("Wow. - Robb");

        answers = new Answers(customAnswers);
        randomNumberGenerator = new RandomNumberGenerator();
    }

    public void onShakeButtonClicked(View button) {
        String randomAnswer = answers.getRandomAnswer(randomNumberGenerator);
        answerText.setText(randomAnswer);
    }
}











