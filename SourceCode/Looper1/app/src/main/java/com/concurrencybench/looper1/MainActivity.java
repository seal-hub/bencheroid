package com.concurrencybench.looper1;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends Activity {

    static String coordinates;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinates = getCurrentCoordinates();

        handler =  new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == 0){
                    String latDiff = String.valueOf(Double.valueOf(coordinates.split(",")[0]) - Double.valueOf(msg.obj.toString().split(",")[0]));
                    String longDiff = String.valueOf(Double.valueOf(coordinates.split(",")[1]) - Double.valueOf(msg.obj.toString().split(",")[1]));
                }else if(msg.what == 1){
                    coordinates = null;
                }
            }
        };
    }

    public void onClick(View view) {
        coordinates = getCurrentCoordinates();

        Message readMsg = new Message();
        readMsg.what = 0; // 0 for Read
        readMsg.obj = getCurrentCoordinates();
        handler.dispatchMessage(readMsg);

        Message writeMsg = new Message();
        writeMsg.what = 1; // 1 for Write
        handler.dispatchMessage(writeMsg);
    }

    private String getCurrentCoordinates() {
        // Generate random coordinates
        Random r = new Random();
        String Latitude = new DecimalFormat("#0.0000").format(0 + (90) * r.nextDouble());
        String Longitude = new DecimalFormat("#0.0000").format(0 + (180) * r.nextDouble());
        return (Latitude + ", " + Longitude);
    }


}
