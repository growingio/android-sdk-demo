package com.demo.app.androidsdkdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.demo.app.androidsdkdemo.fragment.FirstPostFragment;
import com.demo.app.androidsdkdemo.fragment.SecondPostFragment;
import com.demo.app.androidsdkdemo.fragment.ThirdPostFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lishaojie on 16/9/20.
 */

public class TabLayoutFragmentActivity extends AppCompatActivity {
    private static final String TAG = "TabLayoutActivity";
    @Bind(R.id.top_tab_bar)
    TabLayout tabBar;
    @Bind(R.id.pager_fragment)
    ViewPager pager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout_fragment);
        ButterKnife.bind(this);
        pager = (ViewPager) findViewById(R.id.pager_fragment);
        pager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0: {
                        return new FirstPostFragment();
                    }

                    case 1: {
                        return new SecondPostFragment();
                    }

                    case 2: {
                        return new ThirdPostFragment();
                    }

                    default:
                        return null;
                }
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }

            String[] titles = new String[]{"Saas全面爆发", "LinkedIn被收购", "数据采集"};

            @Override
            public int getCount() {
                return 3;
            }
        });
        pager.setOffscreenPageLimit(3);
        tabBar.setupWithViewPager(pager);
        tabBar.setTabTextColors(Color.WHITE, Color.WHITE);
    }
}
