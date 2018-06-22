package com.example.laz3r.emergencymedicalapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainViewPagerAdapter extends FragmentPagerAdapter
{

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> fragmentTitles = new ArrayList<>();
    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


    public void addFrag(Fragment fragment, String title) {
        fragments.add(fragment);
        fragmentTitles.add(title);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
}
