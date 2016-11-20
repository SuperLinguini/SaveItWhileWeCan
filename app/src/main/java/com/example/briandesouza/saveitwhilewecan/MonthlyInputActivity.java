package com.example.briandesouza.saveitwhilewecan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.View;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import android.net.Uri;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.briandesouza.saveitwhilewecan.R.drawable.beef;
import static com.example.briandesouza.saveitwhilewecan.R.drawable.bike;
import static com.example.briandesouza.saveitwhilewecan.R.drawable.bus;
import static com.example.briandesouza.saveitwhilewecan.R.drawable.car;
import static com.example.briandesouza.saveitwhilewecan.R.drawable.chicken;
import static com.example.briandesouza.saveitwhilewecan.R.drawable.pork;
import static com.example.briandesouza.saveitwhilewecan.R.id.submitBtnMonthly;
import static com.example.briandesouza.saveitwhilewecan.R.id.submitDailyBtn;

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

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar4);
        bottomBar.setDefaultTab(R.id.tab_monthly);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
            if (tabId == R.id.tab_home) {
                Intent i = new Intent(MonthlyInputActivity.this, MainActivity.class);
                startActivity(i);
                finish();
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

        final EditText household = (EditText) findViewById(R.id.houseSize);
        final EditText energy = (EditText) findViewById(R.id.energyConsumption);
        final EditText water = (EditText) findViewById(R.id.waterConsumption);
        final EditText flights = (EditText) findViewById(R.id.flightsAmt);
        final EditText trash = (EditText) findViewById(R.id.trashBag);
        final EditText recycle = (EditText) findViewById(R.id.recycleBag);
        final EditText donation1 = (EditText) findViewById(R.id.donationAmtNRDC);
        final EditText donation2 = (EditText) findViewById(R.id.donationAmtSierra);
        final EditText donation3 = (EditText) findViewById(R.id.donationAmtCarbon);

        final TextView submit = (TextView) findViewById(submitBtnMonthly);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(household.getText().toString().equals("") || energy.getText().toString().equals("") || water.getText().toString().equals("") ||
                        flights.getText().toString().equals("") || trash.getText().toString().equals("") || recycle.getText().toString().equals("") ||
                        donation1.getText().toString().equals("") || donation2.getText().toString().equals("") || donation3.getText().toString().equals(""))
                {
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    // Vibrate for 250 milliseconds
                    v.vibrate(250);

                    Toast toast = Toast.makeText(MonthlyInputActivity.this,
                            "Please Enter A Value for All Options", Toast.LENGTH_LONG);
                    TextView view2 = (TextView) toast.getView().findViewById(android.R.id.message);
                    view2.setTextColor(Color.rgb(241,91,64));
                    toast.show();
                } else {
                    int score = getMonthlyScore(Double.parseDouble(household.getText().toString()), Double.parseDouble(flights.getText().toString()),
                            Double.parseDouble(trash.getText().toString()), Double.parseDouble(recycle.getText().toString()),
                            Double.parseDouble(energy.getText().toString()), Double.parseDouble(water.getText().toString()),
                            Double.parseDouble(donation1.getText().toString()), Double.parseDouble(donation2.getText().toString()),
                            Double.parseDouble(donation3.getText().toString()));

                    SharedPreferences sharedPref = getSharedPreferences(getString(R.string.pref),
                            Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putInt(getString(R.string.saved_monthly_score), score);
                    editor.commit();

                    Intent i = new Intent(MonthlyInputActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        });
    }

    private int getMonthlyScore(double household, double flights, double trash, double recycle, double energy,
                                double water, double donation1, double donation2, double donation3)
    {
        double monthlyscore=0;

        //max score is 450
        energy= energy/household;
        water= water/ household;
        trash= trash/ household;
        recycle= recycle/ household;
        double donation = donation1+ donation2+ donation3;

        if(energy>=1300)
            monthlyscore +=0;
        else if(energy <1300 && energy > 1150)
            monthlyscore +=1;
        else if( energy <= 1150 && energy > 1000)
            monthlyscore += 2;
        else if(energy <= 1000 && energy > 850 )
            monthlyscore += 3;
        else if(energy <=850 && energy > 650)
            monthlyscore += 4;
        else
            monthlyscore +=5;

        if(water> 3500)
            monthlyscore +=0;
        else if(water <= 3500 && water > 3200)
            monthlyscore +=1;
        else if( water <= 2000 && water > 1700)
            monthlyscore += 2;
        else if(energy <= 1700 && water > 1500 )
            monthlyscore += 3;
        else if(water <= 1500 && water > 1300)
            monthlyscore += 4;
        else
            monthlyscore +=5;

        if(trash> 6)
            monthlyscore +=0;
        else if(trash == 5)
            monthlyscore +=1;
        else if( trash==4 )
            monthlyscore += 2;
        else if(trash ==3 )
            monthlyscore += 3;
        else if(trash ==2 )
            monthlyscore += 4;
        else
            monthlyscore +=5;

        if(recycle==0)
            monthlyscore +=0;
        else if(recycle == 1)
            monthlyscore +=3;
        else if( recycle== 2)
            monthlyscore += 4;
        else
            monthlyscore += 5;

        if(flights >= 3)
            monthlyscore +=0;
        else if(flights == 2)
            monthlyscore += 2;
        else if(flights ==1 )
            monthlyscore += 3;
        else if(flights==0 )
            monthlyscore += 5;

        if(donation >= 15)
            monthlyscore += 6;
        else if(donation > 15 && donation >=10)
            monthlyscore +=5;
        else if(donation > 10 && donation >= 5)
            monthlyscore +=4;
        else
            monthlyscore +=3;
        System.out.println("" + monthlyscore);
        monthlyscore= monthlyscore * 100.0/30.0;

        if(monthlyscore > 100)
            monthlyscore= monthlyscore - (monthlyscore - 100);
        System.out.println("" + monthlyscore);
        return (int) monthlyscore;
    }
}
