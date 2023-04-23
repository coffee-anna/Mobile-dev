package com.example.a1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FourthFragment extends Fragment {

    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fourth_fragment, container, false);

        imageView = view.findViewById(R.id.imageViewFour);
        imageView.setImageResource(R.drawable.frog_open);

        TextView textView = view.findViewById(R.id.textView_four);
        if (getArguments() != null) {
            textView.setText(getArguments().getString("data"));
        } else {
            textView.setText("Ничего не написали на прошлом экране");
        }

        Button button = view.findViewById(R.id.buttonFromFrag4ToMainView);
        button.setOnClickListener(
                v -> {
                    getFragmentManager().beginTransaction().remove(this).commit();
                    startActivity(new Intent(getActivity(), MainActivity.class));
                }
        );
        return view;
    }
}
