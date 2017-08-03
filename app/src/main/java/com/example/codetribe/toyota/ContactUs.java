package com.example.codetribe.toyota;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class ContactUs extends AppCompatActivity {
    private WebView browser;
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        browser = (WebView)findViewById(R.id.webView1);
        browser.loadUrl("file:///android_asset/Developers.html");


        btnHome = (Button)findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainMenu.class);
                startActivityForResult(myIntent, 0);
            }
        });

    }

}
