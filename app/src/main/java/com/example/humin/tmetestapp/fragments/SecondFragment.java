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
import com.example.humin.tmetestapp.listener.WallpaperListClickListener;
import com.example.humin.tmetestapp.model.Wallpaper;
import com.example.humin.tmetestapp.model.WallpaperList;

import java.util.Random;

/**
 * Created by humin on 1/8/2018.
 */

public class SecondFragment extends Fragment implements View.OnClickListener{

    private RecyclerView recyclerView;
    private WallpaperList mWallpapersList;
    private ListViewAdapter adapter;
    private WallpaperListClickListener mWallpaperListClickListener;
    private FloatingActionButton mFloatingActionButton;
    private Context mContext;

    public static SecondFragment newInstance(WallpaperList mList){
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
        if(savedInstanceState!=null){
            if(savedInstanceState.getSerializable(getString(R.string.key_my_list))!=null){
                mWallpapersList= (WallpaperList) savedInstanceState.getSerializable(getString(R.string.key_my_list));
                Toast.makeText(getActivity(),"RESTORE",Toast.LENGTH_LONG).show();
            }
        }
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
        savedInstanceState.putSerializable(getString(R.string.key_my_list), mWallpapersList);
        Toast.makeText(getActivity(),"SAVE",Toast.LENGTH_LONG).show();
    }
}
