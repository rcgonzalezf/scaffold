package com.lamcreations.scaffoldsampleapp;


import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.lamcreations.scaffold.common.activities.TabDrawerActivity;


public class SampleTabDrawerActivity extends TabDrawerActivity {

    @Override
    protected Fragment getLeftStartDrawerFragment() {
        return new SampleNavigationDrawerFragment();
    }

    @Override
    protected Fragment getRightEndDrawerFragment() {
        return null;
    }

    @Override
    protected int getTabMode() {
        return TabLayout.MODE_SCROLLABLE;
    }

    @Override
    protected PagerAdapter getPagerAdapter() {
        return new SampleTabPagerAdapter(getSupportFragmentManager());
    }

    @Override
    protected int getInitialTabPosition() {
        return 0;
    }

    @Override
    protected boolean setupFab() {
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mContentView, "Do Something Awesome!", Snackbar.LENGTH_SHORT).show();
            }
        });
        return true;
    }

    @Override
    protected void onUpNavigation() {
        ActivityCompat.finishAfterTransition(this);
    }
}