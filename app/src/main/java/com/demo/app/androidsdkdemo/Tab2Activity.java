package com.demo.app.androidsdkdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

public class Tab2Activity extends TabActivity {

    protected void switchTab(int tabIndex) {
        mCurrentFragment.setUserVisibleHint(false);
        Fragment targetFragment = mFragments[tabIndex];
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (targetFragment.isAdded()) {
            transaction.show(targetFragment).hide(mCurrentFragment);
            targetFragment.setUserVisibleHint(true);
        } else {
            transaction.add(R.id.fragment_container, targetFragment).hide(mCurrentFragment);
        }
        transaction.commit();
        mCurrentFragment = targetFragment;
    }

}
