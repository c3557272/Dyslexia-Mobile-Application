package com.example.dyslexialearningapplication.Maths;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dyslexialearningapplication.MainActivity;
import com.example.dyslexialearningapplication.R;

/*
This is the main maths activity where the user can select their maths game.
 */

public class mathsActivity extends AppCompatActivity {

    public Button additionBtn;
    public Button subtractionBtn;
    public Button matchNumBtn;

    /*
    This override of the onCreate method assigns the buttons to their layout counterparts and sets the onClickListeners correctly.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);

        additionBtn = findViewById(R.id.additionBtn);
        subtractionBtn = findViewById(R.id.subtractionBtn);
        matchNumBtn = findViewById(R.id.matchNumBtn);

        additionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent additionIntent = new Intent(mathsActivity.this, additionMain.class);
                startActivity(additionIntent);
            }
        });

        subtractionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent subtractionIntent = new Intent(mathsActivity.this, subtractionMain.class);
                startActivity(subtractionIntent);
            }
        });

        matchNumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent matchIntent = new Intent(mathsActivity.this, matchMenu.class);
                startActivity(matchIntent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent randomIntent = new Intent(this, MainActivity.class);
        startActivity(randomIntent);
    }
}