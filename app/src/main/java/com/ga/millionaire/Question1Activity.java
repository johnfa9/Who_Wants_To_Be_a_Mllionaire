package com.ga.millionaire;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Locale;

public class Question1Activity extends AppCompatActivity implements QuestionDialog.QuestionDialogLister {
    public static final String EXTRA_SCORE = "key";
    static int score = 0;
    private final int QUESTION_VALUE = 100;
    private Boolean endGame;
    Boolean flag;

    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    String numberAsString = null;

    RadioButton one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        // ActionBar actionBar;
        //actionBar = getSupportActionBar();



        //change color of background
//        ColorDrawable colorDrawable
//                = new ColorDrawable(Color.parseColor("#0000ee"));
        // Set BackgroundDrawable
        // actionBar.setBackgroundDrawable(colorDrawable);


        // RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);


    }



    //        radioGroup.seton(new RadioGroup.OnClickListener() {
//            @Override
//            public void onclick(RadioGroup group, int checkedId) {
//                RadioButton rb = (RadioButton) findViewById(checkedId);
//                if (!rb.isChecked()) {
//                    rb.setChecked(true);
//                }
//                else {
//                    rb.setChecked(true);
//                }
//            }
//        });
    //}
     public void submitQuestion1 (View view) {
            //user ends game if they do not make a selection and press the final answer button
            //a dialog will display, confirming that they want to cancel the game.

            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton) findViewById(selectedId);


            //If user does not select a response, open dialog and confirm
            //that they don't want to continue the game
            //user will be shown how much they won

            if (selectedId == -1) {
                openDialog();
            } else if (radioButton.getId() == R.id.choiceD) {

                Intent nextQuestion = new Intent(this, Question2Activity.class);
                nextQuestion.putExtra(EXTRA_SCORE, score += QUESTION_VALUE);

                numberAsString = numberFormat.format(score);

                Toast.makeText(this, "Your Answer is Correct!, you got $" + (numberAsString),
                        Toast.LENGTH_SHORT).show();
                startActivity(nextQuestion);
            } else {
                Toast toast = Toast.makeText(this, "Your Answer is Wrong, Game Over!",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 0);
                toast.show();
                Intent finalScore = new Intent(this, FinalScoreActivity.class);
                finalScore.putExtra(EXTRA_SCORE, 100);
                startActivity(finalScore);
            }
        }

        public void onBackPressed () {
            //Prevent operation of back button
            Toast.makeText(this, "Game in progress, you can't go back now",
                    Toast.LENGTH_SHORT).show();
        }

        public void openDialog () {
            //Create dialog and confirm user wants to end game
            QuestionDialog newDialog = new QuestionDialog();
            newDialog.show(getSupportFragmentManager(), "dialogfragment");
        }

        @Override
        public void returnAnswer (Boolean Answer){
            //if user ends game, display the amount they won
            //if not wait for user to select an answer
            endGame = Answer;
            if (endGame) {
                Intent finalScore = new Intent(this, FinalScoreActivity.class);
                finalScore.putExtra(EXTRA_SCORE, 100);
                startActivity(finalScore);
            }
        }
    }