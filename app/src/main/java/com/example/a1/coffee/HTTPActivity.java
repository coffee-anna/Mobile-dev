package com.example.a1.coffee;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;



import com.example.a1.R;
import com.example.a1.favourites.FavouritesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HTTPActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    BottomNavigationView bottomNavigationView;

    CoffeeFragment coffeeFragment = new CoffeeFragment();
    FavouritesFragment favouritesFragment = new FavouritesFragment();

    Boolean firstLaunch = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.http_activity);

//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED) {
//        if (firstLaunch) {
//            // Permission is not granted, request it
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                    MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
//            firstLaunch = false;
//        }

        requestPermission();

        bottomNavigationView = findViewById(R.id.CoffeeNavBar);

        getSupportFragmentManager().beginTransaction().replace(R.id.coffee_container, coffeeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_coffee_fragment:
                    getSupportFragmentManager().beginTransaction().replace(R.id.coffee_container, coffeeFragment).commit();
                    return true;
                case R.id.nav_coffee_second_fragment:
                    getSupportFragmentManager().beginTransaction().replace(R.id.coffee_container, favouritesFragment).commit();
                    return true;
            }
            return false;
        });

        getSupportActionBar().hide();
    }

    private static final int REQUEST_WRITE_STORAGE = 112;

    private void requestPermission() {
        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this, new String[]{
                            Manifest.permission.READ_EXTERNAL_STORAGE},
                    1);
        }
        else
        {
//            Toast.makeText(this, "Has Permissions" , Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_WRITE_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted
                // Proceed with writing to internal storage
            } else {
                // Permission denied
                // Show a message or take appropriate action
            }
        }
    }

}