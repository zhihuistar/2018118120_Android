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
        // 方法1：onPreExecute（）
        // 作用：执行 线程任务前的操作
        protected void onPreExecute() {
            text.setText("加载中");
        }
        // 方法2：doInBackground（）
        // 作用：接收输入参数、执行任务中的耗时操作、返回 线程任务执行的结果
        // 此处通过计算从而模拟“加载进度”的情况
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
        // 方法3：onProgressUpdate（）
        // 作用：在主线程 显示线程任务执行的进度
        protected void onProgressUpdate(Integer... progresses) {
            progressBar.setProgress(progresses[0]);
            text.setText("loading..." + progresses[0] + "%");
        }
        // 方法4：onPostExecute（）
        // 作用：接收线程任务执行结果、将执行结果显示到UI组件
        protected void onPostExecute(String result) {
            text.setText("加载完毕");
        }
        // 方法5：onCancelled()
        // 作用：将异步任务设置为：取消状态
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