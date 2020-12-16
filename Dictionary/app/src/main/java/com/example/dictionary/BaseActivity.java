package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import org.xutils.common.Callback;

public class BaseActivity extends AppCompatActivity implements Callback.CommonCallback {
    @Override
    public void onSuccess(Object result) {

    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {

    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {

    }
}
