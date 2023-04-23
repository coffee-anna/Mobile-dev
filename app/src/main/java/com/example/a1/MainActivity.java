package com.example.a1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a1.calorie_counter.CalorieActivity;
import com.example.a1.calorie_counter.CalorieChooseDate;
import com.example.a1.calorie_counter.GetStart;
import com.example.a1.coffee.HTTPActivity;

public class MainActivity extends AppCompatActivity {

    Button button_to_go_to_First_Activity;
    Button button_to_go_to_Fragment_Activity;
    Button button_to_go_to_Registration_Activity;
    Button button_to_go_to_HTTP_Activity;
    Button button_to_go_to_Calorie_Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        button_to_go_to_First_Activity = findViewById(R.id.buttonToFirstActivity);
        button_to_go_to_Fragment_Activity = findViewById(R.id.buttonToFragmentActivity);
        button_to_go_to_Registration_Activity = findViewById(R.id.buttonToRegistrationActivity);
        button_to_go_to_HTTP_Activity = findViewById(R.id.buttonToHTTPActivity);
        button_to_go_to_Calorie_Activity = findViewById(R.id.buttonToCalorieActivity);

        button_to_go_to_First_Activity.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, FirstActivity.class)));

        button_to_go_to_Fragment_Activity.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, FragmentActivity.class)));

        button_to_go_to_Registration_Activity.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class)));

        button_to_go_to_HTTP_Activity.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, HTTPActivity.class)));

        button_to_go_to_Calorie_Activity.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, GetStart.class)));
    }

}
