package com.example.humin.tmetestapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.humin.tmetestapp.api.ApiUtils;
import com.example.humin.tmetestapp.fragments.FirstFragment;
import com.example.humin.tmetestapp.listener.FirstFragmentListener;
import com.example.humin.tmetestapp.model.WallpaperList;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements FirstFragmentListener {

    private FrameLayout mFrameLayout;
    private FirstFragment mFirstFragment;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=getApplicationContext();
        mFrameLayout = findViewById(R.id.frame_x);

        initFragment();

    }

    private void initFragment(){

        ApiUtils.getWallpapers(mContext, response -> {
            Gson gson =  new Gson();

            WallpaperList wallpapers = gson.fromJson(response,WallpaperList.class);

            mFirstFragment = FirstFragment.newInstance(wallpapers);

            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame_x, mFirstFragment).commit();

        }, error -> Toast.makeText(mContext,"Error:"+error.toString(),Toast.LENGTH_LONG).show());
    }

    @Override
    public void onFirstFragmentClick() {

    }
}
