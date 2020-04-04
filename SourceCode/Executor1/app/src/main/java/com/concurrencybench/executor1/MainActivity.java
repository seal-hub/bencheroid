package com.concurrencybench.executor1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.Executor;

public class MainActivity extends Activity {

    static String coordinates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinates = getCurrentCoordinates();
        ThreadExecutor threadExecutor = new ThreadExecutor();
        threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                if (coordinates != null) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(coordinates.split(",")[0] + "  " + coordinates.split(",")[1]);
                }
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

    public void onClick(View view) {
        coordinates = null;
    }

    class ThreadExecutor implements Executor {
        public void execute(Runnable r) {
            new Thread(r).start();
        }
    }


}
