package com.bwie.wangshaoliang20171227;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private Bean bean;
    private List<Bean> list;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            System.out.println(msg.obj.toString());
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = (ListView) findViewById(R.id.lv);
         list=new ArrayList<Bean>();
        for (int i = 0; i < 10; i++) {
            Bean bean=new Bean();
            bean.setImg("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1629300826,4257003656&fm=27&gp=0.jpg");
            bean.setTitle("标题");
            list.add(bean);
        }
        //通过handler传递数据到主线程
        Message msg = new Message();
        msg.obj = "标题";
        handler.sendMessage(msg);
        lv.setAdapter(new MyAdapter(list,MainActivity.this));
    }
}
