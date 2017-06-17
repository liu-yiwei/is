package cn.levacr.is.is.local.Doc;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by hello on 2017/5/10.
 */


public class Doc {


    private String srcPath;
    private String srcName;
    private String encrName;
    private String key;

    public Doc(String srcPath) {
        this.srcPath = srcPath;
        this.srcName = srcPath.split("/")[srcPath.split("/").length - 1];
        this.encrName = this.srcName + "." + System.currentTimeMillis();
        this.key = null;//从数据库提取照片的时候使用
    }

    //把自己加密咯
    public void encrTrue() {


    }

    public void encrFalse() {

    }

    public static ArrayList<Doc> getRenameDocList(Context context) {

        ArrayList<Doc> list = new ArrayList<Doc>();
        Doc doc;


        return list;
    }

    public static ArrayList<Doc> getEncrDocList(Context context) {
        ArrayList<Doc> list = new ArrayList<Doc>();
        Doc doc;


        return list;

    }
}