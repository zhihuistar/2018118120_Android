package com.example.dictionary.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(@Nullable Context context) {
        super(context, "dict.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table pywordtb(_id integer primary key autoincrement,id varchar(20),zi varchar(4) unique not null," +
                "py varchar(10),wubi varchar(10),pinyin varchar(10),bushou varchar(4),bihua integer)";
        db.execSQL(sql);
        //创建存储文字详情的表格
        sql = "create table wordtb(_id integer primary key autoincrement,id varchar(20),zi varchar(4) unique not null,py varchar(10),"
                + "wubi varchar(10),pinyin varchar(10),bushou varchar(4),bihua integer,jijie text,xiangjie text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
