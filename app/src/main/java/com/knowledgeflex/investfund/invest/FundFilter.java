package com.knowledgeflex.investfund.invest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.knowledgeflex.investfund.Model.ListFundResponse;
import com.knowledgeflex.investfund.Model.Scheme;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.Utils;
import com.knowledgeflex.investfund.utils.Utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FundFilter extends AppCompatActivity implements View.OnClickListener, Equity, Debts, Hybrid, House{

    ListView equityList;
    ListView debtList;
    ListView hybridList;
    ListView fundHouseList;
    TextView equity;
    TextView assetType;
    TextView debt;
    TextView hybrid;
    CheckBox growth;
    CheckBox divided;
    TextView fundHouse;
    LinearLayout assetLayout;
    TextView fundOption;
    List<Scheme> schemeResult;
    FundHouseAdapter baseAdapter;
    EquityAdapter equityAdapter;
    DebtAdapter debtAdapter;
    HybridAdapter hybridAdapter;
    String equityData ="";
    String debtData="";
    String hybridData="";
    String houseData ="";
    String growthData="";
    Button search;
    String data ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund_filter);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        equityList = (ListView) findViewById(R.id.equityList);
        debtList = (ListView) findViewById(R.id.debtList);
        hybridList = (ListView) findViewById(R.id.hybridList);
        fundHouseList = (ListView) findViewById(R.id.houseList);
        equity = (TextView) findViewById(R.id.equity);
        assetType= (TextView) findViewById(R.id.assetType);
        debt = (TextView) findViewById(R.id.debt);
        hybrid = (TextView) findViewById(R.id.hybrid);
        fundOption = (TextView) findViewById(R.id.option);
        growth = (CheckBox) findViewById(R.id.growth);
        divided = (CheckBox) findViewById(R.id.divided);
        fundHouse  = (TextView) findViewById(R.id.fundHouse);
        assetLayout = (LinearLayout) findViewById(R.id.assetList);
        search = (Button) findViewById(R.id.search);
        //equityList.setOnClickListener(this);
        //debtList.setOnClickListener(this);
        // hybridList.setOnClickListener(this);
        //    fundHouseList.setOnClickListener(this);
        equity.setOnClickListener(this);
        assetType.setOnClickListener(this);
        debt.setOnClickListener(this);
        hybrid.setOnClickListener(this);
        search.setOnClickListener(this);

        fundHouse.setOnClickListener(this);
        assetLayout.setOnClickListener(this);
        fundOption.setOnClickListener(this);
        growth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    if(growthData == null){
                        growthData = growth.getText().toString();
                    }
                    else {
                        if(growthData.contains("Growth")){
                            Log.e("Data","there");
                        }
                        else {
                            growthData = growthData + "," +growth.getText().toString();
                        }
                    }
                }
            }
        });
        divided.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    if(growthData == null){
                        growthData = divided.getText().toString();
                    }
                    else {
                        if(growthData.contains("Dividend")){
                            Log.e("Data","there");
                        }
                        else {
                            growthData = growthData + "," +divided.getText().toString();
                        }
                    }
                }
            }
        });

        try{
            if(Utils.isNetworkAvailable(this)) {
                new FundHouse(this).execute();
            }
        }
        catch (Exception e){
            Log.e("fundhouse",e.toString());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.equity:
                equity.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_expand_less, 0);
                equityList.setVisibility(View.VISIBLE);
                break;
            case R.id.assetType:
                assetType.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_expand_less, 0);
                assetLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.debt:
                debt.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_expand_less, 0);
                debtList.setVisibility(View.VISIBLE);
                break;
            case R.id.hybrid:
                hybrid.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_expand_less, 0);
                hybridList.setVisibility(View.VISIBLE);
                break;
            case R.id.option:
                fundOption.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_expand_less, 0);
                growth.setVisibility(View.VISIBLE);
                divided.setVisibility(View.VISIBLE);
                break;
            case R.id.fundHouse:
                fundHouse.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_expand_less, 0);
                fundHouseList.setVisibility(View.VISIBLE);
                break;
            case R.id.search:
                String testVinodPagal="";
                if(equityData !="")
                {
                    testVinodPagal=equityData;
                    if(debtData !="")
                    {
                        testVinodPagal=testVinodPagal+ ","+debtData;
                        if(hybridData !="")
                        {
                            testVinodPagal=testVinodPagal+ ","+hybridData;
                        }
                    }
                    else if(hybridData !="")
                    {
                        testVinodPagal=testVinodPagal+ ","+hybridData;
                    }
                }
                else if(debtData !="")
                {
                    testVinodPagal=debtData;
                    if(equityData !="")
                    {
                        testVinodPagal=testVinodPagal+ ","+equityData;
                        if(hybridData !="")
                        {
                            testVinodPagal=testVinodPagal+ ","+hybridData;
                        }
                    }
                    else if(hybridData !="")
                    {
                        testVinodPagal=testVinodPagal+ ","+hybridData;
                    }
                }
                else if(hybridData !="")
                {
                    testVinodPagal=hybridData;
                    if(equityData !="")
                    {
                        testVinodPagal=testVinodPagal+ ","+equityData;
                        if(debtData !="")
                        {
                            testVinodPagal=testVinodPagal+ ","+debtData;
                        }
                    }
                    else if(debtData !="")
                    {
                        testVinodPagal=testVinodPagal+ ","+debtData;
                    }
                }
                if(testVinodPagal =="")
                {
                    testVinodPagal="-";
                }

                if(houseData.equals("")){
                    houseData = "-";
                }

                if(growthData.equals("")){
                    growthData = "-";
                }
                data = houseData+"/"+testVinodPagal+"/"+growthData;
               /* List<String> dataResult = new  ArrayList<String>();
                dataResult.add(houseData);
                dataResult.add(equityData);
                dataResult.add(debtData);
                dataResult.add(hybridData);
                dataResult.add(growthData);
                for (int i=0;i<dataResult.size();i++){
                    Log.e("datttt",dataResult.get(i).toString());
                    if(!dataResult.get(i).toString().equals("")){
                        if(i==0){
                            data = dataResult.get(i).toString()+"/";
                        }
                        else if(i==3){
                            data = data + dataResult.get(i).toString()+"/";
                        }
                        else if(dataResult.size()-1==i){
                            data = data + dataResult.get(i).toString();
                        }
                        else{
                            data = data + dataResult.get(i).toString()+",";
                        }

                    }
                }*/


              /*  if(equityData.equals("")){
                    data = "-"+"/"+houseData+"/"+growthData;
                }
                if(debtData.equals("")){

                }
                if(hybridData.equals("")){

                }
                if(houseData.equals("")){
                    data = "-"+ "/" +equityData +","+ debtData+","+hybridData+"/"+"-"+"/"+growthData;
                }
                if(growthData.equals("")){
                    data = houseData+"/"+equityData+","+ debtData+","+hybridData+"/"+"-";
                }*/
                Log.e("Data Respose",data);
                Intent i = new Intent(FundFilter.this,FilterPage.class);
                i.putExtra("data",data);
                startActivity(i);
                break;
        }
    }

    @Override
    public void equityFinish(String name) {
        if(equityData.equals("")){
          equityData = name;
        }
        else {
            equityData = equityData +"," +name;
        }
        Log.e("DataResponse",equityData);
    }

    @Override
    public void debtFinish(String name) {
        if(debtData.equals("")){
            debtData = name;
        }
        else {
            debtData = debtData +"," +name;
        }
        Log.e("DataResponse",debtData);
    }

    @Override
    public void hybridFinish(String name) {
        if(hybridData.equals("")){
            hybridData = name;
        }
        else {
            hybridData = hybridData +"," +name;
        }
        Log.e("DataResponse",hybridData);
    }

    @Override
    public void houseFinish(String name) {
        if(houseData.equals("")){
            houseData = name;
        }
        else {
            houseData = houseData +"," +name;
        }
        Log.e("DataResponse",houseData);
    }

    public class FundHouse extends AsyncTask<String, Void, String> {

        private Context context;

        public FundHouse(Context context) {
            this.context=context;
        }

        @Override
        protected String doInBackground(String... arg0) {
            String link;
            BufferedReader bufferedReader;
            String result,data;
            try {
                //data = amCode+"/"+scheme+"/"+ growth +"?responsetype=json";
                /*data += "&p=" + URLEncoder.encode(userName, "UTF-8");*/
                data = "?responsetype=json";
                link = "http://cmapis.cmots.com/CrazyAchievers/MutualFund.svc/Fundhouse?responsetype=json";
                URL url = new URL(link);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                result = bufferedReader.readLine();
                return result;
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            String jsonStr = result;
            if (jsonStr != null) {
                Gson gson = new Gson();
                ListFundResponse listData = gson.fromJson(jsonStr, ListFundResponse.class);
                schemeResult = listData.getResponseMessage().getData().getSchemeList().getData();
                Log.e("schemeResult", String.valueOf(schemeResult.size()));
                try {
                    baseAdapter = new FundHouseAdapter(FundFilter.this, schemeResult);
                    fundHouseList.setAdapter(baseAdapter);
                   // Utility.setListViewHeightBasedOnChildren(fundHouseList);
                    if(Utils.isNetworkAvailable(this.context)) {
                        new FundEquity(context).execute();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(context, "Invalid data", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class FundEquity extends AsyncTask<String, Void, String> {

        private Context context;

        public FundEquity(Context context) {
            this.context=context;
        }

        @Override
        protected String doInBackground(String... arg0) {
            String link;
            BufferedReader bufferedReader;
            String result,data;
            try {
                //data = amCode+"/"+scheme+"/"+ growth +"?responsetype=json";
                /*data += "&p=" + URLEncoder.encode(userName, "UTF-8");*/
              //  data = "?responsetype=json";
                link = "http://cmapis.cmots.com/CrazyAchievers/MutualFund.svc/FundCategory/-/EQUITY?responsetype=json";
                URL url = new URL(link);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                result = bufferedReader.readLine();
                return result;
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            String jsonStr = result;
            if (jsonStr != null) {
                Gson gson = new Gson();
                ListFundResponse listData = gson.fromJson(jsonStr, ListFundResponse.class);
                schemeResult = listData.getResponseMessage().getData().getSchemeList().getData();
                Log.e("schemeResult", String.valueOf(schemeResult.size()));
                try {
                    equityAdapter = new EquityAdapter(FundFilter.this, schemeResult);
                    equityList.setAdapter(equityAdapter);
                    // Utility.setListViewHeightBasedOnChildren(fundHouseList);
                    if(Utils.isNetworkAvailable(this.context)) {
                        new FundDebts(context).execute();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(context, "Invalid data", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class FundDebts extends AsyncTask<String, Void, String> {

        private Context context;

        public FundDebts(Context context) {
            this.context=context;
        }

        @Override
        protected String doInBackground(String... arg0) {
            String link;
            BufferedReader bufferedReader;
            String result,data;
            try {
                //data = amCode+"/"+scheme+"/"+ growth +"?responsetype=json";
                /*data += "&p=" + URLEncoder.encode(userName, "UTF-8");*/
                //  data = "?responsetype=json";
                link = "http://cmapis.cmots.com/CrazyAchievers/MutualFund.svc/FundCategory/-/DEBT?responsetype=json";
                URL url = new URL(link);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                result = bufferedReader.readLine();
                return result;
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            String jsonStr = result;
            if (jsonStr != null) {
                Gson gson = new Gson();
                ListFundResponse listData = gson.fromJson(jsonStr, ListFundResponse.class);
                schemeResult = listData.getResponseMessage().getData().getSchemeList().getData();
                Log.e("schemeResult", String.valueOf(schemeResult.size()));
                try {
                    debtAdapter = new DebtAdapter(FundFilter.this, schemeResult);
                    debtList.setAdapter(debtAdapter);
                    if(Utils.isNetworkAvailable(this.context)) {
                        new FundHybrid(context).execute();
                    }
                    // Utility.setListViewHeightBasedOnChildren(fundHouseList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(context, "Invalid data", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class FundHybrid extends AsyncTask<String, Void, String> {

        private Context context;

        public FundHybrid(Context context) {
            this.context=context;
        }

        @Override
        protected String doInBackground(String... arg0) {
            String link;
            BufferedReader bufferedReader;
            String result,data;
            try {
                //data = amCode+"/"+scheme+"/"+ growth +"?responsetype=json";
                /*data += "&p=" + URLEncoder.encode(userName, "UTF-8");*/
                //  data = "?responsetype=json";
                link = "http://cmapis.cmots.com/CrazyAchievers/MutualFund.svc/FundCategory/-/HYBRID?responsetype=json";
                URL url = new URL(link);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                result = bufferedReader.readLine();
                return result;
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            String jsonStr = result;
            if (jsonStr != null) {
                Gson gson = new Gson();
                ListFundResponse listData = gson.fromJson(jsonStr, ListFundResponse.class);
                schemeResult = listData.getResponseMessage().getData().getSchemeList().getData();
                Log.e("schemeResult", String.valueOf(schemeResult.size()));
                try {
                    hybridAdapter = new HybridAdapter(FundFilter.this, schemeResult);
                    hybridList.setAdapter(hybridAdapter);
                    // Utility.setListViewHeightBasedOnChildren(fundHouseList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(context, "Invalid data", Toast.LENGTH_SHORT).show();
            }
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
