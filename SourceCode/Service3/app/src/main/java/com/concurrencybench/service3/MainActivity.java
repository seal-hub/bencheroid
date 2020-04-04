package com.concurrencybench.service3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.text.DecimalFormat;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    public volatile static String mCoordinates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, Service3.class);
        mCoordinates = getCurrentCoordinates();
        startService(intent);
    }


    public void onClick(View v) {
        mCoordinates = null;
    }


    public String getCurrentCoordinates() {
        // Generate random coordinates
        Random r = new Random();
        String Latitude = new DecimalFormat("#0.0000").format(0 + (90) * r.nextDouble());
        String Longitude = new DecimalFormat("#0.0000").format(0 + (180) * r.nextDouble());
        return (Latitude + ", " + Longitude);
    }

}
