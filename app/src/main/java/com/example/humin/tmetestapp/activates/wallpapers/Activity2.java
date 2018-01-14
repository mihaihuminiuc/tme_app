package com.example.humin.tmetestapp.activates.wallpapers;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.humin.tmetestapp.R;
import com.example.humin.tmetestapp.api.ApiUtils;
import com.example.humin.tmetestapp.fragments.SecondFragment;
import com.example.humin.tmetestapp.model.WallpaperList;
import com.google.gson.Gson;

/**
 * Created by humin on 1/11/2018.
 */

public class Activity2 extends AppCompatActivity{

    private Context mContext;

    private SecondFragment mSecondFragment;

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.row_3_activity);
        mContext=getApplicationContext();

        initFragment();
    }

    private void initFragment(){

        ApiUtils.getWallpapers(mContext, response -> {

            Gson gson =  new Gson();

            WallpaperList wallpapers = gson.fromJson(response,WallpaperList.class);

            mSecondFragment = SecondFragment.newInstance(wallpapers);

            mFragmentManager = getFragmentManager();
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame_x, mSecondFragment);
            mFragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            mFragmentTransaction.commit();
        },
                error -> Toast.makeText(mContext,"Error:"+error.toString(),Toast.LENGTH_LONG).show()
        );
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }
}
