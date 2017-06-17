package cn.levacr.is.is.local;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.gigamole.library.navigationtabstrip.NavigationTabStrip;

import java.util.ArrayList;
import java.util.List;

import cn.levacr.is.is.R;
import cn.levacr.is.is.local.Doc.DocFragment;
import cn.levacr.is.is.local.contract.ContractFragment;
import cn.levacr.is.is.local.photo.PhotoFragment;
import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;
import droidninja.filepicker.fragments.BaseFragment;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by hello on 2017/4/29.
 */
@RuntimePermissions
public class LocalFragment extends BaseFragment {


    private PhotoFragment pf;
    private DocFragment df;
    private ContractFragment cf;

    private final int MAX_ATTACHMENT_COUNT = 10;

    private ArrayList<String> photoPaths = new ArrayList<>();
    private ArrayList<String> docPaths = new ArrayList<>();

    private FloatingActionButton but_addDoc;
    private FloatingActionButton but_addMedia;

    NavigationTabStrip navigationTabStrip;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_local, container, false);
        navigationTabStrip = (NavigationTabStrip) root.findViewById(R.id.tab);
        viewPager = (ViewPager) root.findViewById(R.id.viewpager);
        initTab();

        but_addDoc = (FloatingActionButton) root.findViewById(R.id.add_doc);
        but_addMedia = (FloatingActionButton) root.findViewById(R.id.add_media);

        but_addDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickDoc();
            }
        });
        but_addMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickMedia();
            }
        });
        return root;
    }

    //    选取文件的函数;
    private void pickDoc() {
        int maxCount = MAX_ATTACHMENT_COUNT - photoPaths.size();
        if ((docPaths.size() + photoPaths.size()) == MAX_ATTACHMENT_COUNT)
            Toast.makeText(getActivity(), "Cannot select more than " + MAX_ATTACHMENT_COUNT + " items", Toast.LENGTH_SHORT).show();
        else
            FilePickerBuilder.getInstance().setMaxCount(maxCount)
                    .setSelectedFiles(docPaths)
                    .pickFile(this);
    }

    private void pickMedia() {
        int maxCount = MAX_ATTACHMENT_COUNT - photoPaths.size();
        if ((docPaths.size() + photoPaths.size()) == MAX_ATTACHMENT_COUNT)
            Toast.makeText(getActivity(), "Cannot select more than " + MAX_ATTACHMENT_COUNT + " items", Toast.LENGTH_SHORT).show();
        else
            FilePickerBuilder.getInstance().setMaxCount(maxCount)
                    .setSelectedFiles(docPaths)
                    .pickPhoto(this);
    }

    //返回的文件列表;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case (FilePickerConst.REQUEST_CODE_PHOTO):
                if (resultCode == Activity.RESULT_OK) {
                    photoPaths = new ArrayList<>();
                    photoPaths.addAll(data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_MEDIA));
                }
                break;
            case (FilePickerConst.REQUEST_CODE_DOC):
                if (resultCode == Activity.RESULT_OK) {
                    docPaths = new ArrayList<>();
                    docPaths.addAll(data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_DOCS));
                }
                break;
        }

        if (docPaths.size() != 0 || photoPaths.size() != 0)
            confirmEncr(photoPaths, docPaths);
    }


    //得到用户选择的加密方式
    private void confirmEncr(final List photo, final List doc) {
        new AlertDialog.Builder(this.getActivity()).setTitle("加密方式")
                .setMessage("选择您需要的加密方式")
                .setPositiveButton("真加密", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Encr.encrTruePhoto(photo);
                        Encr.encrTrueDoc(doc);
                        pf.addItem(photo);
                    }
                }).setNegativeButton("假加密", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Encr.encrFalseDoc(doc);
                Encr.encrFalsePhoto(photo);
                Log.e("test", "骗人的加密方式");
            }
        }).setNeutralButton("算了", null).show();
    }

    //初始化tab
    void initTab() {
        try {
            if (navigationTabStrip != null) {
                navigationTabStrip.setTabIndex(1, true);
                navigationTabStrip.setStripColor(Color.RED);
                navigationTabStrip.setStripWeight(6);
                navigationTabStrip.setStripFactor(2);
                navigationTabStrip.setStripType(NavigationTabStrip.StripType.LINE);
                navigationTabStrip.setAnimationDuration(100);
                navigationTabStrip.setInactiveColor(Color.GRAY);
                navigationTabStrip.setActiveColor(R.color.colorPrimary);
            }
        } catch (Exception e) {
        }

        //设置viewpager
        List<Fragment> x = new ArrayList<>();
        pf = new PhotoFragment();
        df = new DocFragment();
        cf = new ContractFragment();
        x.add(pf);
        x.add(df);
        x.add(cf);
        viewPager.setAdapter(new ViewPagerAdapter(getFragmentManager(), x));

        navigationTabStrip.setViewPager(viewPager);
    }
}
