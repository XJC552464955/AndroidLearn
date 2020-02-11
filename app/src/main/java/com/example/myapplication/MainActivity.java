package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        //根布局设置为线性布局
//        LinearLayout ll = new LinearLayout(this);
//        //设置宽高
//        ll.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
//        //设置背景颜色
//        ll.setBackgroundColor(Color.BLUE);
//        //指定此Activity的内容视图为该内容视图
//        setContentView(ll);
    }

    public void register(View view){
        EditText nameEdt = findViewById(R.id.name);
        EditText pwdEdt = findViewById(R.id.pwd);
        final ProgressBar bar = findViewById(R.id.progress);

        String name = nameEdt.getText().toString();
        String pwd = pwdEdt.getText().toString();

        bar.setProgress(10);

        if(name.equals("") || pwd.equals("")){
            //无焦点提示：在屏幕中下部出现的提示框
            //参数一：环境上下文，即无焦点对象依赖的对象
            //参数二：提示文本
            //参数三：持续时间，是一个常量
            Toast.makeText(this, "姓名和密码不能为空", Toast.LENGTH_SHORT).show();
        }else{
            bar.setVisibility(View.VISIBLE);
            new Thread(){
                @Override
                public void run() {
                    for(int i=1;i<=100;i++){
                        bar.setProgress(i);
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
        }

    }
}
