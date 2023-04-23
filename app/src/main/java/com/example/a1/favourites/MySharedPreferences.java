package com.example.a1.favourites;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {

    private static final String PREF_NAME = "my_preferences";

    public static void saveData(Context context, String key, String value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getData(Context context, String key) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getString(key, "");
    }
}

