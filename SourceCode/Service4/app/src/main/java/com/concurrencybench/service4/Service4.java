package com.concurrencybench.service4;

import android.app.IntentService;
import android.content.Intent;

import static com.concurrencybench.service4.MainActivity.mCoordinates;

public class Service4 extends IntentService {

    public static String EXTRA_MESSAGE;

    public Service4() {
        super("Service3");
    }

    // This method is called by onStartCommand() when using IntentService class
    // IntentService run the service code on a background thread.
    @Override
    protected void onHandleIntent(Intent intent) {
        String msg = (String) intent.getExtras().get(EXTRA_MESSAGE);
        if(msg.equals("Read")){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            showText(mCoordinates);
        } else if(msg.equals("Write")){
            System.out.println("write");
            mCoordinates = null;
        }

    }

    private void showText(String text) {
        System.out.println("Coordinates: " + text.split(",")[0] + ", " + text.split(",")[1] + "\n");
    }


}
