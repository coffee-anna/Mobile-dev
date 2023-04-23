package com.example.a1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageViewActivity extends Activity {

    ImageView imageView;
    Button newImageButton;
    Button button_to_main_screen;
    boolean flag = true;

    @SuppressLint({"MissingInflatedId", "UseCompatLoadingForDrawables"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity);

        imageView = findViewById(R.id.imageView);
        imageView.setImageDrawable(getDrawable(R.drawable.frog_close));

        newImageButton = findViewById(R.id.newImageButton);

        button_to_main_screen = findViewById(R.id.buttonFromImageViewToMainView);

        newImageButton.setOnClickListener(v -> {
            imageView.setImageResource(0);
            if (flag) {
                imageView.setImageDrawable(getDrawable(R.drawable.frog_open));
                flag = false;
            }
            else {
                imageView.setImageDrawable(getDrawable(R.drawable.frog_close));
                flag = true;
            }
        });

        button_to_main_screen.setOnClickListener(v ->
                startActivity(new Intent(ImageViewActivity.this, MainActivity.class)));
    }
}
