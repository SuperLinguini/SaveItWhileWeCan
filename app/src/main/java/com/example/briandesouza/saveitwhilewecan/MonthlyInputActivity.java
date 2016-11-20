package com.example.briandesouza.saveitwhilewecan;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MonthlyInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_input);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setDefaultTab(R.id.tab_monthly);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {
                    Intent i = new Intent(MonthlyInputActivity.this, MainActivity.class);
                    startActivity(i);
                } else if (tabId == R.id.tab_todo) {
                    /*Intent i = new Intent(MonthlyInputActivity.this, MainActivity.class);
                    startActivity(i);*/
                } else if (tabId == R.id.tab_daily) {
                    Intent i = new Intent(MonthlyInputActivity.this, DailyInputActivity.class);
                    startActivity(i);
                } else if (tabId == R.id.tab_monthly) {

                }
            }
        });
    }
}
