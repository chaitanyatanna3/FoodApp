package com.example.chaitanya.foodapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * Created by chaitanyatanna on 3/4/16.
 */
public class FragmentImageView extends Fragment {

    ImageView imageView;

    int[] imageIds = {
            R.drawable.demo, R.drawable.demo1,
            R.drawable.demo2, R.drawable.demo3,
            R.drawable.demo4, R.drawable.demo5,
            R.drawable.demo6, R.drawable.demo7,
            R.drawable.demo8, R.drawable.demo9
    };

    int count = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        imageView = (ImageView) view.findViewById(R.id.imageView);


        return view;
    }

    public void progressChanged(SeekBar seekBar, int progress) {
        FragmentImageView.this.count = progress;
        FragmentImageView.this.drawImage(seekBar);
    }

    public void drawImage(SeekBar seekBar) {
        if (count >= imageIds.length) {
            count = 0;
        }
        if (count < 0) {
            count = 9;
        }
        imageView.setImageResource(imageIds[count]);
        seekBar.setProgress(count);
    }

    public void buttonPreviousClicked(){
        count--;
        drawImage();
    }

    public void drawImage(){
        if (count >= imageIds.length) {
            count = 0;
        }
        if (count < 0) {
            count = 9;
        }
        imageView.setImageResource(imageIds[count]);

    }
    public void buttonNextClicked() {
        count++;
        drawImage();
    }
}
