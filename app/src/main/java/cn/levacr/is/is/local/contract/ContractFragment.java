package cn.levacr.is.is.local.contract;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import cn.levacr.is.is.R;
import cn.levacr.is.is.data.Data;
import cn.levacr.is.is.data.EncrContract;

/**
 * Created by hello on 2017/5/6.
 */

public class ContractFragment extends Fragment implements AdapterView.OnItemClickListener{

    private ListView mLv;
    private ContractAdapter mContractAdapter;

    private List<Data.Contract> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_contract, container, false);
        try {
            mLv = (ListView) root.findViewById(R.id.lv_contract);
            mList = EncrContract.getContract(getContext());
            mContractAdapter = new ContractAdapter(mList,getActivity());
            mLv.setAdapter(mContractAdapter);
        }catch (Exception e){
            e.printStackTrace();
            Log.e("aaa","asasdfd");
        }


        return root;
    }


    //调用系统直接拨号;
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
