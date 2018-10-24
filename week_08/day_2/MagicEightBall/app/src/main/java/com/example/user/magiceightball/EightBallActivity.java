package com.example.user.magiceightball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EightBallActivity extends AppCompatActivity {

    EditText questionEditText;
    Button shakeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_ball);

        questionEditText = (EditText) findViewById(R.id.question_input_text);
        shakeButton = (Button) findViewById(R.id.shake_button);
    }

    public void onShakeButtonClicked(View button) {
        Intent intent = new Intent(this, AnswerActivity.class);

        String question = questionEditText.getText().toString();
        intent.putExtra("question", question);

        startActivity(intent);
    }
}











