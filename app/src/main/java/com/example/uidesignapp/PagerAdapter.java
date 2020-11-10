package com.example.uidesignapp;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
   private int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0: return new Tab1Fragment();
            case 1: return new Tab2Fragment();
            }
        return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
