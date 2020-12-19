package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.baidu.ocr.ui.camera.CameraActivity;
import com.example.dictionary.utils.FileUtil;

public class HomeActivity extends AppCompatActivity {
    TextView tv;
    TextView tv2;
    int time = 5;
    int frag = 0;

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==1) {
                time--;
                if (time == 0 && frag == 0) {
                    //  跳转页面
                    Intent intent = new Intent();
                    intent.setClass(HomeActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    tv.setText(time+"");
                    handler.sendEmptyMessageDelayed(1,1000);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tv = findViewById(R.id.home_tv);
        tv2 = findViewById(R.id.homebt_tv);
        handler.sendEmptyMessageDelayed(1,1000);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.homebt_tv:
                intent.setClass(this,MainActivity.class);
                startActivity(intent);
                frag = 1;
                finish();
                break;
        }
    }
}