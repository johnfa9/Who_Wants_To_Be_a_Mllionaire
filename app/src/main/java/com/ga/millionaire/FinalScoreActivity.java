package com.ga.millionaire;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinalScoreActivity extends AppCompatActivity {
    //displays the final game store

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        Intent intent = getIntent();
        int score = intent.getIntExtra(Question1Activity.EXTRA_SCORE, 0);
        TextView vwScore = findViewById(R.id.score1val);

        //determine which score to highlight
        switch (score) {
            case 100:
                vwScore = findViewById(R.id.score1val);
                break;
            case 300:
                vwScore = findViewById(R.id.score2val);
                break;
            case 1000:
                vwScore = findViewById(R.id.score3val);
                break;
            case 4000:
                vwScore = findViewById(R.id.score4val);
                break;
            case 8000:
                vwScore = findViewById(R.id.score5val);
                break;
            case 32000:
                vwScore = findViewById(R.id.score6val);
                break;
            case 125000:
                vwScore = findViewById(R.id.score7val);
                break;
            case 250000:
                vwScore = findViewById(R.id.score8val);
                break;
            case 500000:
                vwScore = findViewById(R.id.score9val);
                break;
            case 1000000:
                vwScore = findViewById(R.id.score10val);
                break;
            default:
        }
        vwScore.setBackgroundResource(R.drawable.btn_rounded);

    }

    public void RestartGame(View view) {
        //restart the game and set score = 0
        Question1Activity.score=0;
        Intent finalScore = new Intent(this, Question1Activity.class);
        startActivity(finalScore);
    }
}