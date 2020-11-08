package com.ga.millionaire;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSharedStorage {


    //create shared storage for user registration
    private int score;
    public static final String SP_Name = "scoreDetails"; //name of storage file
    SharedPreferences sharedPref;

    public UserSharedStorage(Context context){
        sharedPref = context.getSharedPreferences(SP_Name,0);
    }

    public void saveScore(int score){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("score", this.score+=score);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("score", this.score);
    }


}
