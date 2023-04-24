package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Pageadapter extends FragmentPagerAdapter {
    int tabcount;

    public Pageadapter(@NonNull FragmentManager fm, int behaviour) {
        super(fm,behaviour);
        tabcount = behaviour;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0: return new chat();
            case 1: return new stutas();
            case 2: return new call();
            default: return null;
        }

    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
