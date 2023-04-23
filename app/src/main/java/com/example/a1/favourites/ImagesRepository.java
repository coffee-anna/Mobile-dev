//package com.example.a1.favourites;
//
//import android.util.Log;
//
//import com.bumptech.glide.Glide;
//
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import lombok.SneakyThrows;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class ImagesRepository {
//
//    private ArrayList<DessertTable> listOfImages = new ArrayList<>();
//    private DessertModel dessertModel = new DessertModel();
//
//    public List<DessertTable> getResultLiveData(){
//        return listOfImages;
//    }
//
//    public void loadDessertList(){
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        DessertApi dessertApi = retrofit.create(DessertApi.class);
//        Call<DessertModel> dessertModelCall = dessertApi.getImageList("Dessert");
//
//        dessertModelCall.enqueue(new Callback<DessertModel>() {
////            @Override
////            public void onResponse(Call<DessertModel> call, Response<DessertModel> response) {
////                Log.i("ViewModel","Success"+response.isSuccessful());
////                DessertModel res = response.body();
////                listOfImages = response.body().getItemsArrayList();
////            }
//
//            @Override
//            public void onResponse(Call<DessertModel> call, Response<DessertModel> response) {
//                if (response.isSuccessful()) {
//                    List<DessertTable> meals = response.body().getItemsArrayList();
//                    List<String> mealThumbs = new ArrayList<>();
//                    for (DessertTable meal : meals) {
//                        mealThumbs.add(meal.getStrMealThumb());
//                    }
//                    if (!mealThumbs.isEmpty()) {
//                        // Pick a random URL from the list
//                        Random random = new Random();
//                        String imageUrl = mealThumbs.get(random.nextInt(mealThumbs.size()));
//                        // Load the image into the ImageView using Glide or any other image loading library
//                        Glide.with(MainActivity.this)
//                                .load(imageUrl)
//                                .into(imageView);
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<DessertModel> call, Throwable t) {
//                Log.i("ViewModel","Failed");
//            }
//        });
//    }
//
//    public DessertTable getRandomDessert() {
//        loadDessertList();
//        Random rand = new Random();
//        return listOfImages.get(rand.nextInt(listOfImages.size()));
//    };
//
//    @SneakyThrows
//    public String getValueForGivenKey(String jsonObjectStr, String key) {
//        JSONObject jsonObject = new JSONObject(jsonObjectStr);
//        return jsonObject.getString(key);
//    }
//}