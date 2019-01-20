package emremedia.com.nbasonuclar.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.Collections;

import emremedia.com.nbasonuclar.Common.Common;

public class MainFragmentPagerAdapter extends FragmentStatePagerAdapter {
    public MainFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        MainFragment mainFragment=new MainFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("day",position);
        mainFragment.setArguments(bundle);

        return mainFragment;
    }

    @Override
    public int getCount() {
        return Common.oneWeekMatches.size();
    }
}
