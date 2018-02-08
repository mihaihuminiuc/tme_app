package com.example.humin.tmetestapp.database;

import com.orm.SugarRecord;

/**
 * Created by humin on 1/14/2018.
 */

public class WallpaperDB extends SugarRecord{

    public WallpaperDB(){}

    public WallpaperDB(String imgUrl, String tmbUrl){
        this.imgUrl=imgUrl;
        this.tmbUrl=tmbUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTmbUrl() {
        return tmbUrl;
    }

    public void setTmbUrl(String tmbUrl) {
        this.tmbUrl = tmbUrl;
    }

    private String imgUrl;

    private String tmbUrl;
}
