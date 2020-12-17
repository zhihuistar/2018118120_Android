package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.example.dictionary.utils.FileUtil;
import com.example.dictionary.utils.RecognizeService;

public class MainActivity extends AppCompatActivity {
    TextView pyTv,bsTv,cyuTv,twenTv,juziTv;
    EditText ziEt;
    private boolean hasGotToken = false;
    private AlertDialog.Builder alertDialog;
    private static final int REQUEST_CODE_GENERAL_BASIC = 106;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAccessTokenWithAkSk();
    }
    private boolean checkTokenStatus() {
        if (!hasGotToken) {
            Toast.makeText(getApplicationContext(), "token还未成功获取", Toast.LENGTH_LONG).show();
        }
        return hasGotToken;
    }

    /**
     * 用明文ak，sk初始化
     */
    private void initAccessTokenWithAkSk() {
        OCR.getInstance(this).initAccessTokenWithAkSk(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken result) {
                String token = result.getAccessToken();
                hasGotToken = true;
            }

            @Override
            public void onError(OCRError error) {
                error.printStackTrace();
                alertText("AK，SK方式获取token失败", error.getMessage());
            }
        }, getApplicationContext(),  "GQksanaQ7nQ7B9Ld0yamBegp", "tb0xRzf2T2E12MLdeGtyxU6ubnNQBiYh");
    }

    private void alertText(final String title, final String message) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                alertDialog.setTitle(title)
                        .setMessage(message)
                        .setPositiveButton("确定", null)
                        .show();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // 识别成功回调，通用文字识别
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_GENERAL_BASIC && resultCode == Activity.RESULT_OK) {
            RecognizeService.recGeneralBasic(this, FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
                    new RecognizeService.ServiceListener() {
                        @Override
                        public void onResult(String result) {
                            //result是识别出的字符串，可以将字符串传递给下一个界面
                            Log.d("animee", "onResult: result===" + result);
                            //{"words_result":[{"words":"悯农"},{"words":"锄禾日当午"},{"words":"汗滴禾下土。"},{"words":"谁知盘中餐"},{"words":"粒粒皆辛苦。"}],"log_id":1339544087568580608,"words_result_num":5,"direction":0}
                        }
                    });
        }
    }
    private void initView() {
        pyTv = findViewById(R.id.main_tv_pinyin);
        bsTv = findViewById(R.id.main_tv_bushou);
        cyuTv = findViewById(R.id.main_tv_chengyu);
        twenTv = findViewById(R.id.main_tv_tuwen);
        juziTv = findViewById(R.id.main_tv_juzi);
        ziEt = findViewById(R.id.main_et);
    }
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.main_iv_setting:
                break;
            case R.id.main_iv_search:
                String text = ziEt.getText().toString();
                if (!TextUtils.isEmpty(text)) {
                    intent.setClass(this,WordInfoActivity.class);
                    intent.putExtra("zi",text);
                    startActivity(intent);
                }
                break;
            case R.id.main_tv_pinyin:
                intent.setClass(this,SearchPinyinActivity.class);
                startActivity(intent);
                break;
            case R.id.main_tv_bushou:
                intent.setClass(this,SearchBuShouActivity.class);
                startActivity(intent);
                break;
            case R.id.main_tv_chengyu:
                break;
            case R.id.main_tv_tuwen:
                if (!checkTokenStatus()) {
                    return;
                }
                intent.setClass(MainActivity.this, CameraActivity.class);
                intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                        FileUtil.getSaveFile(getApplication()).getAbsolutePath());
                intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
                        CameraActivity.CONTENT_TYPE_GENERAL);
                startActivityForResult(intent, REQUEST_CODE_GENERAL_BASIC);
                break;
        }
    }
}