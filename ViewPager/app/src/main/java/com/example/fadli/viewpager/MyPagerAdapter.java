package com.example.fadli.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by fadli on 3/7/18.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return new NewsFragment();
        }else if (position==1){
            return new TutorialFragment();
        }else {
            return new InfoFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;//jumlah fragment
    }

    //untuk tablayout

    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0){
            return "News";
        }else if (position==1){
            return "Tutorial";
        }else {
            return "Info";
        }
    }
}
