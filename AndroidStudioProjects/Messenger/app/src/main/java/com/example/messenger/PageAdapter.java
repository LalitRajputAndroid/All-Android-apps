package com.example.messenger;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    int tabcount;
    public PageAdapter(@NonNull FragmentManager fm,int i) {
        super(fm,i);
        tabcount = i;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 1: return new calls();
            case 2: return new calls();
            case 3: return new stores();
            default:return null;
        }
    }
    @Override
    public int getCount() {
        return tabcount;
    }
}
