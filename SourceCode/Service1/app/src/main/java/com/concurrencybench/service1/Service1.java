package com.concurrencybench.service1;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.DecimalFormat;
import java.util.Random;

public class Service1 extends android.app.Service {

    private final IBinder binder = new LocalBinder();
    private final Random mGenerator = new Random();

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public String getCurrentCoordinates() {
        // Generate random coordinates
        Random r = new Random();
        String Latitude = new DecimalFormat("#0.0000").format(0 + (90) * r.nextDouble());
        String Longitude = new DecimalFormat("#0.0000").format(0 + (180) * r.nextDouble());
        return (Latitude + ", " + Longitude);
    }

    public class LocalBinder extends Binder {
        Service1 getService() {
            return Service1.this;
        }
    }
}
