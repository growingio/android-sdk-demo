package com.demo.app.androidsdkdemo.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import com.tencent.smtt.sdk.WebView;

import java.util.Map;

/**
 * Created by lishaojie on 16/8/29.
 */

public class CustomWebView extends WebView {
    private static final String TAG = CustomWebView.class.getSimpleName();

    public CustomWebView(Context context) {
        super(context);
    }

    public CustomWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i, boolean b) {
        super(context, attributeSet, i, b);
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i, Map<String, Object> map, boolean b) {
        super(context, attributeSet, i, map, b);
    }


    @Override
    public void loadUrl(String s) {
        super.loadUrl(s);
        Log.i(TAG, "loadUrl: " + s);
    }
}
