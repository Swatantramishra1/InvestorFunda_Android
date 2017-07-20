package com.knowledgeflex.investfund.grid;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.knowledgeflex.investfund.ClickListener;
import com.knowledgeflex.investfund.Mutual_Fund_Adapter;
import com.knowledgeflex.investfund.Mutual_Funds;
import com.knowledgeflex.investfund.R;

import java.util.ArrayList;
import java.util.List;

public class Card_Activity extends AppCompatActivity implements ClickListener {

    private Mutual_Fund_Adapter adapter;
    private ImageView add_icon;
    private List<Mutual_Funds> fund_list;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
        }
       /* add_icon = (ImageView) findViewById(R.id.plus);
        add_icon = new ImageView(this);*/
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(this.mLayoutManager);
        fund_list = new ArrayList();
        adapter = new Mutual_Fund_Adapter(this, this.fund_list);
        adapter.setClickListener(this);
        recyclerView.setAdapter(this.adapter);
        fund_list.add(new Mutual_Funds("663.55", "333.66", "0%", "FRANLIN"));
        fund_list.add(new Mutual_Funds("663.55", "333.66", "0%", "BIRLA"));
        fund_list.add(new Mutual_Funds("663.55", "333.66", "0%", "AXIS"));
        fund_list.add(new Mutual_Funds("663.55", "333.66", "0%", "FRANKLIN"));
        fund_list.add(new Mutual_Funds("663.55", "333.66", "0%", "HDFC"));
    }

    public void itemClicked(View view, int position) {
        if (position == 0) {
            Toast.makeText(getApplicationContext(), "Ankit", Toast.LENGTH_LONG).show();
            this.add_icon.setImageResource(R.drawable.minus25);
        } else if (position == 1) {
            Toast.makeText(getApplicationContext(), "Ankit", Toast.LENGTH_LONG).show();
            this.add_icon.setImageDrawable(view.getResources().getDrawable(R.drawable.minus25));
        } else if (position == 2) {
            Toast.makeText(getApplicationContext(), "Ankit", Toast.LENGTH_LONG).show();
            this.add_icon.setImageDrawable(view.getResources().getDrawable(R.drawable.minus25));
        } else {
            System.out.println("position...." + position);
            Toast.makeText(getApplicationContext(), "Ankit", Toast.LENGTH_LONG).show();
            this.add_icon.setImageDrawable(view.getResources().getDrawable(R.drawable.minus25));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        if (item.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}