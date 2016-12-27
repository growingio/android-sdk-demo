package com.demo.app.androidsdkdemo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class SystemWebActivity extends AppCompatActivity {

    private static final String TAG = "SystemWebActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_web);
        initWebView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        WebView webView = (WebView) findViewById(R.id.sys_webview);
        if (webView != null) {
            webView.destroy();
        }
    }

    void initWebView() {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.webview_load_progress);
        final WebView webView = (WebView) findViewById(R.id.sys_webview);
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
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                result.confirm();
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
                Log.i(TAG, "onPageFinished: " + url);
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webView.setWebContentsDebuggingEnabled(true);
        }
        webView.loadUrl("http://dev.ufile.ucloud.cn/test.html");
    }
}
