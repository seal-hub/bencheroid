package dev.navids.receiver1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    Object memoryObject = new Object();
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            System.out.println(memoryObject.toString());
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(broadcastReceiver, new IntentFilter());
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                memoryObject = null;
            }
        });
    }
}
