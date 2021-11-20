package com.example.sharedprefsexample;

import android.content.Context;
import android.content.SharedPreferences;

public class MSPv1 {

    private static final String SP_FILE = "SharedPrefsExampleApp";

    public static int getIntSP(Context context, String key, int defValue) {
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences(SP_FILE, Context.MODE_PRIVATE);
        return preferences.getInt(key, defValue);
    }

    public static void putIntSP(Context context, String key, int value) {
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences(SP_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static String getStringSP(Context context, String key, String defValue) {
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences(SP_FILE, Context.MODE_PRIVATE);
        return preferences.getString(key, defValue);
    }

    public static void putStringSP(Context context, String key, String value) {
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences(SP_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
}
