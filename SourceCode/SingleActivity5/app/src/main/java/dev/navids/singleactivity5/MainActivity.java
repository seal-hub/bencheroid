package dev.navids.singleactivity5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;

public class MainActivity extends AppCompatActivity {
    Object A = new Object();
    Object B = new Object();
    Object C = new Object();
    Object D = new Object();
    HandlerThread handlerThread = new HandlerThread("otherThread");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler(handlerThread.getLooper()).post(new Runnable() {
            @Override
            public void run() {
                A = null;
                B.toString();
                new Handler(getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        C.toString();
                        new Handler(handlerThread.getLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                D.toString();
                            }
                        });
                    }
                });
            }
        });
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                A.toString();
                new Handler(handlerThread.getLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        B = null;
                        new Handler(getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                C = null;
                                D = null;
                            }
                        });
                    }
                });
            }
        });


    }
}
