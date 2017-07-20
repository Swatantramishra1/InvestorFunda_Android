package com.knowledgeflex.investfund.invest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.knowledgeflex.investfund.Model.ListFundResponse;
import com.knowledgeflex.investfund.Model.Scheme;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.utils.CalculatePortfolio;
import com.knowledgeflex.investfund.utils.FundJson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class OurTopMutualFund extends Fragment {

    RecyclerView list;
    private FundAPI apiService;
    ProgressBar progressDialog;
    List<Scheme> schemeResult;
    OurTopMutualAdapters baseAdapter;
    FloatingActionButton filter;
    String fundFilter;
    String jsonStr;
    OurTopFund listData;
    List<OurFund> listFunds;
    String filterMtype;
    OurTopFund listSetValue;
    TextView mftype;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.our_top_mutual_fund, container, false);

        list = (RecyclerView)root.findViewById(R.id.our_top);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        list.setLayoutManager(mLayoutManager);
        filter = (FloatingActionButton) root.findViewById(R.id.our_fab);
        mftype = (TextView) root.findViewById(R.id.mfTypeName);
        listSetValue = new OurTopFund();
        apiService = (FundAPI) FundAPI.retrofit.create(FundAPI.class);
        progressDialog = (ProgressBar)root.findViewById(R.id.progressBarOur);
        try {
            jsonStr = new FundJson().fundJsonStructure().toString();
            Gson gson = new Gson();
            listData = gson.fromJson(jsonStr, OurTopFund.class);
        }
        catch (Exception e){
            Log.e("json",e.toString());
        }
       // loadData("-","-","Growth");
        loadData("EQ large cap");
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(getContext(),OurTopFundFilter.class);
                    i.putExtra("listdata",listData);
                    startActivityForResult(i, 123);
                 //   getContext().startActivity(i);
                }
                catch (Exception e){
                    Log.e("our",e.toString());
                }
            }
        });
        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            filterMtype = data.getStringExtra("type");
            Log.e("filterMtype", filterMtype);
            loadData(filterMtype);
    }

    private synchronized void loadData(String compare) {
        try {
                progressDialog.setVisibility(View.VISIBLE);
                mftype.setText(compare);
                listFunds = new ArrayList<OurFund>();
                for(int i=0;i<listData.getOurFund().size();i++){
                    if(listData.getOurFund().get(i).getMfType().equals(compare)){
                        OurFund ourFund = new OurFund();
                        ourFund.setScheme_ID(listData.getOurFund().get(i).getScheme_ID());
                        ourFund.setSchemeName(listData.getOurFund().get(i).getSchemeName());
                        ourFund.setbSESchemecode(listData.getOurFund().get(i).getbSESchemecode());
                        ourFund.setDate(listData.getOurFund().get(i).getDate());
                        ourFund.setDesc(listData.getOurFund().get(i).getDesc());
                        ourFund.setIsin(listData.getOurFund().get(i).getIsin());
                        ourFund.setMinInvst(listData.getOurFund().get(i).getMinInvst());
                        ourFund.setMinSip(listData.getOurFund().get(i).getMinSip());
                        ourFund.setMultiplier(listData.getOurFund().get(i).getMultiplier());
                        ourFund.setRank(listData.getOurFund().get(i).getRank());
                        ourFund.setMfType(listData.getOurFund().get(i).getRank());
                        listFunds.add(ourFund);
                    }
                }
                baseAdapter = new OurTopMutualAdapters(OurTopMutualFund.this, getContext(), listFunds,compare);
                list.setAdapter(baseAdapter);
                progressDialog.setVisibility(View.GONE);
        } catch (Exception e) {
            e.printStackTrace();
            progressDialog.setVisibility(View.GONE);
        }
    }

}
