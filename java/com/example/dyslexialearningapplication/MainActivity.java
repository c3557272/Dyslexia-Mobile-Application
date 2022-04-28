package com.example.dyslexialearningapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dyslexialearningapplication.English.englishActivity;
import com.example.dyslexialearningapplication.Maths.mathsActivity;

/*
    This is the main class where the application will direct to on it's initial execution. Here is where the user can navigate to Maths or English Activities.

 */

public class MainActivity extends AppCompatActivity {
    public Button englishButton;
    public Button mathsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        englishButton = findViewById(R.id.englishButton);
        mathsButton = findViewById(R.id.mathsButton);

        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent englishIntent = new Intent(MainActivity.this, englishActivity.class);
                startActivity(englishIntent);
            }
        });

        mathsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mathsIntent = new Intent(MainActivity.this, mathsActivity.class);
                startActivity((mathsIntent));
            }

        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void reportPage(View view) {
        Intent reportIntent = new Intent(this, reportPage.class);
        startActivity(reportIntent);
    }
}