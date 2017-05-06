package cn.levacr.is.is.data;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;

/**
 * Created by hello on 2017/5/7.
 */

//联系人的数据结构
public class Contract {
    private String mName;
    private String mPhoneNum;
    public static ArrayList<Contract> list = new ArrayList<Contract>();


    public Contract() {
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmPhoneNum(String mPhoneNum) {
        this.mPhoneNum = mPhoneNum;
    }

    public String getmName() {
        return mName;
    }

    public String getmPhoneNum() {
        return mPhoneNum;
    }




    //得到一个列表 里面的值是一个姓名和电话号码 这里面同样也包含了对数据库的读取操作;
    public static ArrayList<Contract> getContract(Context context) {
        ArrayList<Contract> list = new ArrayList<Contract>();
        Contract contract;

        Cursor cr = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{"display_name", "data1"}, null, null, null);
        if (cr != null) {
            while (cr.moveToNext()) {
                contract = new Contract();
                String name = cr.getString(cr.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cr.getString(cr.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contract.setmName(name);
                contract.setmPhoneNum(number);
                list.add(contract);
            }
        }
        return list;
    }
}