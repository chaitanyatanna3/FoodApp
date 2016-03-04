package com.example.chaitanya.foodapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

public class FragmentButton extends Fragment {

    Button buttonPrevious, buttonNext;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buttons, container, false);

        buttonPrevious = (Button) view.findViewById(R.id.btn_previous);
        buttonNext = (Button) view.findViewById(R.id.btn_next);

        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GalleryExample galleryExample = (GalleryExample) getActivity();
                galleryExample.buttonPreviousClicked();
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GalleryExample galleryExample = (GalleryExample) getActivity();
                galleryExample.buttonNextClicked();
            }
        });
        return view;
    }
}
