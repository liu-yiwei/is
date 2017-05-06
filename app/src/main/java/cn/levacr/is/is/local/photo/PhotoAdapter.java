package cn.levacr.is.is.local.photo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.levacr.is.is.R;

/**
 * Created by hello on 2017/5/6.
 */

public class PhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Data.Photo> mList;

    public PhotoAdapter(Context mContext, List<Data.Photo> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_photo,parent,false);

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //// TODO: 2017/5/7 绑定photo 
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
