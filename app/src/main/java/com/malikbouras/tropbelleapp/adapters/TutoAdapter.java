package com.malikbouras.tropbelleapp.adapters;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.malikbouras.tropbelleapp.R;
import com.malikbouras.tropbelleapp.fragments.TutoFragment;

/**
 *
 */

public class TutoAdapter extends FragmentPagerAdapter {

    public TutoAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return TutoFragment.newInstance(R.color.deep_purple_500, position); // blue
            case 1:
                return TutoFragment.newInstance(R.color.cyan_500, position); // blue
            case 2:
                return TutoFragment.newInstance(R.color.blue_500, position); // blue
            default:
                return TutoFragment.newInstance(R.color.indigo_500, position); // green
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

}