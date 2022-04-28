package com.example.dyslexialearningapplication.English;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dyslexialearningapplication.MainActivity;
import com.example.dyslexialearningapplication.R;

/*
    This class is the main hub area for the english aspect of the product
 */

public class englishActivity extends AppCompatActivity {

    public Button readingBtn;
    public Button spellingBtn;
    public Button dictionaryBtn;

    /*
    This override of the onCreate method sets the correct Content View and assigns all the button variables to their layout counterparts. The onClick listeners are also
        set for each of the buttons on the page that direct the user to the various areas of the English aspect for the product.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);

        readingBtn = findViewById(R.id.readingBtn);
        spellingBtn = findViewById(R.id.spellingBtn);
        dictionaryBtn = findViewById(R.id.dictionaryBtn);

        readingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent readingIntent = new Intent(englishActivity.this, englishReading.class);
                startActivity(readingIntent);
            }
        });

        spellingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent spellingIntent = new Intent(englishActivity.this, englishWords.class);
                startActivity(spellingIntent);
            }
        });

        dictionaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dictionaryIntent = new Intent(englishActivity.this, dictionaryMain.class);
                startActivity(dictionaryIntent);
            }
        });
    }

    /*
    This override method for onBackPressed redirects the user to the root page of the product when the button is clicked.
     */

    @Override
    public void onBackPressed() {
        Intent backPressedIntent = new Intent(englishActivity.this, MainActivity.class);
        startActivity(backPressedIntent);
    }
}