package com.ga.millionaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;



public class SplashActivity extends AppCompatActivity {
    // Uses EasySplash which is added to the Gradle build
    private static int SPLASH_TIME_OUT = 500;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //execute runnable after 2 seconds
        //hide the actionbar
        getSupportActionBar().hide();
        mHandler.postDelayed(mMainRunnable, SPLASH_TIME_OUT);
    }

    private Runnable mMainRunnable = new Runnable() {
        @Override
        public void run() {
            Intent mainIntent = new Intent(SplashActivity.this,Question1Activity.class);
            startActivity(mainIntent);
        }
    };
}