package com.example.u0151051.screen_conversion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Activity2 extends Activity {
    TextView tv6, tv7, tv8, tv9, tv10, tv11, tv12, tv13;
    Button bt2;// 設一個button可以返回上一頁
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 把第二個畫面的xml檔交給第二個畫面的java檔
        setContentView(R.layout.activity2);
        // 宣告一個包裹接收第一個畫面傳來的包裹利用getIntent()呼叫郵差再利用getExtras叫郵差拿出包裹
        bundle = this.getIntent().getExtras();
        findview();
        setdata();

    }

    void findview() {
        tv9 = (TextView) findViewById(R.id.textView9);
        tv10 = (TextView) findViewById(R.id.textView10);
        tv11 = (TextView) findViewById(R.id.textView11);
        tv12 = (TextView) findViewById(R.id.textView12);
        bt2 = (Button) findViewById(R.id.button3);
        bt2.setOnClickListener(s);
    }

    // 把第一個畫面的值顯現出來
    void setdata() {
        //  bundle.getString("key值"),key值相當於名字
        tv9.setText(bundle.getString("ch"));
        tv10.setText(bundle.getString("en"));
        tv11.setText(bundle.getString("ma"));
        int total = Integer.parseInt(bundle.getString("ch")) + Integer.parseInt(bundle.getString("en"))
                + Integer.parseInt(bundle.getString("ma"));
        tv12.setText(String.valueOf(total));
    }

    View.OnClickListener s = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // 回到上一頁
            Intent b = new Intent();
            b.setClass(Activity2.this, MainActivity.class);
            startActivity(b);
            Activity2.this.finish();
        }
    };

}
