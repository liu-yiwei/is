package cn.levacr.is.is.local.contract;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;

import cn.levacr.is.is.util.DatabaseHelper;

/**
 * Created by hello on 2017/5/7.
 */

//联系人的数据结构
public class Contract {
    private String mName;
    private String mPhoneNum;
    public static ArrayList<Contract> list = new ArrayList<Contract>();


    public Contract(String name, String phoneNum) {
        this.mName = name;
        this.mPhoneNum = phoneNum;

    }

    public String getmName() {
        return mName;
    }

    public String getmPhoneNum() {
        return mPhoneNum;
    }


    //得到一个列表 里面的值是一个姓名和电话号码 这里面同样也包含了对数据库的读取操作;
    public static ArrayList<Contract> getContract(Context context) {
        wDB(context);
        ArrayList<Contract> list = new ArrayList<Contract>();
        Contract contract;

        Cursor cr = DatabaseHelper.getInstance(context).getReadableDatabase()
                .query("contact", new String[]{"name", "number"}, null, null, null, null, null);
        Log.e("testsql1", "getContract: "+cr.getCount() );;

        if (cr != null) {
            while (cr.moveToNext()) {
                String name = cr.getString(cr.getColumnIndex("name"));
                String number = cr.getString(cr.getColumnIndex("number"));
                contract = new Contract(name, number);
                Log.e("testsql", contract.getmName() + contract.getmPhoneNum());
                list.add(contract);
            }
        }
        return list;
    }


    //得到一个列表 里面的值是一个姓名和电话号码 这里面同样也包含了对数据库的读取操作;
    public static void wDB(Context context) {
        ArrayList<Contract> list = new ArrayList<Contract>();
        Contract contract;

        Cursor cr = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{"display_name", "data1"}, null, null, null);
        if (cr != null) {
            while (cr.moveToNext()) {
                String name = cr.getString(cr.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cr.getString(cr.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contract = new Contract(name, number);
                list.add(contract);
            }
        }
        Cursor r;
        String sql;
        for (Contract i : list) {
//            Log.e("testsql", i.getmName() + i.mPhoneNum);
            r = DatabaseHelper.getInstance(context).getReadableDatabase().query("contact",
                    new String[]{"name", "number"}, "name =? AND number=?"
                    , new String[]{i.mName, i.mPhoneNum}, null, null, null);
//            Log.e("testsql", r.getCount() + "");
            if (r.getCount() == 0) {
                sql = String.format("insert into %s values(null,'%s','%s');", "contact", i.getmName(), i.getmPhoneNum());
//                Log.e("testsql", sql);
                DatabaseHelper.getInstance(context).getWritableDatabase().execSQL(sql);
            }
        }

    }
}