package com.example.a1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    EditText editText;
    Button button_to_go_to_Image_View_Activity;
    Button button_to_go_to_Text_View_Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        editText = findViewById(R.id.editText);
        button_to_go_to_Image_View_Activity = findViewById(R.id.buttonToImageView);
        button_to_go_to_Text_View_Activity = findViewById(R.id.buttonToTextView);

        button_to_go_to_Image_View_Activity.setOnClickListener(v ->
                startActivity(new Intent(FirstActivity.this, ImageViewActivity.class)));

        button_to_go_to_Text_View_Activity.setOnClickListener(v -> {
            Intent myIntent = new Intent(getApplicationContext(), TextViewActivity.class);
            myIntent.putExtra("text", editText.getText().toString());
            startActivity(myIntent); });
    }
}
