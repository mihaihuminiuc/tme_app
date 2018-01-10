package com.example.humin.tmetestapp.adapter;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.humin.tmetestapp.R;
import com.example.humin.tmetestapp.holder.ListViewHolder;
import com.example.humin.tmetestapp.model.Wallpaper;
import com.example.humin.tmetestapp.model.WallpaperList;
import com.example.humin.tmetestapp.util.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by humin on 12/27/2017.
 */

public class ListViewAdapter extends RecyclerView.Adapter{

    private WallpaperList wallpapers = new WallpaperList();
    private int mType = 0;
    private Context mContext;

    public static final int ADAPTER_STATE_1=1;
    public static final int ADAPTER_STATE_2=2;

    private Point mScreenDimensions;

    public ListViewAdapter(final WallpaperList wallpapers, int type, Context context) {
        if (wallpapers != null) {
            this.wallpapers = wallpapers;
        }
        this.mType = type;
        this.mContext = context;
        this.mScreenDimensions = CommonUtils.getDefaultDisplaySize((AppCompatActivity) context);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindData(wallpapers.getWallpapers().get(position), mType, mContext, mScreenDimensions);
    }

    @Override
    public int getItemCount() {
        return wallpapers.getWallpapers().size();
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.list_item;
    }
}
