package com.example.briandesouza.saveitwhilewecan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.content.Context;
import android.widget.Toast;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.graphics.Color;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import org.w3c.dom.Text;

import static android.app.PendingIntent.getActivity;
import static com.example.briandesouza.saveitwhilewecan.R.id.bottomBar;
import static com.example.briandesouza.saveitwhilewecan.R.id.bottomBar2;
import static com.example.briandesouza.saveitwhilewecan.R.id.noBtnBeefLamb;
import static com.example.briandesouza.saveitwhilewecan.R.id.noBtnBikeWalk;
import static com.example.briandesouza.saveitwhilewecan.R.id.noBtnBus;
import static com.example.briandesouza.saveitwhilewecan.R.id.noBtnCar;
import static com.example.briandesouza.saveitwhilewecan.R.id.noBtnChickenFish;
import static com.example.briandesouza.saveitwhilewecan.R.id.noBtnDairy;
import static com.example.briandesouza.saveitwhilewecan.R.id.noBtnFruitsVeggies;
import static com.example.briandesouza.saveitwhilewecan.R.id.noBtnPorkTurkey;
import static com.example.briandesouza.saveitwhilewecan.R.id.noBtnProcessedFood;
import static com.example.briandesouza.saveitwhilewecan.R.id.submitDailyBtn;
import static com.example.briandesouza.saveitwhilewecan.R.id.yesBtnBeefLamb;
import static com.example.briandesouza.saveitwhilewecan.R.id.yesBtnBikeWalk;
import static com.example.briandesouza.saveitwhilewecan.R.id.yesBtnBus;
import static com.example.briandesouza.saveitwhilewecan.R.id.yesBtnCar;
import static com.example.briandesouza.saveitwhilewecan.R.id.yesBtnChickenFish;
import static com.example.briandesouza.saveitwhilewecan.R.id.yesBtnDairy;
import static com.example.briandesouza.saveitwhilewecan.R.id.yesBtnFruitsVeggies;
import static com.example.briandesouza.saveitwhilewecan.R.id.yesBtnPorkTurkey;
import static com.example.briandesouza.saveitwhilewecan.R.id.yesBtnProcessedFood;


public class DailyInputActivity extends AppCompatActivity {

