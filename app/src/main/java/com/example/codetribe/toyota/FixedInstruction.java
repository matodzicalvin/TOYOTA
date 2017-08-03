package com.example.codetribe.toyota;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class FixedInstruction extends Activity {

    private WebView browser;
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixed_instruction);

        browser = (WebView)findViewById(R.id.webView1);
        browser.loadUrl("file:///android_asset/Help2.html");

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
