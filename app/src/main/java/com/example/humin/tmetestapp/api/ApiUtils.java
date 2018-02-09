package com.example.humin.tmetestapp.api;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.humin.tmetestapp.util.CustomStringRequest;

/**
 * Created by humin on 1/8/2018.
 */

public class ApiUtils {

    private static String BASE_URL="http://192.168.2.118:8080/";
    private static String GET_WALLPAPERS_URL =BASE_URL+"rest/get/json";

    public static void getWallpapers(Context context, Response.Listener<String> successListener, Response.ErrorListener errorListener){
        RequestQueue queue = Volley.newRequestQueue(context);

        CustomStringRequest request = new CustomStringRequest(null, Request.Method.GET, GET_WALLPAPERS_URL, successListener, errorListener, context);
        queue.add(request);
    }

}
