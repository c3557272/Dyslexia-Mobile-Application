package com.example.dyslexialearningapplication.Maths;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dyslexialearningapplication.English.englishActivity;
import com.example.dyslexialearningapplication.R;

import java.util.Arrays;
import java.util.Collections;

/*
    This is the main activity class for the higher difficulty for the match numbers game.
 */

/*
Code was adapted from:
Tihomir RAdeff (2017) Develop Memory Game in Android Studio [Online Video]. February 2017. Available from: <https://www.youtube.com/watch?v=94CWNE9ruMA&t=181s> [Accessed 27 February 2022]
 */

public class matchNumbersPlus extends AppCompatActivity {

    TextView player_score, match_timer;
    ImageView card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15, card16, card17, card18, card19, card20;
    Integer[] cardsArray = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210};

    int image101, image102, image103, image104, image105, image106, image107, image108, image109, image110, image201, image202, image203, image204, image205, image206, image207, image208, image209, image210;
    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    int turn = 1;
    int playerPoints = 0, cpuPoints = 0;

    int remainingSeconds = 50;

    /*
    This is the method for the timer aspect of the activity.
     */

    CountDownTimer timer = new CountDownTimer(50000, 1000) {
        @Override
        public void onTick(long l) {
            remainingSeconds--;
            match_timer.setText("Time Left: " + remainingSeconds + "   ");
        }

        @Override
        public void onFinish() {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(matchNumbersPlus.this);
            alertDialogBuilder.setMessage("GAME OVER!\nScore: " + playerPoints)
                    .setCancelable(false)
                    .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), matchNumbersPlus.class);
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
    };

    /*
    This is the override method for onBackPressed. This assures the timer is cancelled correctly and the page directs the user to the correct page.
     */

    @Override
    public void onBackPressed() {
        timer.cancel();
        Intent randomIntent = new Intent(matchNumbersPlus.this, englishActivity.class);
        startActivity(randomIntent);
    }

    /*
    This onCreate override method is responsible for setting the correct content view and also sets the cards on screen to their layout counterpart and sets the on click listeners.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_numbers_plus);
        player_score = findViewById(R.id.player_score);
        match_timer = findViewById(R.id.match_timer);
        timer.start();
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
        card13 = findViewById(R.id.iv_42);
        card14 = findViewById(R.id.iv_43);
        card15 = findViewById(R.id.iv_44);
        card16 = findViewById(R.id.iv_45);
        card17 = findViewById(R.id.iv_52);
        card18 = findViewById(R.id.iv_53);
        card19 = findViewById(R.id.iv_54);
        card20 = findViewById(R.id.iv_55);

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
        card13.setTag("12");
        card14.setTag("13");
        card15.setTag("14");
        card16.setTag("15");
        card17.setTag("16");
        card18.setTag("17");
        card19.setTag("18");
        card20.setTag("19");

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

        card13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card13, theCard);
            }
        });

        card14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card14, theCard);
            }
        });

        card15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card15, theCard);
            }
        });

        card16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card16, theCard);
            }
        });

        card17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card17, theCard);
            }
        });

        card18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card18, theCard);
            }
        });

        card19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card19, theCard);
            }
        });

        card20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card20, theCard);
            }
        });
    }

    /*
    This method sets the correct image for the respective card.
     */

    private void doStuff(ImageView cardIV, int card) {
        if (cardsArray[card] == 101) {
            cardIV.setImageResource(image101);
        } else if (cardsArray[card] == 102) {
            cardIV.setImageResource(image102);
        } else if (cardsArray[card] == 103) {
            cardIV.setImageResource(image103);
        } else if (cardsArray[card] == 104) {
            cardIV.setImageResource(image104);
        } else if (cardsArray[card] == 105) {
            cardIV.setImageResource(image105);
        } else if (cardsArray[card] == 106) {
            cardIV.setImageResource(image106);
        } else if (cardsArray[card] == 107) {
            cardIV.setImageResource(image107);
        } else if (cardsArray[card] == 108) {
            cardIV.setImageResource(image108);
        } else if (cardsArray[card] == 109) {
            cardIV.setImageResource(image109);
        } else if (cardsArray[card] == 110) {
            cardIV.setImageResource(image110);
        } else if (cardsArray[card] == 201) {
            cardIV.setImageResource(image201);
        } else if (cardsArray[card] == 202) {
            cardIV.setImageResource(image202);
        } else if (cardsArray[card] == 203) {
            cardIV.setImageResource(image203);
        } else if (cardsArray[card] == 204) {
            cardIV.setImageResource(image204);
        } else if (cardsArray[card] == 205) {
            cardIV.setImageResource(image205);
        } else if (cardsArray[card] == 206) {
            cardIV.setImageResource(image206);
        } else if (cardsArray[card] == 207) {
            cardIV.setImageResource(image207);
        } else if (cardsArray[card] == 208) {
            cardIV.setImageResource(image208);
        } else if (cardsArray[card] == 209) {
            cardIV.setImageResource(image209);
        } else if (cardsArray[card] == 210) {
            cardIV.setImageResource(image210);
        }


        if (cardNumber == 1) {
            firstCard = cardsArray[card];
            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            cardIV.setEnabled(false);
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
            card13.setEnabled(false);
            card14.setEnabled(false);
            card15.setEnabled(false);
            card16.setEnabled(false);
            card17.setEnabled(false);
            card18.setEnabled(false);
            card19.setEnabled(false);
            card20.setEnabled(false);

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
            } else if (clickedFirst == 12) {
                card13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 13) {
                card14.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 14) {
                card15.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 15) {
                card16.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 16) {
                card17.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 17) {
                card18.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 18) {
                card19.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 19) {
                card20.setVisibility(View.INVISIBLE);
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
            } else if (clickedSecond == 12) {
                card13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 13) {
                card14.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 14) {
                card15.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 15) {
                card16.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 16) {
                card17.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 17) {
                card18.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 18) {
                card19.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 19) {
                card20.setVisibility(View.INVISIBLE);
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
            card13.setImageResource(R.drawable.button_question_mark);
            card14.setImageResource(R.drawable.button_question_mark);
            card15.setImageResource(R.drawable.button_question_mark);
            card16.setImageResource(R.drawable.button_question_mark);
            card17.setImageResource(R.drawable.button_question_mark);
            card18.setImageResource(R.drawable.button_question_mark);
            card19.setImageResource(R.drawable.button_question_mark);
            card20.setImageResource(R.drawable.button_question_mark);
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
        card13.setEnabled(true);
        card14.setEnabled(true);
        card15.setEnabled(true);
        card16.setEnabled(true);
        card17.setEnabled(true);
        card18.setEnabled(true);
        card19.setEnabled(true);
        card20.setEnabled(true);
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
                card12.getVisibility() == View.INVISIBLE &&
                card13.getVisibility() == View.INVISIBLE &&
                card14.getVisibility() == View.INVISIBLE &&
                card15.getVisibility() == View.INVISIBLE &&
                card16.getVisibility() == View.INVISIBLE &&
                card17.getVisibility() == View.INVISIBLE &&
                card18.getVisibility() == View.INVISIBLE &&
                card19.getVisibility() == View.INVISIBLE &&
                card20.getVisibility() == View.INVISIBLE) {
                timer.cancel();
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(matchNumbersPlus.this);
            alertDialogBuilder.setMessage("GAME OVER!\nScore: " + playerPoints)
                    .setCancelable(false)
                    .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), matchNumbersPlus.class);
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
        image101 = R.drawable.button_10;
        image102 = R.drawable.button_1;
        image103 = R.drawable.button_2;
        image104 = R.drawable.button_3;
        image105 = R.drawable.button_4;
        image106 = R.drawable.button_5;
        image107 = R.drawable.button_6;
        image108 = R.drawable.button_7;
        image109 = R.drawable.button_8;
        image110 = R.drawable.button_9;
        image201 = R.drawable.button_10_2;
        image202 = R.drawable.button_1_2;
        image203 = R.drawable.button_2_2;
        image204 = R.drawable.button_3_2;
        image205 = R.drawable.button_4_2;
        image206 = R.drawable.button_5_2;
        image207 = R.drawable.button_6_2;
        image208 = R.drawable.button_7_2;
        image209 = R.drawable.button_8_2;
        image210 = R.drawable.button_9_2;
    }
}