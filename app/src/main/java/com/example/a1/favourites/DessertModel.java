package com.example.a1.favourites;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DessertModel {

    @SerializedName("meals")
    private ArrayList<DessertTable> itemsArrayList;

}
