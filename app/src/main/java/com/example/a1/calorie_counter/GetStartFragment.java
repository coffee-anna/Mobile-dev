package com.example.a1.calorie_counter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.a1.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GetStartFragment extends Fragment {

    TextView target_calories;
    TextView currentCalories;

    String tar_cal, cur_cal;
    Double tar_w, cur_w;

    Button getStarted;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.get_start_fragment, container, false);

        target_calories = view.findViewById(R.id.calorieTarget);
        currentCalories = view.findViewById(R.id.calorieCurrent);
        getStarted = view.findViewById(R.id.getStarted);

        if (getArguments() != null) {
            cur_cal = getArguments().getString("currentCalories");
            tar_cal = getArguments().getString("target_calories");
            cur_w = getArguments().getDouble("currentWeight");
            tar_w = getArguments().getDouble("target_weight");

        } else {
            Toast.makeText(getContext(),
                    "Ничего не написали на прошлом экране",
                    Toast.LENGTH_SHORT).show();
        }

        currentCalories.setText(cur_cal);
        target_calories.setText(tar_cal);

        getStarted.setOnClickListener(v -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref_basicInfo = database.getReference("basicInfo");

            GetStartModel getStart = new GetStartModel(cur_w,
                    tar_w, Double.parseDouble(tar_cal), Double.parseDouble(cur_cal));
            ref_basicInfo.setValue(getStart);

            startActivity(new Intent(getActivity(), CalorieChooseDate.class));
        });

        return view;
    }
}
