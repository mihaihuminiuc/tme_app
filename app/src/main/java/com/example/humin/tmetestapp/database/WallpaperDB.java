package com.example.humin.tmetestapp.database;

import com.orm.SugarRecord;

/**
 * Created by humin on 1/14/2018.
 */

public class WallpaperDB extends SugarRecord{

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

    public WallpaperDB(){}

    public WallpaperDB(String img_url, String tmb_url){
        this.img_url=img_url;
        this.tmb_url=tmb_url;
    }

    private String img_url;

    private String tmb_url;
}
