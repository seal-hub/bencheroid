package dev.navids.timertask2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    Object A = new Object();
    @Override
    protected void onResume() {
        super.onResume();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                A = null;
            }
        };
        Timer timer = new Timer(true);
        timer.schedule(timerTask, 2000);
        try {
            Thread.sleep(new Random().nextInt(4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        A.toString();
    }
}
