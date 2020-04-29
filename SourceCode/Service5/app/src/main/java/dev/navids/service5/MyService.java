package dev.navids.service5;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.A = new Object();
            }
        }, 2000);
        return new Binder();
    }
}
