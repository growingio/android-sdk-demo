package com.demo.app.androidsdkdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.demo.app.androidsdkdemo.fragment.FirstPostFragment;
import com.demo.app.androidsdkdemo.fragment.SecondPostFragment;
import com.demo.app.androidsdkdemo.fragment.ThirdPostFragment;
import com.squareup.picasso.Callback;

import java.lang.ref.WeakReference;

public class TabActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private static final String TAG = "TabActivity";

    protected FirstPostFragment[] mFragments = new FirstPostFragment[]{
            new FirstPostFragment(), new SecondPostFragment(), new ThirdPostFragment()
    };
    protected Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        RadioGroup tabBar = (RadioGroup) findViewById(R.id.bottom_tab_bar);
        assert tabBar != null;
        tabBar.check(tabBar.getChildAt(0).getId());
        tabBar.setOnCheckedChangeListener(this);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mFragments[0]).commit();
        mCurrentFragment = mFragments[0];
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int tabIndex = group.indexOfChild(group.findViewById(checkedId));
        Log.i(TAG, "onCheckedChanged: " + tabIndex);
        switchTab(tabIndex);
    }

    protected void switchTab(int tabIndex) {
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.fragment_container, mFragments[tabIndex]);
        trans.commit();
    }

    public static class AutoResizeCallback implements Callback {

        WeakReference<ImageView> imageRef;

        public AutoResizeCallback(ImageView image) {
            this.imageRef = new WeakReference<ImageView>(image);
        }

        @Override
        public void onSuccess() {
            ImageView image = imageRef.get();
            if (image == null) return;
            int width = image.getDrawable().getIntrinsicWidth();
            int height = image.getDrawable().getIntrinsicHeight();
            float scale = 1.f * image.getResources().getDisplayMetrics().widthPixels / width;
            ViewGroup.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (height * scale));
            image.setLayoutParams(params);
        }

        @Override
        public void onError() {

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setTitle("bug #711");
        return super.onOptionsItemSelected(item);
    }
}
