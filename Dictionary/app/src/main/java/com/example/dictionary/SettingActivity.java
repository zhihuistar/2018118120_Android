package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.setting_iv_back:
                finish();
                break;
            case R.id.setting_tv_about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_tv_collect:
                intent = new Intent(this, CollectionActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_tv_feedback:
                intent = new Intent(this, WaitActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_tv_good:
                intent = new Intent(this, WaitActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_tv_share:
                shareSoftware();
                break;
        }
    }

    private void shareSoftware() {
        // 分享这个软件到其他用户
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String msg = "想随时查找汉字和成语详细内容么？快来下载中华字典APP吧！";
        intent.putExtra(Intent.EXTRA_TEXT,msg);
        startActivity(Intent.createChooser(intent,"分享到...."));
    }
}