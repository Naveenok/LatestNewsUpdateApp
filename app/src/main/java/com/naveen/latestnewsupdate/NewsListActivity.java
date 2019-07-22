package com.naveen.latestnewsupdate;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NewsListActivity extends AppCompatActivity {
    public static TextView data;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        data = (TextView) findViewById(R.id.txtTest);
        NewsData newsData=new NewsData();
        newsData.execute();

    }
}
