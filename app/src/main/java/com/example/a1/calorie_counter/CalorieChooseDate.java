package com.example.a1.calorie_counter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a1.R;
import com.example.a1.SQLActivity;

import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.widget.Button;
        import android.widget.EditText;

        import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


public class CalorieChooseDate extends AppCompatActivity {

    private EditText dateEditText;
    String date;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calorie_choose_date);

        dateEditText = findViewById(R.id.editDate);

        Button dateButton = findViewById(R.id.buttonSubmit);

        preferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        if (preferences.contains("date")) {
            getSharedPrefs();
        }

        dateButton.setOnClickListener(v -> {
            date = dateEditText.getText().toString();
            setSharedPrefs();

            startActivity(new Intent(CalorieChooseDate.this, ListActivity.class));
        });
    }

    void getSharedPrefs() {
        date = preferences.getString("date", "");
        dateEditText.setText(date);
    }

    void setSharedPrefs() {
        editor = preferences.edit();
        editor.putString("date", date);
        editor.apply();
    }
}

