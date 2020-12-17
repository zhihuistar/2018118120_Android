package com.example.dictionary.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.dictionary.bean.PinBuWordBean;
import com.example.dictionary.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static SQLiteDatabase db;
    public static void initDB(Context context){
        DBOpenHelper helper = new DBOpenHelper(context);
        db = helper.getWritableDatabase();
    }
    /**
     * 插入很多数据到pywordtb表当中
     * 插入了多个对象所在的集合
     * */
    public static void insertListToPywordtb(List<PinBuWordBean.ResultBean.ListBean> list){
        if (list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
//                获取集合当中的每一个bean对象
                PinBuWordBean.ResultBean.ListBean bean = list.get(i);
//                调用单个对象插入的方法
                try {
                    insertWordToPywordtb(bean);
                }catch (Exception e){
                    Log.i("animee", "insertListToPywordtb: "+bean.getZi()+"已存在！");
                }
            }
        }
    }
    /*
     * 执行插入数据到pywordtb表当中
     * 插入一个对象的方法
     * */
    public static void insertWordToPywordtb(PinBuWordBean.ResultBean.ListBean bean){
        ContentValues values = new ContentValues();
        values.put("id",bean.getId());
        values.put("zi",bean.getZi());
        values.put("py",bean.getPy());
        values.put("wubi",bean.getWubi());
        values.put("pinyin",bean.getPinyin());
        values.put("bushou",bean.getBushou());
        values.put("bihua",bean.getBihua());
        long loc = db.insert(CommonUtils.TABLE_PYWORDTB, null, values);
    }
    /**
     * 查询pywordtb表当中指定拼音的数据
     * */
    public static List<PinBuWordBean.ResultBean.ListBean>queryPyWordFromPywordtb(String py,int page,int pagesize){
        List<PinBuWordBean.ResultBean.ListBean>list = new ArrayList<>();
        // 0,48   48,48+48    96,96+48
        String sql = "select * from pywordtb where py=? or py like ? or py like ? or py like ? limit ?,?";
        int start = (page-1)*pagesize;
        int end = page*pagesize;
        String type1 = py+",%";
        String type2 = "%,"+py+",%";    //之所以加入三种type，是因为多音字可能导致缓存出错
        String type3 = "%,"+py;
        Cursor cursor = db.rawQuery(sql, new String[]{py,type1,type2,type3, start + "", end + ""});     //+""可转换为String类型
        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String zi = cursor.getString(cursor.getColumnIndex("zi"));
            String py1 = cursor.getString(cursor.getColumnIndex("py"));
            String wubi = cursor.getString(cursor.getColumnIndex("wubi"));
            String pinyin = cursor.getString(cursor.getColumnIndex("pinyin"));
            String bushou = cursor.getString(cursor.getColumnIndex("bushou"));
            String bihua = cursor.getString(cursor.getColumnIndex("bihua"));
            PinBuWordBean.ResultBean.ListBean bean = new PinBuWordBean.ResultBean.ListBean(id, zi, py, wubi, pinyin, bushou, bihua);
            list.add(bean);
        }
        return list;
    }
}
