package com.example.a1.favourites;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a1.R;
import com.example.a1.coffee.CoffeeApi;
import com.example.a1.coffee.CoffeeFragment;
import com.example.a1.coffee.CoffeeModel;
import com.example.a1.coffee.CoffeeNames;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FavouritesFragment extends Fragment {

    ImageView CoffeeImageView, DessertImageView;
    Button nextButton, shareButton;
    TextView CoffeeNameTextView, DessertNameTextView;

    String dessertName;
    String  imagePath;
    Boolean firstLaunch = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favourites_fragment, container, false);

//        imagesRepository = new ImagesRepository();

        CoffeeImageView = view.findViewById(R.id.coffee_image_view_on_dessert_fragment);
        CoffeeNameTextView = view.findViewById(R.id.coffee_name_text_view_on_dessert_fragment);
        DessertImageView = view.findViewById(R.id.dessert_image_view);
        DessertNameTextView = view.findViewById(R.id.dessert_name_text_view);
        nextButton = view.findViewById(R.id.dessertNextButton);
        shareButton = view.findViewById(R.id.dessertShareButton);

        String coffeeImageUrl = MySharedPreferences.getData(getContext(), "coffeeImage");
        Glide.with(FavouritesFragment.this).load(coffeeImageUrl).into(CoffeeImageView);

        String coffeeName = MySharedPreferences.getData(getContext(), "coffeeName");
        CoffeeNameTextView.setText(coffeeName);

        if (firstLaunch) {
            loadDessert();
            dessertName = DessertNames.generateCoffeeName();
            firstLaunch = false;
        } else {
            Glide.with(FavouritesFragment.this).load(imagePath).into(DessertImageView);
        }

        displayDessertData(dessertName);

        nextButton.setOnClickListener(v -> loadDessert());
        shareButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Look what dessert I'm having today !\n" + dessertName + "\n" + "Check this pic -> " + imagePath);
            startActivity(intent);
        });

        CoffeeImageView.setOnLongClickListener(v -> {
            // Save the picture
            savePicture(CoffeeImageView);
            return true;
        });
        DessertImageView.setOnLongClickListener(v -> {
            // Save the picture
            savePicture(DessertImageView);
            return true;
        });
        return view;
    }

    public void loadDessert(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DessertApi dessertApi = retrofit.create(DessertApi.class);
        Call<DessertModel> dessertModelCall = dessertApi.getImageList("Dessert");

        dessertModelCall.enqueue(new Callback<DessertModel>() {
            @Override
            public void onResponse(Call<DessertModel> call, Response<DessertModel> response) {
                if (response.isSuccessful()) {
                    List<DessertTable> meals = response.body().getItemsArrayList();
                    List<String> mealThumbs = new ArrayList<>();
                    for (DessertTable meal : meals) {
                        mealThumbs.add(meal.getStrMealThumb());
                    }
                    if (!mealThumbs.isEmpty()) {
                        // Pick a random URL from the list
                        Random random = new Random();
                        String imageUrl = mealThumbs.get(random.nextInt(mealThumbs.size()));
                        imagePath = imageUrl;
                        // Load the image into the ImageView using Glide or any other image loading library
                        Glide.with(getContext())
                                .load(imageUrl)
                                .into(DessertImageView);
                        displayDessertData(DessertNames.generateCoffeeName());
                    }
                }
            }

            @Override
            public void onFailure(Call<DessertModel> call, Throwable t) {
                Log.i("ViewModel","Failed");
            }
        });
    }

    private void displayDessertData(String coffeeName) {//String imageUrl, String coffeeName) {
        DessertNameTextView.setText(coffeeName);
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
