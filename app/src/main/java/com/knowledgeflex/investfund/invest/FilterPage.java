package com.knowledgeflex.investfund.invest;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.knowledgeflex.investfund.Model.ListFundResponse;
import com.knowledgeflex.investfund.Model.Scheme;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static android.R.id.list;

public class FilterPage extends AppCompatActivity {

    String data;
    ProgressDialog progressDialog;
    List<Scheme> schemeResult;
    FundListAdapters baseAdapter;
    RecyclerView list;
    FloatingActionButton filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_page);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        data = getIntent().getStringExtra("data");
        list = (RecyclerView)findViewById(R.id.list_fund);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        list.setLayoutManager(mLayoutManager);
        filter = (FloatingActionButton) findViewById(R.id.fab);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FilterPage.this,FundFilter.class);
                startActivity(i);
            }
        });
        try{
            if(Utils.isNetworkAvailable(this)) {
                progressDialog = new ProgressDialog(this);
                new MutualFunds(this).execute();
            }
        }
        catch (Exception e){
            Log.e("fundhouse",e.toString());
        }
    }

    public class MutualFunds extends AsyncTask<String, Void, String> {

        private Context context;

        public MutualFunds(FilterPage filterPage) {
            this.context=filterPage;
        }

        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("please wait...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... arg0) {
            String link;
            BufferedReader bufferedReader;
            String result, request;
            try {
                request = data + "?responsetype=json";
                Log.e("request",request);
                link = "http://cmapis.cmots.com/CrazyAchievers/MutualFund.svc/ListingFunds/"+ request;
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
                try {
                    Log.e("jsonStr",jsonStr);
                    ListFundResponse data = gson.fromJson(jsonStr,ListFundResponse.class);
                    schemeResult = data.getResponseMessage().getData().getSchemeList().getData();
                    baseAdapter = new FundListAdapters(FilterPage.this, context, schemeResult);
                    list.setAdapter(baseAdapter);
                    progressDialog.dismiss();

                } catch (Exception e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
                }
            } else {
                Toast.makeText(context, "Invalid data", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
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
