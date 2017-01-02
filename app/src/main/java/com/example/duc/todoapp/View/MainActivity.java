package com.example.duc.todoapp.View;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.duc.todoapp.Service.Pager;
import com.example.duc.todoapp.R;

/**
 * Main Class of the application
 */
public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;

    private ViewPager viewPager;

    private Pager adapter;

    /**
     * Initialize the views
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.ToDo)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.Statistics)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.pager);

        adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(this);
    }

    /**
     * Set the correct tab by clicking on a tab on the ui
     * @param tab
     */
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition(), true);

        if (tab.getPosition() == 1) {
            viewPager.getAdapter().notifyDataSetChanged();

            adapter.getStatisticsFragment().onResume();

            System.out.println("CLICKED");
        }

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

}
