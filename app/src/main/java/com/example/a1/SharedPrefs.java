package com.example.a1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SharedPrefs {

    private final SharedPreferences mSharedPreference;
    private final SharedPreferences.Editor mEditor;

    private final Context mContext;

    private static final String PREF_NAME = "SharedPrefLogin";
    private  static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    public SharedPrefs(Context mContext) {
        this.mContext = mContext;
        mSharedPreference = this.mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreference.edit();
    }

    public void createLoginSession(String username, String password){
        mEditor.putBoolean(IS_LOGIN,true);
        mEditor.putString(KEY_USERNAME, username);
        mEditor.putString(KEY_PASSWORD, password);
        mEditor.commit();
    }


    public boolean isLoggedIn(){
        return  mSharedPreference.getBoolean(IS_LOGIN,false);
    }

    public void checkIsLogin(){
        if(!isLoggedIn()){
            Intent i = new Intent(mContext, RegistrationActivity.class);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(i);
        }
    }

    public void logoutUser(){
        mEditor.clear();
        mEditor.commit();

        Intent i = new Intent(mContext,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);
    }

    public String getNama(){
        return mSharedPreference.getString("name",null);
    }

}
