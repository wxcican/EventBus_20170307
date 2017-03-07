package com.fuicuiedu.xc.eventbus_20170307;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EventBus在监听事件模块完成注册
        EventBus.getDefault().register(this);

        mTv = (TextView) findViewById(R.id.main_tv);

        findViewById(R.id.mian_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void aaa(MessageEvent messageEvent){
        String msg = messageEvent.getMsg();
        //弹吐司
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        //更新UI
        mTv.setText(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消订阅，反注册
        EventBus.getDefault().unregister(this);
    }
}
