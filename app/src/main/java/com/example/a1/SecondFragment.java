package com.example.a1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.load_fragment, container, false);
        ProgressBar progressBar = view.findViewById(R.id.rotateCenter);
        progressBar.setVisibility(View.GONE);
        Button button = view.findViewById(R.id.buttonToLoad);
        button.setOnClickListener(v ->
        {
            progressBar.setVisibility(View.VISIBLE);
            view.startAnimation(AnimationUtils.loadAnimation(progressBar.getContext(), R.anim.rotate_center));
        });
        return view;
    }
}