    int beef = -1;
    int chicken = -1;
    int fruits = -1;
    int dairy = -1;
    int pork = -1;
    int processed = -1;
    int bike = -1;
    int car = -1;
    int bus = -1;

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
                yesBeef.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
                noBeef.setBackgroundColor(0xFFAA0000);
            }
        });

        final TextView yesChicken = (TextView) findViewById(yesBtnChickenFish);
        final TextView noChicken = (TextView) findViewById(noBtnChickenFish);

        yesChicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chicken = 1;
                yesChicken.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, null));
                noChicken.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
            }
        });

        noChicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chicken = 0;
                yesChicken.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
                noChicken.setBackgroundColor(0xFFAA0000);
            }
        });

        final TextView yesFruits = (TextView) findViewById(yesBtnFruitsVeggies);
        final TextView noFruits = (TextView) findViewById(noBtnFruitsVeggies);

        yesFruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fruits = 1;
                yesFruits.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, null));
                noFruits.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
            }
        });

        noFruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fruits = 0;
                yesFruits.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
                noFruits.setBackgroundColor(0xFFAA0000);
            }
        });

        final TextView yesDairy = (TextView) findViewById(yesBtnDairy);
        final TextView noDairy = (TextView) findViewById(noBtnDairy);

        yesDairy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dairy = 1;
                yesDairy.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, null));
                noDairy.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
            }
        });

        noDairy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dairy = 0;
                yesDairy.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
                noDairy.setBackgroundColor(0xFFAA0000);
            }
        });

        final TextView yesPork = (TextView) findViewById(yesBtnPorkTurkey);
        final TextView noPork = (TextView) findViewById(noBtnPorkTurkey);

        yesPork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pork = 1;
                yesPork.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, null));
                noPork.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
            }
        });

        noPork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pork = 0;
                yesPork.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
                noPork.setBackgroundColor(0xFFAA0000);
            }
        });

        final TextView yesProcessed = (TextView) findViewById(yesBtnProcessedFood);
        final TextView noProcessed = (TextView) findViewById(noBtnProcessedFood);

        yesProcessed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processed = 1;
                yesProcessed.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, null));
                noProcessed.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
            }
        });

        noProcessed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processed = 0;
                yesProcessed.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
                noProcessed.setBackgroundColor(0xFFAA0000);
            }
        });

        final TextView yesBike = (TextView) findViewById(yesBtnBikeWalk);
        final TextView noBike = (TextView) findViewById(noBtnBikeWalk);

        yesBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bike = 1;
                yesBike.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, null));
                noBike.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
            }
        });

        noBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bike = 0;
                yesBike.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
                noBike.setBackgroundColor(0xFFAA0000);
            }
        });

        final TextView yesCar = (TextView) findViewById(yesBtnCar);
        final TextView noCar = (TextView) findViewById(noBtnCar);

        yesCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                car = 1;
                yesCar.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, null));
                noCar.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
            }
        });

        noCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                car = 0;
                yesCar.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
                noCar.setBackgroundColor(0xFFAA0000);
            }
        });

        final TextView yesBus = (TextView) findViewById(yesBtnBus);
        final TextView noBus = (TextView) findViewById(noBtnBus);

        yesBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bus = 1;
                yesBus.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, null));
                noBus.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
            }
        });

        noBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bus = 0;
                yesBus.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_dark_background, null));
                noBus.setBackgroundColor(0xFFAA0000);
            }
        });

        final TextView submit = (TextView) findViewById(submitDailyBtn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bus != -1 && car != -1 && bike != -1 && processed != -1 && pork != -1 && dairy != -1 && fruits != -1 && chicken != -1 && beef != -1) {
                    int score = getScore(beef, chicken, fruits, dairy, pork, processed, bike, car, bus);
                    Intent i = new Intent(DailyInputActivity.this, MainActivity.class);
                    System.out.println("" + score);
                    i.putExtra("score", score);
                    startActivity(i);
                    finish();
                } else {
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    // Vibrate for 250 milliseconds
                    v.vibrate(250);

                    Toast toast = Toast.makeText(DailyInputActivity.this,
                            "Please Enter Yes or No for All Options", Toast.LENGTH_LONG);
                    TextView view2 = (TextView) toast.getView().findViewById(android.R.id.message);
                    view2.setTextColor(Color.rgb(241,91,64));
                    toast.show();

                }
            }
        });


        BottomBar bottomBar = (BottomBar) findViewById(bottomBar2);
        bottomBar.setDefaultTab(R.id.tab_daily);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {
                    Intent i = new Intent(DailyInputActivity.this, MainActivity.class);
                    startActivity(i);
                } else if (tabId == R.id.tab_todo) {

                } else if (tabId == R.id.tab_daily) {

                } else if (tabId == R.id.tab_monthly) {
                    Intent i = new Intent(DailyInputActivity.this, MonthlyInputActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });


    }

    private int getScore(int beef, int chicken, int fruits, int dairy, int pork, int processed, int bike, int car, int bus)
    {
        //these variables reperesent the yes or no questions from the user daily input
        // 1 = yes, 0 = no
        //all names only consider the first element in the name

        int dailyscore = 0;
        //maximum score = 900

        if(car == 0)
            dailyscore+= 125;
        else
            dailyscore+=30;

        if(bus ==0)
            dailyscore+=50;
        else
            dailyscore+=30;

        if(bike== 1)
            dailyscore+= 150;
        else
            dailyscore+= 30;

        if(beef== 0 )
            dailyscore+= 125;
        else
            dailyscore+= 30;

        if(chicken == 0)
            dailyscore+= 50;
        else
            dailyscore+=30;

        if (dairy ==0 )
            dailyscore+= 100;
        else
            dailyscore+= 30;

        if( pork == 0)
            dailyscore+= 50;
        else
            dailyscore+= 30;

        if( fruits == 1)
            dailyscore+= 150;
        else
            dailyscore+= 30;

        if( processed == 0)
            dailyscore += 100;
        else
            dailyscore +=30;

        dailyscore = (int) (((double) dailyscore/ 900.0) * 100.0);

        return dailyscore;
    }
}
