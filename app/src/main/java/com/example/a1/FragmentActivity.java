package com.example.a1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    FirstFragment textFragment = new FirstFragment();
    SecondFragment loadFragment = new SecondFragment();
    ThirdFragment editTextFragment = new ThirdFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);

        bottomNavigationView = findViewById(R.id.NavBar);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, textFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_first_fragment:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, textFragment).commit();
                    return true;
                case R.id.nav_second_fragment:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, loadFragment).commit();
                    return true;
                case R.id.nav_third_fragment:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, editTextFragment).commit();
                    return true;
            }

            return false;
        });
    }
}