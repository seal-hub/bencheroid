package dev.navids.service2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;

import java.util.Random;

public class MyService extends Service {
    public Object myMemoryObject = new Object();
    public Object secondMemoryObject = new Object();
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                myMemoryObject.toString();
            }
        }, 10000);
    }
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }
    class MyBinderClass extends Binder {
        MyService getMyService(){
            return MyService.this;
        }
    }

    public int getRandom(){
        java.util.Random random = new Random();
        return random.nextInt();
    }

    private MyBinderClass myBinder = new MyBinderClass();
}
