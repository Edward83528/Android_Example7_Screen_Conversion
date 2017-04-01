package com.example.u0151051.screen_conversion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//Activity和Activity轉換透過Intent(郵差,轉換畫面)和Bundle(包裹,傳遞值)
//新增第二個畫面的view:在layout右鍵新增Android xml檔
//新增第二個畫面的java檔:在src下的com.專案名稱右鍵新增class檔->Browse:android.app.Activity(要import用)
//第二個畫面產生後的class要extend Activity,然後在程式區塊內右鍵source->增加載入畫面的方法override/implement方法->把oncreat()打勾->ok)
//要轉換畫面最重要的設定:在AndroidManifest.xml檔中插入這段 <activity android:name=".第二個畫面java檔名稱" android:label="第二個畫面顯示的名稱" />
public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3;
    EditText et1, et2, et3;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
    }

    void findview() {
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        bt1 = (Button) findViewById(R.id.button);
        bt1.setOnClickListener(c);
    }

    View.OnClickListener c = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // 利用Intent這個類別物件轉換畫面,Intent的職位相當於郵差
            Intent a = new Intent();
            // 把主畫面的專案名稱轉換到第二個畫面的專案名稱
            a.setClass(MainActivity.this, Activity2.class);
            // 利用Bundle這個類別傳遞畫面間的參數,Bundle相當於包裹
            Bundle b = new Bundle();
            // 利用putString放入物件,要給key值,相當於包裹上的名字,不然郵差不知道要交給誰
            b.putString("ch", et1.getText().toString());
            b.putString("en", et2.getText().toString());
            b.putString("ma", et3.getText().toString());
            // 把包裹交給郵差利用putExtras方法
            a.putExtras(b);
            // 轉換畫面
            startActivity(a);
            // 轉換畫面後把自己的畫面刪掉,不然會堆疊
            MainActivity.this.finish();
        }
    };

}
