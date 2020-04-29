package com.concurrencybench.service1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Service1 mService;
    boolean mBound = false;
    String coordinates;
    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            Service1.LocalBinder binder = (Service1.LocalBinder) service;
            mService = binder.getService();
            mBound = true;
            coordinates = mService.getCurrentCoordinates();
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
            coordinates = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, Service1.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
        mBound = false;
    }

    public void onClick(View v) {
        if (mBound) {
            Toast.makeText(this, "lat: " + coordinates.split(",")[0] + "  " +
                    "lang: ", Toast.LENGTH_SHORT).show();
        }
    }

}
