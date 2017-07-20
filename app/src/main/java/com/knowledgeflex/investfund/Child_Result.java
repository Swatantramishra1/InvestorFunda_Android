package com.knowledgeflex.investfund;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.knowledgeflex.investfund.Model.CreateUserPlan;
import com.knowledgeflex.investfund.Model.CreateUsersPlanResult;
import com.knowledgeflex.investfund.Model.InvestmentList;
import com.knowledgeflex.investfund.Model.LoginResponse;
import com.knowledgeflex.investfund.Model.UserDetailResponse;
import com.knowledgeflex.investfund.Model.UserPlan;
import com.knowledgeflex.investfund.Model.UserPortfolio;
import com.knowledgeflex.investfund.utils.CalculatePortfolio;
import com.knowledgeflex.investfund.utils.SelectDate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Child_Result extends AppCompatActivity implements View.OnClickListener {

    public static final String MASTER_ID = "1";
    public static final String SCHEME_ID = "1,2,3";
    public static final String PREFS_NAME = "Result";
    TextView equity;
    TextView debt;
    TextView total;
    TextView goldText;
    SharedPreferences sharedPreferences;
    Button submit;
    Long t1;
    Long t2;
    Long t3;
    String name;
    int inflation;
    int durationYear;
    int planYear;
    int current_age;
    int higher_edu_age;
    int duration;
    double current_cost_edu;
    double monthly_expenses;
    double annual_invest;
    double living_cost;
    int saved;
    CreateUserPlan plan;
    double equityPerCost;
    double debtPerCost;
    double investAmount;
    double currentCost;
    double sumCost;
    double budgetCost;
    double budgetAmount;
    double goalAmount;
    double investsumCost;
    int marriage_age;
    int sub;
    int retirement_age;
    private ApiService apiService;
    UserPortfolio port;
    UserPlan user;
    double totalAmount;
    double totalLivingCost;
    double totalCourseFee;
    ProgressDialog progressDialog;
    String goalData;
   // PieChart pieChart;
    private int Fund_LargeCap_result;
    private int Fund_LargeCap_result_Temp;
    private int Fund_MultiCap_result;
    private int Fund_MultiCap_result_Temp;
    private int Fund_BondCap_result;
    private int Fund_BondCap_result_Temp;
    private int Fund_UltraCap_result;
    private int Fund_UltraCap_result_Temp;
    private int Fund_MidCap_result;
    private int Fund_MidCap_result_Temp;
    private int Fund_CreditOpportunity_result;
    private int Fund_CreditOpportunity_result_Temp;
    private int Fund_DebtLiquid_result;
    private int Fund_DebtLiquid_result_Temp;
    private int Fund_Gold_result;
    private int Fund_Gold_result_Temp;
    private int Fund_Balanced_result;
    private int Fund_Balanced__result_Temp ;
    private int Fund_Income_result;
    private int Fund_Income__result_Temp;
    private int Fund_MIP_result;
    private int Fund_MIP_result_Temp;
    private int Fund_GILT_result;
    private int Fund_GILT__result_Temp;
    private int estimated_percentage;
    JSONObject resultTemp;
    //JSONObject sampleStructure;
    JSONArray sampleStructureJson;
    //private String Result_Temp[];
    private int fundLargeCap;
    private int fundMultiCap;
    private int fundBondFunds;
    private int fundMidCap;
    private int fundGold;
    private int fundLiquidCap;
    private int fundUltraSortFund;
    private int fundCreditOpportunity;
    private int fundBalanced;
    private int fundGlit;
    double goldPerCost;
    List<String> equityLargeCapIndex;
    List<String> equityMultiCapIndex;
    List<String> equityMidSmallIndex;
    List<String> equityUltraSortIndex;
    List<String> equityBondIndex;
    List<String> equityLiquidIndex;
    List<String> creditOpportunitiesIndex;
    List<String> goldIndex;
    List<String> balancedIndex;
    List<String> glitIndex;
    List<String> mipIndex;
    List<String> incomeIndex;
    List<String> giltIndex;
    ArrayList<InvestmentList> investList;
    LinearLayout goldLay;
    ImageView add;
    ImageView minus;
    int year;
    double c_equity;
    double c_debt;
    double c_gold;
    String page;
    String screenName;
    int calculatedCost;
    private UserDetailResponse userDetailResponse;
    private String schemeName[];
    private String schemeAmount[];
    ListView schemelist;
    TextView dateText;
    CheckBox terms;
    Spinner date;
    DatePickerDialog datePickerDialog;
    Calendar myCalendar = Calendar.getInstance();
    SimpleDateFormat dateFormatter;
    String risk = "";
    String dateValue[];
    Button changeFund;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child__result);
        getWindow().setSoftInputMode(3);
        apiService = (ApiService) ApiService.retrofit.create(ApiService.class);
        page = getIntent().getStringExtra("page");
        screenName = getIntent().getStringExtra("calculate");
        goldPerCost  = getIntent().getDoubleExtra("gold",0);
        goalData = getIntent().getStringExtra("goalData");
        fundLargeCap = getIntent().getIntExtra("fundLargeCap",0);
        fundMultiCap = getIntent().getIntExtra("fundMultiCap",0);
        fundBondFunds = getIntent().getIntExtra("fundBondFunds",0);;
        fundMidCap = getIntent().getIntExtra("fundMidCap",0);
        fundGold = getIntent().getIntExtra("fundGold",0);
        fundLiquidCap = getIntent().getIntExtra("fundLiquidCap",0);
        fundUltraSortFund = getIntent().getIntExtra("fundUltraSortFund",0);
        fundCreditOpportunity = getIntent().getIntExtra("fundCreditOpportunity",0);
        fundBalanced = getIntent().getIntExtra("fundBalanced",0);
        fundGlit = getIntent().getIntExtra("fundGlit",0);
        c_equity = getIntent().getDoubleExtra("p_equity",0);
        c_debt = getIntent().getDoubleExtra("p_debts",0);
        c_gold = getIntent().getDoubleExtra("p_gold",0);

        if(page.equals("1")){
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                name = extras.getString("name");
                inflation = getIntent().getIntExtra("inflate", 0);
                current_age = getIntent().getIntExtra("age", 0);
                higher_edu_age = getIntent().getIntExtra("edu_age", 0);
                duration = getIntent().getIntExtra("duration", 0);
                current_cost_edu = getIntent().getDoubleExtra("cost", 0);
                living_cost = getIntent().getDoubleExtra("living_cost", 0);
                sumCost = getIntent().getDoubleExtra("sum", 0);
                equityPerCost = getIntent().getDoubleExtra("equity", 0);
                debtPerCost = getIntent().getDoubleExtra("debt", 0);
                saved = getIntent().getIntExtra("save", 0);
                totalAmount = getIntent().getDoubleExtra("total", 0);
                totalLivingCost = getIntent().getDoubleExtra("totalLiving", 0);
                calculatedCost = getIntent().getIntExtra("calculatedCost", 0);
                totalCourseFee =  current_cost_edu * duration;
                sub = higher_edu_age-current_age;
            }
        }
        else if(page.equals("2")){
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                name = extras.getString("name");
                inflation = getIntent().getIntExtra("inflate",0);
                current_age = getIntent().getIntExtra("current_age",0);
                retirement_age = getIntent().getIntExtra("retirement_age", 0);
                estimated_percentage = getIntent().getIntExtra("estimated", 0);
                calculatedCost = getIntent().getIntExtra("calculatedCost", 0);
                annual_invest = getIntent().getDoubleExtra("annual_invest", 0);
                monthly_expenses = getIntent().getDoubleExtra("monthly_expenses", 0);
                sumCost = getIntent().getDoubleExtra("sum", 0);
                equityPerCost = getIntent().getDoubleExtra("equity", 0);
                debtPerCost = getIntent().getDoubleExtra("debt", 0);
                sub = retirement_age-current_age;
            }
        }
        else if(page.equals("3")){
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                planYear = getIntent().getIntExtra("planYear", 0);
                inflation = getIntent().getIntExtra("inflate", 0);
                current_age = getIntent().getIntExtra("current_age",0);
                year = getIntent().getIntExtra("year", 0);
                calculatedCost = getIntent().getIntExtra("calculatedCost", 0);
                currentCost = getIntent().getDoubleExtra("currentCost", 0);
                investAmount = getIntent().getDoubleExtra("investAmount", 0);
                sumCost = getIntent().getDoubleExtra("sum", 0);
                equityPerCost = getIntent().getDoubleExtra("equity", 0);
                debtPerCost = getIntent().getDoubleExtra("debt", 0);
                sub = year-current_age;
            }
        }
        else if(page.equals("4")){
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                name = extras.getString("name");
                inflation = getIntent().getIntExtra("inflate", 0);
                calculatedCost = getIntent().getIntExtra("calculatedCost", 0);
                durationYear = getIntent().getIntExtra("durationYear", 0);
                goalAmount =getIntent().getDoubleExtra("goalAmount", 0);
                sumCost = getIntent().getDoubleExtra("sum", 0);
                equityPerCost = getIntent().getDoubleExtra("equity", 0);
                debtPerCost = getIntent().getDoubleExtra("debt", 0);
                sub = durationYear-0;
            }
        }
        else if(page.equals("5")){
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                marriage_age = getIntent().getIntExtra("marriage_age", 0);
                inflation = getIntent().getIntExtra("inflate", 0);
                current_age = getIntent().getIntExtra("your_age", 0);
                year = getIntent().getIntExtra("year", 0);
                budgetCost = getIntent().getDoubleExtra("budgetCost",0);
                investsumCost = getIntent().getDoubleExtra("investsumCost",0);
                sumCost = getIntent().getDoubleExtra("sum", 0);
                calculatedCost = getIntent().getIntExtra("calculatedCost", 0);
                equityPerCost = getIntent().getDoubleExtra("equity", 0);
                debtPerCost = getIntent().getDoubleExtra("debt", 0);
                sub = year-0;
            }
        }
        else if(page.equals("7")){
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                name = extras.getString("name");
                inflation = getIntent().getIntExtra("inflate", 0);
                durationYear = getIntent().getIntExtra("durationYear", 0);
                current_age = getIntent().getIntExtra("current_age",0);
                planYear = getIntent().getIntExtra("planYear", 0);
                budgetAmount = getIntent().getDoubleExtra("budgetAmount", 0);
                sumCost = getIntent().getDoubleExtra("sum", 0);
                equityPerCost = getIntent().getDoubleExtra("equity", 0);
                debtPerCost = getIntent().getDoubleExtra("debt", 0);
                sub = durationYear-0;
            }
        }
        else if(page.equals("8")){
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                sumCost = getIntent().getDoubleExtra("sum", 0);
                equityPerCost = getIntent().getDoubleExtra("equity", 0);
                debtPerCost = getIntent().getDoubleExtra("debt", 0);
                risk = getIntent().getStringExtra("risk");
                sub = 1;
                /*if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(screenName);
                }*/

            }
        }
        else if(page.equals("9")){
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                sumCost = getIntent().getDoubleExtra("sum", 0);
                equityPerCost = getIntent().getDoubleExtra("equity", 0);
                debtPerCost = getIntent().getDoubleExtra("debt", 0);
                sub = getIntent().getIntExtra("durationYear",0);
                risk = getIntent().getStringExtra("risk");
               /* if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(screenName);
                }*/
            }
        }

        equityLargeCapIndex = new ArrayList<String>();
        equityMultiCapIndex = new ArrayList<String>();
        equityMidSmallIndex = new ArrayList<String>();
        equityUltraSortIndex = new ArrayList<String>();
        equityBondIndex = new ArrayList<String>();
        equityLiquidIndex = new ArrayList<String>();
        creditOpportunitiesIndex = new ArrayList<String>();
        balancedIndex = new ArrayList<String>();
        glitIndex = new ArrayList<String>();
        goldIndex = new ArrayList<String>();
        mipIndex = new ArrayList<String>();
        incomeIndex = new ArrayList<String>();
        giltIndex = new ArrayList<String>();
        progressDialog= new ProgressDialog(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
        }
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        equity = (TextView) findViewById(R.id.equity);
        debt = (TextView) findViewById(R.id.debt);
        goldText = (TextView) findViewById(R.id.gold);
        total = (TextView) findViewById(R.id.total);
        goldLay = (LinearLayout)findViewById(R.id.goldLayout);
        submit = (Button) findViewById(R.id.investNow);
        changeFund = (Button) findViewById(R.id.changeFunds);
        schemelist = (ListView) findViewById(R.id.schemeList);
        dateText = (TextView) findViewById(R.id.dateText);
        terms = (CheckBox) findViewById(R.id.terms);
        date = (Spinner) findViewById(R.id.dateImg);
        sharedPreferences = getSharedPreferences(PREFS_NAME, 0);
        add = (ImageView) findViewById(R.id.add);
        minus = (ImageView) findViewById(R.id.minus);
        t1 = Long.valueOf(sharedPreferences.getLong("total1", 0));
        t2 = Long.valueOf(sharedPreferences.getLong("total2", 0));
        t3 = Long.valueOf(sharedPreferences.getLong("total3", 0));
        equity.setText(String.valueOf(new DecimalFormat("##,##,##,###.##").format(equityPerCost)));
        debt.setText(String.valueOf(new DecimalFormat("##,##,##,###.##").format(debtPerCost)));
        total.setText(String.valueOf(new DecimalFormat("##,##,##,###.##").format(sumCost)));
        if(goldPerCost==0){
            goldLay.setVisibility(View.GONE);
        }
        else {
            goldLay.setVisibility(View.VISIBLE);
            goldText.setText(String.valueOf(new DecimalFormat("##,##,##,###.##").format(goldPerCost)));
        }

        add.setOnClickListener(this);
        minus.setOnClickListener(this);

        dateText.setVisibility(View.GONE);

        loadDate();
        /*dateImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });*/

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                dateText.setText(dateFormatter.format(newDate.getTime()));
            }
        },myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH));

        terms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    //if(!TextUtils.isEmpty(dateText.getText().toString())){
                       // submit.setVisibility(View.VISIBLE);

                    Intent i= new Intent(Child_Result.this, SelectDate.class);
                    i.putExtra("value",dateValue);
                    startActivityForResult(i,11);
                    // Show the date picker dialog fragment
                    //}
                   /* else {
                        Toast.makeText(getApplicationContext(),"Please select the date",Toast.LENGTH_LONG).show();
                    }*/
                   // submit.setVisibility(View.VISIBLE);
                }
                else {
                    submit.setVisibility(View.GONE);
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(Child_Result.this, PortfolioDialog.class);
                    i.putExtra("amount",sumCost);
                    startActivityForResult(i,121);
                   // sentData();
                }
                catch (Exception e){
                    Log.e("UserResponse Child_result",e.toString());
                }
            }
        });

        changeFund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        try {
            weekCalculate();
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    private synchronized void loadDate() {
        Calendar c = Calendar.getInstance();
        int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        dateValue = new String[monthMaxDays];
       // dateValue[0] = "Select";
        for (int i=0;i<monthMaxDays;i++){
            dateValue[i] = String.valueOf(i+1);
        }
      //  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,dateValue);
       // date.setAdapter(adapter);
    }

    private synchronized void sentData() {
        switch (page){
            case "1":
                plan = new CreateUserPlan();
                plan.setUserId(Utils.getStringPref(Utils.UserId));
                user=new UserPlan();
                user.setPlan_ID("");
                user.setMasterPlanId(page);
                user.setUser_ID("");
                user.setGoal(name);
                user.setPresentAge(String.valueOf(current_age));
                user.setGoalTimeToStart(String.valueOf(higher_edu_age));
                user.setGoalDuration(String.valueOf(sub));
                user.setGoalPerYearCost((int) current_cost_edu);
                user.setGoalPerYearLivingCost((int) living_cost);
                user.setGoalLumpsum(String.valueOf(saved));
                user.setGoalInflationRate(String.valueOf(inflation));
                user.setGoalTotalCost(0);
                user.setGoalLivingTotalCost((int) totalLivingCost);
                user.setGoalTotalAmount((int) totalAmount);
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
                user.setRisk(risk);
                port=new UserPortfolio();
                port.setPortfolio_ID("");
                port.setPlan_ID("");
                port.setUser_ID("");
                port.setGold((int) goldPerCost);
                port.setDebt((int) debtPerCost);
                port.setEquity((int) equityPerCost);
                port.setEstimatedTotalSIPAmt((int) sumCost);
                port.setSchemeId("");
                plan.setUserPlan(user);
                plan.setUserPortfolio(port);
                plan.setInvestmentList(investList);
                webCall();
                //Log.e("sampleStructure investList", String.valueOf(investList));
                break;
            case "2":
                plan = new CreateUserPlan();
                plan.setUserId(Utils.getStringPref(Utils.UserId));
                user=new UserPlan();
                user.setPlan_ID("");
                user.setMasterPlanId(page);
                user.setUser_ID("");
                user.setGoal(name);
                user.setPresentAge(String.valueOf(current_age));
                user.setGoalTimeToStart("");
                user.setGoalDuration("");
                user.setGoalPerYearCost((int) annual_invest);
                user.setGoalPerYearLivingCost(0);
                user.setGoalLumpsum("");
                user.setGoalInflationRate(String.valueOf(inflation));
                user.setGoalTotalCost(0);
                user.setGoalLivingTotalCost((int) totalLivingCost);
                user.setGoalTotalAmount(calculatedCost);
                user.setGoalTotalLumpsumAmount(0);
                user.setEstimatedInflationRate(String.valueOf(estimated_percentage));
                user.setGoalDateOfSip("");
                user.setGoalRetirementYear(String.valueOf(retirement_age));
                user.setGoalRetirementExpense((int) annual_invest);
                user.setGoalRetirementMonthlyExpenditure((int) monthly_expenses);
                user.setGoalHousePlanYear("");
                user.setGoalHouseCurrentCost(0);
                user.setGoalHouseDownPayment(0);
                user.setGoalHouseLoanYear("");
                user.setGoalChildMerrageBudgetAmount(0);
                user.setRisk("");
                port=new UserPortfolio();
                port.setGold((int) goldPerCost);
                port.setDebt((int) debtPerCost);
                port.setEquity((int) equityPerCost);
                port.setPlan_ID("");
                port.setUser_ID("");
                port.setPortfolio_ID("");
                port.setEstimatedTotalSIPAmt((int) sumCost);
                port.setSchemeId("");
                plan.setUserPlan(user);
                plan.setUserPortfolio(port);
                plan.setInvestmentList(investList);
                webCall();
                break;
            case "3":
                plan = new CreateUserPlan();
                plan.setUserId(Utils.getStringPref(Utils.UserId));
                user=new UserPlan();
                user.setPlan_ID("");
                user.setUser_ID(Utils.getStringPref(Utils.UserId));
                user.setMasterPlanId(page);
                user.setGoal("");
                user.setEstimatedInflationRate(String.valueOf(inflation));
                user.setPresentAge(String.valueOf(current_age));
                user.setGoalTimeToStart("");
                user.setGoalDuration("");
                user.setGoalPerYearCost(0);
                user.setGoalPerYearLivingCost(0);
                user.setGoalLumpsum("");
                user.setGoalInflationRate("");
                user.setGoalLivingTotalCost(0);
                user.setGoalTotalLumpsumAmount(0);
                user.setGoalDateOfSip("");
                user.setGoalRetirementYear("");
                user.setGoalRetirementExpense(0);
                user.setGoalRetirementMonthlyExpenditure(0);
                user.setGoalTotalCost(0);
                user.setGoalTotalAmount(calculatedCost);
                user.setGoalHousePlanYear(String.valueOf(planYear));
                user.setGoalHouseLoanYear(String.valueOf(year));
                user.setGoalHouseCurrentCost((int) currentCost);
                user.setGoalHouseDownPayment((int) investAmount);
                user.setGoalChildMerrageBudgetAmount(0);
                user.setRisk("");
                port=new UserPortfolio();
                port.setGold((int) goldPerCost);
                port.setDebt((int) debtPerCost);
                port.setEquity((int) equityPerCost);
                port.setEstimatedTotalSIPAmt((int) sumCost);
                port.setSchemeId("");
                port.setPlan_ID("");
                port.setUser_ID("");
                port.setPortfolio_ID("");
                plan.setUserPlan(user);
                plan.setUserPortfolio(port);
                plan.setInvestmentList(investList);
                webCall();
                break;
            case "4":
                plan = new CreateUserPlan();
                plan.setUserId(Utils.getStringPref(Utils.UserId));
                user=new UserPlan();
                user.setUser_ID(Utils.getStringPref(Utils.UserId));
                user.setMasterPlanId(page);
                user.setGoal(name);
                user.setEstimatedInflationRate(String.valueOf(inflation));
                user.setGoalTotalCost(0);
                user.setGoalDuration(String.valueOf(durationYear));
                user.setGoalTotalAmount((int) goalAmount);
                user.setPlan_ID("");
                user.setPresentAge("");
                user.setGoalTimeToStart("");
                user.setGoalPerYearCost(0);
                user.setGoalPerYearLivingCost(0);
                user.setGoalLumpsum("");
                user.setGoalInflationRate("");
                user.setGoalLivingTotalCost(0);
                user.setGoalTotalLumpsumAmount(0);
                user.setGoalDateOfSip("");
                user.setGoalRetirementYear("");
                user.setGoalRetirementExpense(0);
                user.setGoalRetirementMonthlyExpenditure(0);
                user.setGoalHousePlanYear(String.valueOf(planYear));
                user.setGoalHouseLoanYear(String.valueOf(year));
                user.setGoalHouseCurrentCost((int) currentCost);
                user.setGoalHouseDownPayment((int) investAmount);
                user.setGoalChildMerrageBudgetAmount(0);
                user.setRisk("");
                port=new UserPortfolio();
                port.setGold((int) goldPerCost);
                port.setDebt((int) debtPerCost);
                port.setEquity((int) equityPerCost);
                port.setEstimatedTotalSIPAmt((int) sumCost);
                port.setSchemeId("");
                port.setPlan_ID("");
                port.setUser_ID("");
                port.setPortfolio_ID("");
                plan.setUserPlan(user);
                plan.setUserPortfolio(port);
                plan.setInvestmentList(investList);
                webCall();
                break;
            case "5":
                plan = new CreateUserPlan();
                plan.setUserId(Utils.getStringPref(Utils.UserId));
                user=new UserPlan();
                user.setUser_ID("");
                user.setPlan_ID("");
                user.setMasterPlanId(page);
                user.setGoal("");
                user.setGoalDuration("") ;
                user.setPresentAge(String.valueOf(current_age));
                user.setGoalTimeToStart(String.valueOf(marriage_age));
                user.setGoalPerYearCost(0);
                user.setGoalPerYearLivingCost(0);
                user.setGoalInflationRate("");
                user.setGoalLumpsum("");
                user.setGoalTotalCost(0);
                user.setGoalTotalAmount(calculatedCost);
                user.setGoalLivingTotalCost(0);
                user.setGoalTotalLumpsumAmount(0);
                user.setGoalDateOfSip("");
                user.setGoalRetirementYear("");
                user.setGoalRetirementExpense(0);
                user.setGoalRetirementMonthlyExpenditure(0);
                user.setGoalHouseCurrentCost(0);
                user.setGoalHouseDownPayment(0);
                user.setGoalHouseLoanYear("");
                user.setGoalHousePlanYear("");
                user.setEstimatedInflationRate(String.valueOf(inflation));
                user.setGoalChildMerrageBudgetAmount((int) budgetCost);
                user.setRisk("");
                port=new UserPortfolio();
                port.setGold((int) goldPerCost);
                port.setDebt((int) debtPerCost);
                port.setEquity((int) equityPerCost);
                port.setEstimatedTotalSIPAmt((int) sumCost);
                port.setSchemeId("");
                port.setPlan_ID("");
                port.setUser_ID("");
                port.setPortfolio_ID("");
                plan.setUserPlan(user);
                plan.setUserPortfolio(port);
                plan.setInvestmentList(investList);
                webCall();
                break;
            case "7":
                plan = new CreateUserPlan();
                plan.setUserId(Utils.getStringPref(Utils.UserId));
                user=new UserPlan();
                user.setUser_ID("");
                user.setPlan_ID("");
                user.setMasterPlanId(page);
                user.setGoal(name);
                user.setPresentAge(String.valueOf(current_age));
                user.setEstimatedInflationRate(String.valueOf(inflation));
                user.setGoalDuration(String.valueOf(durationYear));
                user.setGoalTotalAmount((int) budgetAmount);
                user.setGoalTimeToStart(String.valueOf(planYear));
                user.setGoalTimeToStart("");
                user.setGoalPerYearCost(0);
                user.setGoalPerYearLivingCost(0);
                user.setGoalLumpsum("");
                user.setGoalInflationRate("");
                user.setGoalTotalCost(0);
                user.setGoalLivingTotalCost(0);
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
                port.setGold((int) goldPerCost);
                port.setDebt((int) debtPerCost);
                port.setEquity((int) equityPerCost);
                port.setEstimatedTotalSIPAmt((int) sumCost);
                port.setSchemeId("");
                port.setPlan_ID("");
                port.setUser_ID("");
                port.setPortfolio_ID("");
                plan.setUserPlan(user);
                plan.setUserPortfolio(port);
                plan.setInvestmentList(investList);
                webCall();
                break;
            case "8":

                break;
        }
    }

    private void webCall() {
        if(new Utils().isNetworkAvailable(getApplicationContext())){
            apiService.createUserPlan(plan).enqueue(new Invest());
        }
        else {
            Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_LONG).show();
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
            //onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add:
                try {
                    calculateAddMinus("P","ChildGoal");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.minus:
                try {
                    calculateAddMinus("M","ChildGoal");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void calculateAddMinus(String action, String page) throws JSONException {
        Fund_LargeCap_result_Temp = 0;
        Fund_MultiCap_result= 0;
        Fund_MultiCap_result_Temp= 0;
        Fund_BondCap_result= 0;
        Fund_BondCap_result_Temp= 0;
        Fund_UltraCap_result= 0;
        Fund_UltraCap_result_Temp= 0;
        Fund_MidCap_result= 0;
        Fund_MidCap_result_Temp= 0;
        Fund_CreditOpportunity_result= 0;
        Fund_CreditOpportunity_result_Temp= 0;
        Fund_DebtLiquid_result= 0;
        Fund_DebtLiquid_result_Temp= 0;
        Fund_Gold_result= 0;
        Fund_Gold_result_Temp= 0;
        Fund_MIP_result= 0;
        Fund_MIP_result_Temp= 0;
        Fund_Balanced_result= 0;
        Fund_Balanced__result_Temp = 0;
        Fund_Income_result= 0;
        Fund_Income__result_Temp= 0;
        Fund_GILT_result= 0;
        Fund_GILT__result_Temp= 0;
        Fund_Income_result = 0;
        Fund_Income__result_Temp = 0;
        Fund_MIP_result = 0;
        Fund_MIP_result_Temp = 0;
        resultTemp = null;
        //JSONObject sampleStructure;
        sampleStructureJson = null;
        //private String Result_Temp[];
        fundLargeCap = 0;
        fundMultiCap = 0;
        fundBondFunds = 0;
        fundMidCap = 0;
        fundGold = 0;
        fundLiquidCap = 0;
        fundUltraSortFund= 0;
        fundBalanced = 0;
        fundGlit = 0;
        fundCreditOpportunity= 0;
        equityLargeCapIndex.clear();
        equityMultiCapIndex.clear();
        equityMidSmallIndex.clear();
        equityUltraSortIndex.clear();
        equityBondIndex.clear();
        equityLiquidIndex.clear();
        creditOpportunitiesIndex.clear();
        balancedIndex.clear();
        glitIndex.clear();
        equityPerCost = 0.0;
        debtPerCost = 0.0;
        goldIndex.clear();
        mipIndex.clear();
        incomeIndex.clear();
        giltIndex.clear();
        if(action.equals("P")){
            //$scope.Portfolio_Calculate("ChnageAmount");
            sumCost = (int) (sumCost + 1000);
            //Log.e("total +", String.valueOf(sumCost));
            calculation((int) sumCost, screenName, risk);

        }
        else if(action.equals("M")){
            if(sumCost >= 1000) {
                sumCost = (int) (sumCost - 1000);
                //Log.e("total -", String.valueOf(sumCost));
                calculation((int) sumCost, screenName,risk);
            }
            else {
                Toast.makeText(getApplicationContext(),"you can not have less than 1000 Rupees",Toast.LENGTH_LONG).show();
            }
        }
    }

    private synchronized void calculation(int totalMonthlyInvestment, String screenName, String risk) throws JSONException {
        JSONObject obj= new CalculatePortfolio().CalculatePortfolioAllocation(sub, totalMonthlyInvestment,risk,screenName,"");
        JSONArray res = obj.getJSONArray("data");
        //Log.e("res", String.valueOf(res));
        goalData = obj.toString();
        for(int i=0;i<res.length();i++){
            JSONObject jsonobject = res.getJSONObject(i);
            c_equity = Integer.parseInt(jsonobject.getString("Return_EquityPer"));
            c_gold = Integer.parseInt(jsonobject.getString("Returm_GoldPer"));
            c_debt = Integer.parseInt(jsonobject.getString("Returm_DebtPer"));
            JSONArray jsonArray = jsonobject.getJSONArray("Fund");
            for (int j=0;j<jsonArray.length();j++){
                JSONObject object = jsonArray.getJSONObject(i);
                fundLargeCap = Integer.parseInt(object.getString("Fund_LargeCap"));
                fundMultiCap = Integer.parseInt(object.getString("Fund_MultiCap"));
                fundBondFunds = Integer.parseInt(object.getString("Fund_BondFunds"));
                fundMidCap = Integer.parseInt(object.getString("Fund_MidCap"));
                fundGold = Integer.parseInt(object.getString("Fund_Gold"));
                fundLiquidCap = Integer.parseInt(object.getString("Fund_LiquidCap"));
                fundUltraSortFund = Integer.parseInt(object.getString("Fund_UltraSortFund"));
                fundCreditOpportunity = Integer.parseInt(object.getString("Fund_CreditOpportunity"));
                fundBalanced = Integer.parseInt(object.getString("Fund_Balanced"));
                fundGlit = Integer.parseInt(object.getString("Fund_GILT"));
            }
        }
        equityPerCost = totalMonthlyInvestment * c_equity/100;
        double equtTemp = equityPerCost % 100;
        if(equtTemp != 0){
            double equtTemp2 = 100 - equtTemp;
            equityPerCost = equityPerCost + equtTemp2;
        }
        debtPerCost = totalMonthlyInvestment* c_debt/100;
        double debtTemp = debtPerCost % 100;
        if(debtTemp !=0) {
            double debtTemp2 = 100 - debtTemp;
            debtPerCost = debtPerCost + debtTemp2;
        }
        goldPerCost =  totalMonthlyInvestment* c_gold/100;
        goldPerCost = sumCost * c_gold / 100;
        double goldTemp = goldPerCost % 100;
        if (goldTemp != 0) {
            double goldTemp2 = 100 - goldTemp;
            goldPerCost = goldPerCost + goldTemp2;
        }
        equity.setText(String.valueOf(new DecimalFormat("##,##,##,###.##").format(equityPerCost)));
        debt.setText(String.valueOf(new DecimalFormat("##,##,##,###.##").format(debtPerCost)));
        total.setText(String.valueOf(new DecimalFormat("##,##,##,###.##").format(totalMonthlyInvestment)));
        if(goldPerCost==0){
            goldLay.setVisibility(View.GONE);
        }
        else {
            goldLay.setVisibility(View.VISIBLE);
            goldText.setText(String.valueOf(new DecimalFormat("##,##,##,###.##").format(goldPerCost)));
        }
        try {
            weekCalculate();
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    private class Invest implements Callback<CreateUsersPlanResult> {

        @Override
        public void onResponse(Call<CreateUsersPlanResult> call, Response<CreateUsersPlanResult> response) {
            ////Log.e("Data",response.toString());
            if (((CreateUsersPlanResult) response.body()).getGetCreateUsersPlanResult().getResponseCode().intValue() == 0) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),getApplicationContext().getResources().getString(R.string.submission),Toast.LENGTH_LONG).show();
                Intent i =new Intent(Child_Result.this, DashBoard.class);
                startActivity(i);
                finish();
            }
        }

        @Override
        public void onFailure(Call<CreateUsersPlanResult> call, Throwable t) {
            Toast.makeText(Child_Result.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
        }
    }

    private synchronized void  weekCalculate() throws JSONException {
        resultTemp = new JSONObject();
        sampleStructureJson = new JSONArray();
        JSONObject object= new JSONObject(new CalculatePortfolio().goalJsonStructure().toString());
        JSONArray res = object.getJSONArray("data");
        // //Log.e("res", String.valueOf(res));
        for(int i=0;i<res.length();i++){
            JSONObject obj = res.getJSONObject(i);
            if(obj.getString("MFtype").equals("EQ large cap")){
                equityLargeCapIndex.add(String.valueOf(i));
            }
            else if(obj.getString("MFtype").equals("EQ Multicap")) {
                equityMultiCapIndex.add(String.valueOf(i));
            }
            else if(obj.getString("MFtype").equals("EQ Mid/small")) {
                equityMidSmallIndex.add(String.valueOf(i));
            }
            else if(obj.getString("MFtype").equals("Debt/ ultra short")) {
                equityUltraSortIndex.add(String.valueOf(i));
            }
            else if(obj.getString("MFtype").equals("Debt/ GILT")) {
                equityBondIndex.add(String.valueOf(i));
            }
            else if(obj.getString("MFtype").equals("Debt liquid")) {
                equityLiquidIndex.add(String.valueOf(i));
            }
            else if(obj.getString("MFtype").equals("Credit Opportunities")) {
                creditOpportunitiesIndex.add(String.valueOf(i));
            }
            else if(obj.getString("MFtype").equals("Gold")) {
                goldIndex.add(String.valueOf(i));
            }
            else if(obj.getString("MFtype").equals("Balanced")) {
                balancedIndex.add(String.valueOf(i));
            }
            else if(obj.getString("MFtype").equals("MIP")) {
                mipIndex.add(String.valueOf(i));
            }
            else if(obj.getString("MFtype").equals("Debt/Income")) {
                incomeIndex.add(String.valueOf(i));
            }
            else if(obj.getString("MFtype").equals("Debt/ GILT")) {
                giltIndex.add(String.valueOf(i));
            }
        }
        //Log.e("sumCost", String.valueOf(sumCost));
        if (fundLargeCap > 0) {
            Fund_LargeCap_result = (int) ((double) fundLargeCap/100 * sumCost);
            Fund_LargeCap_result_Temp = Fund_LargeCap_result%100;
            resultTemp.put("SchemeType", "Large");
            resultTemp.put("ModResult", Fund_LargeCap_result_Temp);
            //Log.e("Fund_LargeCap_result_Temp", String.valueOf(Fund_LargeCap_result_Temp));
        }
        if (fundMultiCap > 0) {
            Fund_MultiCap_result = (int) ((double) fundMultiCap/ 100 * sumCost);
            Fund_MultiCap_result_Temp = Fund_MultiCap_result % 100;
            resultTemp.put("SchemeType", "Multi");
            resultTemp.put("ModResult", Fund_MultiCap_result_Temp);
            //Log.e("Fund_MultiCap_result_Temp", String.valueOf(Fund_MultiCap_result_Temp));
        }
        if (fundBondFunds > 0) {
            Fund_BondCap_result = (int) ((double) fundBondFunds/ 100 * sumCost);
            Fund_BondCap_result_Temp = Fund_BondCap_result % 100;
            resultTemp.put("SchemeType", "Bond");
            resultTemp.put("ModResult", Fund_BondCap_result_Temp);
            //Log.e("Fund_BondCap_result_Temp", String.valueOf(Fund_BondCap_result_Temp));
        }
        if (fundUltraSortFund > 0) {
            Fund_UltraCap_result = (int) ((double) fundUltraSortFund /100 * sumCost);
            Fund_UltraCap_result_Temp = Fund_UltraCap_result % 100;
            resultTemp.put("SchemeType", "Ultra");
            resultTemp.put("ModResult", Fund_UltraCap_result_Temp);
            //Log.e("Fund_UltraCap_result_Temp", String.valueOf(Fund_UltraCap_result_Temp));
        }
        if (fundMidCap > 0) {
            Fund_MidCap_result = (int) ((double) fundMidCap/100 * sumCost);
            Fund_MidCap_result_Temp = Fund_MidCap_result % 100;
            resultTemp.put("SchemeType", "Mid");
            resultTemp.put("ModResult", Fund_MidCap_result_Temp);
            //Log.e("Fund_MidCap_result_Temp", String.valueOf(Fund_MidCap_result_Temp));
        }
        if (fundCreditOpportunity > 0) {
            Fund_CreditOpportunity_result = (int) ((double) fundCreditOpportunity/100 * sumCost);
            Fund_CreditOpportunity_result_Temp = Fund_CreditOpportunity_result % 100;
            resultTemp.put("SchemeType", "Credit");
            resultTemp.put("ModResult", Fund_CreditOpportunity_result_Temp);
            //Log.e("Fund_CreditOpportunity_result_Temp", String.valueOf(Fund_CreditOpportunity_result_Temp));
        }
        if (fundLiquidCap > 0) {
            Fund_DebtLiquid_result = (int) ((double) fundLiquidCap/ 100 * sumCost);
            Fund_DebtLiquid_result_Temp = Fund_DebtLiquid_result % 100;
            resultTemp.put("SchemeType", "Liquid");
            resultTemp.put("ModResult", Fund_DebtLiquid_result_Temp);
            //Log.e("Fund_DebtLiquid_result_Temp", String.valueOf(Fund_DebtLiquid_result_Temp));
        }
        if (fundGold > 0) {
            Fund_Gold_result = (int) ((double) fundGold/ 100 * sumCost);
            Fund_Gold_result_Temp = Fund_Gold_result % 100;
            resultTemp.put("SchemeType", "Gold");
            resultTemp.put("ModResult", Fund_Gold_result_Temp);
            //Log.e("Fund_Gold_result_Temp", String.valueOf(Fund_Gold_result_Temp));
        }
        if(fundBalanced > 0){
            Fund_Balanced_result = (int) ((double) fundBalanced/ 100 * sumCost);
            Fund_Balanced__result_Temp = Fund_Balanced_result % 100;
            resultTemp.put("SchemeType", "Balanced");
            resultTemp.put("ModResult", Fund_Balanced__result_Temp);
        }
        if(fundGlit > 0){
            Fund_GILT_result = (int) ((double) fundGlit/ 100 * sumCost);
            Fund_GILT__result_Temp = Fund_GILT_result % 100;
            resultTemp.put("SchemeType", "GILT");
            resultTemp.put("ModResult", Fund_GILT__result_Temp);
        }


        //////////////////////////////////////////////////////////////////////////////////////////////

        if (fundLargeCap > 0)
        {   JSONObject sampleStructure = new JSONObject();
            for(int a=0;a<equityLargeCapIndex.size();a++) {
                JSONObject result = res.getJSONObject(Integer.parseInt(equityLargeCapIndex.get(a)));
                // JSONObject dateResult = res.getJSONObject(Integer.parseInt(equityUltraSortIndex.get(a));
                if (Fund_LargeCap_result > Integer.parseInt(result.getString("MinInvst").toString())) {
                    if ((Fund_LargeCap_result % Integer.parseInt(result.getString("multiplier").toString())) == 0) {
                        sampleStructure.put("SchemeName", result.getString("SchemeName").toString());
                        sampleStructure.put("BSESchmecode", result.getString("BSESchmecode").toString());
                        sampleStructure.put("ISIN", result.getString("ISIN").toString());
                      //  String date = result.getString("date").toString();
                       // String d[] = date.split(",");
                       // d[Integer.parseInt(index)-1] == "1 - 30 all days" ? d[a-1] :
                        //    sampleStructure.put("Date", d[Integer.parseInt(index) - 1] == "1-30 all days" ? dateResult.date.split(',')[parseInt(Number) - 1] : $scope.SIPGoalStructureDate[EquityUltraSortIndex[a]].date.split(',')[parseInt(Number) - 1],
                        sampleStructure.put("Amount", Fund_LargeCap_result);
                        sampleStructureJson.put(sampleStructure);
                        break;
                    }
                }
            }
            //Log.e("sampleStructure Large", String.valueOf(sampleStructure));
        }

        //Equity Mid Cap
        if (fundMultiCap > 0) {
            JSONObject sampleStructure = new JSONObject();
            //Fund_MultiCap_result = parseInt(($scope.CalculatedPercentage.Data[0].Fund[0].Fund_MultiCap / 100) * $rootScope.Portfolio_Parameter.TotalMonthlyInvestment);
            for (int a = 0; a < equityMultiCapIndex.size(); a++) {
                JSONObject result = res.getJSONObject(Integer.parseInt(equityMultiCapIndex.get(a)));
                if (Fund_MultiCap_result > Integer.parseInt(result.getString("MinInvst").toString())) {
                    if ((Fund_MultiCap_result % Integer.parseInt(result.getString("multiplier").toString())) == 0) {
                        sampleStructure.put("SchemeName", result.getString("SchemeName").toString());
                        sampleStructure.put("BSESchmecode", result.getString("BSESchmecode").toString());
                        sampleStructure.put("ISIN", result.getString("ISIN").toString());
                        // sampleStructure.put("Date": $scope.SIPGoalStructureDate[EquityUltraSortIndex[a]].date.split(',')[parseInt(Number) - 1] == '1-30 all days' ? $scope.SIPGoalStructureDate[EquityUltraSortIndex[a]].date.split(',')[parseInt(Number) - 1] : $scope.SIPGoalStructureDate[EquityUltraSortIndex[a]].date.split(',')[parseInt(Number) - 1],
                        sampleStructure.put("Amount", Fund_MultiCap_result);
                        sampleStructureJson.put(sampleStructure);
                        break;
                    }
                }
            }
            //Log.e("sampleStructure Multi", String.valueOf(sampleStructure));
        }

        //Bonds Fund
        if (fundBondFunds > 0) {
            JSONObject sampleStructure = new JSONObject();
            for (int a = 0; a < equityBondIndex.size(); a++) {
                JSONObject result = res.getJSONObject(Integer.parseInt(equityBondIndex.get(a)));
                if (Fund_BondCap_result > Integer.parseInt(result.getString("MinInvst").toString())) {
                    if ((Fund_BondCap_result % Integer.parseInt(result.getString("multiplier").toString())) == 0) {
                        sampleStructure.put("SchemeName", result.getString("SchemeName").toString());
                        sampleStructure.put("BSESchmecode", result.getString("BSESchmecode").toString());
                        sampleStructure.put("ISIN", result.getString("ISIN").toString());
                        //"Date": $scope.SIPGoalStructureDate[EquityUltraSortIndex[a]].date.split(',')[parseInt(Number) - 1] == '1-30 all days' ? $scope.SIPGoalStructureDate[EquityUltraSortIndex[a]].date.split(',')[parseInt(Number) - 1] : $scope.SIPGoalStructureDate[EquityUltraSortIndex[a]].date.split(',')[parseInt(Number) - 1],
                        sampleStructure.put("Amount", Fund_BondCap_result);
                        sampleStructureJson.put(sampleStructure);
                        break;
                    }
                }
            }
            //Log.e("sampleStructure Bonds", String.valueOf(sampleStructure));
        }

        //Ultry Sort Fund
        if (fundUltraSortFund > 0) {
            JSONObject sampleStructure = new JSONObject();
            for (int a = 0; a < equityUltraSortIndex.size(); a++) {
                JSONObject result = res.getJSONObject(Integer.parseInt(equityUltraSortIndex.get(a)));
                if (Fund_UltraCap_result > Integer.parseInt(result.getString("MinInvst").toString())) {
                    if ((Fund_UltraCap_result % Integer.parseInt(result.getString("multiplier").toString())) == 0) {
                        sampleStructure.put("SchemeName", result.getString("SchemeName").toString());
                        sampleStructure.put("BSESchmecode", result.getString("BSESchmecode").toString());
                        sampleStructure.put("ISIN", result.getString("ISIN").toString());
                        //"Date": $scope.SIPGoalStructureDate[EquityUltraSortIndex[a]].date.split(',')[parseInt(Number) - 1] == '1-30 all days' ? $scope.SIPGoalStructureDate[EquityUltraSortIndex[a]].date.split(',')[parseInt(Number) - 1] : $scope.SIPGoalStructureDate[EquityUltraSortIndex[a]].date.split(',')[parseInt(Number) - 1],
                        sampleStructure.put("Amount", Fund_UltraCap_result);
                        sampleStructureJson.put(sampleStructure);
                        // "Date": $scope.SIPGoalStructureDate[EquityUltraSortIndex[a]].date.split(',')[parseInt(Number) - 1] == '1-30 all days' ? $scope.SIPGoalStructureDate[EquityUltraSortIndex[a]].date.split(',')[parseInt(Number) - 1] : $scope.SIPGoalStructureDate[EquityUltraSortIndex[a]].date.split(',')[parseInt(Number) - 1],
                        break;
                    }
                }
            }
            //Log.e("sampleStructure Ultry", String.valueOf(sampleStructure));
        }

        //Mid Fund
        if (fundMidCap > 0) {
            JSONObject sampleStructure = new JSONObject();
            //Fund_MidCap_result = parseInt(($scope.CalculatedPercentage.Data[0].Fund[0].Fund_MidCap / 100) * $rootScope.Portfolio_Parameter.TotalMonthlyInvestment);
            for (int a = 0; a < equityMidSmallIndex.size(); a++) {
                JSONObject result = res.getJSONObject(Integer.parseInt(equityMidSmallIndex.get(a)));
                if (Fund_MidCap_result > Integer.parseInt(result.getString("MinInvst").toString())) {
                    if ((Fund_MidCap_result % Integer.parseInt(result.getString("multiplier").toString())) == 0) {
                        sampleStructure.put("SchemeName", result.getString("SchemeName").toString());
                        sampleStructure.put("BSESchmecode", result.getString("BSESchmecode").toString());
                        sampleStructure.put("ISIN", result.getString("ISIN").toString());
                        //"Date":       $scope.SIPGoalStructureDate[EquityUltraSortIndex[a]].date.split(',')[parseInt(Number) - 1] == '1-30 all days' ? $scope.SIPGoalStructureDate[EquityUltraSortIndex[a]].date.split(',')[parseInt(Number) - 1] : $scope.SIPGoalStructureDate[EquityUltraSortIndex[a]].date.split(',')[parseInt(Number) - 1],
                        sampleStructure.put("Amount", Fund_MidCap_result);
                        sampleStructureJson.put(sampleStructure);
                        break;
                    }
                }
            }
            //Log.e("sampleStructure Mid", String.valueOf(sampleStructure));
        }
        //Credit Opportunity
        if (fundCreditOpportunity > 0) {
            JSONObject sampleStructure = new JSONObject();
            //Fund_CreditOpportunity_result = parseInt(($scope.CalculatedPercentage.Data[0].Fund[0].Fund_CreditOpportunity / 100) * $rootScope.Portfolio_Parameter.TotalMonthlyInvestment);
            for (int a = 0; a < creditOpportunitiesIndex.size(); a++) {
                JSONObject result = res.getJSONObject(Integer.parseInt(creditOpportunitiesIndex.get(a)));
                if (Fund_CreditOpportunity_result > Integer.parseInt(result.getString("MinInvst").toString())) {
                    if ((Fund_CreditOpportunity_result % Integer.parseInt(result.getString("multiplier").toString())) == 0) {
                        sampleStructure.put("SchemeName", result.getString("SchemeName").toString());
                        sampleStructure.put("BSESchmecode", result.getString("BSESchmecode").toString());
                        sampleStructure.put("ISIN", result.getString("ISIN").toString());
                        //"Date": $scope.SIPGoalStructureDate[CreditOpportunitiesIndex[a]].date.split(',')[parseInt(Number) - 1] == '1-30 all days' ? $scope.SIPGoalStructureDate[CreditOpportunitiesIndex[a]].date.split(',')[parseInt(Number) - 1] : $scope.SIPGoalStructureDate[CreditOpportunitiesIndex[a]].date.split(',')[parseInt(Number) - 1],
                        sampleStructure.put("Amount", Fund_CreditOpportunity_result);
                        sampleStructureJson.put(sampleStructure);
                        break;
                    }
                }
            }
            //Log.e("sampleStructure Credit", String.valueOf(sampleStructure));
        }

        //Liquid Fund
        if (fundLiquidCap > 0) {
            JSONObject sampleStructure = new JSONObject();
            for (int a = 0; a < equityLiquidIndex.size(); a++) {
                JSONObject result = res.getJSONObject(Integer.parseInt(equityLiquidIndex.get(a)));
                if (Fund_DebtLiquid_result > Integer.parseInt(result.getString("MinInvst").toString())) {
                    if ((Fund_DebtLiquid_result % Integer.parseInt(result.getString("multiplier").toString())) == 0) {
                        sampleStructure.put("SchemeName", result.getString("SchemeName").toString());
                        sampleStructure.put("BSESchmecode", result.getString("BSESchmecode").toString());
                        sampleStructure.put("ISIN", result.getString("ISIN").toString());
                        //"Date": $scope.SIPGoalStructureDate[EquityLiquidIndex[a]].date.split(',')[parseInt(Number) - 1] == '1-30 all days' ? $scope.SIPGoalStructureDate[EquityLiquidIndex[a]].date.split(',')[parseInt(Number) - 1] : $scope.SIPGoalStructureDate[EquityLiquidIndex[a]].date.split(',')[parseInt(Number) - 1],
                        sampleStructure.put("Amount", Fund_DebtLiquid_result);
                        sampleStructureJson.put(sampleStructure);
                        break;
                    }
                }
            }
        }

        //Gold Fund
        if (fundGold > 0) {
            JSONObject sampleStructure = new JSONObject();
            for (int a = 0; a < goldIndex.size(); a++) {
                JSONObject result = res.getJSONObject(Integer.parseInt(goldIndex.get(a)));
                if (Fund_Gold_result > Integer.parseInt(result.getString("MinInvst").toString())) {
                    if ((Fund_Gold_result % Integer.parseInt(result.getString("multiplier").toString())) == 0) {
                        sampleStructure.put("SchemeName", result.getString("SchemeName").toString());
                        sampleStructure.put("BSESchmecode", result.getString("BSESchmecode").toString());
                        sampleStructure.put("ISIN", result.getString("ISIN").toString());
                        //"Date": $scope.SIPGoalStructureDate[GoldIndex[a]].date.split(',')[parseInt(Number) - 1] == '1-30 all days' ? $scope.SIPGoalStructureDate[GoldIndex[a]].date.split(',')[parseInt(Number) - 1] : $scope.SIPGoalStructureDate[GoldIndex[a]].date.split(',')[parseInt(Number) - 1],
                        sampleStructure.put("Amount", Fund_Gold_result);
                        sampleStructureJson.put(sampleStructure);
                        break;
                    }
                }
            }
        }

        if(fundBalanced > 0){
            JSONObject sampleStructure = new JSONObject();
            for (int a = 0; a < balancedIndex.size(); a++) {
                JSONObject result = res.getJSONObject(Integer.parseInt(balancedIndex.get(a)));
                if (Fund_Balanced_result > Integer.parseInt(result.getString("MinInvst").toString())) {
                    if ((Fund_Balanced_result % Integer.parseInt(result.getString("multiplier").toString())) == 0) {
                        sampleStructure.put("SchemeName", result.getString("SchemeName").toString());
                        sampleStructure.put("BSESchmecode", result.getString("BSESchmecode").toString());
                        sampleStructure.put("ISIN", result.getString("ISIN").toString());
                        //"Date": $scope.SIPGoalStructureDate[GoldIndex[a]].date.split(',')[parseInt(Number) - 1] == '1-30 all days' ? $scope.SIPGoalStructureDate[GoldIndex[a]].date.split(',')[parseInt(Number) - 1] : $scope.SIPGoalStructureDate[GoldIndex[a]].date.split(',')[parseInt(Number) - 1],
                        sampleStructure.put("Amount", Fund_Balanced_result);
                        sampleStructureJson.put(sampleStructure);
                        break;
                    }
                }
            }
        }

        if(fundGlit > 0){
            JSONObject sampleStructure = new JSONObject();
            for (int a = 0; a < glitIndex.size(); a++) {
                JSONObject result = res.getJSONObject(Integer.parseInt(glitIndex.get(a)));
                if (Fund_GILT_result > Integer.parseInt(result.getString("MinInvst").toString())) {
                    if ((Fund_GILT_result % Integer.parseInt(result.getString("multiplier").toString())) == 0) {
                        sampleStructure.put("SchemeName", result.getString("SchemeName").toString());
                        sampleStructure.put("BSESchmecode", result.getString("BSESchmecode").toString());
                        sampleStructure.put("ISIN", result.getString("ISIN").toString());
                        //"Date": $scope.SIPGoalStructureDate[GoldIndex[a]].date.split(',')[parseInt(Number) - 1] == '1-30 all days' ? $scope.SIPGoalStructureDate[GoldIndex[a]].date.split(',')[parseInt(Number) - 1] : $scope.SIPGoalStructureDate[GoldIndex[a]].date.split(',')[parseInt(Number) - 1],
                        sampleStructure.put("Amount", Fund_GILT_result);
                        sampleStructureJson.put(sampleStructure);
                        break;
                    }
                }
            }
        }
        // Log.e("sampleStructure", String.valueOf(sampleStructureJson));
       /* //Log.e("Fund_Gold_result", String.valueOf(Fund_Gold_result));
        //Log.e("Fund_DebtLiquid_result", String.valueOf(Fund_DebtLiquid_result));
        //Log.e("Fund_CreditOpportunity", String.valueOf(Fund_CreditOpportunity_result));
        //Log.e("Fund_MidCap_result", String.valueOf(Fund_MidCap_result));
        //Log.e("Fund_LargeCap_result", String.valueOf(Fund_LargeCap_result));
        //Log.e("Fund_BondCap_result", String.valueOf(Fund_BondCap_result));
        //Log.e("Fund_MidCap_result", String.valueOf(Fund_MidCap_result));*/
        //  //Log.e("sampleStructure", String.valueOf(sampleStructure));
       /* //Log.e("equityLargeCapIndex", String.valueOf(equityLargeCapIndex));
        //Log.e("resultTemp", String.valueOf(resultTemp));*/
        //Log.e("sampleStructureJson", String.valueOf(sampleStructureJson));
        try{
            investList = new ArrayList<InvestmentList>();
            JSONArray jsonArray = new JSONArray(sampleStructureJson.toString());
            schemeAmount = new String[jsonArray.length()];
            schemeName = new String[jsonArray.length()];
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                InvestmentList invest = new InvestmentList();
                invest.setAmount(Integer.parseInt(jsonObject.getString("Amount")));
                invest.setSchemeName(jsonObject.getString("SchemeName"));
                invest.setBseSchemeCode(jsonObject.getString("BSESchmecode"));
                invest.setIsIn(jsonObject.getString("ISIN"));
                invest.setDueDate("01/March/2017");
                invest.setDateString("");
                invest.setScheme_ID("");
                invest.setInvestmentType("SIP");
                investList.add(invest);
               // Log.e("sampleStructure jsonObject", jsonObject.toString());
                schemeName[i] = jsonObject.getString("SchemeName");
                schemeAmount[i] = jsonObject.getString("Amount");
            }
            SchemeAdapter adapter = new SchemeAdapter(getApplicationContext(),schemeName, schemeAmount);
            schemelist.setAdapter(adapter);
        }
        catch (Exception e){
            Log.e("error",e.toString());
        }
    }

    public class SchemeAdapter extends ArrayAdapter<String> {

        String schemeName[];
        String schemeAmount[];
        Context context;

        public SchemeAdapter(Context context, String[] schemeName, String[] schemeAmount) {
            super(context, -1, schemeName);
            this.schemeAmount = schemeAmount;
            this.schemeName = schemeName;
            this.context = context;
        }

        public View getView(int position,View view,ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.scheme_text, null, true);
            TextView name = (TextView)rowView.findViewById(R.id.schemeName);
            TextView cost = (TextView)rowView.findViewById(R.id.schemeCost);
            name.setText(schemeName[position]);
            cost.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(Double.parseDouble(schemeAmount[position]))));
            return rowView;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 11) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                submit.setVisibility(View.VISIBLE);
                dateText.setText("Date - " + result );
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }

        else if (requestCode == 121) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
               if(result.equals("ok")){
                   if(Utils.isNetworkAvailable(this)){
                       progressDialog.setMessage("please wait...");
                       progressDialog.show();
                       String userName =Utils.getStringPref("email");
                       String password =Utils.getStringPref("pass");
                       apiService.createLogin(userName,password).enqueue(new Callback<LoginResponse>() {
                           @Override
                           public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                               if (((LoginResponse) response.body()).getGetLoginResult().getResult().getIsComplete().equals("0")) {
                                sentData();
                               }
                               else if (((LoginResponse) response.body()).getGetLoginResult().getResult().getIsComplete().equals("1")) {
                                   Toast.makeText(getApplicationContext(),getApplicationContext().getResources().getString(R.string.alert_invest),Toast.LENGTH_LONG).show();
                                   Intent i = new Intent(Child_Result.this,Portfolio.class);
                                   i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                   startActivity(i);
                               }
                           }

                           @Override
                           public void onFailure(Call<LoginResponse> call, Throwable t) {
                               progressDialog.dismiss();
                           }
                       });
                   }
                  // sentData();
               }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }

}