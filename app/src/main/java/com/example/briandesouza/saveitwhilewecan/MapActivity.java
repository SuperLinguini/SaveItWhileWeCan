package com.example.briandesouza.saveitwhilewecan;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.esri.android.map.MapView;

public class MapActivity extends AppCompatActivity {
    MapView mMapView;

    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // After the content of this Activity is set, the map can be accessed programmatically from the layout.
        mMapView = (MapView) findViewById(R.id.map);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Call MapView.pause to suspend map rendering while the activity is paused, which can save battery usage.
        if (mMapView != null)
        {
            mMapView.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Call MapView.unpause to resume map rendering when the activity returns to the foreground.
        if (mMapView != null)
        {
            mMapView.unpause();
        }
    }

}
