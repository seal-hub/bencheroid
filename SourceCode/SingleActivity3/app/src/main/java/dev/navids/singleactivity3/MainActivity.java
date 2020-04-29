package dev.navids.singleactivity3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;

public class MainActivity extends AppCompatActivity {

    Object memoryObject = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HandlerThread handlerThread = new HandlerThread("otherThread");
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                if(memoryObject != null)
                    memoryObject.toString();
            }
        });
        new Handler(handlerThread.getLooper()).post(new Runnable() {
            @Override
            public void run() {
                memoryObject = null;
            }
        });
    }
}
