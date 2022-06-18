package com.delawar.app_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class web_viewActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web_view);
     /*   webView = findViewById(R.id.webview);
        String  webdata = "<html><body><h1>header1</h1> <h1><i>header1</i></h1></body></html>";
       // webView.loadData(webdata,"text/html", "UTF-8");
        webView.loadUrl("https://www.google.com");*/

       final ProgressDialog progressBar = new ProgressDialog(web_viewActivity.this);
        progressBar.setMessage("Please wait...");

        webView.loadUrl("https://www.facebook.com");

        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (!progressBar.isShowing()) {
                    progressBar.show();
                }
            }

            public void onPageFinished(WebView view, String url) {
                if (progressBar.isShowing()) {
                    progressBar.dismiss();
                }
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                if (progressBar.isShowing()) {
                    progressBar.dismiss();
                }
            }
        });

    }
}