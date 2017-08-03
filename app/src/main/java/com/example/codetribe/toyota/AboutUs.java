package com.example.codetribe.toyota;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;


public class AboutUs extends AppCompatActivity {

    private WebView browser;
    Button btnWorkingHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        browser = (WebView)findViewById(R.id.webView1);
        browser.loadUrl("file:///android_asset/AboutUs.html");


        btnWorkingHours = (Button)findViewById(R.id.btnWorkingHours);
        btnWorkingHours.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), WorkingHours.class);
                startActivityForResult(myIntent, 0);
            }
        });

    }
}
