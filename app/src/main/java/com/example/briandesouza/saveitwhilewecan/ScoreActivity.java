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

        TextView tip = (TextView) findViewById(R.id.suggestionBox);
        TextView donation = (TextView) findViewById(R.id.recommendedDonationAmt);

        if (overallScoreInt >= 90) {
            tip.setText("Awesome! You are on the right track to  dramatically reduce emissions and save our climate.  Make sure your friends are doing their part for the environment!");
            donation.setText("$5/mo");
        } else if (overallScoreInt < 90 && overallScoreInt >= 70) {
            tip.setText("Great job! Your Eco Score is above average! Consider improving to a low carbon vehicle and make sure to always turn off lights you are not using.");
            donation.setText("$10/mo");
        } else if (overallScoreInt < 70 && overallScoreInt >= 50) {
            tip.setText("You currently have an average Eco Score for an American. To improve, try to stop eating red meat more than three times a week and take the bus as often as possible.");
            donation.setText("$15/mo");
        } else {
            tip.setText("Your Eco Score is well below average. You should strongly consider restructuring how you act in terms of travel, food, and, energy use.");
            donation.setText("$20/mo");
        }
    }

    public void onBackPressed(){
        NavUtils.navigateUpFromSameTask(this);
    }
}
