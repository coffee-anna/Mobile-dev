package com.example.a1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class TextViewActivity extends Activity {

    TextView textView;
    Button button_to_main_screen;
//    Bundle myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_activity);

        textView = findViewById(R.id.textView);
        textView.setText("Здесь мог бы быть ваш текст");
        button_to_main_screen = findViewById(R.id.buttonFromTextViewToMainView);

        Intent myIntent = getIntent();
        if (!Objects.equals(myIntent.getStringExtra("text"), ""))
            textView.setText(myIntent.getStringExtra("text"));

        button_to_main_screen.setOnClickListener(v ->
                startActivity(new Intent(TextViewActivity.this, MainActivity.class)));
    }
}
