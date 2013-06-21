package com.yammer.samples.oauth;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OAuthLoginActivity extends Activity {
	
	// UI references.
    private WebView mWebView;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_oauth_login);
		
		WebView mWebView = new WebView(this);
        setContentView(mWebView);

        mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                // do your handling codes here, which url is the requested url
                // probably you need to open that url rather than redirect:
                view.loadUrl(url);
                return false; // then it is not handled by default action
            }
        });

        mWebView.loadUrl("https://www.thunderdome.yammer.com/dialog/authenticate?client_id=CudAH4tRNP6UP6P9FuAJg");
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.oauth_login, menu);
		return true;
	}

}
