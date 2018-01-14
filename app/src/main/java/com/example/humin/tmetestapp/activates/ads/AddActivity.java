package com.example.humin.tmetestapp.activates.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.humin.tmetestapp.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by humin on 1/11/2018.
 */

public class AddActivity extends AppCompatActivity implements View.OnClickListener{

    private InterstitialAd mInterstitialAd;
    private ProgressBar mProgressBar;
    private Context mContext;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ad_activity);
        mContext=getApplicationContext();

        initUI();

        initAdMob();
    }

    private void initUI(){
        mButton = findViewById(R.id.ad_button);
        mProgressBar = findViewById(R.id.progressBar1);
        mButton.setOnClickListener(this);
    }

    private void initAdMob(){
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.admob_placemnet_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        //dismiss mProgressBar after 10 sec
        startTimer();

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                if(mProgressBar!=null && mProgressBar.getVisibility()==View.VISIBLE)
                    mProgressBar.setVisibility(View.GONE);
                mInterstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                if(mProgressBar!=null && mProgressBar.getVisibility()==View.VISIBLE)
                    mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                mButton.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ad_button:

                mButton.setVisibility(View.GONE);
                mProgressBar.setVisibility(View.VISIBLE);

                mInterstitialAd.loadAd(new AdRequest.Builder().build());

                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        // Code to be executed when an ad finishes loading.
                        if(mProgressBar!=null && mProgressBar.getVisibility()==View.VISIBLE)
                            mProgressBar.setVisibility(View.GONE);
                        mInterstitialAd.show();
                    }

                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        // Code to be executed when an ad request fails.
                        if(mProgressBar!=null && mProgressBar.getVisibility()==View.VISIBLE)
                            mProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAdOpened() {
                        // Code to be executed when the ad is displayed.
                    }

                    @Override
                    public void onAdLeftApplication() {
                        // Code to be executed when the user has left the app.
                    }

                    @Override
                    public void onAdClosed() {
                        // Code to be executed when when the interstitial ad is closed.
                        Toast.makeText(mContext, R.string.button_click_toast_message,Toast.LENGTH_LONG).show();
                        mButton.setVisibility(View.VISIBLE);
                    }
                });
                break;
        }
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }

    private void startTimer(){
        new Handler().postDelayed(() -> {
            if(mProgressBar!=null && mProgressBar.getVisibility()==View.VISIBLE)
                mProgressBar.setVisibility(View.GONE);
        }, 10000);
    }

}
