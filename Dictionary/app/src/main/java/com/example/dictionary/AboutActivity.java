package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {
    RelativeLayout update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        update = findViewById(R.id.about_update);
    }
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.about_iv_back:
                finish();
                break;
            case R.id.about_update:
                Toast.makeText(AboutActivity.this, "当前已为最新版本！", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}