package com.example.humin.tmetestapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by humin on 2/6/2018.
 */

public class PreferenceUtilModel implements Parcelable {

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }

    public static Creator<PreferenceUtilModel> getCREATOR() {
        return CREATOR;
    }

    boolean isSaved;

    protected PreferenceUtilModel(Parcel in) {
        isSaved = in.readByte() != 0;
    }

    public static final Creator<PreferenceUtilModel> CREATOR = new Creator<PreferenceUtilModel>() {
        @Override
        public PreferenceUtilModel createFromParcel(Parcel in) {
            return new PreferenceUtilModel(in);
        }

        @Override
        public PreferenceUtilModel[] newArray(int size) {
            return new PreferenceUtilModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (isSaved ? 1 : 0));
    }
}
