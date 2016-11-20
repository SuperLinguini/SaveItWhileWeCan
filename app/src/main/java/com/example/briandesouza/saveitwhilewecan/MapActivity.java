package com.example.briandesouza.saveitwhilewecan;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.esri.android.map.GraphicsLayer;
import com.esri.android.map.MapView;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.esri.android.map.ags.ArcGISFeatureLayer;
import com.esri.core.geometry.Envelope;
import com.esri.core.geometry.Point;
import com.esri.core.map.Feature;
import com.esri.core.map.FeatureResult;
import com.esri.core.map.Graphic;
import com.esri.core.symbol.SimpleMarkerSymbol;
import com.esri.core.tasks.query.QueryParameters;
import com.esri.core.tasks.query.QueryTask;

public class MapActivity extends AppCompatActivity {
    private MapView mMapView;
    private ArcGISFeatureLayer mFeatureLayer;
    private GraphicsLayer mGraphicsLayer;
    private String mFeatureServiceURL;
    ProgressDialog progress;

    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // After the content of this Activity is set, the map can be accessed programmatically from the layout.
        mMapView = (MapView) findViewById(R.id.map);

        // Get the feature service URL from values->strings.xml
        mFeatureServiceURL = this.getResources().getString(R.string.data);
        // Add Feature layer to the MapView
        mFeatureLayer = new ArcGISFeatureLayer(mFeatureServiceURL, ArcGISFeatureLayer.MODE.ONDEMAND);
        mMapView.addLayer(mFeatureLayer);
        // Add Graphics layer to the MapView
        mGraphicsLayer = new GraphicsLayer();
        mMapView.addLayer(mGraphicsLayer);
        //new QueryFeatureLayer().execute();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MapActivity.this, Map2Activity.class);
                startActivity(i);
            }
        });

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar11);
        bottomBar.setDefaultTab(R.id.tab_map);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {
                    Intent i = new Intent(MapActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                } else if (tabId == R.id.tab_daily) {
                    Intent i = new Intent(MapActivity.this, DailyInputActivity.class);
                    startActivity(i);
                    finish();
                } else if (tabId == R.id.tab_monthly) {
                    Intent i = new Intent(MapActivity.this, MonthlyInputActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
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

    /**
     * Run the query task on the feature layer and put the result on the map.
     */
    private class QueryFeatureLayer extends AsyncTask<Void, Void, FeatureResult> {

        // default constructor
        public QueryFeatureLayer() {
        }

        @Override
        protected void onPreExecute() {
            progress = ProgressDialog.show(MapActivity.this, "", "Please wait....query task is executing");
        }

        @Override
        protected FeatureResult doInBackground(Void... v) {

            // Define a new query and set parameters
            QueryParameters mParams = new QueryParameters();
            mParams.setReturnGeometry(true);

            // Define the new instance of QueryTask
            QueryTask queryTask = new QueryTask(mFeatureServiceURL);
            FeatureResult results;

            try {
                // run the querytask
                results = queryTask.execute(mParams);
                return results;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(FeatureResult results) {

            // Remove the result from previously run query task
            mGraphicsLayer.removeAll();

            // Define a new marker symbol for the result graphics
            SimpleMarkerSymbol sms = new SimpleMarkerSymbol(Color.BLUE, 10, SimpleMarkerSymbol.STYLE.CIRCLE);

            // Envelope to focus on the map extent on the results
            Envelope extent = new Envelope();

            // iterate through results
            for (Object element : results) {
                // if object is feature cast to feature
                if (element instanceof Feature) {
                    Feature feature = (Feature) element;
                    // convert feature to graphic
                    Graphic graphic = new Graphic(feature.getGeometry(), sms, feature.getAttributes());
                    // merge extent with point
                    extent.merge((Point)graphic.getGeometry());
                    // add it to the layer
                    mGraphicsLayer.addGraphic(graphic);
                }
            }

            // Set the map extent to the envelope containing the result graphics
            mMapView.setExtent(extent, 100);
            // Disable the progress dialog
            progress.dismiss();

        }
    }

}
