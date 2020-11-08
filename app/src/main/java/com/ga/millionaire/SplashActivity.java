package com.ga.millionaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;


public class SplashActivity extends AppCompatActivity {
    // Create a splash screen which is added to the Gradle build
    private static int SPLASH_TIME_OUT = 1000;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

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