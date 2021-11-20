package com.example.sharedprefsexample;

import android.content.Context;
import android.content.SharedPreferences;

public class MSPv2 {

    private static final String SP_FILE = "SharedPrefsExampleApp";

    private Context context;
    private SharedPreferences preferences;

    public MSPv2(Context context) {
        this.context = context;
        preferences = context.getApplicationContext().getSharedPreferences(SP_FILE, Context.MODE_PRIVATE);
    }

    public int getIntSP(String key, int defValue) {
        return preferences.getInt(key, defValue);
    }

    public void putIntSP(String key, int value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public String getStringSP(String key, String defValue) {
        return preferences.getString(key, defValue);
    }

    public void putStringSP(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

}
