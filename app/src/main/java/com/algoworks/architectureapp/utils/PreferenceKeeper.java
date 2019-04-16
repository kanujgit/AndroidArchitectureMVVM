package com.algoworks.architectureapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


/**
 * Class is used to save user data in preference.
 */
public class PreferenceKeeper {

    private static PreferenceKeeper keeper;
    private static Context context;
    private SharedPreferences prefs;

    private PreferenceKeeper(Context context) {
        if (context != null)
            prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static PreferenceKeeper getInstance() {
        if (keeper == null) {
            keeper = new PreferenceKeeper(context);
        }
        return keeper;
    }

    public static void setContext(Context context1) {
        context = context1;
    }

    public void clearData() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }

    public void setData(String key, String value) {
        // Save the access key for later
        prefs.edit().putString(key, value).apply();
    }

    public String getData(String key) {
        return prefs.getString(key, null);
    }


    public void setData(String key, boolean value) {
        // Save the access key for later
        prefs.edit().putBoolean(key, value).apply();
    }

    public boolean getBooleanData(String key) {
        return prefs.getBoolean(key, false);
    }


    public boolean getIsLogin() {
        return prefs.getBoolean(AppConstant.PreferenceKeeperNames.LOGIN, false);
    }

    public void setIsLogin(boolean isLogin) {
        prefs.edit().putBoolean(AppConstant.PreferenceKeeperNames.LOGIN, isLogin).apply();
    }

    public String getAccessToken() {
        return prefs.getString(AppConstant.PreferenceKeeperNames.ACCESS_TOKEN, "");
    }

    public void setAccessToken(String accessToken) {
        prefs.edit().putString(AppConstant.PreferenceKeeperNames.ACCESS_TOKEN, accessToken).apply();
    }


    public void setPhoneNUmber(String key, String value) {
        // Save the access key for later
        prefs.edit().putString(key, value).apply();
    }

    public String getPhoneNUmber(String key) {
        return prefs.getString(key, null);
    }

    public void setvendorPhoneNUmber(String key, String value) {
        // Save the access key for later
        prefs.edit().putString(key, value).apply();
    }

    public String getvendorPhoneNUmber(String key) {
        return prefs.getString(key, null);
    }


}
