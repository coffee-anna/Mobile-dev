package com.example.a1.coffee;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoffeeModel {

    @SerializedName("file")
    private String file;
}
