package com.example.humin.tmetestapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by humin on 12/27/2017.
 */

public class Wallpaper {

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getTmb_url() {
        return tmb_url;
    }

    public void setTmb_url(String tmb_url) {
        this.tmb_url = tmb_url;
    }

    public Wallpaper(String img_url, String tmb_url){
        this.img_url=img_url;
        this.tmb_url=tmb_url;
    }

    private String img_url;

    private String tmb_url;
}
