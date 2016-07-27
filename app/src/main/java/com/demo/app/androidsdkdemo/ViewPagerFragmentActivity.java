package com.demo.app.androidsdkdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.demo.app.androidsdkdemo.fragment.FirstPostFragment;
import com.growingio.android.sdk.collection.GrowingIO;

public class ViewPagerFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_fragment);
        ViewPager pager = (ViewPager) findViewById(R.id.pager_fragment);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                GrowingIO growingio = GrowingIO.getInstance();
                switch (position) {
                    case 0: {
                        Fragment frag = new FirstPostFragment();
                        frag.setUserVisibleHint(true);
                        growingio.setPageGroup(frag, "P" + position);
                        growingio.setPS1(frag, "postid" + position);
                        return frag;
                    }

                    case 1: {
                        Fragment frag = new FirstPostFragment();
                        frag.setUserVisibleHint(true);
                        growingio.setPageGroup(frag, "P" + position);
                        growingio.setPS1(frag, "postid" + position);
                        return frag;
                    }

                    case 2: {
                        Fragment frag = new FirstPostFragment();
                        frag.setUserVisibleHint(true);
                        growingio.setPageGroup(frag, "P" + position);
                        growingio.setPS1(frag, "postid" + position);
                        return frag;
                    }

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
