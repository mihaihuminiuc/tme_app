package com.example.humin.tmetestapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by humin on 12/28/2017.
 */

public class WallpaperList implements Parcelable {

    protected WallpaperList(Parcel in) {
        wallpapers = in.createTypedArrayList(Wallpaper.CREATOR);
    }

    public static final Creator<WallpaperList> CREATOR = new Creator<WallpaperList>() {
        @Override
        public WallpaperList createFromParcel(Parcel in) {
            return new WallpaperList(in);
        }

        @Override
        public WallpaperList[] newArray(int size) {
            return new WallpaperList[size];
        }
    };

    public List<Wallpaper> getWallpapers() {
        return wallpapers;
    }

    public void setWallpapers(List<Wallpaper> wallpapers) {
        this.wallpapers = wallpapers;
    }

    @SerializedName("wallpapers")
    private List<Wallpaper> wallpapers;

    public WallpaperList(){

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(wallpapers);
    }
}
