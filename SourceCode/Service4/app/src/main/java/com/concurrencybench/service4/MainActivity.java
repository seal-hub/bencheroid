package com.concurrencybench.service4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.Random;

import static com.concurrencybench.service4.Service4.EXTRA_MESSAGE;


public class MainActivity extends AppCompatActivity {

    public volatile static String mCoordinates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This will not result in Event Race as the Service will only process one Intent at a time in onHandleIntent().
        // Read will always happen before the write.

        Intent intent = new Intent(this, Service4.class);
        intent.putExtra(EXTRA_MESSAGE, "Read");
        mCoordinates = getCurrentCoordinates();
        startService(intent);

        Intent intent2 = new Intent(this, Service4.class);
        intent2.putExtra(EXTRA_MESSAGE, "Write");
        startService(intent2);
    }


    public String getCurrentCoordinates() {
        // Generate random coordinates
        Random r = new Random();
        String Latitude = new DecimalFormat("#0.0000").format(0 + (90) * r.nextDouble());
        String Longitude = new DecimalFormat("#0.0000").format(0 + (180) * r.nextDouble());
        return (Latitude + ", " + Longitude);
    }

}
