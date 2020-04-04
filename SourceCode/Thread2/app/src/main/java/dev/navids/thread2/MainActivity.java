package dev.navids.thread2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Thread useThread;
    Object memoryObject = new Object();
    Object secondMemoryObject = new Object();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        useThread = new Thread(new Runnable() {
            @Override
            public void run() {
                memoryObject.toString();
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    useThread.join();
                    memoryObject = null;
                    secondMemoryObject.toString();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                secondMemoryObject = null;
            }
        }).start();
        useThread.start();
    }

}
