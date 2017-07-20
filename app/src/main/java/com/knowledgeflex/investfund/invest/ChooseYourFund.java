package com.knowledgeflex.investfund.invest;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
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
import java.util.ArrayList;
import java.util.List;

public class ChooseYourFund extends Fragment {

    RecyclerView list;
    private FundAPI apiService;
    ProgressBar progressDialog;
    List<Scheme> schemeResult;
    List<Scheme> getSchemeResultTwo;
    FundListAdapters baseAdapter;
    FloatingActionButton filter;
    String fundFilter;
    EditText inputSearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.choose_your_fund, container, false);
        list = (RecyclerView)root.findViewById(R.id.list_fund);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        list.setLayoutManager(mLayoutManager);
        filter = (FloatingActionButton) root.findViewById(R.id.fab);
        apiService = (FundAPI) FundAPI.retrofit.create(FundAPI.class);
        progressDialog = (ProgressBar)root.findViewById(R.id.progressBarCompare);
        inputSearch = (EditText)root.findViewById(R.id.inputSearch);
        loadData("-","-","Growth");
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),FundFilter.class);
                getContext().startActivity(i);
            }
        });

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //.getFilter().g.filter(charSequence);
                if(schemeResult !=null) {
                    getSchemeResultTwo = new ArrayList<Scheme>();
                    for (int j = 0; j < schemeResult.size(); j++) {
                        if (schemeResult.get(j).getSchemeName().contains(charSequence)) ;
                        try {
                            Scheme scheme = new Scheme();
                            scheme.setSchemeID(schemeResult.get(j).getSchemeID());
                            scheme.setSchemeName(schemeResult.get(j).getSchemeName());
                            scheme.setSchemeOption(schemeResult.get(j).getSchemeOption());
                            scheme.setNav(schemeResult.get(j).getNav());
                            scheme.setReturn_3Yr(schemeResult.get(j).getReturn_3Yr());
                            getSchemeResultTwo.add(scheme);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    baseAdapter = new FundListAdapters(ChooseYourFund.this, getContext(), getSchemeResultTwo);
                    list.setAdapter(baseAdapter);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return root;
    }

    private void loadData(String amCode, String scheme, String growth) {
        if(new Utils().isNetworkAvailable(getContext())){
            new MutualFunds(getContext(),amCode,scheme,growth).execute();
        }
        else {
            Toast.makeText(getContext(),"No Internet Connection",Toast.LENGTH_LONG).show();
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
                        baseAdapter = new FundListAdapters(ChooseYourFund.this, context, schemeResult);
                        list.setAdapter(baseAdapter);
                        progressDialog.setVisibility(View.GONE);
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
}
