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
This class is used as the main activity class for the subtraction element of the product.
 */

/*
Code adapted from this source to help implement the question loading function. Applies to addition AND subtraction games.
Programming with Professor Sluiter (2019) Math Quiz Mobile App in Android Studio. [Online]. Available from: <https://www.youtube.com/watch?v=ja1Jli7bHNM>. [Accessed 15 February 2022]
 */

public class subtractionMain extends AppCompatActivity {

    Button startButton, answerBtn0, answerBtn1, answerBtn2, answerBtn3;
    TextView questionDisplay, timerDisplay, scoreDisplay, systemResponse;
    ProgressBar progressionBar;

    gameTrackerMinus g = new gameTrackerMinus();

    int remainingSeconds = 45;
    int savedScoreSub;

    /*
            This override onTick method assures seconds are depleted on each tick and updates the display.
     */

    CountDownTimer timer = new CountDownTimer(45000, 1000) {
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
            answerBtn0.setEnabled(false);
            answerBtn1.setEnabled(false);
            answerBtn2.setEnabled(false);
            answerBtn3.setEnabled(false);
            systemResponse.setText("Game has ended! Well done! Your Score: " + g.getNumberCorrect() + "/" + (g.getTotalQuestions() - 1));

            savedScoreSub = g.getScore();
            SharedPreferences preferences2 = getSharedPreferences("PREFS2", 0);
            SharedPreferences.Editor editor = preferences2.edit();
            editor.putInt("lastScore", savedScoreSub);
            editor.apply();

            Intent subScoreIntent = new Intent(getApplicationContext(), subtractionScores.class);
            startActivity(subScoreIntent);
            finish();
        }
    };

    /*
    This method overrides the onBackPressed method, this assures the countdown timer is cancelled and the correct activity is backtracked to.
     */

    @Override
    public void onBackPressed() {
        timer.cancel();
        Intent randomIntent = new Intent(subtractionMain.this, mathsActivity.class);
        startActivity(randomIntent);
    }

    /*
    This onCreate override method sets the content view for the appropriate layout and assigns the buttons and other window features to their layout elements.
    OnClickListeners are also set here for the start button and answer button.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction_questions);

        startButton = findViewById(R.id.startButton);
        answerBtn0 = findViewById(R.id.answerBtn0);
        answerBtn1 = findViewById(R.id.answerBtn1);
        answerBtn2 = findViewById(R.id.answerBtn2);
        answerBtn3 = findViewById(R.id.answerBtn3);

        questionDisplay = findViewById(R.id.questionDisplay);
        timerDisplay = findViewById(R.id.timerDisplay);
        scoreDisplay = findViewById(R.id.scoreDisplay);
        systemResponse = findViewById(R.id.systemResponse);
        progressionBar = findViewById(R.id.progressionBar);

        timerDisplay.setText("0 Secs");
        questionDisplay.setText("");
        systemResponse.setText("Press Start!");
        scoreDisplay.setText("0 Points");
        progressionBar.setProgress(0);

        View.OnClickListener startBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button startBtn = (Button) v;
                startBtn.setVisibility(View.INVISIBLE);
                remainingSeconds = 45;
                scoreDisplay.setText("0");
                g = new gameTrackerMinus();
                turnLoop();
                timer.start();

            }
        };

        View.OnClickListener answerBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button answerBtnClicked = (Button) view;
                int answerSelected = Integer.parseInt(answerBtnClicked.getText().toString());
                Toast.makeText(subtractionMain.this, "Answer Selected = " + answerSelected, Toast.LENGTH_SHORT).show();
                g.checkAnswer(answerSelected);
                scoreDisplay.setText(Integer.toString(g.getScore()));
                turnLoop();
            }
        };

        startButton.setOnClickListener(startBtnClickListener);

        answerBtn0.setOnClickListener(answerBtnClickListener);
        answerBtn1.setOnClickListener(answerBtnClickListener);
        answerBtn2.setOnClickListener(answerBtnClickListener);
        answerBtn3.setOnClickListener(answerBtnClickListener);
    }

    /*
    This method loads in the next question and sets the correct current score values.
     */

    private void turnLoop() {
        g.makeNewQ();
        int[] answer = g.getCurrentQuestion().getAnswerArray();
        answerBtn0.setText(Integer.toString(answer[0]));
        answerBtn1.setText(Integer.toString(answer[1]));
        answerBtn2.setText(Integer.toString(answer[2]));
        answerBtn3.setText(Integer.toString(answer[3]));

        answerBtn0.setEnabled(true);
        answerBtn1.setEnabled(true);
        answerBtn2.setEnabled(true);
        answerBtn3.setEnabled(true);

        questionDisplay.setText(g.getCurrentQuestion().getQuestionPhrase());

        systemResponse.setText(g.getNumberCorrect() + "/" + (g.getTotalQuestions() - 1));
    }

}