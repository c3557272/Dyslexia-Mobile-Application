package com.example.dyslexialearningapplication.English;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dyslexialearningapplication.R;

/*
This class is where the phonics scores are saved using sharedPreferences to communicate with the phonics activity.
 */

public class PhonicScores extends AppCompatActivity {

    TextView phonicsScore;
    int lastScore;
    int best1pho, best2pho, best3pho;

    /*
    This onCreate override sets the correct content view layout and also assigns the TextView to it's layout element.
    SharedPreferences is used in order to transfer the data collected from the phonics activity over to this activity
    and if statements are used to see if the high score requires updating and modifies accordingly.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonic_scores);
        phonicsScore = findViewById(R.id.scoreDisplayPho);

        SharedPreferences preferences3 = getSharedPreferences("PREFS3", 0);
        lastScore = preferences3.getInt("lastScore", 0);
        best1pho = preferences3.getInt("best1", 0);
        best2pho = preferences3.getInt("best2", 0);
        best3pho = preferences3.getInt("best3", 0);

        if (lastScore > best3pho) {
            best3pho = lastScore;
            SharedPreferences.Editor editor = preferences3.edit();
            editor.putInt("best3", best3pho);
            editor.apply();
        }
        if (lastScore > best2pho) {
            int temp = best2pho;
            best2pho = lastScore;
            best3pho = temp;
            SharedPreferences.Editor editor = preferences3.edit();
            editor.putInt("best3", best3pho);
            editor.putInt("best2", best2pho);
            editor.apply();
        }
        if (lastScore > best1pho) {
            int temp = best1pho;
            best1pho = lastScore;
            best2pho = temp;
            SharedPreferences.Editor editor = preferences3.edit();
            editor.putInt("best2", best2pho);
            editor.putInt("best1", best1pho);
            editor.apply();
        }
        phonicsScore.setText("Last Score: " + lastScore + "\n" + "\n" + "Best 1: " + best1pho + "\n" + "\n" + "Best 2: " + best2pho + "\n" + "\n" + "Best 3: " + best3pho);
    }

    /*
    This method returns the user to the main english activity hub area.
     */
    public void backPressed(View view) {
        Intent backIntent = new Intent(getApplicationContext(), englishActivity.class);
        startActivity(backIntent);
    }
}