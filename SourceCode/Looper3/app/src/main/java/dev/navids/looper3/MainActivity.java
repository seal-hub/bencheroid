package dev.navids.looper3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    Object A = new Object();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                A.toString();
            }
        });
        new Handler().postAtFrontOfQueue(new Runnable() {
            @Override
            public void run() {
                A = null;
            }
        });

    }
}
