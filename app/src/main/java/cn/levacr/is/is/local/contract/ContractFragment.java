package cn.levacr.is.is.local.contract;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import cn.levacr.is.is.R;

/**
 * Created by hello on 2017/5/6.
 */

public class ContractFragment extends Fragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {


    private ListView mLv;
    private ContractAdapter mAdapter;

    private List<Contract> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_contract, container, false);
        try {
            mLv = (ListView) root.findViewById(R.id.lv_contract);

            mLv.setOnItemClickListener(this);
            mLv.setOnItemLongClickListener(this);

            mList = Contract.getContract(getActivity());
            mAdapter = new ContractAdapter(mList, getActivity());
            mLv.setAdapter(mAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }

    //调用系统直接拨号;
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String number = mList.get(position).getmPhoneNum();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.CALL");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse("tel:" + number));
        getActivity().startActivity(intent);
    }

    //长按操作
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        new AlertDialog.Builder(this.getActivity()).setTitle("选择操作").setNeutralButton("取消", null)
                .setPositiveButton("删除", null).show();
        return false;
    }
}
