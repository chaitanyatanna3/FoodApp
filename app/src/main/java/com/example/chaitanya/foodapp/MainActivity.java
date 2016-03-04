package com.example.chaitanya.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonMenu, buttonContact, buttonWebsite, buttonPreferences, buttonGallery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonMenu = (Button) findViewById(R.id.btn_menu);
        buttonContact = (Button) findViewById(R.id.btn_contact);
        buttonWebsite = (Button) findViewById(R.id.btn_website);
        buttonPreferences = (Button) findViewById(R.id.btn_preferences);
        buttonGallery = (Button) findViewById(R.id.btn_gallery);

        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMenu = new Intent(MainActivity.this, MenuListExample.class);
                startActivity(intentMenu);
            }
        });

        buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentContact = new Intent(MainActivity.this, ContactUsExample.class);
                startActivity(intentContact);
            }
        });

        buttonWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWebsite = new Intent(MainActivity.this, WebsiteExample.class);
                startActivity(intentWebsite);
            }
        });

        buttonPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPref = new Intent(MainActivity.this, PreferenceExample.class);
                startActivity(intentPref);
            }
        });

        buttonGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGallery = new Intent(MainActivity.this, GalleryExample.class);
                startActivity(intentGallery);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.menu_preferences:
                Intent intentPref = new Intent(MainActivity.this, PreferenceExample.class);
                startActivity(intentPref);
                break;
            case R.id.menu_gallery:
                Intent intentGallery = new Intent(MainActivity.this, GalleryExample.class);
                startActivity(intentGallery);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }


        return super.onOptionsItemSelected(item);
    }
}
