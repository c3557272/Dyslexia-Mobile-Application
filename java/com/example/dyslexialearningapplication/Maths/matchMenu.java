package com.example.dyslexialearningapplication.Maths;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dyslexialearningapplication.R;

/*
This class is the menu activity for the match activity.
 */

public class matchMenu extends AppCompatActivity {

    /*
    This override method onCreate sets the correct content view.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_menu);
    }

    /*
    This method holds the intent that allows the button to direct the user to the correct page.
     */

    public void matchNormalClick(View view) {
        Intent matchNumbersIntent = new Intent(matchMenu.this, matchNumbers.class);
        startActivity(matchNumbersIntent);
    }

    /*
    This method holds the intent that allows the button to direct the user to the correct page.
     */

    public void matchChallengeClick(View view) {
        Intent matchChallengeIntent = new Intent(matchMenu.this, matchNumbersPlus.class);
        startActivity(matchChallengeIntent);
    }
}