package com.example.dictionary.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;

import com.example.dictionary.bean.ChengyuBean;
import com.example.dictionary.bean.PinBuWordBean;
import com.example.dictionary.bean.WordBean;
import com.example.dictionary.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static SQLiteDatabase db;
    public static void initDB(Context context){
        DBOpenHelper helper = new DBOpenHelper(context);
        db = helper.getWritableDatabase();
    }
    //插入很多数据到pywordtb表当中，插入了多个对象所在的集合
    public static void insertListToPywordtb(List<PinBuWordBean.ResultBean.ListBean>list){
        if (list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
                //获取集合当中的每一个bean对象
                PinBuWordBean.ResultBean.ListBean bean = list.get(i);
                //调用单个对象插入的方法
                try {
                    insertWordToPywordtb(bean);
                }catch (Exception e){
                    Log.i("animee", "insertListToPywordtb: "+bean.getZi()+"已存在！");
                }
            }
        }
    }
    //执行插入数据到pywordtb表当中，插入一个对象的方法
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
    //查询pywordtb表当中指定拼音的数据
    public static List<PinBuWordBean.ResultBean.ListBean>queryPyWordFromPywordtb(String py,int page,int pagesize){
        List<PinBuWordBean.ResultBean.ListBean>list = new ArrayList<>();
        // 0,48   48,48+48    96,96+48
        String sql = "select * from pywordtb where py=? or py like ? or py like ? or py like ? limit ?,?";
        int start = (page-1)*pagesize;
        int end = page*pagesize;
        String type1 = py+",%";
        String type2 = "%,"+py+",%";    //之所以加入三种type，是因为多音字可能导致缓存出错
        String type3 = "%,"+py;
        Cursor cursor = db.rawQuery(sql, new String[]{py,type1,type2,type3, start + "", end + ""});
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

    //查询pywordtb表当中指定部首的数据
    public static List<PinBuWordBean.ResultBean.ListBean>queryBsWordFromPywordtb(String bs,int page,int pagesize){
        List<PinBuWordBean.ResultBean.ListBean>list = new ArrayList<>();
        // 0,48   48,48+48    96,96+48
        String sql = "select * from pywordtb where bushou=? limit ?,?";
        int start = (page-1)*pagesize;
        int end = page*pagesize;
        Cursor cursor = db.rawQuery(sql, new String[]{bs, start + "", end + ""});
        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String zi = cursor.getString(cursor.getColumnIndex("zi"));
            String py1 = cursor.getString(cursor.getColumnIndex("py"));
            String wubi = cursor.getString(cursor.getColumnIndex("wubi"));
            String pinyin = cursor.getString(cursor.getColumnIndex("pinyin"));
            String bushou = cursor.getString(cursor.getColumnIndex("bushou"));
            String bihua = cursor.getString(cursor.getColumnIndex("bihua"));
            PinBuWordBean.ResultBean.ListBean bean = new PinBuWordBean.ResultBean.ListBean(id, zi, py1, wubi, pinyin, bushou, bihua);
            list.add(bean);
        }
        return list;
    }
    //@des 插入汉字到汉字详情表当中
    public static void insertWordToWordtb(WordBean.ResultBean bean){
        ContentValues values = new ContentValues();
        values.put("id",bean.getId());
        values.put("zi",bean.getZi());
        values.put("py",bean.getPy());
        values.put("wubi",bean.getWubi());
        values.put("pinyin",bean.getPinyin());
        values.put("bushou",bean.getBushou());
        values.put("bihua",bean.getBihua());
        //将集合转化成字符串类型进行插入
        String jijie = listToString(bean.getJijie());
        values.put("jijie",jijie);
        String xiangjie = listToString(bean.getXiangjie());
        values.put("xiangjie",xiangjie);
        db.insert(CommonUtils.TABLE_WORDTB,null,values);
    }
    //根据传入的汉字，查找对应信息组成的对象
    public static WordBean.ResultBean queryWordFromWordtb(String word){
        String sql = "select * from wordtb where zi=?";
        Cursor cursor = db.rawQuery(sql, new String[]{word});
        if (cursor.moveToFirst()) {
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String zi = cursor.getString(cursor.getColumnIndex("zi"));
            String py1 = cursor.getString(cursor.getColumnIndex("py"));
            String wubi = cursor.getString(cursor.getColumnIndex("wubi"));
            String pinyin = cursor.getString(cursor.getColumnIndex("pinyin"));
            String bushou = cursor.getString(cursor.getColumnIndex("bushou"));
            String bihua = cursor.getString(cursor.getColumnIndex("bihua"));
            String jijie = cursor.getString(cursor.getColumnIndex("jijie"));
            String xiangjie = cursor.getString(cursor.getColumnIndex("xiangjie"));
            List<String> jijielist = stringToList(jijie);
            List<String> xiangxilist = stringToList(xiangjie);
            WordBean.ResultBean bean = new WordBean.ResultBean(id, zi, py1, wubi, pinyin, bushou, bihua, jijielist, xiangxilist);
            return bean;
        }
        return null;
    }
    //插入数据到成语表当中
    public static void insertCyToCyutb(ChengyuBean.ResultBean bean){
        ContentValues values = new ContentValues();
        values.put("chengyu",bean.getChengyu());
        values.put("bushou",bean.getBushou());
        values.put("head",bean.getHead());
        values.put("pinyin",bean.getPinyin());
        values.put("chengyujs",bean.getChengyujs());
        values.put("from_",bean.getFrom_());
        values.put("example",bean.getExample());
        values.put("yufa",bean.getYufa());
        values.put("ciyujs",bean.getCiyujs());
        values.put("yinzhengjs",bean.getYinzhengjs());
        String ty = listToString(bean.getTongyi());
        values.put("tongyi",ty);
        String fy = listToString(bean.getFanyi());
        values.put("fanyi",fy);
        db.insert(CommonUtils.TABLE_CYUB,null,values);
    }
    //根据传入的成语，查看详情内容
    public static ChengyuBean.ResultBean queryCyFromCyutb(String cyu){
        String sql = "select * from cyutb where chengyu = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{cyu});
        if (cursor.moveToFirst()) {
            String chengyu = cursor.getString(cursor.getColumnIndex("chengyu"));
            String bushou = cursor.getString(cursor.getColumnIndex("bushou"));
            String head = cursor.getString(cursor.getColumnIndex("head"));
            String pinyin = cursor.getString(cursor.getColumnIndex("pinyin"));
            String chengyujs = cursor.getString(cursor.getColumnIndex("chengyujs"));
            String from_ = cursor.getString(cursor.getColumnIndex("from_"));
            String example = cursor.getString(cursor.getColumnIndex("example"));
            String yufa = cursor.getString(cursor.getColumnIndex("yufa"));
            String ciyujs = cursor.getString(cursor.getColumnIndex("ciyujs"));
            String yinzhengjs = cursor.getString(cursor.getColumnIndex("yinzhengjs"));
            String tongyi = cursor.getString(cursor.getColumnIndex("tongyi"));
            String fanyi = cursor.getString(cursor.getColumnIndex("fanyi"));
            List<String> tylist = stringToList(tongyi);
            List<String> fyList = stringToList(fanyi);
            ChengyuBean.ResultBean bean = new ChengyuBean.ResultBean(chengyu, bushou, head, pinyin, chengyujs, from_, example, yufa, ciyujs, yinzhengjs, tylist, fyList);
            return bean;
        }
        return null;
    }
    //向收藏汉字的表格当中传入数据
    public static void insertZiToCollwordtb(String zi){
        ContentValues values = new ContentValues();
        values.put("zi",zi);
        db.insert(CommonUtils.TABLE_COLLECT_WORDTB,null,values);
    }
    //删除收藏汉字表格当中的数据
    public static void deleteZiToCollwordtb(String zi){
        String sql = "delete from collwordtb where zi = ?";
        db.execSQL(sql,new Object[]{zi});
    }
    //查找此汉字是否收藏在表格当中
    public static boolean isExistZiInCollwordtb(String zi){
        String sql = "select * from collwordtb where zi = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{zi});
        if (cursor.getCount()>0) {
            return true;
        }
        return false;
    }
    //向收藏成语的表格当中传入数据
    public static void insertCyuToCollcyutb(String cy){
        ContentValues values = new ContentValues();
        values.put("chengyu",cy);
        db.insert(CommonUtils.TABLE_COLLECT_CYUTB,null,values);
    }
    //删除收藏成语表格当中的数据
    public static void deleteCyuToCollcyutb(String cy){
        String sql = "delete from collcyutb where chengyu = ?";
        db.execSQL(sql,new Object[]{cy});
    }
    //查找此成语是否收藏在表格当中
    public static boolean isExistCyuInCollcyutb(String cy){
        String sql = "select * from collcyutb where chengyu = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{cy});
        if (cursor.getCount()>0) {
            return true;
        }
        return false;
    }
    //查询成语表当中所有的记录
    public static List<String>queryAllCyFromCyutb(){
        List<String>cyAllList = new ArrayList<>();
        String sql = "select chengyu from cyutb";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String chengyu = cursor.getString(cursor.getColumnIndex("chengyu"));
            cyAllList.add(chengyu);
        }
        return cyAllList;
    }
    //将字符串转换成List集合的方法
    public static List<String>stringToList(String msg){
        List<String>list = new ArrayList<>();
        if (!TextUtils.isEmpty(msg)) {
            String[] arr = msg.split("\\|");
            for (int i = 0; i < arr.length; i++) {
                String s = arr[i].trim();
                if (!TextUtils.isEmpty(s)) {
                    list.add(s);
                }
            }
        }
        return list;
    }
    //将List集合转化成字符串的方法
    public static String listToString(List<String>list){
        StringBuilder sb = new StringBuilder();
        if (list!=null&&!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                String msg = list.get(i);
                msg+="|";
                sb.append(msg);
            }
        }
        return sb.toString();
    }
}
