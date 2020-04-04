package dev.navids.multicomp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    MemoryObject memoryObject = new MemoryObject();
    MyReceiver myReceiver = new MyReceiver(memoryObject);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        registerReceiver(myReceiver, intentFilter);
        findViewById(R.id.use_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memoryObject.object.toString();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }
}
