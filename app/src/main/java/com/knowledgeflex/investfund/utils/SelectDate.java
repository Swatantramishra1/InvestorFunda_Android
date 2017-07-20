package com.knowledgeflex.investfund.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.knowledgeflex.investfund.Child_Result;
import com.knowledgeflex.investfund.R;

public class SelectDate extends AppCompatActivity {

    String[] value;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
        }
        value = getIntent().getStringArrayExtra("value");
        gridView =(GridView)findViewById(R.id.dates);
        DateAdapter adapter = new DateAdapter(SelectDate.this,value);
        gridView.setAdapter(adapter);
    }

}
