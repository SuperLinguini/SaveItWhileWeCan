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

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.ProfileTracker;

import static com.example.briandesouza.saveitwhilewecan.R.id.overallScore;

public class MainActivity extends AppCompatActivity {

    Intent i;
    CallbackManager callbackManager;
    AccessTokenTracker accessTokenTracker;
    ProfileTracker profileTracker;
    AccessToken accessToken;
    private TextView overallButton, toButton, monthButton, tipBoxButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overallButton = (TextView) findViewById(overallScore);
        toButton = (TextView) findViewById(R.id.todayScore);
        monthButton = (TextView) findViewById(R.id.monthScore);
        tipBoxButton = (TextView) findViewById(R.id.tipBox);

        TextView overallScore = (TextView)findViewById(R.id.overallScore);

        int score;
        Intent received = getIntent();
        if(received.hasExtra("score"))
        {
            score = received.getIntExtra("score",43);
        } else {
            score = 42;
        }
        overallScore.setText("" + score);

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

                } else if (tabId == R.id.tab_todo) {
                    Intent i = new Intent(MainActivity.this, MapActivity.class);
                    startActivity(i);
                    finish();
                } else if (tabId == R.id.tab_daily) {
                    Intent i = new Intent(MainActivity.this, DailyInputActivity.class);
                    startActivity(i);
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
