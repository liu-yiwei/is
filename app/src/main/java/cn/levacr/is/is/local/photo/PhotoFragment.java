package cn.levacr.is.is.local.photo;

import android.os.Bundle;
import android.support.annotation.Nullable;
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


    private List<Data.Photo> mList;
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_photo, container, false);

        initView(view);

        return view;

    }

    //初始化布局
    void initView(View view){
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_photo);

    }
}
