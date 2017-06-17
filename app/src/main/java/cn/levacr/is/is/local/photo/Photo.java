package cn.levacr.is.is.local.photo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import cn.levacr.is.is.util.DatabaseHelper;
import cn.levacr.is.is.util.MainApplication;

/**
 * Created by hello on 2017/5/7.
 */

public class Photo {


    private String srcPath;
    private String srcName;
    private String encrName;
    private String key;

    public Photo(String srcPath) {
        this.srcPath = srcPath;
        this.srcName = srcPath.split("/")[srcPath.split("/").length - 1];
        this.encrName = this.srcName + "." + System.currentTimeMillis();
        this.key = null;//从数据库提取照片的时候使用
    }

    //把自己加密咯
    public void encrTrue() {


    }

    public void encrFalse() {
        String sql = String.format("INSERT INTO NorMedia VALUES (NULL ,'%s','%s','%s');", this.srcPath, this.encrName, this.encrName, this.encrName);

        DatabaseHelper helper = DatabaseHelper.getInstance(MainApplication.getContext());
        helper.getWritableDatabase().execSQL(sql);
    }

    public String getSrcPath() {
        return srcPath;
    }

    public static ArrayList<Photo> getNorPhotoList() {
        ArrayList<Photo> list;
        String[] columns;
        SQLiteDatabase db = DatabaseHelper.getInstance(MainApplication.getContext()).getWritableDatabase();
        Cursor cursor = db.query(" ", null, null, null, null, null, null);
        if (cursor.getCount() > 0) {
            list = new ArrayList<Photo>(cursor.getCount());

            while (cursor.moveToNext()) {
                Photo photo = new Photo("");
                list.add(photo);
            }
            return list;
        }

        return null;
    }

    public static ArrayList<Photo> getEncrPhotoList() {
        ArrayList<Photo> list = new ArrayList<>() ;
        SQLiteDatabase db = DatabaseHelper.getInstance(MainApplication.getContext()).getReadableDatabase();
        Cursor cursor = db.query("NorMedia", null, null, null, null, null, null);
        Log.e("testsql",cursor.getCount()+"");
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Photo photo = parseMedia(cursor) ;
                list.add(photo);
            }
            return list;
        }
        return list;
    }

    private static Photo parseMedia(Cursor cursor){
        String path = cursor.getString(cursor.getColumnIndex("scrPath"));
        return new Photo(path);
    }
}
