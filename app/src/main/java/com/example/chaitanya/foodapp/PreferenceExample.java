package com.example.chaitanya.foodapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class PreferenceExample extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    ToggleButton toggleButton;
    TextView textViewSpecials, textViewSpecials1;
    EditText editTextSpecials;
    Button buttonAdd, buttonReset;

    int selectedId;

    SharedPreferences sharedPreferences;
    public final String PREFERENCES = "preferences";
    SharedPreferences.Editor editor;
    private int radio;
    private boolean TOGGLE = false;
    private String TEXT = "text";
    private String TEXT1 = "text1";
    private String TEXT2 = "text2";
    private boolean BUTTON = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_preferences);

        radioGroup = (RadioGroup) findViewById(R.id.radioMenu);
        toggleButton = (ToggleButton) findViewById(R.id.btn_toggle);
        textViewSpecials = (TextView) findViewById(R.id.specials);
        editTextSpecials = (EditText) findViewById(R.id.et_specials);
        textViewSpecials1 = (TextView) findViewById(R.id.textSpecials);
        buttonAdd = (Button) findViewById(R.id.btn_add);
        buttonReset = (Button) findViewById(R.id.btn_reset);

        selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);

        sharedPreferences = getSharedPreferences(PREFERENCES, MODE_PRIVATE);

        checkPreferences();

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textViewSpecials.setText("Send Me Specials");
                } else {
                    textViewSpecials.setText("Don't Send Me Specials");
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewSpecials1.setVisibility(View.VISIBLE);
                String string = editTextSpecials.getText().toString();
                textViewSpecials1.setText(string);
                editTextSpecials.setVisibility(View.INVISIBLE);
                buttonAdd.setVisibility(View.INVISIBLE);
                buttonReset.setVisibility(View.VISIBLE);
            }
        });
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewSpecials1.setVisibility(View.INVISIBLE);
                editTextSpecials.setText("");
                editTextSpecials.setVisibility(View.VISIBLE);
                buttonReset.setVisibility(View.INVISIBLE);
                buttonAdd.setVisibility(View.VISIBLE);
            }
        });
    }

    public void checkPreferences() {
        TOGGLE = toggleButton.isChecked();
        radio = selectedId;
        TEXT = textViewSpecials.getText().toString();
        TEXT1 = textViewSpecials1.getText().toString();
        TEXT2 = editTextSpecials.getText().toString();
        BUTTON = radioButton.isChecked();

        editor = getSharedPreferences(PREFERENCES, MODE_PRIVATE).edit();
        editor.putBoolean("button", TOGGLE);
        editor.putInt("radio", radio);
        editor.putString("text", TEXT);
        editor.putString("text1", TEXT1);
        editor.putString("text2", TEXT2);
        editor.putBoolean("radioButton", BUTTON);
        editor.commit();

        if (sharedPreferences != null) {
            sharedPreferences = getSharedPreferences(PREFERENCES, MODE_PRIVATE);
            boolean toggle = sharedPreferences.getBoolean("button", TOGGLE);
            int radio1 = sharedPreferences.getInt("radio", radio);
            String texts = sharedPreferences.getString("text", TEXT);
            String texts1 = sharedPreferences.getString("text1", TEXT1);
            String texts2 = sharedPreferences.getString("text2", TEXT2);
            boolean radioB1 = sharedPreferences.getBoolean("radioButton", BUTTON);

            selectedId = radio1;
            toggleButton.setChecked(toggle);
            radioButton.setChecked(radioB1);
            textViewSpecials.setText(texts);
            textViewSpecials1.setText(texts1);
            editTextSpecials.setText(texts2);

        }
    }
}