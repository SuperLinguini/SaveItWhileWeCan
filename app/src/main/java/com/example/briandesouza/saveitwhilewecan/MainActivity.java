package com.example.briandesouza.saveitwhilewecan;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    Intent i;
    private TextView overallButton, toButton, monthButton, tipBoxButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overallButton = (TextView) findViewById(R.id.overallScore);
        toButton = (TextView) findViewById(R.id.todayScore);
        monthButton = (TextView) findViewById(R.id.monthScore);
        tipBoxButton = (TextView) findViewById(R.id.tipBox);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {

                } else if (tabId == R.id.tab_todo) {
                    /*Intent i = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();*/
                } else if (tabId == R.id.tab_daily) {
                    // The tab with id R.id.tab_favorites was selected,
                    // change your content accordingly.
                } else if (tabId == R.id.tab_monthly) {
                    // The tab with id R.id.tab_favorites was selected,
                    // change your content accordingly.
                }
            }
        });

    }


}
