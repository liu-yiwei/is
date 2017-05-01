package cn.levacr.is.is.local;

/**
 * Created by hello on 2017/4/30.
 */

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;
public class ViewPagerAdapter extends FragmentPagerAdapter
{
    List<Fragment> fragmentList;
    public ViewPagerAdapter(FragmentManager fm, List fragmentList)
    {
        super(fm);
        this.fragmentList = fragmentList;
    }
    public void addPager(Fragment fragment){
        fragmentList.add(fragment);
    }
    @Override
    public Fragment getItem(int position)
    {
        return fragmentList.get(position);
    }
    @Override
    public int getCount()
    {
        return fragmentList.size();
    }
}