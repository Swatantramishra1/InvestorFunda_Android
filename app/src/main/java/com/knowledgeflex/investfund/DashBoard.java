package com.knowledgeflex.investfund;

import android.app.Activity;
import android.content.Intent;
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
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.knowledgeflex.investfund.Model.DashBoardDetailsResult;
import com.knowledgeflex.investfund.Model.UserInvestmentSchemeDetailsData;
import com.knowledgeflex.investfund.adapter.DashBoardAdapter;
import com.knowledgeflex.investfund.tax.SaveTaxes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoard extends AppCompatActivity implements MyAdapter.OnItemClickListener{

    ListView scheme;
    private ApiService apiService;
    ProgressBar progressBar;
    TextView welcome;
    ArrayList<UserInvestmentSchemeDetailsData> resultSchemeData;
    DashBoardAdapter adapter;
    //Float schemeNav[];
    double cNav[];
    String folio[];
    String isin[];
    String name[];
    String sNav[];
    double amountTotal[];
    double units[];
    Map<String,Integer> id;
    int count = 0;
    DrawerLayout Drawer;
    String EMAIL;
    String NAME;
    int PROFILE;
    String[] TITLES;
    private Intent intent;
    private MyAdapter.OnItemClickListener listener;
    RecyclerView.Adapter mAdapter;
    ActionBarDrawerToggle mDrawerToggle;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView mRecyclerView;
    private Toolbar toolbar;
    TextView totalAmount;
    TextView currentTotalValue;
    TextView totalProfitLoss;
    TextView amountText;
    TextView currentText;
    TextView lossText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        this.listener = this;
        this.NAME = Utils.getStringPref(Utils.LoginNAME);
        this.EMAIL = Utils.getStringPref(Utils.LoginID);
        getWindow().setSoftInputMode(3);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
            SpannableString s = new SpannableString(getString(R.string.dashboard));
            s.setSpan(Utils.returnOpenSansFont(this), 0, s.length(), 28);
            getSupportActionBar().setTitle(s);
        }
        scheme = (ListView)findViewById(R.id.scheme);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        welcome = (TextView) findViewById(R.id.welcome);
        apiService = (ApiService) ApiService.retrofit.create(ApiService.class);
        totalAmount= (TextView) findViewById(R.id.totalAmount);
        currentTotalValue = (TextView) findViewById(R.id.currentTotalValue);
        totalProfitLoss = (TextView) findViewById(R.id.totalProfitLoss);
        amountText = (TextView) findViewById(R.id.totalText);
        currentText = (TextView) findViewById(R.id.CurrentValueText);
        lossText = (TextView) findViewById(R.id.lossText);
        resultSchemeData = new ArrayList<UserInvestmentSchemeDetailsData>();
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new MyAdapter(TITLES, NAME, EMAIL, PROFILE, listener, this);
        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(this);
        currentTotalValue.setTypeface(Utils.returnPtSansFont(this));
        totalAmount.setTypeface(Utils.returnPtSansFont(this));
        totalProfitLoss.setTypeface(Utils.returnPtSansFont(this));
        amountText.setTypeface(Utils.returnPtSansFont(this));
        currentText.setTypeface(Utils.returnPtSansFont(this));
        lossText.setTypeface(Utils.returnPtSansFont(this));
        mRecyclerView.setLayoutManager(this.mLayoutManager);
        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
        mDrawerToggle = new Tool(this, Drawer, toolbar, R.string.openDrawer, R.string.closeDrawer);
        Drawer.setDrawerListener(this.mDrawerToggle);
        mDrawerToggle.syncState();
        /*cNav = new ArrayList<String>();
        folio = new ArrayList<String>();
        isin = new ArrayList<String>();
        name = new ArrayList<String>();
        sNav = new ArrayList<String>();
        amountTotal = new ArrayList<Double>();
        units = new ArrayList<Double>();*/
        id = new ConcurrentHashMap<String, Integer>();
        if(new Utils().isNetworkAvailable(getApplicationContext())){
            apiService.getDashBoard(Utils.getStringPref(Utils.UserId)).enqueue(new DashBoardResult());
        }
        else {
            progressBar.setVisibility(View.GONE);
            welcome.setVisibility(View.VISIBLE);
            Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_LONG).show();
        }
    }

    private class DashBoardResult implements Callback<DashBoardDetailsResult> {
        @Override
        public void onResponse(Call<DashBoardDetailsResult> call, Response<DashBoardDetailsResult> response) {
            if (((DashBoardDetailsResult) response.body()).getGetDashInvestmentDetailsResult().getResponseCode().intValue() == 0){
                resultSchemeData = ((DashBoardDetailsResult) response.body()).getGetDashInvestmentDetailsResult().getResultSchemeData().getUserInvestmentSchemeDetailsData();
               /* adapter = new DashBoardAdapter(DashBoard.this, resultSchemeData);
                scheme.setAdapter(adapter);*/
                calculateSchemeCost(resultSchemeData);
               // progressBar.setVisibility(View.GONE);
            }
            else {
                welcome.setVisibility(View.VISIBLE);
                welcome.setText("No Schemes");
                progressBar.setVisibility(View.GONE);
            }
        }

        @Override
        public void onFailure(Call<DashBoardDetailsResult> call, Throwable t) {
            Log.e("Error result",t.toString());
            progressBar.setVisibility(View.GONE);
            welcome.setVisibility(View.VISIBLE);
            welcome.setText("Currently not available please try again");
        }
    }

    private synchronized void calculateSchemeCost(ArrayList<UserInvestmentSchemeDetailsData> resultSchemeData) {
        double amount=0.0;
        double unit =0.0;
        double currentValue = 0.0;
       // schemeNav = new Float[resultSchemeData.size()];
      //  Log.e("resultSchemeData.size()", String.valueOf(resultSchemeData.size()));
        for(int i=0;i<resultSchemeData.size();i++){
            amount = amount + Double.parseDouble(resultSchemeData.get(i).getAmount());
            checkMap(resultSchemeData.get(i));
        }
        totalAmount.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(amount)));
        Iterator<String> it1 = id.keySet().iterator();
        cNav = new double[id.size()];
        folio = new String[id.size()];
        isin = new String[id.size()];
        name = new String[id.size()];
        sNav = new String[id.size()];
        amountTotal= new double[id.size()];
        units = new double[id.size()];

        while(it1.hasNext()){
            String key = it1.next();
          //  System.out.println("Map Value:"+id.get(key));
          //  Log.e("Map Value:", String.valueOf(id.get(key)));
          //  Log.e("Map Count:", key);
            addValue(id.get(key),key, count);
            count = count +1;
        }

       // Log.e("CNav, folio", String.valueOf(cNav.length)+" "+String.valueOf(folio.length)+ " "+ String.valueOf(isin.length)+" "+String.valueOf(name.length));

        adapter = new DashBoardAdapter(DashBoard.this, name, units, cNav, amountTotal,folio,currentTotalValue,totalProfitLoss);
        scheme.setAdapter(adapter);
        System.out.println(Arrays.toString(units));
        System.out.println(Arrays.toString(name));
        System.out.println(Arrays.toString(folio));
        System.out.println(Arrays.toString(cNav));
        System.out.println(Arrays.toString(amountTotal));
        progressBar.setVisibility(View.GONE);
    }

    private synchronized void addValue(Integer totalCount, String key, int cnt) {
        double unit =0.0;
        double amount =0.0;
        String s_name = "Na";
        String s_foli = "Na";
        double s_cnav = 0.0;

       for (int i=0;i<=resultSchemeData.size();i++){
         //  if(totalCount>1) {
           if(resultSchemeData.size()==i){
               units[cnt] = unit;
               amountTotal[cnt] = amount;
               name[cnt] = s_name;
               folio[cnt] = s_foli;
               cNav[cnt] = s_cnav;
           }
           else {
               if (resultSchemeData.get(i).getISIN().equals(key)) {
                   unit = unit + Double.parseDouble(resultSchemeData.get(i).getAmount()) / Double.parseDouble(resultSchemeData.get(i).getSchemeNav());
                   amount = amount + Double.parseDouble(resultSchemeData.get(i).getAmount());
                   s_name = resultSchemeData.get(i).getSchemeName();
                   s_foli = resultSchemeData.get(i).getFolio();
                   s_cnav = Double.parseDouble(resultSchemeData.get(i).getCurrentNav());
               }
           }
       }
    }

    private synchronized void checkMap(UserInvestmentSchemeDetailsData userInvestmentSchemeDetailsData) {
        if(id.size()!=0) {
            Iterator<String> it1 = id.keySet().iterator();
            while(it1.hasNext()){
                String key = it1.next();
               // Log.e("Map Value loop:", String.valueOf(id.get(key)));
                int value = id.get(key);
                if(key.equals(userInvestmentSchemeDetailsData.getISIN())){
                    id.remove(key);
                    int count = value + 1;
                    id.put(key, count);
                }
                else {
                    id.put(userInvestmentSchemeDetailsData.getISIN(), 1);
                }
            }
        }
        else if(id.size()==0){
           // Log.e("Map Value loop 0:", userInvestmentSchemeDetailsData.getISIN());
            id.put(userInvestmentSchemeDetailsData.getISIN(), 1);
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

    public DashBoard() {
       // this.TITLES = new String[]{"DASHBOARD", "PLAN YOUR FUTURE", "NOTIFICATIONS", "CONTACT US", "HELP", "PRIVACY", "SHARE APP", "ABOUT", "LOGOUT"};
        this.TITLES = new String[]{"HOME", "PROFILE", "DASHBOARD", "PRIVACY", "TERMS OF USE", "CONTACT US", "LOGOUT"};
        this.NAME = Utils.LoginNAME;
        this.EMAIL = Utils.getStringPref(Utils.LoginID);
        this.PROFILE = R.drawable.profile;
        this.intent = null;
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
                 this.intent = new Intent(DashBoard.this, Portfolio.class);
                 //finish();
                break;
            case 1 :
                this.intent = new Intent(DashBoard.this, Drawer_Activity.class);
                finish();
                break;
            case 4:
                this.intent = new Intent(DashBoard.this, Privacy.class);
             //   finish();
                break;
            case 5:
                this.intent = new Intent(DashBoard.this, Terms.class);
               // finish();
                break;
            case 6:
                this.intent = new Intent(DashBoard.this, Contact.class);
               // finish();
                break;
            case 7:
                this.intent = new Intent(DashBoard.this, MainActivity.class);
                finish();
                Utils.clearAll();
                Utils.setBooleanPref(Utils.LoginSucces, false);
                break;
        }
        if (this.intent != null) {
            startActivity(this.intent);
        }
        this.Drawer.closeDrawers();
    }

}
