package com.example.dictionary;

import android.app.Application;

import com.example.dictionary.db.DBManager;

import org.xutils.x;

public class UniteApplication extends Application {
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);   //初始化xUtils的模块数据
        DBManager.initDB(this);    //初始化数据库对象
    }
}
