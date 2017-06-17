package cn.levacr.is.is.local;

import java.util.List;

import cn.levacr.is.is.local.Doc.Doc;
import cn.levacr.is.is.local.photo.Photo;

/**
 * Created by hello on 2017/5/10.
 */
/*
* 和加密有关的所有类;
 */
public class Encr {


    public static boolean encrTruePhoto(List<String> list) {
        if (list == null)
            return false;
        for (String i : list) {
            new Photo(i).encrTrue();
            return true;
        }
        return false;

    }

    public static boolean encrFalsePhoto(List<String> list) {
        if (list == null) return false;
        for (String i : list) {
            new Photo(i).encrFalse();
            return true;
        }
        return false;
    }

    public static boolean encrTrueDoc(List<String> list) {
        if (list == null)
            return false;
        for (String i : list) {
            new Doc(i).encrTrue();
            return true;
        }
        return false;

    }

    public static boolean encrFalseDoc(List<String> list) {
        if (list == null) return false;
        for (String i : list) {
            new Doc(i).encrFalse();
            return true;
        }
        return false;
    }
}
