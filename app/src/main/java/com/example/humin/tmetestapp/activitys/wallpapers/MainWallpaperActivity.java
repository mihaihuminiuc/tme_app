package com.example.humin.tmetestapp.activitys.wallpapers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.humin.tmetestapp.R;

/**
 * Created by humin on 1/11/2018.
 */

public class MainWallpaperActivity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;

    private Button mButtonActivity1, mButtonActivity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_wallpaper_acivity);
        mContext=getApplicationContext();

        initUI();
    }

    private void initUI(){

        mButtonActivity1 = findViewById(R.id.button_1);
        mButtonActivity2 = findViewById(R.id.button_2);

        mButtonActivity1.setOnClickListener(this);
        mButtonActivity2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.button_1:
                i = new Intent(mContext, Activity1.class);
                startActivity(i);
                break;
            case R.id.button_2:
                i = new Intent(mContext, Activity2.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }

}
