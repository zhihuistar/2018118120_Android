package com.example.chapter9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MyTask mTask;
    Button button,cancel;
    TextView text;
    ProgressBar progressBar;
    private class MyTask extends AsyncTask<String, Integer, String> {
        protected void onPreExecute() {
            text.setText("加载中");
        }
        protected String doInBackground(String... params) {
            try {
                int count = 0;
                while (count<99) {
                    count++;
                    publishProgress(count);
                    Thread.sleep(50);
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        protected void onProgressUpdate(Integer... progresses) {
            progressBar.setProgress(progresses[0]);
            text.setText("loading..." + progresses[0] + "%");
        }
        protected void onPostExecute(String result) {
            text.setText("加载完毕");
        }
        protected void onCancelled() {
            text.setText("已取消");
            progressBar.setProgress(0);
        }
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        cancel = (Button) findViewById(R.id.cancel);
        text = (TextView) findViewById(R.id.text);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mTask = new MyTask();
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mTask.execute();
            }
        });
        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mTask.cancel(true);
            }
        });
    }
}