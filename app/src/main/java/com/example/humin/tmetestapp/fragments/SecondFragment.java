package com.example.humin.tmetestapp.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.humin.tmetestapp.R;
import com.example.humin.tmetestapp.adapter.ListViewAdapter;
import com.example.humin.tmetestapp.database.WallpaperDB;
import com.example.humin.tmetestapp.listener.WallpaperListClickListener;
import com.example.humin.tmetestapp.model.PreferenceUtilModel;
import com.example.humin.tmetestapp.model.Wallpaper;
import com.example.humin.tmetestapp.model.WallpaperList;
import com.example.humin.tmetestapp.util.PreferencesUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by humin on 1/8/2018.
 */

public class SecondFragment extends Fragment implements View.OnClickListener{

    private RecyclerView recyclerView;
    private WallpaperList mWallpapersList;
    private List<Wallpaper> mWallpaper;
    private ListViewAdapter adapter;
    private WallpaperListClickListener mWallpaperListClickListener;
    private FloatingActionButton mFloatingActionButton;
    private Context mContext;
    private PreferenceUtilModel mPreferenceUtilModel;

    public static SecondFragment newInstance(WallpaperList mList){
        SecondFragment fragment = new SecondFragment();
        fragment.mWallpapersList=mList;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.row_3_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mContext = getActivity();
        initUI(view);
        setupList(view);
    }

    private void initUI(View view){
        mFloatingActionButton = view.findViewById(R.id.fab);

        mFloatingActionButton.setOnClickListener(this);
    }

    private void setupList(View view){
        mWallpaperListClickListener = url -> Toast.makeText(mContext,url,Toast.LENGTH_LONG).show();

        mPreferenceUtilModel = PreferencesUtils.getPreferenceModel(mContext);

        if(mPreferenceUtilModel!=null && mPreferenceUtilModel.isSaved()
                && (WallpaperDB.listAll(WallpaperDB.class) !=null || !WallpaperDB.listAll(WallpaperDB.class).isEmpty())){

            Toast.makeText(mContext, "RESTORED", Toast.LENGTH_SHORT).show();

            mWallpaper = new ArrayList<>();

            for(WallpaperDB w : WallpaperDB.listAll(WallpaperDB.class)){
                mWallpaper.add(new Wallpaper(w.getImgUrl(),w.getTmbUrl()));
            }

            mWallpapersList.setWallpapers(mWallpaper);
        }

        adapter = new ListViewAdapter(mWallpapersList,ListViewAdapter.ADAPTER_STATE_2,mContext,mWallpaperListClickListener);
        recyclerView = view.findViewById(R.id.simple_recyclerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(mContext,3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab:
                int random = new Random().nextInt(mWallpapersList.getWallpapers().size()) ;
                Wallpaper tempWallpaper = mWallpapersList.getWallpapers().get(random);

                mWallpapersList.getWallpapers().set(0,tempWallpaper);

                adapter.updateList(mWallpapersList);

                recyclerView.smoothScrollToPosition(0);
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        mPreferenceUtilModel.setSaved(true);

        PreferencesUtils.setPreferenceModel(mContext,mPreferenceUtilModel);

        Toast.makeText(mContext, "SAVED", Toast.LENGTH_SHORT).show();

        WallpaperDB.deleteAll(WallpaperDB.class);

        for(Wallpaper w : adapter.getList().getWallpapers()){
            WallpaperDB wallpaperDB = new WallpaperDB(w.getImgUrl(),w.getTmbUrl());
            wallpaperDB.save();
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        mWallpaperListClickListener = null;
    }
}
