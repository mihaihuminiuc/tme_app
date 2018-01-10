package com.example.humin.tmetestapp.holder;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.humin.tmetestapp.R;
import com.example.humin.tmetestapp.adapter.ListViewAdapter;
import com.example.humin.tmetestapp.model.Wallpaper;

/**
 * Created by humin on 1/10/2018.
 */

public class ListViewHolder extends RecyclerView.ViewHolder {

    private LinearLayout mBoderLayout;
    private ImageView mWallpaperImage;
    private Point size;

    /**
     * The ViewHolder that will be used to display the data in each item shown
     * in the RecyclerView
     *
     * @param itemView
     *         The layout view group used to display the data
     */
    public ListViewHolder(final View itemView) {
        super(itemView);
        mBoderLayout = itemView.findViewById(R.id.layout_border);
        mWallpaperImage = itemView.findViewById(R.id.wallpaper_img);
    }

    /**
     * Method that is used to bind the data to the ViewHolder
     *
     * @param mWallpaper
     *         The viewmodel that contains the data
     */
    public void bindData(final Wallpaper mWallpaper, int type, Context context, Point mScreenDimensions) {
        switch (type){
            case ListViewAdapter.ADAPTER_STATE_1:
                mBoderLayout.setBackgroundResource(R.drawable.yellow_border);

                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mBoderLayout.getLayoutParams();
                params.height = (int) (mScreenDimensions.y*0.2f);
                params.width = (int) (mScreenDimensions.x*0.5f);

                mBoderLayout.setLayoutParams(params);

                RequestOptions options = new RequestOptions();
                options.centerCrop();

                Glide.with(context)
                        .load(mWallpaper.getTmb_url())
                        .apply(options)
                        .into(mWallpaperImage);
                break;
            case ListViewAdapter.ADAPTER_STATE_2:
                mBoderLayout.setBackgroundResource(R.drawable.blue_border);
                Glide.with(context)
                        .load(mWallpaper.getTmb_url())
                        .into(mWallpaperImage);
                break;
        }

    }
}
