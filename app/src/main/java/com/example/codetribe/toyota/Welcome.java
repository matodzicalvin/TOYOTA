package com.example.codetribe.toyota;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class Welcome extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        spinner=(ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);
        spinner.setMax(6000);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your application welcome activity
                Intent i = new Intent(Welcome.this, MainMenu.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
