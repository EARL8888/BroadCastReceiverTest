package com.earl.broadcastreceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    public static final String ACTION="com.earl.broadcastreceivertest.intent.action.MyReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("广播已收到"+intent.getStringExtra("sendData"));
    }
}
