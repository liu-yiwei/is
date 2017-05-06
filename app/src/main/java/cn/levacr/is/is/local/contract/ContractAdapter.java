package cn.levacr.is.is.local.contract;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cn.levacr.is.is.R;
import cn.levacr.is.is.data.Data;

/**
 * Created by hello on 2017/5/6.
 */

public class ContractAdapter extends BaseAdapter {

    private List<Data.Contract> mList;
    private Context mContext;

    public ContractAdapter(List<Data.Contract> list, Context context) {
        this.mList = list;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Data.Contract getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            ViewHolder viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_contract, null);
            viewHolder.name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.number = (TextView) convertView.findViewById(R.id.tv_number);
            viewHolder.name.setText(mList.get(position).getmName());
            viewHolder.number.setText(mList.get(position).getmPhoneNum());
        }
        return convertView;
    }

    public class ViewHolder {
        TextView name;
        TextView number;
    }
}
