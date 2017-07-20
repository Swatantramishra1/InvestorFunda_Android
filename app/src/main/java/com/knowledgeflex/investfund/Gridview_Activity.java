package com.knowledgeflex.investfund;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

import com.knowledgeflex.investfund.grid.BuyCar;
import com.knowledgeflex.investfund.grid.BuyHome;
import com.knowledgeflex.investfund.grid.Card_Activity;
import com.knowledgeflex.investfund.grid.Child_E;
import com.knowledgeflex.investfund.grid.Child_Marriage;
import com.knowledgeflex.investfund.grid.Retirement;
import com.knowledgeflex.investfund.grid.Tour;

public class Gridview_Activity extends AppCompatActivity implements View.OnClickListener {

    GridView grid;
    int[] imageId;
    String[] web;
    RelativeLayout education;
    RelativeLayout retire;
    RelativeLayout marriage;
    RelativeLayout house;
    RelativeLayout car;
    RelativeLayout tour;   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        getWindow().setSoftInputMode(3);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
            SpannableString s = new SpannableString(getString(R.string.planYour));
            s.setSpan(Utils.returnOpenSansFont(this), 0, s.length(), 33);
            getSupportActionBar().setTitle(s);
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
       /* CustomGrid adapter = new CustomGrid(this, web, imageId);
        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new GridClickTwo());*/
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
                startActivity(new Intent(Gridview_Activity.this, Child_E.class));
                break;
            case R.id.retirement_cal:
                startActivity(new Intent(Gridview_Activity.this, Retirement.class));
                break;
            case R.id.marriage_cal:
                startActivity(new Intent(Gridview_Activity.this, Child_Marriage.class));
                break;
            case R.id.house_cal:
                startActivity(new Intent(Gridview_Activity.this, BuyHome.class));
                break;
            case R.id.car_cal:
                startActivity(new Intent(Gridview_Activity.this, BuyCar.class));
                break;
            case R.id.holiday_cal:
                startActivity(new Intent(Gridview_Activity.this, Tour.class));
                break;
        }
    }

    class GridClickTwo implements OnItemClickListener {
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            switch (position) {
                case 0:
                    Gridview_Activity.this.startActivity(new Intent(Gridview_Activity.this, Child_E.class));
                    //finish();
                    break;
                case 1:
                    Gridview_Activity.this.startActivity(new Intent(Gridview_Activity.this, Retirement.class));
                    //finish();
                    break;
                case 2:
                    Gridview_Activity.this.startActivity(new Intent(Gridview_Activity.this, Child_Marriage.class));
                    //finish();
                    break;
                case 3:
                    //Gridview_Activity.this.startActivity(new Intent(Gridview_Activity.this, Card_Activity.class));
                    Gridview_Activity.this.startActivity(new Intent(Gridview_Activity.this, BuyHome.class));
                    //finish();
                    break;
                case 4:
                    Gridview_Activity.this.startActivity(new Intent(Gridview_Activity.this, BuyCar.class));
                    break;
                case 5:
                    Gridview_Activity.this.startActivity(new Intent(Gridview_Activity.this, Tour.class));
                    break;
                default:
            }
        }
    }

    /*public Gridview_Activity() {
        this.web = new String[]{"Child's Education", "Retirement", "Child's Marriage", "Buy A House", "Buy A Car", "Plan A Holiday"};
        this.imageId = new int[]{R.drawable.childeducation, R.drawable.retire_, R.drawable.c_marriage, R.drawable.home_two, R.drawable.buy_car, R.drawable.vacation};
    }*/
}