package com.knowledgeflex.investfund.invest;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.knowledgeflex.investfund.Comparison;
import com.knowledgeflex.investfund.Model.ListFundResponse;
import com.knowledgeflex.investfund.Model.Scheme;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.RecyclerTouchListener;
import com.knowledgeflex.investfund.Utils;
import com.knowledgeflex.investfund.utils.FundJson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class CompareFund extends Fragment implements View.OnClickListener {

    RecyclerView list;
    private FundAPI apiService;
    ProgressBar progressDialog;
    List<Scheme> schemeResult;
    CompareFundAdapter baseAdapter;
    FloatingActionButton filter;
    String fundFilter;
    int[] schemePositions;
    Context mContext;
    Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_compare_fund, container, false);
        list = (RecyclerView)root.findViewById(R.id.compare);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        list.setLayoutManager(mLayoutManager);
        filter = (FloatingActionButton) root.findViewById(R.id.compare_fab);
        //positions = new int[3];
        progressDialog = (ProgressBar) root.findViewById(R.id.progressBarFund);
        mContext = getContext();
        loadData("-","-","Growth");

        LocalBroadcastManager.getInstance(getContext()).registerReceiver(mMessageReceiver, new IntentFilter("custom-message"));

        filter.setOnClickListener(this);

       /* list.addOnItemTouchListener(new RecyclerTouchListener(getContext(), list, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

               // Movie movie = movieList.get(position);
                //Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));*/

        return root;
    }

    private synchronized void loadData(String amCode, String scheme, String growth) {
        try {
            if(new Utils().isNetworkAvailable(getContext())) {
                new MutualFunds(getContext(), amCode, scheme, growth).execute();
            }
            else {
                Toast.makeText(getContext(),"No Internet Connection",Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            progressDialog.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.compare_fab:
                try {
                    if (schemeResult != null && bundle != null) {
                        Intent i = new Intent(getContext(), Comparison.class);
                        i.putExtras(bundle);
                        getContext().startActivity(i);
                    } else {
                        Log.e("this is my array value", "arr: " + "no value");
                    }
                }
                catch (Exception e){
                    Log.e("exception",e.toString());
                }
                break;
        }
    }

    public class MutualFunds extends AsyncTask<String, Void, String> {
        private Context context;
        private String success;
        String amCode = "";
        String scheme = "";
        String growth = "";

        public MutualFunds(Context context, String amCode, String scheme, String growth) {
            this.context=context;
            this.amCode = amCode;
            this.scheme = scheme;
            this.growth = scheme;
        }

        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... arg0) {
            String link;
            BufferedReader bufferedReader;
            String result,data;
            try {
                data = amCode+"/"+scheme+"/"+ growth +"?responsetype=json";
                /*data += "&p=" + URLEncoder.encode(userName, "UTF-8");*/

                link = "http://cmapis.cmots.com/CrazyAchievers/MutualFund.svc/ListingFunds/"+ data;
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
                try {
                    baseAdapter = new CompareFundAdapter(CompareFund.this, context, schemeResult);
                    list.setAdapter(baseAdapter);
                    progressDialog.setVisibility(View.GONE);;
                      /*  Bean = new ArrayList<BeanlistGrooming>();
                        for (int i = 0; i < PRODUCT_ID_P.length; i++) {
                            BeanlistGrooming bean = new BeanlistGrooming(PRODUCT_ID_P[i],IMAGE_P[i], TITLE_P[i], NEW_RATE_P[i], OLD_RATE_P[i], DISCOUNT_P[i], DISCOUNT_END_P[i], RATING_P[i], LIKE_P[i], WISH_P[i]);
                            Bean.add(bean);
                        }
                        baseAdapter = new GroomingRecyclerViewAdapter(MainActivity.this, context, Bean) {
                        };
                        rv.setAdapter(baseAdapter); */

                } catch (Exception e) {
                    e.printStackTrace();
                    progressDialog.setVisibility(View.GONE);
                }
            } else {
                Toast.makeText(context, "Invalid data", Toast.LENGTH_SHORT).show();
                progressDialog.setVisibility(View.GONE);
            }
        }
    }

    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            int[] stringArray=intent.getIntArrayExtra("position");
            bundle = new Bundle();
            bundle.putSerializable("fundOne", schemeResult.get(stringArray[0]));
            bundle.putSerializable("fundTwo", schemeResult.get(stringArray[1]));
            bundle.putSerializable("fundThree", schemeResult.get(stringArray[2]));
            Log.e("this is my array", "arr: " + Arrays.toString(stringArray));
// or
            System.out.println("arr: " + Arrays.toString(stringArray));
        }
    };
}
