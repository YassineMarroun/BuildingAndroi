package com.yassine.app_intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        wv1 = (WebView)findViewById(R.id.wv1);

        String URL = getIntent().getStringExtra("website");
        wv1.setWebViewClient(new WebViewClient());
        wv1.loadUrl("http://" + URL);
    }

    //Close button method
    public void Close(View view) {
        finish();
    }
}