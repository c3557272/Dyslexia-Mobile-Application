package com.example.dyslexialearningapplication.English;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dyslexialearningapplication.English.story1.story1p1;
import com.example.dyslexialearningapplication.English.story2.story2p1;
import com.example.dyslexialearningapplication.English.story3.story3p1;
import com.example.dyslexialearningapplication.English.story4.story4p1;
import com.example.dyslexialearningapplication.R;

import java.util.Random;

/*
This is the main menu for the reading area of the product. Here the user can navigate between two options:
The first option is to pick a story themselves which will direct them to the choose story activity;
the second option will randomly pick a story for the user.
 */

public class englishReading extends AppCompatActivity {
    public Button pickStoryBtn;
    public Button randomStoryBtn;

    /*
    This override onCreate method sets the content view for the activity and sets the onClickListener for the two buttons.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_reading);

        pickStoryBtn = findViewById(R.id.pickStoryBtn);
        randomStoryBtn = findViewById(R.id.randomStoryBtn);

        /*
        This is the onClickListener that directs the user to the choose story activity.
         */

        pickStoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pickStoryIntent = new Intent(englishReading.this, chooseStory.class);
                startActivity(pickStoryIntent);
            }
        });

        /*
        This is the onClickListener that directs the user to a random story.
         */

        randomStoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random numberGenerator = new Random();
                int number = numberGenerator.nextInt(4) + 1;
                Class activity = null;
                switch (number) {
                    case 1:
                        activity = story1p1.class;
                        break;
                    case 2:
                        activity = story2p1.class;
                        break;
                    case 3:
                        activity = story3p1.class;
                        break;
                    case 4:
                        activity = story4p1.class;
                        break;
                }
                Intent randomStoryIntent = new Intent(englishReading.this, activity);
                startActivity(randomStoryIntent);
            }
        });
    }
}