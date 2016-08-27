package com.demo.app.androidsdkdemo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.growingio.android.sdk.collection.Configuration;
import com.growingio.android.sdk.collection.GrowingIO;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by lishaojie on 16/7/16.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        GrowingIO.startWithConfiguration(this, new Configuration()
                .useID()
                .trackAllFragments()
                .setDebugMode(true)
                .setThrottle(true)
                .setChannel("IEIE"));
        initFloatView();
    }

    private void initFloatView() {
        final View floatingView = LayoutInflater.from(this).inflate(R.layout.simle_item, null);

        int flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;

        final WindowManager.LayoutParams maskParams = new WindowManager.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_TOAST, flags, PixelFormat.TRANSLUCENT);
        maskParams.gravity = Gravity.TOP | Gravity.LEFT;
        maskParams.width = 500;
        maskParams.height = 220;
        maskParams.x = 0;
        maskParams.y = getResources().getDisplayMetrics().heightPixels / 2 + maskParams.height;
        maskParams.setTitle("TestFloatingView");
        floatingView.setLayoutParams(maskParams);
        TextView textView = new TextView(this);
        textView.setText("悬浮窗");
        ((ViewGroup) floatingView.findViewById(R.id.cardView)).addView(textView);
        final WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        windowManager.addView(floatingView, maskParams);

        floatingView.findViewById(R.id.cardView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                windowManager.removeView(floatingView);
            }
        });

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                if (floatingView.getParent() != null) {
                    floatingView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onActivityPaused(Activity activity) {
                if (floatingView.getParent() != null) {
                    floatingView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
