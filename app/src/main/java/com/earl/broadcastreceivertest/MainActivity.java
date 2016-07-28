package com.earl.broadcastreceivertest;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.sendBroadCast).setOnClickListener(this);
        findViewById(R.id.registBroadCast).setOnClickListener(this);
        findViewById(R.id.unRegistBroadCast).setOnClickListener(this);
        intent = new Intent(MainActivity.this, MyReceiver.class);
    }

    /**
     * 静态注册广播要在清单文件中配置
     * <receiver
     * android:name=".MyReceiver"
     * android:enabled="true"
     * android:exported="true">
     * </receiver>
     */
    //    @Override
    //    public void onClick(View view) {
    //        switch (view.getId()) {
    //            case R.id.sendBroadCast:
    //                intent.putExtra("sendData","我是发送过来的数据");
    //                sendBroadcast(intent);
    //                break;
    //        }
    //    }

    //动态注册广播,不需要清单文件配置

    private MyReceiver myReceiver = null;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sendBroadCast:
                Intent intent1 = new Intent(MyReceiver.ACTION);//隐式
                intent1.putExtra("sendData", "我是发送过来的数据");
                //这个是无序广播，如果想被abortBroadcast()拦截，就要使用有序广播
//                sendBroadcast(intent1);
                sendOrderedBroadcast(intent1,null);
                break;
            case R.id.registBroadCast:
                if (myReceiver == null) {
                    myReceiver = new MyReceiver();
                    registerReceiver(myReceiver, new IntentFilter(MyReceiver.ACTION));
                }
                break;
            case R.id.unRegistBroadCast:
                if (myReceiver != null) {
                    unregisterReceiver(myReceiver);
                    myReceiver = null;
                }
                break;
        }
    }
}
