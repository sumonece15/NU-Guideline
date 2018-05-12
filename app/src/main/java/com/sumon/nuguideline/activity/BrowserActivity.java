package com.sumon.nuguideline.activity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sumon.nuguideline.R;
import com.sumon.nuguideline.utils.InternetConnectionCheck;

public class BrowserActivity extends AppCompatActivity {

    WebView wvBrowser;
    TextView tvEmpty;
    ProgressBar pbLoader;
    SwipeRefreshLayout mySwipeRefreshLayout;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        wvBrowser = findViewById(R.id.wv_browser);
        tvEmpty = findViewById(R.id.tv_empty);
        pbLoader = findViewById(R.id.pb_loader);
        mySwipeRefreshLayout = findViewById(R.id.swipeContainer);

        int itemPosition;
        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            itemPosition= 0;
        } else {
            itemPosition= extras.getInt("itemPosition");
        }

        loadWebsite(itemPosition);
    }

    private void loadWebsite(int itemPosition) {

        if (!InternetConnectionCheck.checkInternetConnection(this)){
            tvEmpty.setVisibility(View.VISIBLE);
            wvBrowser.setVisibility(View.GONE);
        }else{

            String url = null;
            if (itemPosition == 0){
                url ="http://ist.edu.bd/";
            }
            else if(itemPosition == 1){

                url = "http://istt.edu.bd/";
            }
            else if(itemPosition == 2){

                url = "https://bist.edu.bd/";
            }
            else if(itemPosition == 10){

                url = "http://nubd.info/prof/apply/";

            }
            else if(itemPosition == 11){

                url = "http://www.nu.edu.bd/nu-home/index.php?option=com_content&view=category&id=107&Itemid=2337";

            }


            wvBrowser.getSettings().setJavaScriptEnabled(true);
            wvBrowser.getSettings().setBuiltInZoomControls(true);
            wvBrowser.getSettings().setDisplayZoomControls(false);
            wvBrowser.setWebViewClient(new CustomWebClient());
            wvBrowser.loadUrl(url);

            mySwipeRefreshLayout.setOnRefreshListener(
                    new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            wvBrowser.reload();
                            mySwipeRefreshLayout.setRefreshing(false);
                        }
                    }
            );
        }

    }


    public class CustomWebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
            pbLoader.setVisibility(View.VISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            pbLoader.setVisibility(View.VISIBLE);
            mySwipeRefreshLayout.setVisibility(View.GONE);
            tvEmpty.setVisibility(View.GONE);
            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);

            pbLoader.setVisibility(View.GONE);
            mySwipeRefreshLayout.setVisibility(View.VISIBLE);
        }
    }

   /* @Override
    public void onBackPressed() {
        wvBrowser.goBack();
    }*/
   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
       onBackPressed();
       return true;
   }
}
