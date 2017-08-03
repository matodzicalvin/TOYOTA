package com.example.codetribe.toyota;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;



public class Customers extends AppCompatActivity {

    private WebView browser;
    Button btnBookService;
    Button btnBookRepair;
    Button btnOderParts;
    Button buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);

        browser = (WebView)findViewById(R.id.webView1);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl("file:///android_asset/customer/index.html");

        btnBookService = (Button)findViewById(R.id.btnBookService);

        btnBookService.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), BookServices.class);
                startActivityForResult(myIntent, 0);
            }
        } );

        btnBookRepair = (Button)findViewById(R.id.btnBookRepair);

        btnBookRepair.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), BookRepairs.class);
                startActivityForResult(myIntent, 0);
            }
        } );

        btnOderParts = (Button)findViewById(R.id.btnOderParts);

        btnOderParts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), OrderParts.class);
                startActivityForResult(myIntent, 0);
            }
        } );
        buy = (Button)findViewById(R.id.button1);

        buy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainMenu.class);
                startActivityForResult(myIntent, 0);
            }
        } );

    }
}
