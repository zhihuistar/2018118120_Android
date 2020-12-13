package com.example.chapter8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView text;
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            text.setText(msg.obj.toString());
        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("线程之间");
        text = (TextView)findViewById(R.id.textView);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int n = 0;
                        while(true){
                            n++;
                            Message message = new Message();
                            String string = "线程号 : " + Thread.currentThread().getId() + "\n完成的任务数 : " + n;
                            message.obj = string;
                            handler.sendMessage(message);
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
                break;
            default:
                break;
        }
    }
}