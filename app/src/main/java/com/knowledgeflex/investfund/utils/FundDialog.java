package com.knowledgeflex.investfund.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.knowledgeflex.investfund.ApiService;
import com.knowledgeflex.investfund.Child_Result;
import com.knowledgeflex.investfund.DashBoard;
import com.knowledgeflex.investfund.Model.CreateUserPlan;
import com.knowledgeflex.investfund.Model.CreateUsersPlanResult;
import com.knowledgeflex.investfund.Model.InvestmentList;
import com.knowledgeflex.investfund.Model.Scheme;
import com.knowledgeflex.investfund.Model.UserPlan;
import com.knowledgeflex.investfund.Model.UserPortfolio;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.Utils;
import com.knowledgeflex.investfund.invest.OurFund;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FundDialog extends AppCompatActivity {

    Button submit,cancel;
    UserPortfolio port;
    UserPlan user;
    CreateUserPlan plan;
    ArrayList<InvestmentList> investList;
    ProgressDialog progressDialog;
    private ApiService apiService;
    String amount;
    String type;
    String no;
    Scheme thumbs;
    OurFund ourFund;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fund_dialog);
        this.setFinishOnTouchOutside(false);
        if (getSupportActionBar() != null) {
         //   getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("")));
            SpannableString s = new SpannableString("Confirmation of proceed");
            s.setSpan(Utils.returnOpenSansFont(this), 0, s.length(), 33);
            getSupportActionBar().setTitle(s);
        }
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        amount = getIntent().getStringExtra("amount");
        type = getIntent().getStringExtra("type");
        no = getIntent().getStringExtra("no");

        if(no.equals("1")){
            ourFund = (OurFund) bundle.getSerializable("OurFund");
        }
        else if(no.equals("2")) {
            thumbs = (Scheme) bundle.getSerializable("scheme");
        }

        submit = (Button)findViewById(R.id.submit_feed);
        cancel = (Button)findViewById(R.id.cancel_feed);
        investList = new ArrayList<InvestmentList>();
        progressDialog = new ProgressDialog(this);
        port=new UserPortfolio();
        user=new UserPlan();
        plan = new CreateUserPlan();

//        Log.e("dtata seria",thumbs.getSchemeName());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plan = new CreateUserPlan();
                plan.setUserId(Utils.getStringPref(Utils.UserId));
                user=new UserPlan();
                user.setPlan_ID("");
                user.setMasterPlanId("");
                user.setUser_ID(new Utils().getStringPref(Utils.UserId));
                user.setGoal("");
                user.setPresentAge("");
                user.setGoalTimeToStart("");
                user.setGoalDuration("");
                user.setGoalPerYearCost(0);
                user.setGoalPerYearLivingCost(0);
                user.setGoalLumpsum("");
                user.setGoalInflationRate("");
                user.setGoalTotalCost(0);
                user.setGoalLivingTotalCost(0);
                user.setGoalTotalAmount(0);
                user.setGoalTotalLumpsumAmount(0);
                user.setEstimatedInflationRate("");
                user.setGoalDateOfSip("");
                user.setGoalRetirementYear("");
                user.setGoalRetirementExpense(0);
                user.setGoalRetirementMonthlyExpenditure(0);
                user.setGoalHousePlanYear("");
                user.setGoalHouseCurrentCost(0);
                user.setGoalHouseDownPayment(0);
                user.setGoalHouseLoanYear("");
                user.setGoalChildMerrageBudgetAmount(0);
                user.setRisk("");
                port=new UserPortfolio();
                port.setGold(0);
                port.setDebt(0);
                port.setEquity(0);
                port.setPlan_ID("");
                port.setUser_ID("");
                port.setPortfolio_ID("");
                port.setEstimatedTotalSIPAmt(0);
                port.setSchemeId("");
                plan.setUserPlan(user);
                plan.setUserPortfolio(port);
                if(no.equals("2")) {
                    InvestmentList list = new InvestmentList();
                    list.setIsIn(thumbs.getIsin());
                    list.setBseSchemeCode("");
                    list.setSchemeName(thumbs.getSchemeName());
                    list.setAmount(Integer.parseInt(amount));
                    list.setInvestmentType(type);
                    list.setDateString("");
                    list.setScheme_ID(thumbs.getSchemeID());
                    investList.add(list);
                }
                else if(no.equals("1")){
                    InvestmentList list = new InvestmentList();
                    list.setIsIn(ourFund.getIsin());
                    list.setBseSchemeCode(ourFund.getbSESchemecode());
                    list.setSchemeName(ourFund.getSchemeName());
                    list.setAmount(Integer.parseInt(amount));
                    list.setInvestmentType(type);
                    list.setDateString("");
                    list.setScheme_ID(ourFund.getScheme_ID());
                    investList.add(list);
                }
                plan.setInvestmentList(investList);
                webCall();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void webCall() {
        if(new Utils().isNetworkAvailable(getApplicationContext())){

            progressDialog.setMessage("please wait...");
            progressDialog.show();
            apiService = (ApiService) ApiService.retrofit.create(ApiService.class);
            apiService.createUserPlan(plan).enqueue(new Invest());
        }
        else {
            Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_LONG).show();
        }
    }

    private class Invest implements Callback<CreateUsersPlanResult> {

        @Override
        public void onResponse(Call<CreateUsersPlanResult> call, Response<CreateUsersPlanResult> response) {
            ////Log.e("Data",response.toString());
            if (((CreateUsersPlanResult) response.body()).getGetCreateUsersPlanResult().getResponseCode().intValue() == 0) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"data saved",Toast.LENGTH_LONG).show();
                Intent i =new Intent(FundDialog.this, DashBoard.class);
                startActivity(i);
                finish();
            }
        }

        @Override
        public void onFailure(Call<CreateUsersPlanResult> call, Throwable t) {
            //Toast.makeText(Fu.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
        }
    }



}

