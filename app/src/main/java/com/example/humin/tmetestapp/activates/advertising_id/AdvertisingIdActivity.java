package com.example.humin.tmetestapp.activates.advertising_id;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.humin.tmetestapp.R;
import com.example.humin.tmetestapp.util.CommonUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import java.io.IOException;
import java.util.Calendar;

/**
 * Created by humin on 1/14/2018.
 */

public class AdvertisingIdActivity  extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    private Switch mSwitch;
    private TextView mTextView;
    private Button mButton;

    private boolean isOn=false;

    private Calendar mCalendar;

    private Context mContext;

    private static final int PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advertisingid_activity);
        mContext=this;
        initUI();
    }

    private void initUI(){
        mSwitch = findViewById(R.id.switch_1);
        mTextView = findViewById(R.id.text_view_1);
        mButton = findViewById(R.id.button_1);

        mButton.setOnClickListener(this);
        mSwitch.setOnCheckedChangeListener(this);
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_1:
                if(isOn)
                    new MyTask().execute();
                else
                    setDateAndPhoneNumber();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.switch_1:
                isOn=b;
                break;
        }
    }

    private void setDateAndPhoneNumber(){
        if (!CommonUtils.checkPermission(mContext,Manifest.permission.READ_PHONE_STATE))
            requestPermission(Manifest.permission.READ_PHONE_STATE);
        else{
            setTextViewText(getPhone());
        }
    }

    private String getPhone() {
        TelephonyManager phoneMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(mContext, R.string.phone_permision_error, Toast.LENGTH_LONG).show();
            return "";
        }
        return phoneMgr.getLine1Number();
    }

    private void requestPermission(String permission){
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)){
            Toast.makeText(mContext, R.string.phone_permision_error, Toast.LENGTH_LONG).show();
        }
        ActivityCompat.requestPermissions(this, new String[]{permission},PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    setDateAndPhoneNumber();
                } else {
                    Toast.makeText(mContext, R.string.phone_permision_denied, Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    private void setTextViewText(String text){
        String finalString = "";
        String currentString = "";

        mCalendar = Calendar.getInstance();

        currentString = getResources().getString(R.string.date_addvertising_id,
                mCalendar.get(Calendar.DAY_OF_MONTH), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.YEAR), text);

        if(mTextView!=null){
            finalString = currentString + mTextView.getText().toString()+ "//";
            mTextView.setText(finalString);
        }
    }

    private class MyTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            String advertId = null;

            try {
                advertId = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext()).getId();
            } catch (IOException e) {
                Toast.makeText(mContext, R.string.io_exception, Toast.LENGTH_LONG).show();
            } catch (GooglePlayServicesNotAvailableException e) {
                Toast.makeText(mContext, R.string.google_play_exception, Toast.LENGTH_LONG).show();
            } catch (GooglePlayServicesRepairableException e) {
                Toast.makeText(mContext, R.string.google_play_repair_exception, Toast.LENGTH_LONG).show();
            }

            return advertId;
        }
        @Override
        protected void onPostExecute(String advertId) {
            setTextViewText(advertId);
        }
    }
}
