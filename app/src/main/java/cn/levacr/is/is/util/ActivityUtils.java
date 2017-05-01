package cn.levacr.is.is.util;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


/**
 * Created by hello on 2017/4/29.
 */

public class ActivityUtils {

    public static class UtilsV4{
        public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                                  @NonNull Fragment fragment, int frameId) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(frameId, fragment);
            transaction.commit();
        }
        public static void removeFragmentFromActivity(FragmentManager fragmentManager,
                                                      @NonNull Fragment fragment){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(fragment);
            transaction.commit();
        }
    }

    public static class UnitlsV3{
        public static void addFragmentToActivity (@NonNull android.app.FragmentManager fragmentManager,
                                                  @NonNull android.app.Fragment fragment, int frameId) {
            android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(frameId, fragment);
            transaction.commit();
        }
        public static void removeFragmentFromActivity(android.app.FragmentManager fragmentManager,
                                                      @NonNull android.app.Fragment fragment){
            android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(fragment);
            transaction.commit();
        }
    }

}
