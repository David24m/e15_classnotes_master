package com.example.user.magiceightball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_eight_ball, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selectedItemId = item.getItemId();
        switch (selectedItemId) {
            case R.id.action_toast:
                makeToast("I am a toast", Toast.LENGTH_SHORT);
                return true;
            case R.id.action_secret:
                goToSecretActivity();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goToSecretActivity() {
        Intent intent = new Intent(this, SecretActivity.class);
        startActivity(intent);
    }

    public void makeToast(String message, int length) {
        Toast.makeText(this, message, length).show();
    }
}











