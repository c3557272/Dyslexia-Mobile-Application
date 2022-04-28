package com.example.dyslexialearningapplication.Maths;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dyslexialearningapplication.R;

/*
This class is responsible for the addition Scores and will keep track of the highest score using an intent to transfer data from the activity.
 */

public class additionScores extends AppCompatActivity {

    TextView additionScore;
    int lastScore;
    int best1add, best2add, best3add;

    /*
    This override of the onCreate method is responsible for setting the correct content view and connecting the sharedprerefence that will hold the score data.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_scores);

        additionScore = findViewById(R.id.scoreDisplayAdd);

        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        lastScore = preferences.getInt("lastScore", 0);
        best1add = preferences.getInt("best1", 0);
        best2add = preferences.getInt("best2", 0);
        best3add = preferences.getInt("best3", 0);

        if (lastScore > best3add) {
            best3add = lastScore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3", best3add);
            editor.apply();
        }
        if (lastScore > best2add) {
            int temp = best2add;
            best2add = lastScore;
            best3add = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3", best3add);
            editor.putInt("best2", best2add);
            editor.apply();
        }
        if (lastScore > best1add) {
            int temp = best1add;
            best1add = lastScore;
            best2add = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best2", best2add);
            editor.putInt("best1", best1add);
            editor.apply();
        }


        additionScore.setText("Last Score: " + lastScore + "\n" + "\n" + "Best 1: " + best1add + "\n" + "\n" + "Best 2: " + best2add + "\n" + "\n" + "Best 3: " + best3add);
    }

    /*
    This backPressed method makes sure the back button directs the user to the correct prior page.
     */

    public void backPressed(View view) {
        Intent backIntent = new Intent(getApplicationContext(), mathsActivity.class);
        startActivity(backIntent);
    }
}