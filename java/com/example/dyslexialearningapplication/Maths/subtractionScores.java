package com.example.dyslexialearningapplication.Maths;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dyslexialearningapplication.R;

/*
This class is responsible for the subtraction Scores and will keep track of the highest score using an intent to transfer data from the activity.
 */

public class subtractionScores extends AppCompatActivity {
    TextView subtractionScore;
    int lastScore;
    int best1sub, best2sub, best3sub;

    /*
    This override of the onCreate method is responsible for setting the correct content view and connecting the sharedprerefence that will hold the score data.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction_scores);

        subtractionScore = findViewById(R.id.scoreDisplaySub);

        SharedPreferences preferences2 = getSharedPreferences("PREFS2", 0);
        lastScore = preferences2.getInt("lastScore", 0);
        best1sub = preferences2.getInt("best1", 0);
        best2sub = preferences2.getInt("best2", 0);
        best3sub = preferences2.getInt("best3", 0);

        if (lastScore > best3sub) {
            best3sub = lastScore;
            SharedPreferences.Editor editor = preferences2.edit();
            editor.putInt("best3", best3sub);
            editor.apply();
        }
        if (lastScore > best2sub) {
            int temp = best2sub;
            best2sub = lastScore;
            best3sub = temp;
            SharedPreferences.Editor editor = preferences2.edit();
            editor.putInt("best3", best3sub);
            editor.putInt("best2", best2sub);
            editor.apply();
        }
        if (lastScore > best1sub) {
            int temp = best1sub;
            best1sub = lastScore;
            best2sub = temp;
            SharedPreferences.Editor editor = preferences2.edit();
            editor.putInt("best2", best2sub);
            editor.putInt("best1", best1sub);
            editor.apply();
        }


        subtractionScore.setText("Last Score: " + lastScore + "\n" + "\n" + "Best 1: " + best1sub + "\n" + "\n" + "Best 2: " + best2sub + "\n" + "\n" + "Best 3: " + best3sub);
    }

    /*
    This backPressed method makes sure the back button directs the user to the correct prior page.
     */

    public void backPressed(View view) {
        Intent backIntent = new Intent(getApplicationContext(), mathsActivity.class);
        startActivity(backIntent);
    }
}