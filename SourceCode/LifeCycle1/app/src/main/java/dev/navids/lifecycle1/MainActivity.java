package dev.navids.lifecycle1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Object onResume_onPause = new Object();
    Object onStart_onStop = new Object();
    Object onDestroy_onCreate = new Object();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onDestroy_onCreate = null;
    }

    @Override
    protected void onStart() {
        super.onStart();
        onStart_onStop.toString();
    }

    @Override
    protected void onResume() {
        super.onResume();
        onResume_onPause.toString();
    }

    @Override
    protected void onPause() {
        super.onPause();
        onResume_onPause = null;
    }

    @Override
    protected void onStop() {
        super.onStop();
        onStart_onStop = null;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDestroy_onCreate.toString();

    }
}
