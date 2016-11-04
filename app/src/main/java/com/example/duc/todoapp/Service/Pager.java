package com.example.duc.todoapp.Service;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.duc.todoapp.Fragment.StatisticsFragment;
import com.example.duc.todoapp.Fragment.ToDoListFragment;

/**
 * Created by Duc on 26/10/16.
 */

public class Pager extends FragmentStatePagerAdapter {

    private StatisticsFragment statisticsFragment;

    public StatisticsFragment getStatisticsFragment() {
        return statisticsFragment;
    }

    public void setStatisticsFragment(StatisticsFragment statisticsFragment) {
        this.statisticsFragment = statisticsFragment;
    }

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                ToDoListFragment tab1 = new ToDoListFragment();
                return tab1;
            case 1:
                //StatisticsFragment tab2 = new StatisticsFragment();
                statisticsFragment = new StatisticsFragment();
                return statisticsFragment;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }


}
