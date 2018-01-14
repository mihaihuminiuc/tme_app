package com.example.humin.tmetestapp.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.humin.tmetestapp.R;
import com.example.humin.tmetestapp.adapter.ListViewAdapter;
import com.example.humin.tmetestapp.listener.FirstFragmentListener;
import com.example.humin.tmetestapp.listener.WallpaperListClickListener;
import com.example.humin.tmetestapp.model.WallpaperList;

/**
 * Created by humin on 1/8/2018.
 */

public class FirstFragment extends Fragment {

    private FirstFragmentListener mListener;
    private WallpaperListClickListener mWallpaperListClickListener;

    private RecyclerView recyclerView;
    private WallpaperList mWallpapersList;

    private Context mContext;

    public static FirstFragment newInstance(WallpaperList mList){
        FirstFragment fragment = new FirstFragment();
        fragment.mWallpapersList=mList;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.row_2_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = getActivity();
        setupList(view);
    }

    private void setupList(View view){
        mWallpaperListClickListener = url -> mListener.onFirstFragmentClick(url);

        ListViewAdapter adapter = new ListViewAdapter(mWallpapersList,ListViewAdapter.ADAPTER_STATE_1,mContext,mWallpaperListClickListener);
        recyclerView = view.findViewById(R.id.simple_recyclerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(mContext,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof FirstFragmentListener) {
            mListener = (FirstFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FirstFragmentListener");
        }
    }
}
