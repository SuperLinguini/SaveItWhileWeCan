package com.example.briandesouza.saveitwhilewecan;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import android.net.Uri;

public class MonthlyInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_input);

        ImageView img = (ImageView)findViewById(R.id.nrdcImg);
        img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://secure.nrdconline.org/site/Donation2?df_id=16182&mfc_pref=T&16182.donation=form1&s_src=MRSENRDC116&utm_source=mrad&utm_medium=web"));
                startActivity(intent);
            }
        });

        ImageView img2 = (ImageView)findViewById(R.id.sierraImg);
        img2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://sierra.secure.force.com/donate/rc_connect__campaign_designform?id=70131000001LmZIAA0&formcampaignid=70131000001Lm6aAAC&_ga=1.145506807.2125554356.1479512825#!form=00P3100000TZkiLEAT"));
                startActivity(intent);
            }
        });

        ImageView img3 = (ImageView)findViewById(R.id.carbonImg);
        img3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://carbonfund.org/product/general-donation/"));
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar4);
        bottomBar.setDefaultTab(R.id.tab_monthly);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {
                    Intent i = new Intent(MonthlyInputActivity.this, MainActivity.class);
                    startActivity(i);
                } else if (tabId == R.id.tab_map) {
                    Intent i = new Intent(MonthlyInputActivity.this, MapActivity.class);
                    startActivity(i);
                    finish();
                } else if (tabId == R.id.tab_daily) {
                    Intent i = new Intent(MonthlyInputActivity.this, DailyInputActivity.class);
                    startActivity(i);
                    finish();
                } else if (tabId == R.id.tab_monthly) {

                }
            }
        });
    }
}
