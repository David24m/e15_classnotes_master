package com.example.alex.counter;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Habit habit;
    TextView title;
    TextView counter;
    TextView feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView) findViewById(R.id.title);
        counter = (TextView)findViewById(R.id.counter);
        feedback = (TextView) findViewById(R.id.feedback);

        habit = new Habit("Make more git commits", true);

        // retrieve saved counter value here

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        //                                       key  , default value if not found
        int savedCounter = sharedPrefs.getInt("counter", 0);

        habit.setCounter(savedCounter);
        this.updateView();
    }

    public void handleButtonPress(View view) {
        switch (view.getId()) {
            case R.id.add_button:
                habit.addToCounter();
                break;
            case R.id.subtract_button:
                habit.subtractFromCounter();
                break;
            case R.id.reset_button:
                habit.resetCounter();
                break;
            default:
                break;
        }

        this.saveCounter();
        this.updateView();
    }

    public void saveCounter() {

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("counter", habit.getCounter());
        editor.apply();

        // Method chaining version does the same thing:

//        PreferenceManager.getDefaultSharedPreferences(this)
//                .edit()
//                .putInt("counter", habit.getCounter())
//                .apply();
    }

    public void updateView(){
        title.setText(habit.getTitle());
        counter.setText(String.valueOf(habit.getCounter()));
        feedback.setText(habit.getFeedback());
    }

}

