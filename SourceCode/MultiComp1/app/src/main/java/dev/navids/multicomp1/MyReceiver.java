package dev.navids.multicomp1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    MemoryObject memoryObject;
    public MyReceiver(MemoryObject memoryObject) {
        this.memoryObject = memoryObject;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        memoryObject.object = null;
        System.out.println("---- Receive something");
    }
}
