package cn.levacr.is.is.data;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hello on 2017/5/5.
 */

//对联系人加密以后存进本地的数据库
public class EncrContract extends Service {


    public static ArrayList<Data.Contract> list = new ArrayList<Data.Contract>();


    //得到一个列表 里面的值是一个姓名和电话号码 这里面同样也包含了对数据库的读取操作;
    public static ArrayList<Data.Contract> getContract(Context context) {
        ArrayList<Data.Contract> list = new ArrayList<Data.Contract>();
        Data.Contract contract;

        Cursor cr = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{"display_name", "sort_key", "contact_id", "data1"}, null, null, "sort_key");
        if (cr != null) {
            while (cr.moveToNext()) {
                contract = new Data.Contract();
                String name = cr.getString(cr.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cr.getString(cr.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contract.setmName(name);
                contract.setmPhoneNum(number);
                list.add(contract);
            }
        }
        return list;
    }

    public static void writeToLocal() {

    }

    private static void encrContract() {

    }

    //读取联系人
    private static void readContract(Context context) {

        //获得一个游标的数据类型;
//
//        ContentResolver  cr = getContentResolver();

//        resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
