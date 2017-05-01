package cn.levacr.is.is.util;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hello on 2017/4/29.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;

    public ViewPagerAdapter(FragmentManager fm,List fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
