package com.demo.app.androidsdkdemo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class SystemWebActivity extends AppCompatActivity {

    private static final String TAG = "SystemWebActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_web);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.webview_load_progress);
        final WebView webView = (WebView) findViewById(R.id.sys_webview);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView webView, int i) {
                progressBar.setProgress(i);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                setTitle(title);
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
//                    view.evaluateJavascript("document.body.clientHeight", new ValueCallback<String>() {
//                        @Override
//                        public void onReceiveValue(String value) {
//                            Log.i(TAG, "onReceiveValue: clientHeight = " + value);
//                            webView.getLayoutParams().height = Integer.valueOf(value);
//                            webView.requestLayout();
//                        }
//                    });
                }
            }
        });
//        webView.loadUrl("https://blog.growingio.com");
        webView.loadUrl("http://dev.ufile.ucloud.cn/test.html");
    }
}
