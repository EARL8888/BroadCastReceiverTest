package com.earl.broadcastreceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver1 extends BroadcastReceiver {
    public MyReceiver1() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("MyReceiver1");

        abortBroadcast();
    }
}
