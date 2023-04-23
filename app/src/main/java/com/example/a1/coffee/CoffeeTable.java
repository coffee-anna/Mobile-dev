package com.example.a1.coffee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoffeeTable {
    public int number;
    public String name;
    public String url;

    public int getNumber() {
        String[] urlFormat = url.split("/");
        return Integer.parseInt(urlFormat[urlFormat.length -1]);
    }
}
