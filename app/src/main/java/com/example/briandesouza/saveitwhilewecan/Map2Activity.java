package com.example.briandesouza.saveitwhilewecan;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class Map2Activity extends AppCompatActivity {

    WebView browserView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Removes the title bar in the application
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_map2_header);

        //Creation of the Webview found in the XML Layout file
        browserView = (WebView)findViewById(R.id.webkit);

        //Enable Javascripts
        browserView.getSettings().setJavaScriptEnabled(true);

        //Removes both vertical and horizontal scroll bars
        browserView.setVerticalScrollBarEnabled(false);
        browserView.setHorizontalScrollBarEnabled(false);

        //The website which is wrapped to the webview
        browserView.loadUrl("https://a.tiles.mapbox.com/v3/kamini.gol506en/mm/zoompan,zoomwheel.html?secure=1#3/3.34/-133.95");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Map2Activity.this, MapActivity.class);
                startActivity(i);
            }
        });

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar10);
        bottomBar.setDefaultTab(R.id.tab_map);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {
                    Intent i = new Intent(Map2Activity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                } else if (tabId == R.id.tab_daily) {
                    Intent i = new Intent(Map2Activity.this, DailyInputActivity.class);
                    startActivity(i);
                    finish();
                } else if (tabId == R.id.tab_monthly) {
                    Intent i = new Intent(Map2Activity.this, MonthlyInputActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });

    }
}
