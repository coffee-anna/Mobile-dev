package com.example.a1.calorie_counter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.text.TextUtils;

import com.example.a1.R;

import java.util.Locale;

public class GetStart extends AppCompatActivity {

    GetStartFragment getStartFragment = new GetStartFragment();

    EditText age;
    EditText height;
    EditText tartgetWeight_et;
    EditText currentWeight_et;

    Button calculateDayCalories;

    String sex = null, activity = null;

    Double target_calories;
    Double currentCalories;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_start);

        age = findViewById(R.id.input_age);
        height = findViewById(R.id.input_height);
        tartgetWeight_et = findViewById(R.id.targetWeight);
        currentWeight_et = findViewById(R.id.currentWeight);


        calculateDayCalories = findViewById(R.id.calculateDayCal);

        calculateDayCalories.setOnClickListener(v -> {
            currentCalories = 0.0;
            target_calories = 0.0;

            if ((sex != null) && (activity != null)
                    && !(TextUtils.isEmpty(height.getText().toString()))
                    && !(TextUtils.isEmpty(currentWeight_et.getText().toString()))
                    && !(TextUtils.isEmpty(tartgetWeight_et.getText().toString())))
            {
                currentCalories = calculateTargetCalories(
                        Integer.parseInt(age.getText().toString()),
                        sex,
                        Double.parseDouble(currentWeight_et.getText().toString()),
                        Integer.parseInt(height.getText().toString()),
                        activity);
                target_calories = calculateTargetCaloriesWithWeightGoal(
                        Double.parseDouble(currentWeight_et.getText().toString()),
                        Double.parseDouble(tartgetWeight_et.getText().toString()),
                        Integer.parseInt(height.getText().toString()),
                        Integer.parseInt(age.getText().toString()),
                        sex,
                        activity);
            }

            Bundle bundle = new Bundle();
            bundle.putString("currentCalories", String.format(Locale.US, "%.2f", currentCalories));
            bundle.putString("target_calories", String.format(Locale.US, "%.2f", target_calories));//target_calories.toString());
            bundle.putDouble("currentWeight", Double.parseDouble(currentWeight_et.getText().toString()));
            bundle.putDouble("target_weight", Double.parseDouble(tartgetWeight_et.getText().toString()));
            getStartFragment.setArguments(bundle);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.get_start_layout, getStartFragment)
                    .commit();
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {

            case R.id.radio_female:
                if (checked)
                    sex = "female";
            case R.id.radio_male:
                if (checked)
                    sex = "male";
            case R.id.radio_sedentary:
                if (checked)
                    activity = "sedentary";
            case R.id.radio_lightly_active:
                if (checked)
                    activity = "lightly_active";
            case R.id.radio_moderate_active:
                if (checked)
                    activity = "moderate_active";
            case R.id.radio_very_active:
                if (checked)
                    activity = "very_active";
            case R.id.radio_extra_active:
                if (checked)
                    activity = "extra_active";
        }
    }

    public double calculateTargetCalories(int age,
                                          String gender,
                                          double weight,
                                          double height,
                                          String activityLevel) {

        double bmr; // Basal Metabolic Rate

        // Calculate BMR based on gender and age
        if (gender.equals("male")) {
            bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }

        // Adjust BMR for activity level
        double activityFactor;
        switch (activityLevel) {
            case "lightly_active":
                activityFactor = 1.375;
                break;
            case "moderately_active":
                activityFactor = 1.55;
                break;
            case "very_active":
                activityFactor = 1.725;
                break;
            case "extra_active":
                activityFactor = 1.9;
                break;
            default:
                activityFactor = 1.2; // Default to sedentary
                break;
        }
        return bmr * activityFactor;
    }

    public double calculateTargetCaloriesWithWeightGoal(double currentWeight,
                                                        double desiredWeight,
                                                        int height,
                                                        int age,
                                                        String gender,
                                                        String activityLevel) {

//        double targetWeightLoss = currentWeight - desiredWeight;
//        int numOfDays = 60; // assuming goal period is two months (60 days)
//        double targetCalorieDeficit = targetWeightLoss * 7700 / numOfDays; // 7700 is the number of calories in one kilogram of body fat
//
//        double bmr;
//        if (gender.equals("male")) {
//            bmr = 88.362 + (13.397 * currentWeight) + (4.799 * height) - (5.677 * age);
//        } else {
//            bmr = 447.593 + (9.247 * currentWeight) + (3.098 * height) - (4.330 * age);
//        }
//
//        double activityFactor;
//        switch (activityLevel) {
//            case "sedentary":
//                activityFactor = 1.2;
//                break;
//            case "lightly active":
//                activityFactor = 1.375;
//                break;
//            case "moderately active":
//                activityFactor = 1.55;
//                break;
//            case "very active":
//                activityFactor = 1.725;
//                break;
//            case "extra active":
//                activityFactor = 1.9;
//                break;
//            default:
//                activityFactor = 1.5;
//                break;
//        }
//
//        double targetCalories = (bmr * activityFactor) - targetCalorieDeficit;
//        return targetCalories;

        double bmr; // Basal Metabolic Rate
        // Calculate BMR based on gender and age
//        double targetCalories;

        if (gender.equals("male")) {
            bmr = 88.362 + (13.397 * currentWeight) + (4.799 * height) - (5.677 * age);
        } else {
            bmr = 447.593 + (9.247 * currentWeight) + (3.098 * height) - (4.330 * age);
        }
        // Adjust BMR for activity level
        double activityFactor;
        switch (activityLevel) {
            case "lightly_active":
                activityFactor = 1.375;
                break;
            case "moderately_active":
                activityFactor = 1.55;
                break;
            case "very_active":
                activityFactor = 1.725;
                break;
            case "extra_active":
                activityFactor = 1.9;
                break;
            default:
                activityFactor = 1.2; // Default to sedentary
                break;
        }
//        // Calculate the daily calorie deficit or surplus needed to achieve the weight goal *30.5 - days
        double calorieDeficitSurplus = (desiredWeight - currentWeight) * 3500 / 60;
        if (calorieDeficitSurplus < 0) {
            calorieDeficitSurplus *= 1;
        }
        else{
            calorieDeficitSurplus *= -1;
        } // To get a calorie surplus instead of deficit
        double targetCalories = bmr * activityFactor + calorieDeficitSurplus;
//        targetCalories = bmr * activityFactor;
//
//        double weightDifference = Math.abs(currentWeight - desiredWeight);
//        double weightDelta = weightDifference * 3500; // 1 pound of fat = 3500 calories
//        if (desiredWeight > currentWeight) {
//            // gain weight: add calories to target
//            targetCalories += weightDelta;
//        } else if (desiredWeight < currentWeight) {
//            // lose weight: subtract calories from target
//            targetCalories -= weightDelta;
//        }
//        return targetCalories;
////        double targetCalories = bmr * activityFactor;
//        double weightDifference = Math.abs(currentWeight - desiredWeight);
//        double weightDelta = weightDifference * 3500; // 1 pound of fat = 3500 calories
//        if (desiredWeight > currentWeight) {
//            // gain weight: add calories to target
//            targetCalories += weightDelta;
//        } else if (desiredWeight < currentWeight) {
//            // lose weight: subtract calories from target
//            targetCalories -= weightDelta;
//        }
        return targetCalories;
    }
}