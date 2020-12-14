package com.example.chapter10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static TextView textView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("服务与线程");
        textView = (TextView) findViewById(R.id.text);
        Button startService = (Button) findViewById(R.id.start_service);
        Button stopService = (Button) findViewById(R.id.stop_service);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
    }
    public void onClick(View v) {
        MyTask mTask = new MyTask();
        switch (v.getId()) {
            case R.id.start_service:
                mTask.execute();
                break;
            case R.id.stop_service:
                mTask.cancel(true);
                break;
            default:
                break;
        }
    }
    static class MyTask extends AsyncTask<Integer, Integer, Void> {
        protected void onPreExecute() {
            super.onPreExecute();
        }
        protected Void doInBackground(Integer... params) {
            try {
                publishProgress(params);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        protected void onProgressUpdate(Integer... values) {
            MainActivity.textView.setText("服务开始了！");
            super.onProgressUpdate(values);
        }
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
        protected void onCancelled() {
            MainActivity.textView.setText("服务停止了！");
        }
    }
}