package com.example.humin.tmetestapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.humin.tmetestapp.model.Wallpaper;
import com.example.humin.tmetestapp.model.WallpaperList;

/**
 * Created by humin on 1/14/2018.
 */

public class PreferencesUtils {

    public static final String PREFS_NAME = "tme_app";

    public static final String IS_SAVED = PREFS_NAME + "_is_saved";

    public static void setIsSaved(Context context, boolean isSaved) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(IS_SAVED , isSaved);
        editor.apply();
    }

    public static boolean getIsSaved(Context context) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getBoolean(IS_SAVED, false);
    }

}
