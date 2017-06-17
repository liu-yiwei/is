package cn.levacr.is.is.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 奈落 on 2017/6/13
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String dbname = "fileList";
    private static final int version = 1;

    //创建数据库的操作
    private DatabaseHelper(Context context) {
        super(context, dbname, null, version);
    }


    //数据库创建之后的操作
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table EncrDoc (\n" +
                "FileID               INTEGER    PRIMARY KEY AUTOINCREMENT ,\n" +
                "scrPath              VARCHAR(20)                    not null,\n" +
                "encrName             VARCHAR(20)                    not null,\n" +
                "suffix               VARCHAR(20)                    not null,\n" +
                "EncrDocKey           VARCHAR(20)\n" +
                ");");
        db.execSQL("create table EncrMedia (\n" +
                "FileID               INTEGER    PRIMARY KEY AUTOINCREMENT ,\n" +
                "scrPath              VARCHAR(20)                    not null,\n" +
                "encrName             VARCHAR(20)                    not null,\n" +
                "suffix               VARCHAR(20)                    not null,\n" +
                "EncrMediaKey         VARCHAR(20)                    not null\n" +
                ");\n");
        db.execSQL("create table NorDoc (\n" +
                "FileID               INTEGER    PRIMARY KEY AUTOINCREMENT ,\n" +
                "scrPath              VARCHAR(20)                    not null,\n" +
                "encrName             VARCHAR(20)                    not null,\n" +
                "suffix               VARCHAR(20)                    not null\n" +
                ");\n");
        db.execSQL("create table NorMedia (\n" +
                "FileID               INTEGER    PRIMARY KEY AUTOINCREMENT ,\n" +
                "scrPath              VARCHAR(20)                    not null,\n" +
                "encrName             VARCHAR(20)                    not null,\n" +
                "suffix               VARCHAR(20)                    not null\n" +
                ");\n");
        db.execSQL("create table contact (\n" +
                "ContactID            INTEGER    PRIMARY KEY AUTOINCREMENT ,\n" +
                "name                 VARCHAR(20),                             \n" +
                "number               VARCHAR(20)                             \n" +
                ");\n");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*
    * 单利模式,省点内存吧
     */
    private static DatabaseHelper databaseHelper;

    public static DatabaseHelper getInstance(Context context) {
        if (databaseHelper == null)
            databaseHelper = new DatabaseHelper(context);
        return databaseHelper;
    }
}
