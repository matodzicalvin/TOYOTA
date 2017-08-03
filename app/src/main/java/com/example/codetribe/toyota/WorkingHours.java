package com.example.codetribe.toyota;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;


public class WorkingHours extends AppCompatActivity {

    private WebView browser;
    Button btnOnlineWorkingHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working_hours);

        browser = (WebView)findViewById(R.id.webView1);
        browser.loadUrl("file:///android_asset/WorkingHours.html");

        btnOnlineWorkingHours = (Button)findViewById(R.id.btnOnlineWorkingHours);
        btnOnlineWorkingHours.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(WorkingHours.this,"24/7", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
