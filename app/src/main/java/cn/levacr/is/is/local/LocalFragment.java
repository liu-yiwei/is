package cn.levacr.is.is.local;

import android.app.Instrumentation;
import android.content.Intent;
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

import java.util.ArrayList;
import java.util.List;



import cn.levacr.is.is.R;
import cn.levacr.is.is.local.contract.ContractFragment;
import cn.levacr.is.is.local.photo.PhotoFragment;
import droidninja.filepicker.fragments.BaseFragment;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by hello on 2017/4/29.
 */
@RuntimePermissions
public class LocalFragment extends BaseFragment {


    private ArrayList<String> photoPaths = new ArrayList<>();
    private ArrayList<String> docPaths = new ArrayList<>();

    private FloatingActionButton but_addDoc;
    private FloatingActionButton but_addMedia;

    NavigationTabStrip navigationTabStrip;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_local,container,false);
        navigationTabStrip = (NavigationTabStrip) root.findViewById(R.id.tab);
        viewPager = (ViewPager) root.findViewById(R.id.viewpager);
        initTab();

        but_addDoc = (FloatingActionButton) root.findViewById(R.id.add_doc);
        but_addMedia = (FloatingActionButton) root.findViewById(R.id.add_media);

        but_addDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        but_addMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return root;
    }


    //返回的文件列表;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
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
        x.add(new ContractFragment());
        viewPager.setAdapter(new  ViewPagerAdapter(getFragmentManager(),x));

        navigationTabStrip.setViewPager(viewPager);
    }


}
