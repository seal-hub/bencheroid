package dev.navids.lifecycle2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Object onCreate_onStart = new Object();
    Object onCreate_onResume = new Object();
    Object onCreate_onStop = new Object();
    Object onPause_onDestroy = new Object();
    Object onRestart_onDestroy = new Object();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onCreate_onStart.toString();
        onCreate_onResume.toString();
        onCreate_onStop.toString();
    }

    @Override
    protected void onStart() {
        super.onStart();
        onCreate_onStart = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        onCreate_onResume = null;

    }

    @Override
    protected void onPause() {
        super.onPause();
        onPause_onDestroy.toString();
    }

    @Override
    protected void onStop() {
        super.onStop();
        onCreate_onStop = null;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        onRestart_onDestroy.toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onRestart_onDestroy = null;
        onPause_onDestroy = null;

    }
}
