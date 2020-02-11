package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        //获取按钮
        Button btn1 = findViewById(R.id.btn1);
        //点击事件：被点击时触发的事件
        btn1.setOnClickListener(new MyClickListener());  //为按钮注册点击事件监听器

        Button btn2 = findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("tag","这是匿名内部类实现的点击");
            }
        });

        Button btn3 = findViewById(R.id.btn3);

        btn3.setOnClickListener(this);
    }

    public void myClick(View view){
        //getId()可以获取被点击按钮的id属性
//        Log.e("tag","通过xml绑定方法实现点击");
        switch (view.getId()){
            case R.id.btn4:
                Log.e("tag","通过xml绑定方法实现点击");
                break;
            case R.id.btn5:
                Log.e("tag","通过xml1绑定方法实现点击");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        Log.e("tag","当前类继承点击实现");
    }

    //定义内部类实现点击事件类
    class MyClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Log.e("tag","这是内部类按钮");
        }
    }
}
