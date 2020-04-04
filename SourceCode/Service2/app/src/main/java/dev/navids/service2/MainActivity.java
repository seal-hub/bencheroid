package dev.navids.service2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private MyService.MyBinderClass myBinder = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sIntent = new Intent(MainActivity.this, MyService.class);
                bindService(sIntent, myServiceConnection, Context.BIND_AUTO_CREATE);
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                myBinder.getMyService().secondMemoryObject.toString();
            }
        }, 10000);
    }

    private ServiceConnection myServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder = (MyService.MyBinderClass) iBinder;
            myBinder.getMyService().myMemoryObject = null;
            int r = myBinder.getMyService().getRandom();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            myBinder.getMyService().secondMemoryObject = null;
            myBinder = null;
        }
    };
}
