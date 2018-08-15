package com.cxl.demo.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cxl.demo.ui.bean.FragmentInfo;
import com.cxl.demo.ui.fragment.Fragment1;
import com.cxl.demo.ui.fragment.Fragment2;
import com.cxl.demo.ui.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/28.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<FragmentInfo> fragmentList;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragment();
    }

    private void initFragment() {
            fragmentList = new ArrayList<>();
            fragmentList.add(new FragmentInfo("客厅",Fragment1.class));
            fragmentList.add(new FragmentInfo("厨房",Fragment2.class));
            fragmentList.add(new FragmentInfo("更多",Fragment3.class));
    }



    @Override
    public Fragment getItem(int position) {
        try {
           return (Fragment) fragmentList.get(position).getFragmet().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentList.get(position).getTitle();
    }

}
