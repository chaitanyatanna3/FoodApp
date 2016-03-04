package com.example.chaitanya.foodapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebsiteExample extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_web);

        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://www.google.com");

    }
}
