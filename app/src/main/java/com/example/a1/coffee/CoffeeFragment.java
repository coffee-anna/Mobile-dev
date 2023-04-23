package com.example.a1.coffee;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.example.a1.R;
import com.example.a1.SecondFragment;
import com.example.a1.favourites.MySharedPreferences;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoffeeFragment extends Fragment {

    private ImageView coffeeImageView;
    private TextView coffeeNameTextView;
    Button nextButton , shareButton;

    String coffeeName;
    String imagePath;
    Boolean firstLaunch = true;

    int idx;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.coffee_fragment, container, false);

        coffeeImageView = view.findViewById(R.id.coffee_image_view);
        coffeeNameTextView = view.findViewById(R.id.coffee_name_text_view);
        nextButton = view.findViewById(R.id.nextButton);
        shareButton = view.findViewById(R.id.shareButton);


        if (firstLaunch) {
            idx = 0;
            loadCoffee();
            coffeeName = CoffeeNames.generateCoffeeName();
            firstLaunch = false;
        } else {
            Glide.with(CoffeeFragment.this).load(imagePath).into(coffeeImageView);
        }

        displayCoffeeData(coffeeName);

        nextButton.setOnClickListener(v -> loadCoffee());
        shareButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Look what coffee I'm having today !\n" + coffeeName + "\n" + "Check this pic -> " + imagePath);
            startActivity(intent);
        });

        coffeeImageView.setOnLongClickListener(v -> {
            // Save the picture
            savePicture(coffeeImageView);
            return true;
        });

        return view;
    }


    private void displayCoffeeData(String coffeeName) {//String imageUrl, String coffeeName) {
//        Picasso.get().load(imageUrl).into(coffeeImageView); // использование библиотеки Picasso для загрузки изображения
        coffeeNameTextView.setText(coffeeName);
    }

    private void loadCoffee(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://coffee.alexflipnote.dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CoffeeApi coffeeApi = retrofit.create(CoffeeApi.class);
        Call<CoffeeModel> coffeeModelCall = coffeeApi.getCoffeeList();//1,40);

        coffeeModelCall.enqueue(new Callback<CoffeeModel>() {
            @Override
            public void onResponse(Call<CoffeeModel> call, Response<CoffeeModel> response) {
                String imageUrl = String.valueOf(response.body().getFile()); //.getString("file");
                Log.d("request url ", imageUrl);
                imagePath = imageUrl;
                Glide.with(CoffeeFragment.this).load(imageUrl).into(coffeeImageView);
                String coffeeName = CoffeeNames.generateCoffeeName();
                displayCoffeeData(coffeeName);

                MySharedPreferences.saveData(getContext(), "coffeeImage", imageUrl);
                MySharedPreferences.saveData(getContext(), "coffeeName", coffeeName);
            }

            @Override
            public void onFailure(Call<CoffeeModel> call, Throwable t) {
//                Toast.makeText(view,"Something is wrong ! ",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void savePicture(ImageView imageView) {
        // Get the bitmap from the imageView
        BitmapDrawable  drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        String time  = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(System.currentTimeMillis());
        File path  = new File(String.valueOf(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)));
        String fileName = time+".PNG";

        File file = new File(path,fileName);
        OutputStream out;

        try {
            out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,out);
            out.flush();
            out.close();
            Toast.makeText(getContext(), "Image Save To Gallery", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Failed to save picture", Toast.LENGTH_SHORT).show();
        }
    }

}