package dev.navids.thread1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Object memoryObject = new Object();
    Object secondMemoryObject = new Object();
    final Object lock = new Object();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                freeMem();
                secondMemoryObject.toString();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                useMem();
                secondMemoryObject = null;
            }
        }).start();
    }

    void freeMem(){
        synchronized (lock){
            try {
                lock.wait();
                memoryObject = null;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void useMem(){
        synchronized (lock){
            memoryObject.toString();
            lock.notifyAll();
        }
    }
}
