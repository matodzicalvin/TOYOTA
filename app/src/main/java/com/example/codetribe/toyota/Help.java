package com.example.codetribe.toyota;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;


public class Help extends AppCompatActivity {

    private WebView browser;
    Button btnInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        browser = (WebView)findViewById(R.id.webView1);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl("file:///android_asset/pro/index.html");

        btnInstructions = (Button)findViewById(R.id.btnInstructions);
        btnInstructions.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Istructions.class);
                startActivityForResult(myIntent, 0);
            }
        });

    }

}
