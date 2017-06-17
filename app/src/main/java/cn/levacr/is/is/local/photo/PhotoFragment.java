package cn.levacr.is.is.local.photo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.levacr.is.is.R;

/**
 * Created by hello on 2017/4/30.
 */

public class PhotoFragment extends Fragment {


    private List<Photo> mList;

    private static RecyclerView mRecyclerView;

    private CoordinatorLayout mCoordinatorLayout;
    private PhotoAdapter mAdapter;
    private StaggeredGridLayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_photo, container, false);

        initView(view);

        return view;

    }

    public void addItem(List<Photo> l) {
        for (Photo i : l) {
            mList.add(i);
        }
        mAdapter.notifyDataSetChanged();

    }

    //初始化布局
    void initView(View view) {
        mList = Photo.getEncrPhotoList();
        mAdapter = new PhotoAdapter(getActivity(), mList);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_photo);
        mCoordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.coordinatr_photo);
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    //设置各类监听器
    private void setListener() {

    }
}

