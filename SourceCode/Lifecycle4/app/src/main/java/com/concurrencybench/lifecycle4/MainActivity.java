package com.concurrencybench.lifecycle4;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

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
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                coordinates = null;
            }
        }).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (coordinates != null) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(coordinates.split(",")[0] + " ");
        }
    }

    private String getCurrentCoordinates() {
        // Generate random coordinates
        Random r = new Random();
        String Latitude = new DecimalFormat("#0.0000").format(0 + (90) * r.nextDouble());
        String Longitude = new DecimalFormat("#0.0000").format(0 + (180) * r.nextDouble());
        return (Latitude + ", " + Longitude);
    }

}
