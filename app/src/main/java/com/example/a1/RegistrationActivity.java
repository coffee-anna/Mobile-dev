package com.example.a1;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class RegistrationActivity extends AppCompatActivity {

    private EditText loginEditText;
    private EditText passwordEditText;
    String login;
    String password;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        loginEditText = findViewById(R.id.editTextUsername);
        passwordEditText = findViewById(R.id.editTextPassword);

        Button loginButton = findViewById(R.id.buttonLogin);

        preferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        if (preferences.contains("login") && preferences.contains("password")) {
            getSharedPrefs();
        }

        loginButton.setOnClickListener(v -> {
            login = loginEditText.getText().toString();
            password = passwordEditText.getText().toString();
            setSharedPrefs();

            startActivity(new Intent(RegistrationActivity.this, SQLActivity.class));
        });
    }

    void getSharedPrefs() {
        login = preferences.getString("login", "");
        password = preferences.getString("password", "");
        loginEditText.setText(login);
        passwordEditText.setText(password);
    }

    void setSharedPrefs() {
        editor = preferences.edit();
        editor.putString("login", login);
        editor.putString("password", password);
        editor.apply();
    }
}

