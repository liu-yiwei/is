package cn.levacr.is.is.local;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.gigamole.library.navigationtabstrip.NavigationTabStrip;
import com.isnc.facesdk.SuperID;

import java.util.ArrayList;
import java.util.List;



import cn.levacr.is.is.R;
import droidninja.filepicker.fragments.BaseFragment;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by hello on 2017/4/29.
 */
@RuntimePermissions
public class LocalFragment extends BaseFragment {


    private ArrayList<String> photoPaths = new ArrayList<>();
    private ArrayList<String> docPaths = new ArrayList<>();


    FloatingActionButton addDoc;


    NavigationTabStrip navigationTabStrip;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.local_frag,container,false);
        navigationTabStrip = (NavigationTabStrip) root.findViewById(R.id.tab);
        viewPager = (ViewPager) root.findViewById(R.id.viewpager);
        initTab();



        return root;
    }


    //初始化tab
    void initTab(){
        try {
            if (navigationTabStrip != null){
                navigationTabStrip.setTabIndex(1, true);
                navigationTabStrip.setStripColor(Color.RED);
                navigationTabStrip.setStripWeight(6);
                navigationTabStrip.setStripFactor(2);
                navigationTabStrip.setStripType(NavigationTabStrip.StripType.LINE);
                navigationTabStrip.setAnimationDuration(100);
                navigationTabStrip.setInactiveColor(Color.GRAY);
                navigationTabStrip.setActiveColor(R.color.colorPrimary);
            }
        }catch (Exception e){
            Log.v("asdfd","asdfjksdalj");
        }



        List<Fragment> x = new ArrayList<>();
        x.add(new PhotoFragment());
        x.add(new PhotoFragment());
        x.add(new PhotoFragment());
        viewPager.setAdapter(new  ViewPagerAdapter(getFragmentManager(),x));

        navigationTabStrip.setViewPager(viewPager);
    }


}
