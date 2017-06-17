package cn.levacr.is.is.pref;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.levacr.is.is.R;

/**
 * Created by hello on 2017/4/29.
 */

public class PrefFragment extends PreferenceFragment{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = super.onCreateView(inflater, container, savedInstanceState);
        addPreferencesFromResource(R.xml.general);
        return view;
    }
}
