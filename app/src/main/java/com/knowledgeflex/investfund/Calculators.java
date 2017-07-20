package com.knowledgeflex.investfund;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.knowledgeflex.investfund.grid.BuyCar;
import com.knowledgeflex.investfund.grid.BuyHome;
import com.knowledgeflex.investfund.grid.Child_E;
import com.knowledgeflex.investfund.grid.Child_Marriage;
import com.knowledgeflex.investfund.grid.Retirement;
import com.knowledgeflex.investfund.grid.Tour;

public class Calculators extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout education;
    RelativeLayout retire;
    RelativeLayout marriage;
    RelativeLayout house;
    RelativeLayout car;
    RelativeLayout tour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
        }

        education = (RelativeLayout)findViewById(R.id.childEducation_cal);
        retire = (RelativeLayout)findViewById(R.id.retirement_cal);
        marriage = (RelativeLayout)findViewById(R.id.marriage_cal);
        house = (RelativeLayout)findViewById(R.id.house_cal);
        car = (RelativeLayout)findViewById(R.id.car_cal);
        tour = (RelativeLayout)findViewById(R.id.holiday_cal);
        education.setOnClickListener(this);
        retire.setOnClickListener(this);
        marriage.setOnClickListener(this);
        house.setOnClickListener(this);
        car.setOnClickListener(this);
        tour.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.childEducation_cal:
                startActivity(new Intent(Calculators.this, Child_E.class));
                break;
            case R.id.retirement_cal:
                startActivity(new Intent(Calculators.this, Retirement.class));
                break;
            case R.id.marriage_cal:
                startActivity(new Intent(Calculators.this, Child_Marriage.class));
                break;
            case R.id.house_cal:
                startActivity(new Intent(Calculators.this, BuyHome.class));
                break;
            case R.id.car_cal:
                startActivity(new Intent(Calculators.this, BuyCar.class));
                break;
            case R.id.holiday_cal:
                startActivity(new Intent(Calculators.this, Tour.class));
                break;
        }
    }
}
