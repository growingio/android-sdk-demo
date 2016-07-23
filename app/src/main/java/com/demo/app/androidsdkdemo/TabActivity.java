package com.demo.app.androidsdkdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import static com.demo.app.androidsdkdemo.FragmentConstants.CONTENTS;
import static com.demo.app.androidsdkdemo.FragmentConstants.IMAGES;

public class TabActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private static final String TAG = "TabActivity";

    private FirstPostFragment[] mFragments = new FirstPostFragment[]{
            new FirstPostFragment(), new SecondPostFragment(), new ThirdPostFragment()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        RadioGroup tabBar = (RadioGroup) findViewById(R.id.bottom_tab_bar);
        assert tabBar != null;
        tabBar.check(tabBar.getChildAt(0).getId());
        tabBar.setOnCheckedChangeListener(this);
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.add(R.id.fragment_container, mFragments[0]);
        trans.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int tabIndex = group.indexOfChild(group.findViewById(checkedId));
        Log.i(TAG, "onCheckedChanged: " + tabIndex);
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.fragment_container, mFragments[tabIndex]);
        trans.commit();
    }

    private static class AutoResizeCallback implements Callback {

        ImageView image;

        AutoResizeCallback(ImageView image) {
            this.image = image;
        }

        @Override
        public void onSuccess() {
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

    public static class FirstPostFragment extends Fragment {

        int getContentIndex() {
            return 0;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
            View content = inflater.inflate(R.layout.post_content, container, false);
            final ImageView image = (ImageView) content.findViewById(R.id.post_image);
            TextView text = (TextView) content.findViewById(R.id.post_text_content);
            Picasso.with(container.getContext()).load(IMAGES.get(getContentIndex())).into(image, new AutoResizeCallback(image));
            text.setText(CONTENTS.get(getContentIndex()));
            return content;
        }
    }

    public static class SecondPostFragment extends FirstPostFragment {

        int getContentIndex() {
            return 1;
        }
    }

    public static class ThirdPostFragment extends FirstPostFragment {

        int getContentIndex() {
            return 2;
        }
    }
}
