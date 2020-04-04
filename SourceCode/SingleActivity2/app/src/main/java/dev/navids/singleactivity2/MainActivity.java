package dev.navids.singleactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    Object memoryObject = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                memoryObject.toString();
            }
        });
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                memoryObject = null;
            }
        });
    }
}
