package ajiet.ise.postalinfoapp;


import android.icu.text.CaseMap;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class viewPagerAdapter extends FragmentPagerAdapter {

    public viewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new PROFILE();
            case 1: return new SCHEMES();
            case 2: return new LOCATION();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position){
        switch (position)
        {
            case 0:return "SERVICES";
            case 1:return "SCHEMES";
            case 2:return "CALCULATOR";

        }
        return null;
    }
}