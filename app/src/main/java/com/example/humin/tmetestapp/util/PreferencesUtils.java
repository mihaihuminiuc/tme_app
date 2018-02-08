package com.example.humin.tmetestapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.humin.tmetestapp.model.PreferenceUtilModel;
import com.example.humin.tmetestapp.model.Wallpaper;
import com.example.humin.tmetestapp.model.WallpaperList;

/**
 * Created by humin on 1/14/2018.
 */

public class PreferencesUtils {

    public static final String PREFS_NAME = "tme_app";

    public static final String PREF_MODEL = PREFS_NAME + "_pref_model";

    public static void setPreferenceModel(Context context, PreferenceUtilModel mPreferenceUtilModel) {
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(context, PREFS_NAME, 0);
        complexPreferences.putObject(PREF_MODEL, mPreferenceUtilModel);
        complexPreferences.commit();
    }

    public static PreferenceUtilModel getPreferenceModel(Context context) {
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(context, PREFS_NAME, 0);
        PreferenceUtilModel mPreferenceUtilModel = complexPreferences.getObject(PREF_MODEL, PreferenceUtilModel.class);
        return mPreferenceUtilModel;
    }

    public static void clearPreferenceModel( Context ctx){
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(ctx, PREFS_NAME, 0);
        complexPreferences.clearObject();
        complexPreferences.commit();
    }
}
