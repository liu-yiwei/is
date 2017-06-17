package cn.levacr.is.is.util;

/**
 * Created by hello on 2017/5/7.
 */

import android.app.Application;
import android.content.Context;

public class MainApplication extends Application{
    /**
     * 全局的上下文
     */
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    /**
     * 获取context
     * @return
     */
    public static Context getContext(){
        return mContext;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

}