package com.knowledgeflex.investfund;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Retirement_Result extends AppCompatActivity {

    public static final String PREFS_NAME = "Result";
    TextView invest;
    TextView need;
    TextView returns;
    SharedPreferences sharedPreferences;
    Button submit;
    Long t1;
    Long t2;
    Long t3;
    Long t4;
    TextView years;

    class C02831 implements View.OnClickListener {
         public void onClick(View v) {
            Retirement_Result.this.startActivity(new Intent(Retirement_Result.this, InvestNow_Activity.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retirement__result);
        getWindow().setSoftInputMode(3);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
        }
        this.need = (TextView) findViewById(R.id.need_retirement);
        this.invest = (TextView) findViewById(R.id.invest_retirement);
        this.years = (TextView) findViewById(R.id.years);
        this.returns = (TextView) findViewById(R.id.returns);
        this.submit = (Button) findViewById(R.id.get_going_retirement);
        this.sharedPreferences = getSharedPreferences(PREFS_NAME, 0);
        this.t1 = Long.valueOf(this.sharedPreferences.getLong("total7", 0));
        this.t2 = Long.valueOf(this.sharedPreferences.getLong("total8", 0));
        this.t3 = Long.valueOf(this.sharedPreferences.getLong("total9", 0));
        this.t4 = Long.valueOf(this.sharedPreferences.getLong("total6", 0));
        this.need.setText(String.valueOf(this.t1));
        this.invest.setText(String.valueOf(this.t2));
        this.years.setText(String.valueOf(this.t3));
        this.returns.setText(String.valueOf(this.t4));
        this.submit.setOnClickListener(new C02831());
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

