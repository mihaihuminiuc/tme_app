package com.example.humin.tmetestapp;

import android.app.Application;
import android.os.Bundle;

import com.google.android.gms.ads.MobileAds;
import com.orm.SugarApp;
import com.orm.SugarContext;
import com.orm.SugarDb;

/**
 * Created by humin on 1/11/2018.
 */

public class TmeApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this, getString(R.string.admob_placemnet_id));
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
