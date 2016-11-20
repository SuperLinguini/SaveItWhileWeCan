package com.example.briandesouza.saveitwhilewecan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.ProfileTracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.briandesouza.saveitwhilewecan.R.id.overallScore;

public class MainActivity extends AppCompatActivity {

    Intent i;
    CallbackManager callbackManager;
    AccessTokenTracker accessTokenTracker;
    ProfileTracker profileTracker;
    AccessToken accessToken;
    private TextView overallButton, toButton, monthButton, tipBoxButton;
    int monthListArray[] = {80, 75, 93};
    int dailyListArray[] = {67, 92, 100, 53, 68, 67, 90, 80, 87, 73, 82, 90, 48, 86, 59, 98,
            65, 100, 70, 59, 83, 76, 95, 100, 84};
    ArrayList<Integer> monthList = new ArrayList<>(monthListArray.length), dailyList = new ArrayList<>(dailyListArray.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_header);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        overallButton = (TextView) findViewById(overallScore);
        toButton = (TextView) findViewById(R.id.overallScoreTxt);
        monthButton = (TextView) findViewById(R.id.monthScore);
        tipBoxButton = (TextView) findViewById(R.id.tipBox);

        TextView todayScore = (TextView) findViewById(R.id.overallScoreTxt);
        TextView overallScore = (TextView)findViewById(R.id.overallScore);
        TextView monthlyScore = (TextView) findViewById(R.id.monthScore);

        int dailySum=0, monthlySum=0;

        for(int i = 0; i < monthListArray.length; i++)
        {
            monthList.add(monthListArray[i]);
            monthlySum += monthListArray[i];
        }

        for(int j = 0; j < dailyListArray.length; j++)
        {
            dailyList.add(dailyListArray[j]);
            dailySum += dailyListArray[j];
        }

        int score, monthlyScoreInt, overallScoreInt;

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.pref),
                Context.MODE_PRIVATE);
        if(sharedPref.getInt(getString(R.string.saved_monthly_score), -1) != -1)
        {
            monthlyScoreInt = sharedPref.getInt(getString(R.string.saved_monthly_score), -1);
        } else {
            monthlyScoreInt = 0;
        }

        if(sharedPref.getInt(getString(R.string.saved_daily_score), -1) != -1)
        {
            score = sharedPref.getInt(getString(R.string.saved_daily_score), -1);
        } else {
            score = 0;
        }

        System.out.println("month " + ((double) monthlySum / monthListArray.length));
        System.out.println("" + ((double)dailySum/dailyListArray.length));

        monthlySum += monthlyScoreInt;
        dailySum += score;

        overallScoreInt = (int) (((double)monthlySum + ((double) dailySum / (dailyListArray.length + 1))) /
                ((double) monthListArray.length + 2));

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(getString(R.string.saved_overall_score), overallScoreInt);
        editor.commit();

        todayScore.setText("" + score);
        overallScore.setText("" + overallScoreInt);
        monthlyScore.setText("" + monthlyScoreInt);

        overallScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ScoreActivity.class);
                startActivity(i);
            }
        });

        FacebookSdk.sdkInitialize(this.getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setDefaultTab(R.id.tab_home);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {

                } else if (tabId == R.id.tab_map) {
                    Intent i = new Intent(MainActivity.this, MapActivity.class);
                    startActivity(i);
                    finish();
                } else if (tabId == R.id.tab_daily) {
                    Intent i = new Intent(MainActivity.this, DailyInputActivity.class);
                    startActivity(i);
                    finish();
                } else if (tabId == R.id.tab_monthly) {
                    Intent i = new Intent(MainActivity.this, MonthlyInputActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });


        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(
                    AccessToken oldAccessToken,
                    AccessToken currentAccessToken) {
                // Set the access token using
                // currentAccessToken when it's loaded or set.
                accessToken = currentAccessToken;
            }
        };
        // If the access token is available already assign it.
        accessToken = AccessToken.getCurrentAccessToken();
        if (accessToken == null) {
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
        }

        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(
                    Profile oldProfile,
                    Profile currentProfile) {
                // App code
            }
        };

        /* make the API call */
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/{friend-list-id}",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
            /* handle the result */
                    }
                }
        ).executeAsync();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        accessTokenTracker.stopTracking();
        profileTracker.stopTracking();
    }

    public void userInput(View v) {
        i = new Intent(MainActivity.this, DailyInputActivity.class);
        startActivity(i);

    }
}
