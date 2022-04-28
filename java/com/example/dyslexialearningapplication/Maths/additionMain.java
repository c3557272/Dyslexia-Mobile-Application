package com.example.dyslexialearningapplication.Maths;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dyslexialearningapplication.R;

/*
This class is used as the main activity class for the addition element of the product.
 */

/*
Code adapted from this source to help implement the question loading function. Applies to addition AND subtraction games.
Programming with Professor Sluiter (2019) Math Quiz Mobile App in Android Studio. [Online Video]. Available from: <https://www.youtube.com/watch?v=ja1Jli7bHNM>. [Accessed 05 February 2022]
 */

public class additionMain extends AppCompatActivity {

    public int savedScoreAdd;
    Button startButton, ansBtn1, ansBtn2, ansBtn3, ansBtn4;
    TextView questionDisplay, timerDisplay, scoreDisplay, systemResponse;
    ProgressBar progressionBar;
    gameTrackerAdd g = new gameTrackerAdd();

    int remainingSeconds = 45;

    CountDownTimer timer = new CountDownTimer(45000, 1000) {

        /*
            This override onTick method assures seconds are depleted on each tick and updates the display.
             */
        @Override
        public void onTick(long l) {
            remainingSeconds--;
            timerDisplay.setText(remainingSeconds + "seconds");
            progressionBar.setProgress(30 - remainingSeconds);
        }
        /*
            This onFinish override method makes sure that the timer has been destroyed after it finishes it's countdown and
            the "sharedPreferences" takes in the user's score to pass to the scores activity.
             */

        @Override
        public void onFinish() {
            ansBtn1.setEnabled(false);
            ansBtn2.setEnabled(false);
            ansBtn3.setEnabled(false);
            ansBtn4.setEnabled(false);
            systemResponse.setText("Game has ended! Well done! Your Score: " + g.getNumberCorrect() + "/" + (g.getTotalQuestions() - 1));

            savedScoreAdd = g.getScore();
            SharedPreferences preferences = getSharedPreferences("PREFS", 0);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("lastScore", savedScoreAdd);
            editor.apply();

            Intent addScoreIntent = new Intent(getApplicationContext(), additionScores.class);
            startActivity(addScoreIntent);
            finish();

        }
    };

    /*
    This method overrides the onBackPressed method, this assures the countdown timer is cancelled and the correct activity is backtracked to.
     */

    @Override
    public void onBackPressed() {
        timer.cancel();
        Intent randomIntent = new Intent(additionMain.this, mathsActivity.class);
        startActivity(randomIntent);
    }

    /*
    This onCreate override method sets the content view for the appropriate layout and assigns the buttons and other window features to their layout elements.
    OnClickListeners are also set here for the start button and answer button.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_questions);
        startButton = findViewById(R.id.startButton);
        ansBtn1 = findViewById(R.id.answerBtn0);
        ansBtn2 = findViewById(R.id.answerBtn1);
        ansBtn3 = findViewById(R.id.answerBtn2);
        ansBtn4 = findViewById(R.id.answerBtn3);
        questionDisplay = findViewById(R.id.questionDisplay);
        timerDisplay = findViewById(R.id.timerDisplay);
        scoreDisplay = findViewById(R.id.scoreDisplay);
        systemResponse = findViewById(R.id.systemResponse);
        progressionBar = findViewById(R.id.progressionBar);

        timerDisplay.setText("0 Secs");
        questionDisplay.setText("Question");
        systemResponse.setText("Press Start to Play!");
        scoreDisplay.setText("0 Points");
        progressionBar.setProgress(0);

        View.OnClickListener startBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button startBtn = (Button) v;
                startBtn.setVisibility(View.INVISIBLE);
                remainingSeconds = 45;
                scoreDisplay.setText("0");
                g = new gameTrackerAdd();
                turnLoop();
                timer.start();

            }
        };

        View.OnClickListener answerBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button answerBtnClicked = (Button) view;
                int answerSelected = Integer.parseInt(answerBtnClicked.getText().toString());
                Toast.makeText(additionMain.this, "Answer Selected = " + answerSelected, Toast.LENGTH_SHORT).show();
                g.validateAns(answerSelected);
                scoreDisplay.setText(Integer.toString(g.getScore()));
                turnLoop();
            }
        };

        startButton.setOnClickListener(startBtnClickListener);

        ansBtn1.setOnClickListener(answerBtnClickListener);
        ansBtn2.setOnClickListener(answerBtnClickListener);
        ansBtn3.setOnClickListener(answerBtnClickListener);
        ansBtn4.setOnClickListener(answerBtnClickListener);
    }

    /*
    This method loads in the next question and sets the correct current score values.
     */

    private void turnLoop() {
        g.newQuestion();
        int[] answer = g.getCurrentQ().getAnswerArray();
        ansBtn1.setText(Integer.toString(answer[0]));
        ansBtn2.setText(Integer.toString(answer[1]));
        ansBtn3.setText(Integer.toString(answer[2]));
        ansBtn4.setText(Integer.toString(answer[3]));

        ansBtn1.setEnabled(true);
        ansBtn2.setEnabled(true);
        ansBtn3.setEnabled(true);
        ansBtn4.setEnabled(true);

        questionDisplay.setText(g.getCurrentQ().getQuestionPhrase());
        systemResponse.setText(g.getNumberCorrect() + "/" + (g.getTotalQuestions() - 1));
    }

}