package com.demo.app.androidsdkdemo;

import android.annotation.TargetApi;
import android.app.Application;
import android.os.Build;

import com.growingio.android.sdk.collection.ActivityLifecycleCallbacksRegistrar;
import com.growingio.android.sdk.collection.Configuration;
import com.growingio.android.sdk.collection.GrowingIO;

/**
 * Created by lishaojie on 16/7/16.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        GrowingIO.startWithConfiguration(this, new Configuration(BuildConfig.GrowingIOProjectID)
                .setURLScheme(BuildConfig.GrowingIOURLScheme)
                .useID()
                .trackAllFragments()
                .setDebugMode(true)
        .setActivityLifecycleCallbacksRegistrar(new ActivityLifecycleCallbacksRegistrar() {
            @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
            @Override
            public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
                MyApplication.this.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }

            @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
            @Override
            public void unRegisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
                MyApplication.this.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        }));
    }
}
