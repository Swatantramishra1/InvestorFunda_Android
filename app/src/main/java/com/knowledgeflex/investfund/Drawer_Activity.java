package com.knowledgeflex.investfund;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.knowledgeflex.investfund.Model.LoginResponse;
import com.knowledgeflex.investfund.Model.UserDetailResponse;
import com.knowledgeflex.investfund.invest.MutualFunds;
import com.knowledgeflex.investfund.tax.SaveTaxes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Drawer_Activity extends AppCompatActivity implements MyAdapter.OnItemClickListener {

    public static final String PREFS_NAME = "userdetails";
    DrawerLayout Drawer;
    String EMAIL;
    String NAME;
    int PROFILE;
    String[] TITLES;
    private Intent intent;
    private MyAdapter.OnItemClickListener listener;
    LinearLayout ll1;
    RecyclerView.Adapter mAdapter;
    ActionBarDrawerToggle mDrawerToggle;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView mRecyclerView;
    SharedPreferences sharedPreferences;
    private Toolbar toolbar;
    private TextView txts1;
    private TextView txts2;
    private TextView txts3;
    private TextView txts4;
    private TextView txts5;
    private TextView txts6;
    private UserDetailResponse userDetailResponse;
    Calendar myCalendar = Calendar.getInstance();
    SimpleDateFormat dateFormatter;
    private ApiService apiService;
    private boolean isNetwork;
    private ProgressDialog dialog;

    class PlanFuture implements View.OnClickListener {
        public void onClick(View v) {
            startActivity(new Intent(Drawer_Activity.this, Gridview_Activity.class));
        }
    }

     class StartSip implements View.OnClickListener {
         @Override
         public void onClick(View view) {
            // startActivity(new Intent(Drawer_Activity.this, StartSIP.class));
             startActivity(new Intent(Drawer_Activity.this, StartSIP.class));
         }
     }

    class Invest implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            //startActivity(new Intent(Drawer_Activity.this, InvestNow_Activity.class));
            startActivity(new Intent(Drawer_Activity.this, MutualFunds.class));
        }
    }

    class SelectFunds implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            //startActivity(new Intent(Drawer_Activity.this, .class));
            startActivity(new Intent(Drawer_Activity.this, OneTimeInvestment.class));
        }
    }

    class Taxes implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(Drawer_Activity.this, SaveTaxes.class));
        }
    }

    class Calculator implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(Drawer_Activity.this, Calculators.class));
        }
    }

   class Tool extends ActionBarDrawerToggle {
        Tool(Activity arg0, DrawerLayout arg1, Toolbar arg2, int arg3, int arg4) {
            super(arg0, arg1, arg2, arg3, arg4);
        }

        public void onDrawerOpened(View drawerView) {
            super.onDrawerOpened(drawerView);
        }

        public void onDrawerClosed(View drawerView) {
            super.onDrawerClosed(drawerView);
        }
    }

    public Drawer_Activity() {
       // this.TITLES = new String[]{"DASHBOARD", "PLAN YOUR FUTURE", "NOTIFICATIONS", "CONTACT US", "HELP", "PRIVACY", "SHARE APP", "ABOUT", "LOGOUT"};
        this.TITLES = new String[]{"HOME", "PROFILE", "DASHBOARD", "PRIVACY", "TERMS OF USE", "CONTACT US", "LOGOUT"};
        this.NAME = Utils.LoginNAME;
        this.EMAIL = Utils.getStringPref(Utils.LoginID);
        this.PROFILE = R.drawable.profile;
        this.intent = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_);
        this.listener = this;
        this.sharedPreferences = getSharedPreferences(PREFS_NAME, 0);
        this.NAME = Utils.getStringPref(Utils.LoginNAME);
        this.EMAIL = Utils.getStringPref(Utils.LoginID);
        getWindow().setSoftInputMode(3);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
            SpannableString s = new SpannableString("INVESTORFUNDA");
            s.setSpan(Utils.returnOpenSansFont(this), 0, s.length(), 33);
            getSupportActionBar().setTitle(s);
        }
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        apiService = (ApiService) ApiService.retrofit.create(ApiService.class);
        dialog = new ProgressDialog(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView_one);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new MyAdapter(TITLES, NAME, EMAIL, PROFILE, listener, this);
        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(this.mLayoutManager);
        ll1 = (LinearLayout) findViewById(R.id.ll1);
        txts1 = (TextView) findViewById(R.id.txtS1);
        txts2 = (TextView) findViewById(R.id.txtS2);
        txts3 = (TextView) findViewById(R.id.txtS3);
        txts4 = (TextView) findViewById(R.id.txtS4);
        txts5 = (TextView) findViewById(R.id.txtS5);
        txts6 = (TextView) findViewById(R.id.txtS6);
        //setTypeFace();
        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout_one);
        mDrawerToggle = new Tool(this, Drawer, toolbar, R.string.openDrawer, R.string.closeDrawer);
        Drawer.setDrawerListener(this.mDrawerToggle);
        mDrawerToggle.syncState();
        txts1.setOnClickListener(new StartSip());
        txts2.setOnClickListener(new PlanFuture());
        txts3.setOnClickListener(new Invest());
        txts4.setOnClickListener(new SelectFunds());
        txts5.setOnClickListener(new Taxes());
        txts6.setOnClickListener(new Calculator());
        //  Log.e("UserId",Utils.getStringPref(Utils.UserId));
        if (Utils.isNetworkAvailable(this)) {
            dialog.setMessage(getString(R.string.loading));
            dialog.setCanceledOnTouchOutside(true);
            dialog.show();
            isNetwork = true;
            apiService.createLogin(Utils.getStringPref("email"),Utils.getStringPref("pass")).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (((LoginResponse) response.body()).getGetLoginResult().getResult().getIsComplete().equals("1")) {
                        Toast.makeText(getApplicationContext(),getApplicationContext().getResources().getString(R.string.alert_invest),Toast.LENGTH_LONG).show();
                        Intent i = new Intent(Drawer_Activity.this,Portfolio.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    }
                    else if(((LoginResponse) response.body()).getGetLoginResult().getResult().getIsComplete().equals("0")) {
                        apiService.getUserDetail(Utils.getStringPref(Utils.UserId)).enqueue(new UserDetail());
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {

                }
            });
        }
    }

    class UserDetail implements Callback<UserDetailResponse> {
        public void onResponse(Call<UserDetailResponse> call, Response<UserDetailResponse> response) {
            try {
                userDetailResponse = (UserDetailResponse) response.body();
                Utils.writeObject(getApplicationContext(), "UserDetails", userDetailResponse);
                dialog.dismiss();
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("Data response error",e.toString());
            }
        }

        public void onFailure(Call<UserDetailResponse> call, Throwable t) {
            dialog.dismiss();
            Log.e("Error userDetails",t.getLocalizedMessage());
           // Toast.makeText(getA, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void setTypeFace() {
        this.txts1.setTypeface(Utils.returnPtSansFont(this));
        this.txts2.setTypeface(Utils.returnPtSansFont(this));
        this.txts3.setTypeface(Utils.returnPtSansFont(this));
        this.txts4.setTypeface(Utils.returnPtSansFont(this));
        this.txts5.setTypeface(Utils.returnPtSansFont(this));
        this.txts6.setTypeface(Utils.returnPtSansFont(this));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings || this.mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

  @Override
    public void onItemClick(int position, View view) {
      switch (position) {
          case 2 :
              this.intent = new Intent(Drawer_Activity.this, Portfolio.class);
             // finish();
              break;
          case 3 :
              this.intent = new Intent(Drawer_Activity.this, DashBoard.class);
              finish();
              break;
          case 4:
              this.intent = new Intent(Drawer_Activity.this, Privacy.class);
              //finish();
              break;
          case 5:
              this.intent = new Intent(Drawer_Activity.this, Terms.class);
             // finish();
              break;
          case 6:
              this.intent = new Intent(Drawer_Activity.this, Contact.class);
             // finish();
              break;
          case 7:
              this.intent = new Intent(Drawer_Activity.this, MainActivity.class);
              finish();
              Utils.clearAll();
              Utils.setBooleanPref(Utils.LoginSucces, false);
              break;
         /* case 3:
              this.intent = new Intent(Drawer_Activity.this, Portfolio.class);
              break;*/
      }
      if (this.intent != null) {
          startActivity(this.intent);
      }
      this.Drawer.closeDrawers();
  }

}
