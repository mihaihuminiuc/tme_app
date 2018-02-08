package com.example.humin.tmetestapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by humin on 12/27/2017.
 */

public class Wallpaper implements Parcelable{

    public static final Creator<Wallpaper> CREATOR = new Creator<Wallpaper>() {
        @Override
        public Wallpaper createFromParcel(Parcel in) {
            return new Wallpaper(in);
        }

        @Override
        public Wallpaper[] newArray(int size) {
            return new Wallpaper[size];
        }
    };

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

    public Wallpaper(String imgUrl, String tmbUrl){
        this.imgUrl=imgUrl;
        this.tmbUrl=tmbUrl;
    }

    @SerializedName("img_url")
    private String imgUrl;

    @SerializedName("img_url")
    private String tmbUrl;

    public Wallpaper(Parcel in){
        this.imgUrl = in.readString();
        this.tmbUrl = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.imgUrl);
        parcel.writeString(this.tmbUrl);
    }
}
