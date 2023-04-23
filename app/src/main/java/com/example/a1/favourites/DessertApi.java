package com.example.a1.favourites;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DessertApi {

    @GET("filter.php")
    Call<DessertModel> getImageList(@Query("c") String category);
}
