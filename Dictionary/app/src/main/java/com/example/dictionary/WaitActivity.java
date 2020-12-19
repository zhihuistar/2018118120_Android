package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WaitActivity extends AppCompatActivity {
    TextView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);
        back = findViewById(R.id.wait_tv);
    }
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.wait_tv:
                finish();
                break;
        }
    }
}