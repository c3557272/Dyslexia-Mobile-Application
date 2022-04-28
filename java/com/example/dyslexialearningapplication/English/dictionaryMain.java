package com.example.dyslexialearningapplication.English;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dyslexialearningapplication.R;

/*
This class is the main dictionary code that programs the layout features of the dictionary.
 */

/*
Oxford Dictionaries (2022) Oxford Dictionaries API [Online]. Available from: https://developer.oxforddictionaries.com/documentation#!/Entries/get_entries_source_lang_word_id [Accessed 02 March 2022]
 */

public class dictionaryMain extends AppCompatActivity {

    String url;
    private TextView showDef;
    private EditText enterWord;

    /*
    This onCreate override method sets the correct content view and assigns the TextView and EditText to their layout equivalents.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary_main);

        showDef = findViewById(R.id.showDef);
        enterWord = findViewById(R.id.enterWord);
    }

    /*
    This method sets the variable names and uses them to return the url search.
     */

    private String dictionaryEntries() {
        final String language = "en-gb";
        final String word = enterWord.getText().toString();
        final String fields = "definitions";
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;
    }

    /*
    This method is the onClickListener for the dictionary search button and here is where the code is executed to locate the word and display the information.
     */

    public void sendRequestOnClick(View v) {
        DictionaryRequest dR = new DictionaryRequest(this, showDef);
        url = dictionaryEntries();
        dR.execute(url);
    }

}