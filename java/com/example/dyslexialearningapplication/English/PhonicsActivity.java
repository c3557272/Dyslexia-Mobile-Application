package com.example.dyslexialearningapplication.English;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.dyslexialearningapplication.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/*
This is the main class where the phonics activity will occur.
 */

public class PhonicsActivity extends AppCompatActivity {

    //List of the variables to be used.
    int totalQuestions;
    int qCounter = 0;
    int score;
    int remainingSeconds = 60;
    int savedScorePho = 0;
    ColorStateList buttonColouring;
    boolean answered;
    CountDownTimer countDownTimer;
    private List<phonicsQuestions> PhonicsQuestions;
    private TextView textScore, textQuestionNo, textTimer, questionText;
    private ImageView questionImage;
    private RadioGroup radioGroup;
    private RadioButton radio1, radio2, radio3, radio4;
    private Button nextButton;
    private TextToSpeech mTTS;
    private phonicsQuestions currentQuestion;

    /*
        This override of the onCreate method sets the correct content view and also assigns all the functions to their layout elements. The questions are also added into the program and the
        questions are shuffled for variation in each playthrough.
         */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonics);

        PhonicsQuestions = new ArrayList<>();
        textScore = findViewById(R.id.textScore);
        textTimer = findViewById(R.id.textTimer);
        textQuestionNo = findViewById(R.id.textQuestionNo);
        questionText = findViewById(R.id.questionText);
        radioGroup = findViewById(R.id.radioGroup);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        radio4 = findViewById(R.id.radio4);
        nextButton = findViewById(R.id.nextButton);
        questionImage = findViewById(R.id.questionImage);

        buttonColouring = radio1.getTextColors();

        addQuestions();
        Collections.shuffle(PhonicsQuestions);

        totalQuestions = PhonicsQuestions.size();
        loadNextQuestion();
        timer();

        // This method checks an answer has been chosen when submit is clicked
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answered == false) {
                    if (radio1.isChecked() || radio2.isChecked() || radio3.isChecked() || radio4.isChecked()) {
                        validateAnswer();
                    } else {
                        Toast.makeText(PhonicsActivity.this, "Please select an option.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    loadNextQuestion();
                }
            }
        });

        /*
        This creates the text to speech function that will be used to read the question to the user.
         */

        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported.");
                    }
                } else {
                    Log.e("TTS", "Language not supported.");
                }
            }
        });
    }

    //This method checks the answer is correct
    private void validateAnswer() {
        answered = true;
        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNo = radioGroup.indexOfChild(rbSelected) + 1;
        if (answerNo == currentQuestion.getCorrectAnsNo()) {
            score++;
            textScore.setText("Score: " + score);
            correctSpeak();
        } else {
            incorrectSpeak();
        }
        radio1.setTextColor(Color.RED);
        radio2.setTextColor(Color.RED);
        radio3.setTextColor(Color.RED);
        radio4.setTextColor(Color.RED);
        switch (currentQuestion.getCorrectAnsNo()) {
            case 1:
                radio1.setTextColor(Color.GREEN);
                break;
            case 2:
                radio2.setTextColor(Color.GREEN);
                break;
            case 3:
                radio3.setTextColor(Color.GREEN);
                break;
            case 4:
                radio4.setTextColor(Color.GREEN);
                break;
        }
        if (qCounter < totalQuestions) {
            nextButton.setText("Next");
        } else {
            nextButton.setText("Finish");
        }
    }


    //This method loads the next question
    private void loadNextQuestion() {
        radioGroup.clearCheck();
        radio1.setTextColor(buttonColouring);
        radio2.setTextColor(buttonColouring);
        radio3.setTextColor(buttonColouring);
        radio4.setTextColor(buttonColouring);

        if (qCounter < totalQuestions) {
            currentQuestion = PhonicsQuestions.get(qCounter);
            questionText.setText(currentQuestion.getQuestion());
            checkImage();
            radio1.setText(currentQuestion.getOption1());
            radio2.setText(currentQuestion.getOption2());
            radio3.setText(currentQuestion.getOption3());
            radio4.setText(currentQuestion.getOption4());
            qCounter++;
            nextButton.setText("Submit");
            textQuestionNo.setText("Question: " + qCounter);
            answered = false;
        } else {
            finish();
        }
    }

    /*
        This method is vital to loading the correct image that matches the question on-screen.
         */

    public void checkImage() {
        if (questionText.getText().toString().contains("is an animal")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question1);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("mode of transport")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question2);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("is in Europe")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question3);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("are fruit")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question4);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("Jake went to the")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question5);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("yel___")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question6);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("is in England")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question7);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("Timothy is my")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question8);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("Monster Trucks are my")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question9);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("I like to go")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question10);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("Monkeys like to eat")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question11);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("Yesterday, I went to the")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question12);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("is b___")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question13);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("Last weekend")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question14);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("bird l___ed on")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question15);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("love to eat Ice")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question16);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("Footb___ is my")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question17);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("I like to p___")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question18);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("Basketball is a")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question19);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("cat likes to")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question20);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("My dad took me")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question21);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("do my homework before")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question22);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("I went to the football game!")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question23);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("Playing tennis")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question24);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("I love _____ my homework!")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question25);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("My ____ is Robert.")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question26);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("I can't wait for the")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question27);
            questionImage.setImageDrawable(drawable);
        } else if (questionText.getText().toString().contains("I like playing _____ games.")) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.question28);
            questionImage.setImageDrawable(drawable);
        }
    }

    /*
    This is the timer method that will be used to time the user while playing.
     */

    private void timer() {
        countDownTimer = new CountDownTimer(60000, 1000) {

            /*
            This override onTick method assures seconds are depleted on each tick and updates the display.
             */

            @Override
            public void onTick(long l) {
                remainingSeconds--;
                textTimer.setText("00:" + remainingSeconds);
            }

            /*
            This onFinish override method makes sure that the timer has been destroyed after it finishes it's countdown and
            the "sharedPreferences" takes in the user's score to pass to the scores activity.
             */

            @Override
            public void onFinish() {
                cancel();
                savedScorePho = score;
                SharedPreferences preferences3 = getSharedPreferences("PREFS3", 0);
                SharedPreferences.Editor editor = preferences3.edit();
                editor.putInt("lastScore", savedScorePho);
                editor.apply();
                Intent phonicScoreIntent = new Intent(getApplicationContext(), PhonicScores.class);
                startActivity(phonicScoreIntent);
                finish();
            }
        }.start();
    }

    /*
    This method is used to add questions into the game and can be used to easily implement new questions using multiple parameters.
     */

    private void addQuestions() {
        PhonicsQuestions.add(new phonicsQuestions("__ake is an animal.", "Sn", "Tr", "Mr", "Dr", 1));
        PhonicsQuestions.add(new phonicsQuestions("Tr__n is a mode of transport.", "ay", "ai", "iy", "ae", 2));
        PhonicsQuestions.add(new phonicsQuestions("En___nd is in Europe.", "gal", "gle", "gla", "jla", 3));
        PhonicsQuestions.add(new phonicsQuestions("A__les are fruit.", "pl", "pp", "lp", "bl", 2));
        PhonicsQuestions.add(new phonicsQuestions("Jake went to the p__k.", "ar", "rr", "ry", "er", 1));
        PhonicsQuestions.add(new phonicsQuestions("My favourite colour is yel___.", "lew", "llw", "low", "law", 3));
        PhonicsQuestions.add(new phonicsQuestions("L__don is in England.", "om", "an", "on", "am", 3));
        PhonicsQuestions.add(new phonicsQuestions("Timothy is my d__'s name!", "og", "ag", "od", "az", 1));
        PhonicsQuestions.add(new phonicsQuestions("Monster Trucks are my favourite types of __rs!.", "da", "ca", "pa", "ma", 2));
        PhonicsQuestions.add(new phonicsQuestions("I like to go s___ming. ", "mim", "pin", "wim", "sim", 3));
        PhonicsQuestions.add(new phonicsQuestions("Monkeys like to eat ba____s! ", "pana", "nana", "laap", "tarp", 2));
        PhonicsQuestions.add(new phonicsQuestions("Yesterday, I went to the Th___ Park!", "eme", "eem", "ree", "orp", 1));
        PhonicsQuestions.add(new phonicsQuestions("My favourite colour is b___.", "lew", "loo", "lue", "blop", 3));
        PhonicsQuestions.add(new phonicsQuestions("Last weekend, I went to the ci____. ", "nyma", "tida", "nema", "nima", 3));
        PhonicsQuestions.add(new phonicsQuestions("A bird l___ed on my hat", "and", "end", "amp", "orp", 1));
        PhonicsQuestions.add(new phonicsQuestions("I love to eat Ice Cr___! ", "eem", "eam", "eim", "iim", 2));
        PhonicsQuestions.add(new phonicsQuestions("Footb___ is my favourite sport! ", "aal", "ael", "all", "oal", 3));
        PhonicsQuestions.add(new phonicsQuestions("I like to p___ sports. ", "ley", "lay", "ick", "lum", 2));
        PhonicsQuestions.add(new phonicsQuestions("Basketball is a f__ sport. ", "un", "an", "um", "am", 1));
        PhonicsQuestions.add(new phonicsQuestions("My cat likes to eat T___.", "ana", "ona", "una", "oon", 3));
        PhonicsQuestions.add(new phonicsQuestions("My dad took me fi__ing today. It was fun!", "sh", "ss", "zh", "in", 1));
        PhonicsQuestions.add(new phonicsQuestions("I ______ do my homework before bedtime.", "shouud", "shuld", "should", "sholdd", 3));
        PhonicsQuestions.add(new phonicsQuestions("Last ____, I went to the football game!", "week", "weec", "weak", "waek", 1));
        PhonicsQuestions.add(new phonicsQuestions("Playing tennis is the ____!", "bast", "best", "besh", "bezt", 2));
        PhonicsQuestions.add(new phonicsQuestions("I love _____ my homework!.", "dooin", "diong", "duing", "doing", 4));
        PhonicsQuestions.add(new phonicsQuestions("My ____ is Robert.", "name", "naem", "naam", "neme", 1));
        PhonicsQuestions.add(new phonicsQuestions("I can't wait for the ______ holidays!", "sckool", "sklool", "school", "schoul", 3));
        PhonicsQuestions.add(new phonicsQuestions("I like playing _____ games.", "video", "vydeo", "vydio", "vidio", 1));
    }

    /*
    This is the text to speech method that plays when the correct answer is chosen.
     */

    private void correctSpeak() {
        String text = "Correct!";
        mTTS.setPitch(1);
        mTTS.setSpeechRate(1);
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    /*
    This is the text to speech method that plays when the incorrect answer is chosen.
     */

    private void incorrectSpeak() {
        String text = "Incorrect!";
        mTTS.setPitch(1);
        mTTS.setSpeechRate(1);
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    /*
    This override of the onDestroy method assures that the text to speech functions of this activity are all force
    closed and not played during any other activities.
     */

    @Override
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }
        countDownTimer.cancel();
        super.onDestroy();
    }

    /*
    This method overrides the onBackPressed method, this assures the countdown timer is cancelled and the correct activity is backtracked to.
     */

    @Override
    public void onBackPressed() {
        countDownTimer.cancel();
        Intent randomIntent = new Intent(PhonicsActivity.this, englishActivity.class);
        startActivity(randomIntent);
    }

}