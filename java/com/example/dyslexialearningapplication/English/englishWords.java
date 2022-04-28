package com.example.dyslexialearningapplication.English;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dyslexialearningapplication.R;

/*
This class is the main menu area for the phonics activity and this will be where the user is able
to navigate to the actual activity.
 */

public class englishWords extends AppCompatActivity {

    Button quizStartBtn;

    /*
    This override onCreate method sets the content view for the correct layout and it also contains the
    onClickListener for the quiz start button.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_words);

        quizStartBtn = findViewById(R.id.quizStartBtn);

        quizStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phonicsIntent = new Intent(englishWords.this, PhonicsActivity.class);
                startActivity(phonicsIntent);
            }
        });

    }
}