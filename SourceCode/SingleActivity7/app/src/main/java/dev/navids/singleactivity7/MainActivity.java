package dev.navids.singleactivity7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Object A = new Object();
    Object B = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().post(aRunnable);
        new Handler().post(aRunnable);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandlerThread handlerThread = new HandlerThread("otherThread");
                new Handler(handlerThread.getLooper()).post(bRunnable);
                new Handler().post(bRunnable);
            }
        });

    }
    Runnable aRunnable = new Runnable() {
        @Override
        public void run() {
            A = this;
        }
    };
    Runnable bRunnable = new Runnable() {
        @Override
        public void run() {
            B = this;
        }
    };
}
