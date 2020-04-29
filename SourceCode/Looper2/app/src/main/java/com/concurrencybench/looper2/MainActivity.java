package com.concurrencybench.looper2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;

import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends Activity {

    static String coordinates;
    HandlerThread handlerThread1;
    HandlerThread handlerThread2;
    Handler handler1;
    Handler handler2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinates = getCurrentCoordinates();

        handlerThread1 = new HandlerThread("handlerThread1");
        handlerThread2 = new HandlerThread("handlerThread2");
        handlerThread1.start();
        handlerThread2.start();
        handler1 = new Handler(handlerThread1.getLooper());
        handler2 = new Handler(handlerThread2.getLooper());
    }

    public void onClick(View view) {
        coordinates = getCurrentCoordinates();

        handler1.post(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                coordinates = null;
            }
        });

        handler2.post(new Runnable() {
            @Override
            public void run() {
                String latDiff = String.valueOf(Double.valueOf(coordinates.split(",")[0]) - Double.valueOf(getCurrentCoordinates().split(",")[0]));
            }
        });
    }

    private String getCurrentCoordinates() {
        // Generate random coordinates
        Random r = new Random();
        String Latitude = new DecimalFormat("#0.0000").format(0 + (90) * r.nextDouble());
        String Longitude = new DecimalFormat("#0.0000").format(0 + (180) * r.nextDouble());
        return (Latitude + ", " + Longitude);
    }


}
