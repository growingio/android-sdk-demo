package com.demo.app.androidsdkdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class SystemWebActivity extends Activity {

    private static final String TAG = "SystemWebActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_web);
        WebView webView = (WebView) findViewById(R.id.sys_webview);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView webView, int i) {
                Log.i(TAG, "onProgressChanged: " + i);
            }
        });
        webView.loadUrl("https://blog.growingio.com");
    }
}
