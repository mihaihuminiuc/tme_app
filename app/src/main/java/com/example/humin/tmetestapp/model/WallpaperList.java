package com.example.humin.tmetestapp.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by humin on 12/28/2017.
 */

public class WallpaperList {

    public List<Wallpaper> getWallpapers() {
        return wallpapers;
    }

    public void setWallpapers(List<Wallpaper> wallpapers) {
        this.wallpapers = wallpapers;
    }

    private List<Wallpaper> wallpapers;

    public WallpaperList(){

    }
}
