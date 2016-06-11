package com.tocatapp.tocatapp.helpers;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by atoledo on 6/11/16.
 */
public class UserData extends AppCompatActivity {

    private static final String repoName = "userData";
    public static final String KEY_FNAME = "firstName";
    public static final String KEY_LNAME = "lastName";
    public static final String KEY_EMAIL = "email";
    private static final int MODE = 0;


    public static String getUserData(AppCompatActivity context, String key) {
        SharedPreferences userData = context.getSharedPreferences(repoName, MODE);
        return userData.getString(key, "");
    }

    public static void setString(AppCompatActivity context, String key, String value) {
        SharedPreferences userData = context.getSharedPreferences(repoName, MODE);
        SharedPreferences.Editor editor = userData.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void flush(AppCompatActivity context) {
        SharedPreferences userData = context.getSharedPreferences(repoName, MODE);
        SharedPreferences.Editor editor = userData.edit();
        editor.clear();
        editor.commit();
    }
}
