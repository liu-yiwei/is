package cn.levacr.is.is.local.Doc;

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
 * Created by 奈落 on 2017/6/15.
 */

public class DocFragment extends Fragment {

    private List<Doc> mList;
    private static RecyclerView mRecyclerView;
    private DocAdapter docAdapter;
    private StaggeredGridLayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_doc, container, false);
        initView(view);

        return view;
    }


    void initView(View view) {
        mList = Doc.getEncrDocList(this.getActivity());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_doc);
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(docAdapter);

    }
}
