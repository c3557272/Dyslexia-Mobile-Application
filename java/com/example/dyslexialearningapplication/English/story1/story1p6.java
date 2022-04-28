package com.example.dyslexialearningapplication.English.story1;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dyslexialearningapplication.English.chooseStory;
import com.example.dyslexialearningapplication.R;

import java.util.Locale;

/*
This class provides the programming for the sixth page of the first story the user can access.
 */

public class story1p6 extends AppCompatActivity {

    private TextToSpeech mTTS;
    private Button speakButton;
    private TextView article;

    /*
    Override creates the onCreate that sets the content view and attaches the features of the windows to the layout elements.
    A text to speech function is setup in order to allow the text to be read to the user when interacted.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story1p6);

        speakButton = findViewById(R.id.voice6);
        article = findViewById(R.id.article6);

        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported.");
                    } else {
                        speakButton.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Language not supported.");
                }
            }
        });
    }

    /*
    this method that allows for the view to be switched via the intent that indicates the program to progress to the previous page.
     */

    public void backPage_S1P5(View view) {
        Intent backPageIntents1p5 = new Intent(this, story1p5.class);
        startActivity(backPageIntents1p5);
    }

    /*
    this method that allows for the view to be switched via the intent that indicates the program to progress to the root page.
     */

    public void returnRoot(View view) {
        Intent returnRootIntent = new Intent(story1p6.this, chooseStory.class);
        startActivity(returnRootIntent);
    }

    /*
    This override of the onDestroy function assures the textToSpeech function is forcefully shutdown to avoid audio cutting into other activities.
     */

    @Override
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();
    }

    /*
    This method defines the onClick function that will active the speak function to read out the text to the user.
     */

    public void voice6Click(View view) {
        speak();
    }

    /*
    This method is called to read out the text to the user and the speech traits are also set within this method ( Pitch, Speech Rate).
     */

    private void speak() {
        String text = article.getText().toString();
        mTTS.setPitch(-2);
        mTTS.setSpeechRate(1);
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

}