package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dictionary.bean.ChengyuBean;
import com.example.dictionary.utils.MyGridView;
import com.example.dictionary.utils.URLUtils;
import com.google.gson.Gson;

public class ChengyuInfoActivity extends BaseActivity {
    TextView ziTv1,ziTv2,ziTv3,ziTv4,pyTv,jsTv,fromTv,exampleTv,yufaTv,yinzhengTv,yinghangTv;
    MyGridView tyGv,fyGv;
    ImageView collectIv;
    private String chengyu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chengyu_info);
        initView();
//        获取上一个页面传递的数据
        Intent intent = getIntent();
        chengyu = intent.getStringExtra("chengyu");
        String url = URLUtils.getChengyuurl(chengyu);
        loadData(url);
    }
    //网络数据加载成功时回调用的方法
    @Override
    public void onSuccess(String result) {
        Log.i("animee", "onSuccess: result==="+result);
        ChengyuBean bean = new Gson().fromJson(result, ChengyuBean.class);
        ChengyuBean.ResultBean cyBean = bean.getResult();
        Log.i("animee", "onSuccess: vybean==="+cyBean.getChengyujs());
    }
    //查找控件的方法
    private void initView() {
        ziTv1 = findViewById(R.id.cyinfo_tv_zi1);
        ziTv2 = findViewById(R.id.cyinfo_tv_zi2);
        ziTv3 = findViewById(R.id.cyinfo_tv_zi3);
        ziTv4 = findViewById(R.id.cyinfo_tv_zi4);
        pyTv = findViewById(R.id.cyinfo_tv_py);
        jsTv = findViewById(R.id.cyinfo_tv_js);
        fromTv = findViewById(R.id.cyinfo_tv_from);
        exampleTv = findViewById(R.id.cyinfo_tv_example);
        yufaTv = findViewById(R.id.cyinfo_tv_yufa);
        yinzhengTv = findViewById(R.id.cyinfo_tv_yinzheng);
        yinghangTv = findViewById(R.id.cyinfo_tv_yinghan);
        tyGv = findViewById(R.id.cyinfo_gv_tongyi);
        fyGv = findViewById(R.id.cyinfo_gv_fanyi);
        collectIv = findViewById(R.id.cyinfo_iv_collection);
    }
}