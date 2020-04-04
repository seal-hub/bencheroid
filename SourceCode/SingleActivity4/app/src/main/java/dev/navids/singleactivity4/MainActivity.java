package dev.navids.singleactivity4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    Object A = new Object();
    Object B = new Object();
    Object C = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                A.toString();

            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                A = null;
                B.toString();
            }
        }, 5000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                B = null;
                C = null;

            }
        }, 10000);
        new Handler().postAtFrontOfQueue(new Runnable() {
            @Override
            public void run() {
                C.toString();
            }
        });


    }
}
