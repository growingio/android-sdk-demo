package com.demo.app.androidsdkdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class SystemWebActivity extends AppCompatActivity {

    private static final String TAG = "SystemWebActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_web);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.webview_load_progress);
        WebView webView = (WebView) findViewById(R.id.sys_webview);
        webView.setWebChromeClient(new WebChromeClient() {
                                       @Override
                                       public void onProgressChanged(WebView webView, int i) {
                                           progressBar.setProgress(i);
                                       }

                                       @Override
                                       public void onReceivedTitle(WebView view, String title) {
                                           setTitle(title);
                                       }

                                   }
        );
        webView.loadUrl("https://blog.growingio.com");
    }
}
