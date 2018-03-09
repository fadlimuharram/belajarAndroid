package com.example.fadli.blogclone;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by fadli on 3/8/18.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==1){
            return "News";
        }else if(position==2){
            return "Info";
        }else{
            return "Tutorial";
        }
    }

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position==1){
            return new NewsFragment();
        }else if(position==2){
            return new InfoFragment();
        }else{
            return new TutorialFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
