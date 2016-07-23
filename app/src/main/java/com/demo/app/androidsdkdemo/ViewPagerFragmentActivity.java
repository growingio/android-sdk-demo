package com.demo.app.androidsdkdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewPagerFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_fragment);
        ViewPager pager = (ViewPager) findViewById(R.id.pager_fragment);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new TabActivity.FirstPostFragment();
                    case 1:
                        return new TabActivity.SecondPostFragment();
                    case 2:
                        return new TabActivity.ThirdPostFragment();
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
    }
}
