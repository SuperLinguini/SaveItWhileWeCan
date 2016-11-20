package com.example.briandesouza.saveitwhilewecan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import org.w3c.dom.Text;

import static com.example.briandesouza.saveitwhilewecan.R.id.bottomBar;
import static com.example.briandesouza.saveitwhilewecan.R.id.bottomBar2;
import static com.example.briandesouza.saveitwhilewecan.R.id.noBtnBeefLamb;
import static com.example.briandesouza.saveitwhilewecan.R.id.yesBtnBeefLamb;


public class DailyInputActivity extends AppCompatActivity {

    int beef = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_input);

        final TextView yesBeef = (TextView) findViewById(yesBtnBeefLamb);
        final TextView noBeef = (TextView) findViewById(noBtnBeefLamb);

        yesBeef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beef = 1;
                yesBeef.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, null));
                noBeef.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
            }
        });

        noBeef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beef = 0;
                noBeef.setBackgroundColor(0xFFAA0000);
                yesBeef.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
            }
        });


        BottomBar bottomBar = (BottomBar) findViewById(bottomBar2);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {
                    /*Intent i = new Intent(DailyInputActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();*/
                } else if (tabId == R.id.tab_todo) {

                } else if (tabId == R.id.tab_daily) {

                } else if (tabId == R.id.tab_monthly) {
                    // The tab with id R.id.tab_favorites was selected,
                    // change your content accordingly.
                }
            }
        });


    }

}
