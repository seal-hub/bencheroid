package com.concurrencybench.service3;

import android.app.IntentService;
import android.content.Intent;

import static com.concurrencybench.service3.MainActivity.mCoordinates;

public class Service3 extends IntentService {

    public static String EXTRA_MESSAGE;

    public Service3() {
        super("Service3");
    }

    // This method is called by onStartCommand() when using IntentService class
    // IntentService run the service code on a background thread.
    @Override
    protected void onHandleIntent(Intent intent) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        showText(mCoordinates);
    }

    private void showText(String text) {
        System.out.println("Coordinates: " + text.split(",")[0] + ", " + text.split(",")[1] + "\n");
    }


}
