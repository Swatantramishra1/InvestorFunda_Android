package com.knowledgeflex.investfund.invest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.knowledgeflex.investfund.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OurTopFundFilter extends AppCompatActivity {

    OurTopFund ourTopFund;
    ListView type;
    private ArrayList<String> list;
    OurTopFilterAdapter ourTopFilterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_top_fund_filter);
        ourTopFund = (OurTopFund)getIntent().getSerializableExtra("listdata");
       // ourTopFund = (OurTopFund) bundle.getSerializable("listData");
        type = (ListView) findViewById(R.id.mftype);
        list = new ArrayList<String>();
        for(int i=0;i<ourTopFund.getOurFund().size();i++){
            list.add(ourTopFund.getOurFund().get(i).getMfType());
        }
        Set<String> hs = new HashSet<>();
        hs.addAll(list);
        list.clear();
        list.addAll(hs);
        ourTopFilterAdapter = new OurTopFilterAdapter(getApplicationContext(),0, (list));
        ourTopFilterAdapter.setNotifyOnChange(true);
        type.setAdapter(ourTopFilterAdapter);

        type.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view.findViewById(R.id.mType);
                Log.e("Check text",textView.getText().toString());
                Intent resultData = new Intent();
                resultData.putExtra("type", textView.getText().toString());
                setResult(123, resultData);
                finish();
            }
        });

    }
}
