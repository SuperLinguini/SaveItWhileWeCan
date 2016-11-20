package com.example.briandesouza.saveitwhilewecan;

import android.content.Intent;
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

        final int overallScoreInt;
        Intent received = getIntent();
        if(received.hasExtra("overallScore"))
        {
            overallScoreInt = received.getIntExtra("overallScore",43);
        } else {
            overallScoreInt = 63;
        }

        overallScore.setText("" + overallScoreInt);
    }

    public void onBackPressed(){
        NavUtils.navigateUpFromSameTask(this);
    }
}
