package com.example.humin.tmetestapp.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.humin.tmetestapp.R;
import com.example.humin.tmetestapp.listener.SecondFragmentListener;
import com.example.humin.tmetestapp.model.Wallpaper;

import java.util.List;

/**
 * Created by humin on 1/8/2018.
 */

public class SecondFragment extends Fragment{

    private SecondFragmentListener mListener;
    private List<Wallpaper> mWallpapersList;

    public static SecondFragment newInstance(List<Wallpaper> mList){
        SecondFragment fragment = new SecondFragment();
        fragment.mWallpapersList=mList;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.second_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof SecondFragmentListener) {
            mListener = (SecondFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement SecondFragmentListener");
        }
    }

}
