package com.example.dyslexialearningapplication.Maths;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dyslexialearningapplication.R;

import java.util.Arrays;
import java.util.Collections;

/*
This is the main activity class for the base difficulty for the match numbers game.
 */

/*
Code for matching grid was adapted from:
Tihomir RAdeff (2017) Develop Memory Game in Android Studio [Online Video]. February 2017. Available from: <https://www.youtube.com/watch?v=94CWNE9ruMA&t=181s> [Accessed 27 February 2022]
 */

public class matchNumbers extends AppCompatActivity {

    TextView player_score;
    ImageView card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12;
    Integer[] cardsArray = {101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206};

    int image101, image102, image103, image104, image105, image106, image201, image202, image203, image204, image205, image206;
    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    int turn = 1;
    int playerPoints = 0, cpuPoints = 0;

    /*
    This onCreate override method is responsible for setting the correct content view and also sets the cards on screen to their layout counterpart and sets the on click listeners.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_numbers);

        player_score = findViewById(R.id.player_score);

        card1 = findViewById(R.id.iv_12);
        card2 = findViewById(R.id.iv_13);
        card3 = findViewById(R.id.iv_14);
        card4 = findViewById(R.id.iv_15);
        card5 = findViewById(R.id.iv_22);
        card6 = findViewById(R.id.iv_23);
        card7 = findViewById(R.id.iv_24);
        card8 = findViewById(R.id.iv_25);
        card9 = findViewById(R.id.iv_32);
        card10 = findViewById(R.id.iv_33);
        card11 = findViewById(R.id.iv_34);
        card12 = findViewById(R.id.iv_35);

        card1.setTag("0");
        card2.setTag("1");
        card3.setTag("2");
        card4.setTag("3");
        card5.setTag("4");
        card6.setTag("5");
        card7.setTag("6");
        card8.setTag("7");
        card9.setTag("8");
        card10.setTag("9");
        card11.setTag("10");
        card12.setTag("11");

        frontOfCardsResources();
        Collections.shuffle(Arrays.asList(cardsArray));

        /*
        These methods are the onClickListeners for each of the buttons. A tag is requested and stored and applied to the following method.
         */

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card1, theCard);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card2, theCard);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card3, theCard);
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card4, theCard);
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card5, theCard);
            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card6, theCard);
            }
        });

        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card7, theCard);
            }
        });

        card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card8, theCard);
            }
        });

        card9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card9, theCard);
            }
        });

        card10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card10, theCard);
            }
        });

        card11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card11, theCard);
            }
        });

        card12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card12, theCard);
            }
        });
    }

    /*
    This method sets the correct image for the respective card.
     */

    private void doStuff(ImageView iv, int card) {
        if (cardsArray[card] == 101) {
            iv.setImageResource(image101);
        } else if (cardsArray[card] == 102) {
            iv.setImageResource(image102);
        } else if (cardsArray[card] == 103) {
            iv.setImageResource(image103);
        } else if (cardsArray[card] == 104) {
            iv.setImageResource(image104);
        } else if (cardsArray[card] == 105) {
            iv.setImageResource(image105);
        } else if (cardsArray[card] == 106) {
            iv.setImageResource(image106);
        } else if (cardsArray[card] == 201) {
            iv.setImageResource(image201);
        } else if (cardsArray[card] == 202) {
            iv.setImageResource(image202);
        } else if (cardsArray[card] == 203) {
            iv.setImageResource(image203);
        } else if (cardsArray[card] == 204) {
            iv.setImageResource(image204);
        } else if (cardsArray[card] == 205) {
            iv.setImageResource(image205);
        } else if (cardsArray[card] == 206) {
            iv.setImageResource(image206);
        }


        if (cardNumber == 1) {
            firstCard = cardsArray[card];
            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        } else if (cardNumber == 2) {
            secondCard = cardsArray[card];
            if (secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            card1.setEnabled(false);
            card2.setEnabled(false);
            card3.setEnabled(false);
            card4.setEnabled(false);
            card5.setEnabled(false);
            card6.setEnabled(false);
            card7.setEnabled(false);
            card8.setEnabled(false);
            card9.setEnabled(false);
            card10.setEnabled(false);
            card11.setEnabled(false);
            card12.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            }, 1000);
        }
    }

    /*
    This method checks to make sure the cards match and subsequent events take place correctly.
     */

    private void calculate() {
        if (firstCard == secondCard) {
            if (clickedFirst == 0) {
                card1.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                card2.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                card3.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                card4.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                card5.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                card6.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                card7.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                card8.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {
                card9.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {
                card10.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 10) {
                card11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 11) {
                card12.setVisibility(View.INVISIBLE);
            }

            if (clickedSecond == 0) {
                card1.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                card2.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                card3.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                card4.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                card5.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                card6.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                card7.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                card8.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 8) {
                card9.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 9) {
                card10.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 10) {
                card11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 11) {
                card12.setVisibility(View.INVISIBLE);
            }

            playerPoints++;
            player_score.setText("Score: " + playerPoints);
        } else {
            card1.setImageResource(R.drawable.button_question_mark);
            card2.setImageResource(R.drawable.button_question_mark);
            card3.setImageResource(R.drawable.button_question_mark);
            card4.setImageResource(R.drawable.button_question_mark);
            card5.setImageResource(R.drawable.button_question_mark);
            card6.setImageResource(R.drawable.button_question_mark);
            card7.setImageResource(R.drawable.button_question_mark);
            card8.setImageResource(R.drawable.button_question_mark);
            card9.setImageResource(R.drawable.button_question_mark);
            card10.setImageResource(R.drawable.button_question_mark);
            card11.setImageResource(R.drawable.button_question_mark);
            card12.setImageResource(R.drawable.button_question_mark);
        }

        card1.setEnabled(true);
        card2.setEnabled(true);
        card3.setEnabled(true);
        card4.setEnabled(true);
        card5.setEnabled(true);
        card6.setEnabled(true);
        card7.setEnabled(true);
        card8.setEnabled(true);
        card9.setEnabled(true);
        card10.setEnabled(true);
        card11.setEnabled(true);
        card12.setEnabled(true);

        checkEnd();
    }

    /*
    This method checks certain conditions to identify if the activity has been completed.
     */

    private void checkEnd() {
        if (card1.getVisibility() == View.INVISIBLE &&
                card2.getVisibility() == View.INVISIBLE &&
                card3.getVisibility() == View.INVISIBLE &&
                card4.getVisibility() == View.INVISIBLE &&
                card5.getVisibility() == View.INVISIBLE &&
                card6.getVisibility() == View.INVISIBLE &&
                card7.getVisibility() == View.INVISIBLE &&
                card8.getVisibility() == View.INVISIBLE &&
                card9.getVisibility() == View.INVISIBLE &&
                card10.getVisibility() == View.INVISIBLE &&
                card11.getVisibility() == View.INVISIBLE &&
                card12.getVisibility() == View.INVISIBLE) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(matchNumbers.this);
            alertDialogBuilder.setMessage("GAME OVER!\nScore: " + playerPoints)
                    .setCancelable(false)
                    .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), matchNumbers.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    /*
    This method assigns the image views to the correct images.
     */

    private void frontOfCardsResources() {
        image101 = R.drawable.button_0;
        image102 = R.drawable.button_1;
        image103 = R.drawable.button_2;
        image104 = R.drawable.button_3;
        image105 = R.drawable.button_4;
        image106 = R.drawable.button_5;
        image201 = R.drawable.button_0_2;
        image202 = R.drawable.button_1_2;
        image203 = R.drawable.button_2_2;
        image204 = R.drawable.button_3_2;
        image205 = R.drawable.button_4_2;
        image206 = R.drawable.button_5_2;


    }
}