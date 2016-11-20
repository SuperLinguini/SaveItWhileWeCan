package com.example.briandesouza.saveitwhilewecan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_layout);

        TextView overallScore = (TextView) findViewById(R.id.overallScoreTxt);

        int overallScoreInt;
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.pref),
                Context.MODE_PRIVATE);
        if(sharedPref.getInt(getString(R.string.saved_overall_score), -1) != -1)
        {
            overallScoreInt = sharedPref.getInt(getString(R.string.saved_overall_score), -1);
        } else {
            overallScoreInt = 0;
        }

        overallScore.setText("" + overallScoreInt);
    }

    public void onBackPressed(){
        NavUtils.navigateUpFromSameTask(this);
    }
}
