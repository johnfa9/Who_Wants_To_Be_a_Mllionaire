package com.ga.millionaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Question9Activity extends AppCompatActivity implements QuestionDialog.QuestionDialogLister{


    private final int QUESTION_VALUE = 250000;
    private Boolean endGame;

    //Variables to format score with commas
    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    String numberAsString = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question9);
        //display score from previous question
        Intent intent = getIntent();
        int score = intent.getIntExtra(Question1Activity.EXTRA_SCORE, 0);
        TextView vwScore =findViewById(R.id.earnings);
        numberAsString = numberFormat.format(Question1Activity.score);
        vwScore.setText("You Earned: $" + numberAsString);
    }

    public void submitQuestion1(View view) {
        //User submitted a question
        //user ends game if they do not make a selection and press the final answer button
        //a dialog will display, confirming that they want to cancel the game.

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);

        if (selectedId == -1){  //user submitted blank answer
            openDialog();
        }

        else if (radioButton.getId() == R.id.choiceB) {

            Intent nextQuestion = new Intent(this, Question10Activity.class);
            nextQuestion.putExtra(Question1Activity.EXTRA_SCORE,
                    Question1Activity.score += QUESTION_VALUE);
            numberAsString = numberFormat.format(Question1Activity.score);
            Toast.makeText(this, "Your Answer is Correct!, you got $" +
                    numberAsString, Toast.LENGTH_SHORT).show();
            startActivity(nextQuestion);
        } else
            {
            Toast toast =Toast.makeText(this, "Your Answer is Wrong, Game Over!",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 0);
            toast.show();
            Intent finalScore = new Intent(this, FinalScoreActivity.class);
            finalScore.putExtra(Question1Activity.EXTRA_SCORE, 250000);
            startActivity(finalScore);
        }
    }
    public void onBackPressed() {
        //Prevent operation of back button
        Toast.makeText(this, "Game in progress, you can't go back now",
                Toast.LENGTH_SHORT).show();

    }

    public void openDialog() {
        //Create dialog and confirm user wants to end game
        QuestionDialog newDialog = new QuestionDialog();
        newDialog.show(getSupportFragmentManager(),"dialogfragment");
    }

    @Override
    public void returnAnswer(Boolean Answer) {
        //if user ends game, display the amount they won
        endGame=Answer;
        if (endGame) {
            Intent finalScore = new Intent(this, FinalScoreActivity.class);
            finalScore.putExtra(Question1Activity.EXTRA_SCORE,Question1Activity.score);
            startActivity(finalScore);
        }
    }
}