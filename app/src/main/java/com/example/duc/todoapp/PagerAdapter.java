package com.example.duc.todoapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Duc on 26/10/16.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int numTabs;

    public PagerAdapter(FragmentManager fm, int numOfTabs)
    {
        super(fm);
        this.numTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch(position)
        {
            case 0:
                ToDoListFragment tab1 = new ToDoListFragment();
                return tab1;
            case 1:
                StatisticsFragment tab2 = new StatisticsFragment();
                return tab2;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
