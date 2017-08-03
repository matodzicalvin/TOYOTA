package com.example.codetribe.toyota;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class Dealership extends Activity {

    private WebView browser;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealership);

        browser = (WebView)findViewById(R.id.webView1);
        browser.loadUrl("http://www.google.com/maps/place/Limpopo+Toyota,+204+Tagore+St,+Polokwane,+0699/@-23.915588,29.442748,17z/data=!4m2!3m1!1s0×1ec6d81e44ae8213:0×d69feb112c7ae98b");

    }
}