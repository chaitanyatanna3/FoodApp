package com.example.chaitanya.foodapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactUsExample extends AppCompatActivity {

    Button buttonMap, buttonShare;
    TextView textViewWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_contact);

        buttonMap = (Button) findViewById(R.id.btn_map);
        buttonShare = (Button) findViewById(R.id.btn_share);
        textViewWeb = (TextView) findViewById(R.id.domain);

        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_geo = new Intent(Intent.ACTION_VIEW);
                intent_geo.setData(Uri.parse("geo:39.0094744,-76.8980658"));
                startActivity(intent_geo);
            }
        });

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = "chaitanyatanna3@gmail.com";
                Intent intent_email = new Intent(Intent.ACTION_SEND);
                intent_email.putExtra(Intent.EXTRA_EMAIL, to);
                intent_email.putExtra(Intent.EXTRA_SUBJECT, "Food");
                intent_email.putExtra(Intent.EXTRA_TEXT, "Chaitanya's Restaurant @ GreenBelt - http://www.google.com/");
                intent_email.setType("message/rfc822");
                startActivity(intent_email);
            }
        });

        textViewWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWebsite = new Intent(ContactUsExample.this, WebsiteExample.class);
                startActivity(intentWebsite);
            }
        });

    }
}
