package com.example.gopal.nfa;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Gopal on 10/30/2018.
 */

public class CustomViewPagerAdapter extends FragmentPagerAdapter {
    public CustomViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            String Url = "https://content.guardianapis.com/search?q=tech&api-key=d71aed14-2fe8-42ca-b962-a9c3794f5049&show-fields=thumbnail";

            Bundle bundle = new Bundle();
            MasterFragment weatherFragment = new MasterFragment();
            bundle.putInt("key",position);
            weatherFragment.setArguments(bundle);
            return weatherFragment;
        }
        else {
            return new MasterFragment();
        }

    }

    @Override
    public int getCount() {
        return 5;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "SPORTS";
        }
        else if (position == 1) {
            return "ENTERTAINMENT";
        }
        else if (position == 2) {
            return "TECH";
        }
        else if (position == 3) {
            return "POLITICS";
        }
        else {
            return "LIFESTYLE";
        }
    }

}
