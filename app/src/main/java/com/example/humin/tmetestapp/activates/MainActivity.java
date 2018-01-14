package com.example.humin.tmetestapp.activates;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.humin.tmetestapp.R;
import com.example.humin.tmetestapp.activates.ads.AddActivity;
import com.example.humin.tmetestapp.activates.advertising_id.AdvertisingIdActivity;
import com.example.humin.tmetestapp.activates.wallpapers.MainWallpaperActivity;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/**
 * Created by humin on 1/11/2018.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;

    private Button mButtonActivity1, mButtonActivity2, mButtonActivity3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        mContext=getApplicationContext();

        initUI();
    }


    private void initUI(){

        mButtonActivity1 = findViewById(R.id.button_1);
        mButtonActivity2 = findViewById(R.id.button_2);
        mButtonActivity3 = findViewById(R.id.button_3);

        mButtonActivity1.setOnClickListener(this);
        mButtonActivity2.setOnClickListener(this);
        mButtonActivity3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.button_1:
                i = new Intent(mContext, AddActivity.class);
                startActivity(i);
                break;
            case R.id.button_2:
                i = new Intent(mContext, MainWallpaperActivity.class);
                startActivity(i);
                break;
            case R.id.button_3:
                i = new Intent(mContext, AdvertisingIdActivity.class);
                startActivity(i);
                break;
        }
    }

}
