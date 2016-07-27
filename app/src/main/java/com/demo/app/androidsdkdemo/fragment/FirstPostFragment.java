package com.demo.app.androidsdkdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.app.androidsdkdemo.R;
import com.demo.app.androidsdkdemo.TabActivity;
import com.squareup.picasso.Picasso;

import static com.demo.app.androidsdkdemo.fragment.FragmentConstants.CONTENTS;
import static com.demo.app.androidsdkdemo.fragment.FragmentConstants.IMAGES;

/**
 * Created by lishaojie on 16/7/27.
 */

public class FirstPostFragment extends Fragment {

    int getContentIndex() {
        return 0;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View content = inflater.inflate(R.layout.post_content, container, false);
        final ImageView image = (ImageView) content.findViewById(R.id.post_image);
        TextView text = (TextView) content.findViewById(R.id.post_text_content);
        Picasso.with(container.getContext()).load(IMAGES.get(getContentIndex())).into(image, new TabActivity.AutoResizeCallback(image));
        text.setText(CONTENTS.get(getContentIndex()));
        return content;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

}
