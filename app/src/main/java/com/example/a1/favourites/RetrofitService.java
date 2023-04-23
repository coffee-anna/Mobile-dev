//package com.example.a1.favourites;
//
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class RetrofitService {
//
//    public static DessertApi getInstance(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.themealdb.com/api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        DessertApi service = retrofit.create(DessertApi.class);
//        return service;
//    }
//
//}
