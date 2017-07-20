package com.knowledgeflex.investfund;

import android.app.Activity;
import android.app.ProgressDialog;
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
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.knowledgeflex.investfund.Model.CreateUserPlan;
import com.knowledgeflex.investfund.Model.CreateUsersPlanResult;
import com.knowledgeflex.investfund.Model.FundScheme;
import com.knowledgeflex.investfund.Model.InvestmentList;
import com.knowledgeflex.investfund.Model.Scheme;
import com.knowledgeflex.investfund.Model.UserPlan;
import com.knowledgeflex.investfund.Model.UserPortfolio;
import com.knowledgeflex.investfund.invest.Comparison_Dialog;
import com.knowledgeflex.investfund.invest.FundDetailsResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Comparison extends AppCompatActivity {

    TextView fundOne;
    TextView fundTwo;
    TextView fundThree;
    TextView nameOne;
    TextView nameTwo;
    TextView nameThree;
    TextView navOne;
    TextView navTwo;
    TextView navThree;
    TextView monthOne;
    TextView monthTwo;
    TextView monthThree;
    TextView oneYearOne;
    TextView oneYearTwo;
    TextView oneYearThree;
    TextView threeYearOne;
    TextView threeYearTwo;
    TextView threeYearThree;
    TextView fiveYearOne;
    TextView fiveYearTwo;
    TextView fiveYearThree;
    TextView objectOne;
    TextView objectTwo;
    TextView objectThree;
    TextView allocationOne;
    TextView allocationTwo;
    TextView allocationThree;
    TextView cateOne;
    TextView cateTwo;
    TextView cateThree;
    TextView planOne;
    TextView planTwo;
    TextView planThree;
    TextView markOne;
    TextView markTwo;
    TextView markThree;
    TextView sizeOne;
    TextView sizeTwo;
    TextView sizeThree;
    TextView minOne;
    TextView minTwo;
    TextView minThree;
    TextView divOne;
    TextView divTwo;
    TextView divThree;
    TextView bonusOne;
    TextView bonusTwo;
    TextView bonusThree;
    TextView exitOne;
    TextView exitTwo;
    TextView exitThree;
    Button selectOne;
    Button selectTwo;
    Button selectThree;
    Scheme fund_one;
    Scheme fund_two;
    Scheme fund_three;
    ProgressDialog progressDialog;
    FundScheme schemeResult_one;
    FundScheme schemeResult_two;
    FundScheme schemeResult_three;
    UserPortfolio port;
    UserPlan user;
    CreateUserPlan plan;
    ArrayList<InvestmentList> investList;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
        }
        Bundle bundle = getIntent().getExtras();
        fund_one = (Scheme)bundle.getSerializable("fundOne");
        fund_two = (Scheme)bundle.getSerializable("fundTwo");
        fund_three = (Scheme)bundle.getSerializable("fundThree");
        progressDialog = new ProgressDialog(this);
        fundOne = (TextView)findViewById(R.id.fundOne);
        fundTwo = (TextView)findViewById(R.id.fundTwo);
        fundThree = (TextView)findViewById(R.id.fundThree);
        nameOne = (TextView)findViewById(R.id.nameOne);
        nameTwo = (TextView)findViewById(R.id.nameTwo);
        nameThree = (TextView)findViewById(R.id.nameThree);
        navOne = (TextView)findViewById(R.id.navOne);
        navTwo = (TextView)findViewById(R.id.navTwo);
        navThree = (TextView)findViewById(R.id.navThree);
        monthOne = (TextView)findViewById(R.id.monthOne);
        monthTwo = (TextView)findViewById(R.id.monthTwo);
        monthThree = (TextView)findViewById(R.id.monthThree);
        oneYearOne = (TextView)findViewById(R.id.oneYearOne);
        oneYearTwo = (TextView)findViewById(R.id.oneYearTwo);
        oneYearThree = (TextView)findViewById(R.id.oneYearThree);
        threeYearOne = (TextView)findViewById(R.id.threeYearOne);
        threeYearTwo = (TextView)findViewById(R.id.threeYearTwo);
        threeYearThree = (TextView)findViewById(R.id.threeYearThree);
        fiveYearOne = (TextView)findViewById(R.id.fiveYearOne);
        fiveYearTwo = (TextView)findViewById(R.id.fiveYearTwo);
        fiveYearThree = (TextView)findViewById(R.id.fiveYearThree);
        objectOne = (TextView)findViewById(R.id.objectOne);
        objectTwo = (TextView)findViewById(R.id.objectTwo);
        objectThree = (TextView)findViewById(R.id.objectThree);
        allocationOne = (TextView)findViewById(R.id.allocationOne);
        allocationTwo = (TextView)findViewById(R.id.allocationTwo);
        allocationThree = (TextView)findViewById(R.id.allocationThree);
        cateOne = (TextView)findViewById(R.id.cateOne);
        cateTwo = (TextView)findViewById(R.id.cateTwo);
        cateThree = (TextView)findViewById(R.id.cateThree);
        planOne = (TextView)findViewById(R.id.planOne);
        planTwo = (TextView)findViewById(R.id.planTwo);
        planThree = (TextView)findViewById(R.id.planThree);
        markOne = (TextView)findViewById(R.id.markOne);
        markTwo = (TextView)findViewById(R.id.markTwo);
        markThree = (TextView)findViewById(R.id.markThree);
        sizeOne = (TextView)findViewById(R.id.sizeOne);
        sizeTwo = (TextView)findViewById(R.id.sizeTwo);
        sizeThree = (TextView)findViewById(R.id.sizeThree);
        minOne = (TextView)findViewById(R.id.minOne);
        minTwo = (TextView)findViewById(R.id.minTwo);
        minThree = (TextView)findViewById(R.id.minThree);
        divOne = (TextView)findViewById(R.id.divOne);
        divTwo = (TextView)findViewById(R.id.divTwo);
        divThree = (TextView)findViewById(R.id.divThree);
        bonusOne = (TextView)findViewById(R.id.bonusOne);
        bonusTwo = (TextView)findViewById(R.id.bonusTwo);
        bonusThree = (TextView)findViewById(R.id.bonusThree);
        exitOne = (TextView)findViewById(R.id.exitOne);
        exitTwo = (TextView)findViewById(R.id.exitTwo);
        exitThree = (TextView)findViewById(R.id.exitThree);
        selectOne = (Button) findViewById(R.id.selectOne);
        selectTwo = (Button) findViewById(R.id.selectTwo);
        selectThree = (Button) findViewById(R.id.selectThree);
        port=new UserPortfolio();
        user=new UserPlan();
        plan = new CreateUserPlan();
        loadData(fund_one.getSchemeID(),fund_two.getSchemeID(),fund_three.getSchemeID());

        selectOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Comparison.this, Comparison_Dialog.class);
                i.putExtra("scheme","1");
                startActivityForResult(i, 1);
            }
        });

        selectTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Comparison.this, Comparison_Dialog.class);
                i.putExtra("scheme","2");
                startActivityForResult(i, 1);
            }
        });

        selectThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Comparison.this, Comparison_Dialog.class);
                i.putExtra("scheme","3");
                startActivityForResult(i, 1);
            }
        });
       /* nameOne.setText(fund_one.getSchemeName());
        nameTwo.setText(fund_two.getSchemeName());
        nameThree.setText(fund_three.getSchemeName());
        navOne.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(fund_one.getNav()))));
        navTwo.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(fund_two.getNav()))));
        navThree.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(fund_three.getNav()))));
        monthOne.setText("");
        monthTwo.setText("");
        monthThree.setText("");
        oneYearOne.setText("");
        oneYearTwo.setText("");
        oneYearThree.setText("");
        threeYearOne.setText("");
        threeYearTwo.setText("");
        threeYearThree.setText("");
        fiveYearOne.setText("");
        fiveYearTwo.setText("");
        fiveYearThree.setText("");
        objectOne.setText("");
        objectTwo.setText("");
        objectThree.setText("");
        allocationOne.setText("");
        allocationTwo.setText("");
        allocationThree.setText("");
        cateOne.setText(fund_one.getCategoryName());
        cateTwo.setText(fund_one.getCategoryName());
        cateThree.setText(fund_one.getCategoryName());
        planOne.setText("");
        planTwo.setText("");
        planThree.setText("");
        markOne.setText("");
        markTwo.setText("");
        markThree.setText("");
        sizeOne.setText("");
        sizeTwo.setText("");
        sizeThree.setText("");
        minOne.setText("");
        minTwo.setText("");
        minThree.setText("");
        divOne.setText("");
        divTwo.setText("");
        divThree.setText("");
        bonusOne.setText("");
        bonusTwo.setText("");
        bonusThree.setText("");
        exitOne.setText("");
        exitTwo.setText("");
        exitThree.setText("");*/
    }

    private synchronized void loadData(String id_one, String id_two, String id_three) {
        if(new Utils().isNetworkAvailable(getApplicationContext())){
            new FundsDetails(getApplicationContext(),id_one, id_two, id_three).execute();
        }
        else {
            Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_LONG).show();
        }
    }

    public class FundsDetails extends AsyncTask<String, Void, String> {

        private Context context;
        private String success;
        String one;
        String two;
        String three;

        public FundsDetails(Context context, String id_on, String id_tw, String id_thr) {
            this.context=context;
            this.one = id_on;
            this.two = id_tw;
            this.three = id_thr;
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
            String result_one;
            String result_two;
            String result_three;
            String data;
            try {
                result_one = fundApi(one);
                result_two = fundApi(two);
                result_three = fundApi(three);
                data = result_one+"#"+result_two+"#"+result_three;
                return data;
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String data) {
            String jsonStr = data;
            if (jsonStr != null) {
                String json[] = jsonStr.split("#");
                Gson gson = new Gson();
                FundDetailsResponse listData = gson.fromJson(json[0], FundDetailsResponse.class);
                FundDetailsResponse listData_one = gson.fromJson(json[1], FundDetailsResponse.class);
                FundDetailsResponse listData_two = gson.fromJson(json[2], FundDetailsResponse.class);
                schemeResult_one = listData.getResponseMessage().getData().getSchemeList().getFundScheme();
                schemeResult_two = listData_one.getResponseMessage().getData().getSchemeList().getFundScheme();
                schemeResult_three = listData_two.getResponseMessage().getData().getSchemeList().getFundScheme();
                try {
                    nameOne.setText(schemeResult_one.getSchemeName());
                    nameTwo.setText(schemeResult_two.getSchemeName());
                    nameThree.setText(schemeResult_three.getSchemeName());
                    navOne.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_one.getNav()))));
                    navTwo.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_two.getNav()))));
                    navThree.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_three.getNav()))));
                    monthOne.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_one.getReturn_3Mon()))));
                    monthTwo.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_two.getReturn_3Mon()))));
                    monthThree.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_three.getReturn_3Mon()))));
                    oneYearOne.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_one.getReturn_1Yr()))));
                    oneYearTwo.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_two.getReturn_1Yr()))));
                    oneYearThree.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_three.getReturn_1Yr()))));
                    threeYearOne.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_one.getReturn_3Yr()))));
                    threeYearTwo.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_two.getReturn_3Yr()))));
                    threeYearThree.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_three.getReturn_3Yr()))));
                    fiveYearOne.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_one.getReturn_5Yr()))));
                    fiveYearTwo.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_two.getReturn_5Yr()))));
                    fiveYearThree.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_three.getReturn_5Yr()))));
                    objectOne.setText(schemeResult_one.getObjective());
                    objectTwo.setText(schemeResult_two.getObjective());
                    objectThree.setText(schemeResult_three.getObjective());
                    allocationOne.setText("");
                    allocationTwo.setText("");
                    allocationThree.setText("");
                    cateOne.setText(schemeResult_one.getCategoryName());
                    cateTwo.setText(schemeResult_two.getCategoryName());
                    cateThree.setText(schemeResult_three.getCategoryName());
                    planOne.setText("");
                    planTwo.setText("");
                    planThree.setText("");
                    markOne.setText(schemeResult_one.getBenchMarkName());
                    markTwo.setText(schemeResult_two.getBenchMarkName());
                    markThree.setText(schemeResult_three.getBenchMarkName());
                    sizeOne.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_one.getAssetSize()))));
                    sizeTwo.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_two.getAssetSize()))));
                    sizeThree.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_three.getAssetSize()))));
                    minOne.setText("");
                    minTwo.setText("");
                    minThree.setText("");
                    divOne.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_one.getDividendPercentage_Latest()))));
                    divTwo.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_two.getDividendPercentage_Latest()))));
                    divThree.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(schemeResult_three.getDividendPercentage_Latest()))));
                    bonusOne.setText(schemeResult_one.getBonus_Latest());
                    bonusTwo.setText(schemeResult_two.getBonus_Latest());
                    bonusThree.setText(schemeResult_three.getBonus_Latest());
                    exitOne.setText(schemeResult_one.getExitLoad());
                    exitTwo.setText(schemeResult_two.getExitLoad());
                    exitThree.setText(schemeResult_three.getExitLoad());
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

    private synchronized String fundApi(String one) {
        String result = null;
        try {
            String link;
            BufferedReader bufferedReader;
            String data = one + "?responsetype=json";
            link = "http://cmapis.cmots.com/CrazyAchievers/MutualFund.svc/SchemeDetails/" + data;
            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            result = bufferedReader.readLine();
        }
        catch (Exception e){
            Log.e("fundapi",e.toString());
        }
        return  result;
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String amt=data.getStringExtra("amount");
                String mode=data.getStringExtra("mode");
                String scheme=data.getStringExtra("scheme");
                sendData(amt, mode, scheme);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }

    private synchronized void sendData(String amt, String mode, String scheme) {
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
        investList = new ArrayList<InvestmentList>();
        if(scheme.equals("1")){
            InvestmentList list = new InvestmentList();
            list.setIsIn(schemeResult_one.getIsin());
            list.setBseSchemeCode(schemeResult_one.getBse_SchemeCode());
            list.setSchemeName(schemeResult_one.getSchemeName());
            list.setAmount(Integer.parseInt(amt));
            list.setInvestmentType(mode);
            list.setDateString("");
            list.setScheme_ID(schemeResult_one.getSchemeID());
            investList.add(list);
        }
        else if(scheme.equals("2")){
            InvestmentList list = new InvestmentList();
            list.setIsIn(schemeResult_two.getIsin());
            list.setBseSchemeCode(schemeResult_two.getBse_SchemeCode());
            list.setSchemeName(schemeResult_two.getSchemeName());
            list.setAmount(Integer.parseInt(amt));
            list.setInvestmentType(mode);
            list.setDateString("");
            list.setScheme_ID(schemeResult_two.getSchemeID());
            investList.add(list);
        }
        else if(scheme.equals("3")){
            InvestmentList list = new InvestmentList();
            list.setIsIn(schemeResult_three.getIsin());
            list.setBseSchemeCode(schemeResult_three.getBse_SchemeCode());
            list.setSchemeName(schemeResult_three.getSchemeName());
            list.setAmount(Integer.parseInt(amt));
            list.setInvestmentType(amt);
            list.setDateString("");
            list.setScheme_ID(schemeResult_three.getSchemeID());
            investList.add(list);
        }

        plan.setInvestmentList(investList);
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
                Intent i =new Intent(Comparison.this, DashBoard.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
