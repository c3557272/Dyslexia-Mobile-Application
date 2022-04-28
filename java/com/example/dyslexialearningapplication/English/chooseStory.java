package com.example.dyslexialearningapplication.English;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dyslexialearningapplication.English.story1.story1p1;
import com.example.dyslexialearningapplication.English.story2.story2p1;
import com.example.dyslexialearningapplication.English.story3.story3p1;
import com.example.dyslexialearningapplication.English.story4.story4p1;
import com.example.dyslexialearningapplication.R;

/*
    This is the class where the story can be chosen by the user. There are 4 buttons that will lead to each story respectively.
 */

public class chooseStory extends AppCompatActivity {

    /*
    This override method for onCreate sets the Content View to the layout file.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_story);
    }

    /*
    This method creates the function to switch to the first story via an intent.
     */

    public void story1btn(View view) {
        Intent storyIntent1 = new Intent(this, story1p1.class);
        startActivity(storyIntent1);
    }

    /*
    This method creates the function to switch to the second story via an intent.
     */

    public void story2btn(View view) {
        Intent storyIntent2 = new Intent(this, story2p1.class);
        startActivity(storyIntent2);
    }

    /*
    This method creates the function to switch to the third story via an intent.
     */

    public void story3btn(View view) {
        Intent storyIntent3 = new Intent(this, story3p1.class);
        startActivity(storyIntent3);
    }

    /*
    This method creates the function to switch to the fourth story via an intent.
     */

    public void story4btn(View view) {
        Intent storyIntent4 = new Intent(this, story4p1.class);
        startActivity(storyIntent4);
    }

    /*
    This method overrides the onBackPressed method to change the activity to the previous activity, the main english hub area, via an intent.
     */

    @Override
    public void onBackPressed() {
        Intent backStoryIntent = new Intent(chooseStory.this, englishActivity.class);
        startActivity(backStoryIntent);
    }
}