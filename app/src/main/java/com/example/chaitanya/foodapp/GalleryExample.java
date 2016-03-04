package com.example.chaitanya.foodapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

public class GalleryExample extends AppCompatActivity {

    FragmentImageView fragmentImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_gallery);

        fragmentImageView = (FragmentImageView) getFragmentManager().findFragmentById(R.id.fragment2);
    }

    public void progressChanged(SeekBar seekBar, int progress) {
            fragmentImageView.progressChanged(seekBar, progress);
    }

    public void buttonPreviousClicked(){
        fragmentImageView.buttonPreviousClicked();
    }
    public void buttonNextClicked() {
        fragmentImageView.buttonNextClicked();
    }
}
