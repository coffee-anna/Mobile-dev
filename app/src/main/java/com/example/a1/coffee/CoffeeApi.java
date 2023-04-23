package com.example.a1.coffee;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoffeeApi {

    @GET("random.json")
    Call<CoffeeModel> getCoffeeList();
}

