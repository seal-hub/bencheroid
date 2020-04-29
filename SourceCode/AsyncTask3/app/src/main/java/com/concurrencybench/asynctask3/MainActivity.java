package com.concurrencybench.asynctask3;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends Activity {

    static String coordinates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinates = getCurrentCoordinates();
    }


    @Override
    protected void onResume() {
        super.onResume();
        new CoordinatesTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "READ");
        new CoordinatesTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "WRITE");
    }

    public void onClick(View view) {
    }


    private String getCurrentCoordinates() {
        // Generate random coordinates
        Random r = new Random();
        String Latitude = new DecimalFormat("#0.0000").format(0 + (90) * r.nextDouble());
        String Longitude = new DecimalFormat("#0.0000").format(0 + (180) * r.nextDouble());
        return (Latitude + ", " + Longitude);
    }


    class CoordinatesTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            if (params[0].equals("READ")) {
                String latDiff = String.valueOf(Double.valueOf(coordinates.split(",")[0]) - Double.valueOf(params[0].split(",")[0]));
                return "Coordinates diff: " + latDiff + "\n";
            } else {
                coordinates = null;
                return "Done";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            TextView txt = findViewById(R.id.textView);
            txt.append(result);
        }
    }

}
