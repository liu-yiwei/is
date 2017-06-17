package cn.levacr.is.is.local.Doc;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;

import cn.levacr.is.is.R;

/**
 * Created by 奈落 on 2017/6/15.
 */

public class DocAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Doc> mList;
    private Context mContext;

    public DocAdapter(ArrayList list, Context context) {
        this.mList = list;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_doc,parent,false);
        DocHolder holder = new DocHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    private class DocHolder extends RecyclerView.ViewHolder {

        private ImageButton iv;

        public DocHolder(View itemView) {
            super(itemView);
            iv = (ImageButton) itemView.findViewById(R.id.iv_doc);
        }
    }
}
