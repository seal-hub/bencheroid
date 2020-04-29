package com.concurrencybench.timertask1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    static String coordinates;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinates = getCurrentCoordinates();
        TimerTask mTimerTask = new mTimerTask();
        timer = new Timer();
        timer.scheduleAtFixedRate(mTimerTask, 0, 3000);
    }


    private String getCurrentCoordinates() {
        // Generate random coordinates
        Random r = new Random();
        String Latitude = new DecimalFormat("#0.0000").format(0 + (90) * r.nextDouble());
        String Longitude = new DecimalFormat("#0.0000").format(0 + (180) * r.nextDouble());
        return (Latitude + ", " + Longitude);
    }

    public void onClick(View view) {
        coordinates = null;
    }

    class mTimerTask extends TimerTask {

        public void run() {
            if (coordinates != null) {
                try {
                    System.out.println("sleeping ...");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(coordinates.split(",")[0] + "  ");
            }
        }
    }

}
