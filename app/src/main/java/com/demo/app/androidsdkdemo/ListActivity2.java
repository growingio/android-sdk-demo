package com.demo.app.androidsdkdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.growingio.android.sdk.collection.GrowingIO;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListActivity2 extends AppCompatActivity {

    @Bind(R.id.listView)
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        ButterKnife.bind(this);
        onClickPg1(null);
    }

    @OnClick(R.id.switchPg1)
    public void onClickPg1(View view) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add("第一个 #" + i);
        }
        GrowingIO.getInstance().setPageGroup(this, "page_ground_1");
        listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, data));
    }

    @OnClick(R.id.switchPg2)
    public void onClickPg2(View view) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add("第二个 #" + i);
        }
        GrowingIO.getInstance().setPageGroup(this, "page_ground_2");
        listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, data));
    }

    @OnClick(R.id.switchPg3)
    public void onClickPg3(View view) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add("第三个 #" + i);
        }
        GrowingIO.getInstance().setPageGroup(this, "page_ground_3");
        listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, data));
    }
}
