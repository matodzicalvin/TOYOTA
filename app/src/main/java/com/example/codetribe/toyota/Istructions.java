package com.example.codetribe.toyota;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;


public class Istructions extends AppCompatActivity {

    private WebView browser;
    Button btnHome;
    Button btnDeveloper;
    Button btnFixed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istructions);

        browser = (WebView)findViewById(R.id.webView1);
        browser.loadUrl("file:///android_asset/Help.html");

        btnHome = (Button)findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainMenu.class);
                startActivityForResult(myIntent, 0);
            }
        });


//        btnDeveloper = (Button)findViewById(R.id.btnDeveloper);
//        btnDeveloper.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Intent myIntent = new Intent(view.getContext(), Developers.class);
//                startActivityForResult(myIntent, 0);
//            }
//        });

        btnFixed = (Button)findViewById(R.id.btnFixed);
        btnFixed.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), FixedInstruction.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }

}
