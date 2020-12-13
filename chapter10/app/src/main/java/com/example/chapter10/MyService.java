package com.example.chapter10;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private MainActivity.MyTask thread;
    public MyService() {
    }
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public void onCreate(){
        super.onCreate();
    }
    public int onStartCommand(Intent intent,int flags,int startId) {
        new Thread(new Runnable(){
            @Override
            public void run() {
                thread = new MainActivity.MyTask();
                thread.execute();
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }
    public void onDestroy(){
        super.onDestroy();
    }
}
