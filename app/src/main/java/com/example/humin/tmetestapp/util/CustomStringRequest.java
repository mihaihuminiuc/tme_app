package com.example.humin.tmetestapp.util;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * Created by humin on 1/8/2018.
 */

public class CustomStringRequest extends StringRequest {

    private static final int CONNECTION_TIMEOUT = 15000; //15 sec

    private Map<String, String> mParamsMap;
    private Context mContext;

    public CustomStringRequest(Map<String, String> paramsMap,
                               int method, String url, Response.Listener<String> listener,
                               Response.ErrorListener errorListener, Context context) {
        super(method, url, listener, errorListener);
        mParamsMap = paramsMap;
        mContext =  context;

        this.setRetryPolicy(new DefaultRetryPolicy(
                CONNECTION_TIMEOUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }

    public CustomStringRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        if (mParamsMap == null) {
            return super.getParams();
        } else {
            return mParamsMap;
        }
    }
}

