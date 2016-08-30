package com.demo.app.androidsdkdemo;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * Created by lishaojie on 16/8/29.
 */

public class X5WebViewActivity extends SystemWebActivity {
    private static final String TAG = X5WebViewActivity.class.getSimpleName();

    @Override
    void initWebView() {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.webview_load_progress);
        final WebView webView = (WebView) findViewById(R.id.x5_webview);
        webView.setVisibility(View.VISIBLE);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView webView, int i) {
                progressBar.setProgress(i);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                setTitle(title);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                result.confirm();
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    Log.i(TAG, "onPageFinished: " + url);
                }
            }
        });
        WebView.setWebContentsDebuggingEnabled(true);
        webView.loadUrl("http://dev.ufile.ucloud.cn/test.html");
    }
}
