package com.demo.app.androidsdkdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

public class Tab2Activity extends TabActivity {

    protected void switchTab(int tabIndex) {
        Fragment targetFragment = mFragments[tabIndex];
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (targetFragment.isAdded()) {
            transaction.hide(mCurrentFragment).show(targetFragment);
        } else {
            transaction.add(R.id.fragment_container, targetFragment).hide(mCurrentFragment);
        }
        transaction.commit();
        mCurrentFragment = targetFragment;
    }

}
