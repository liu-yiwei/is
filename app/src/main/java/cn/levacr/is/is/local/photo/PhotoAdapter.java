package cn.levacr.is.is.local.photo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

import cn.levacr.is.is.R;

/**
 * Created by hello on 2017/5/6.
 */

public class PhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener, View.OnLongClickListener {

    private Context mContext;
    private List<Photo> mList;

    public PhotoAdapter(Context mContext, List<Photo> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view);

        void onItemLongClick(View view);
    }


    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setmOnItemClickListener(OnRecyclerViewItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_photo, parent, false);
        PhotoHolder holder = new PhotoHolder(view);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return holder;
    }

    @Override  //binding the ViewHolder
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Glide.with(mContext).load(new File(mList.get(position).getSrcPath()))
                .into(((PhotoHolder) holder).iv);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    //////////////////////////////////////////////////////////////
    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null)
            mOnItemClickListener.onItemClick(v);
    }

    @Override
    public boolean onLongClick(View v) {
        if (mOnItemClickListener != null)
            mOnItemClickListener.onItemLongClick(v);
        return false;
    }


    class PhotoHolder extends RecyclerView.ViewHolder {
        private ImageButton iv;

        public PhotoHolder(View view) {
            super(view);
            iv = (ImageButton) view.findViewById(R.id.iv_photo);
        }
    }
}
