package com.knowledgeflex.investfund;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.knowledgeflex.investfund.Model.CreateUserPlan;
import com.knowledgeflex.investfund.grid.BuyCar;
import com.knowledgeflex.investfund.grid.BuyHome;
import com.knowledgeflex.investfund.grid.Child_E;
import com.knowledgeflex.investfund.grid.Child_Marriage;
import com.knowledgeflex.investfund.grid.Retirement;
import com.knowledgeflex.investfund.grid.Tour;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class GoalResult extends AppCompatActivity {

    TextView difference;
    RelativeLayout retirement;
    RelativeLayout education;
    RelativeLayout house;
    RelativeLayout car;
    RelativeLayout marriage;
    RelativeLayout tour;
    TextView titleText;
    TextView c_age;
    TextView r_age;
    TextView e_rate;
    TextView expenses;
    TextView c_fee;
    TextView e_lump;
    TextView ed_rate;
    TextView c_cost;
    TextView h_loan;
    TextView h_emi;
    TextView h_rate;
    TextView c_year;
    TextView c_month;
    TextView car_rate;
    TextView c_goalAmount;
    TextView m_budget;
    TextView m_year;
    TextView m_goalYear;
    TextView m_rate;
    TextView t_budget;
    TextView t_year;
    TextView t_monthly;
    TextView t_rate;
    Button help;
    int year;
    int c_equity;
    int c_debt;
    int c_gold;
    String page;
    String screenName;
    int calculatedCost;
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
    double loanAmount;
    double downPaymentAmount;
    double budgetCost;
    double budgetAmount;
    double goalAmount;
    double investsumCost;
    int marriage_age;
    int sub;
    int retirement_age;
    private int estimated_percentage;
    double totalAmount;
    double totalLivingCost;
    double totalCourseFee;
    ProgressDialog progressDialog;
    String goalData;
    TextView circleAmount;
    Context context;
    CustomerDatePickerDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_result);
        getWindow().setSoftInputMode(3);
        this.context = getApplicationContext();
        page = getIntent().getStringExtra("page");
        screenName = getIntent().getStringExtra("calculate");
        goldPerCost  = getIntent().getDoubleExtra("gold",0);
        goalData = getIntent().getStringExtra("goalData");
        fundLargeCap = Integer.parseInt(getIntent().getStringExtra("fundLargeCap"));
        fundMultiCap = Integer.parseInt(getIntent().getStringExtra("fundMultiCap"));
        fundBondFunds = Integer.parseInt(getIntent().getStringExtra("fundBondFunds"));
        fundMidCap = Integer.parseInt(getIntent().getStringExtra("fundMidCap"));
        fundGold = Integer.parseInt(getIntent().getStringExtra("fundGold"));
        fundLiquidCap = Integer.parseInt(getIntent().getStringExtra("fundLiquidCap"));
        fundUltraSortFund = Integer.parseInt(getIntent().getStringExtra("fundUltraSortFund"));
        fundCreditOpportunity = Integer.parseInt(getIntent().getStringExtra("fundCreditOpportunity"));
        fundBalanced = Integer.parseInt(getIntent().getStringExtra("fundBalanced"));
        fundGlit = Integer.parseInt(getIntent().getStringExtra("fundGlit"));
        c_equity = Integer.parseInt(getIntent().getStringExtra("p_equity"));
        c_debt = Integer.parseInt(getIntent().getStringExtra("p_debts"));
        c_gold = Integer.parseInt(getIntent().getStringExtra("p_gold"));

        //education
        c_fee = (TextView) findViewById(R.id.courseFee);
        e_lump = (TextView) findViewById(R.id.e_lumpSum);
        ed_rate = (TextView) findViewById(R.id.ed_Rate);
        retirement = (RelativeLayout) findViewById(R.id.retirementLayout);

        //retirement
        c_age = (TextView) findViewById(R.id.cAge);
        r_age = (TextView) findViewById(R.id.rAge);
        e_rate = (TextView) findViewById(R.id.eRate);
        expenses = (TextView) findViewById(R.id.expanses);
        education = (RelativeLayout) findViewById(R.id.educationLayout);

        //house
        c_cost = (TextView) findViewById(R.id.c_cost);
        h_loan = (TextView) findViewById(R.id.loan);
        h_emi = (TextView) findViewById(R.id.emi);
        h_rate = (TextView) findViewById(R.id.hRate);
        house = (RelativeLayout) findViewById(R.id.houseLayout);

        //car
        c_year = (TextView) findViewById(R.id.c_year);
        c_month = (TextView) findViewById(R.id.month);
        car_rate = (TextView) findViewById(R.id.carRate);
        c_goalAmount = (TextView) findViewById(R.id.gAmount);
        car = (RelativeLayout) findViewById(R.id.carLayout);

        //marriage
        m_budget = (TextView) findViewById(R.id.mBudget);
        m_year = (TextView) findViewById(R.id.yearWed);
        m_goalYear = (TextView) findViewById(R.id.gYear);
        m_rate = (TextView) findViewById(R.id.marriageRate);
        marriage = (RelativeLayout) findViewById(R.id.marriageLayout);

        //tour
        t_budget = (TextView) findViewById(R.id.tBudget);
        t_year = (TextView) findViewById(R.id.yearTour);
        t_monthly = (TextView) findViewById(R.id.monthlyAmount);
        t_rate = (TextView) findViewById(R.id.tourRate);
        tour = (RelativeLayout) findViewById(R.id.tourLayout);

        circleAmount = (TextView) findViewById(R.id.circleAmount);
        titleText = (TextView) findViewById(R.id.titleText);
        difference = (TextView) findViewById(R.id.differenceText);
        help = (Button) findViewById(R.id.help);

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

                //child education
                c_fee.setText(String.valueOf(totalCourseFee));
                e_lump.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(saved)));
                ed_rate.setText(String.valueOf(inflation));
                titleText.setText("Your child needs best education and best education needs the best planning");
                difference.setText("Estimated Cost Of Your Goal After"+" "+ sub +" "+"Years");
                circleAmount.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(calculatedCost)));
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    getSupportActionBar().setDisplayShowHomeEnabled(true);
                    getSupportActionBar().setTitle("CHILD'S EDUCATION PLAN");
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
                }

                education.setVisibility(View.VISIBLE);
                retirement.setVisibility(View.GONE);
                house.setVisibility(View.GONE);
                car.setVisibility(View.GONE);
                marriage.setVisibility(View.GONE);
                tour.setVisibility(View.GONE);
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

                c_age.setText(String.valueOf(current_age));
                r_age.setText(String.valueOf(retirement_age));
                e_rate.setText(String.valueOf(inflation));
                expenses.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(monthly_expenses)));
                titleText.setText("Gift yourself the best retirement");
                difference.setText("Estimated Cost Of Your Goal After"+" "+ sub +" "+"Years");
                circleAmount.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(calculatedCost)));
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    getSupportActionBar().setDisplayShowHomeEnabled(true);
                    getSupportActionBar().setTitle("RETIREMENT");
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
                }

                education.setVisibility(View.GONE);
                retirement.setVisibility(View.VISIBLE);
                house.setVisibility(View.GONE);
                car.setVisibility(View.GONE);
                marriage.setVisibility(View.GONE);
                tour.setVisibility(View.GONE);
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
                loanAmount = getIntent().getDoubleExtra("loanAmount", 0);
                downPaymentAmount = getIntent().getDoubleExtra("downPaymentAmount", 0);
                sub = year-current_age;
                c_cost.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(currentCost)));
                h_loan.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(loanAmount)));
                h_emi.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(sumCost)));
                h_rate.setText(String.valueOf(inflation));
                circleAmount.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(downPaymentAmount)));
                titleText.setText("Lets plan for your home together");
                difference.setText("Your Estimated down payment for your house is");
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    getSupportActionBar().setDisplayShowHomeEnabled(true);
                    getSupportActionBar().setTitle("BUY A HOUSE");
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
                }
                education.setVisibility(View.GONE);
                retirement.setVisibility(View.GONE);
                house.setVisibility(View.VISIBLE);
                car.setVisibility(View.GONE);
                marriage.setVisibility(View.GONE);
                tour.setVisibility(View.GONE);
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
                c_year.setText(String.valueOf(durationYear));
                c_month.setVisibility(View.GONE);
                car_rate.setText(String.valueOf(inflation));
                c_goalAmount.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(goalAmount)));
                circleAmount.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(calculatedCost)));
                titleText.setText("Buy your own car");
                difference.setText("Estimated Cost Of Your Goal After"+" "+ sub +" "+"Years");
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    getSupportActionBar().setDisplayShowHomeEnabled(true);
                    getSupportActionBar().setTitle("BUY A CAR");
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
                }

                education.setVisibility(View.GONE);
                retirement.setVisibility(View.GONE);
                house.setVisibility(View.GONE);
                car.setVisibility(View.VISIBLE);
                marriage.setVisibility(View.GONE);
                tour.setVisibility(View.GONE);
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

                //marriage
                m_budget.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(budgetCost)));
                m_year.setText(String.valueOf(marriage_age));
                m_goalYear.setText(String.valueOf(2017 + year));
                m_rate.setText(String.valueOf(inflation));
                circleAmount.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(calculatedCost)));
                titleText.setText("Make sure you have everything prepared for her big day");
                difference.setText("Estimated Cost Of Your Goal After"+" "+ sub +" "+"Years");
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    getSupportActionBar().setDisplayShowHomeEnabled(true);
                    getSupportActionBar().setTitle("CHILD'S MARRIAGE PLAN");
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
                }

                education.setVisibility(View.GONE);
                retirement.setVisibility(View.GONE);
                house.setVisibility(View.GONE);
                car.setVisibility(View.GONE);
                marriage.setVisibility(View.VISIBLE);
                tour.setVisibility(View.GONE);
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
                calculatedCost = getIntent().getIntExtra("calculatedCost", 0);
                sub = durationYear-0;
                //tour
                t_budget.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(budgetAmount)));
                t_year.setText(String.valueOf(planYear));
                t_monthly.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(sumCost)));
                t_rate.setText(String.valueOf(inflation));
                circleAmount.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(calculatedCost)));
                titleText.setText("Plan your dream tour");
                difference.setText("Estimated Cost Of Your Goal After"+" "+ sub +" "+"Years");
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    getSupportActionBar().setDisplayShowHomeEnabled(true);
                    getSupportActionBar().setTitle("VACATION PLAN");
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
                }
                education.setVisibility(View.GONE);
                retirement.setVisibility(View.GONE);
                house.setVisibility(View.GONE);
                car.setVisibility(View.GONE);
                marriage.setVisibility(View.GONE);
                tour.setVisibility(View.VISIBLE);
            }
        }
        else if(page.equals("8")){
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                sumCost = getIntent().getDoubleExtra("sum", 0);
                equityPerCost = getIntent().getDoubleExtra("equity", 0);
                debtPerCost = getIntent().getDoubleExtra("debt", 0);
                sub = 1;
            }
        }
        else if(page.equals("9")){
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                sumCost = getIntent().getDoubleExtra("sum", 0);
                equityPerCost = getIntent().getDoubleExtra("equity", 0);
                debtPerCost = getIntent().getDoubleExtra("debt", 0);
                sub = getIntent().getIntExtra("durationYear",0);
            }
        }

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(page.equals("1")){
                    Bundle mBundle = new Bundle();
                    mBundle.putString("name",name);
                    mBundle.putInt("inflate",inflation);
                    mBundle.putInt("age",current_age);
                    mBundle.putInt("edu_age",higher_edu_age);
                    mBundle.putInt("duration",duration);
                    mBundle.putDouble("cost",current_cost_edu);
                    mBundle.putDouble("living_cost",living_cost);
                    mBundle.putInt("calculatedCost", calculatedCost);
                    mBundle.putDouble("sum",sumCost);
                    mBundle.putDouble("equity",equityPerCost);
                    mBundle.putDouble("debt",debtPerCost);
                    mBundle.putInt("save",saved);
                    mBundle.putDouble("total",totalCourseFee);
                    mBundle.putDouble("totalLiving",totalLivingCost);
                           /* Intent i = new Intent(Child_E.this,Child_Result.class);*/
                    Intent i = new Intent(GoalResult.this,Child_Result.class);
                    i.putExtra("page","1");
                    i.putExtras(mBundle);
                    i.putExtra("calculate", "ChildGoal");
                    i.putExtra("gold",goldPerCost);
                    i.putExtra("goalData",goalData);
                    i.putExtra("fundLargeCap", fundLargeCap);
                    i.putExtra("fundMultiCap", fundMultiCap);
                    i.putExtra("fundBondFunds", fundBondFunds);
                    i.putExtra("fundMidCap", fundMidCap);
                    i.putExtra("fundGold", fundGold);
                    i.putExtra("fundLiquidCap", fundLiquidCap);
                    i.putExtra("fundUltraSortFund", fundUltraSortFund);
                    i.putExtra("fundCreditOpportunity", fundCreditOpportunity);
                    i.putExtra("fundBalanced", fundBalanced);
                    i.putExtra("fundGlit", fundGlit);
                    i.putExtra("p_equity",equityPerCost);
                    i.putExtra("p_debts", debtPerCost);
                    i.putExtra("p_gold",goldPerCost);
                    startActivity(i);

                }
                else if(page.equals("2")){
                    Bundle mBundle = new Bundle();
                    mBundle.putString("name",name);
                    mBundle.putInt("inflate", inflation);
                    mBundle.putInt("current_age",current_age);
                    mBundle.putInt("estimated",estimated_percentage);
                    mBundle.putInt("retirement_age", retirement_age);
                    mBundle.putInt("calculatedCost", calculatedCost);
                    mBundle.putDouble("annual_invest", annual_invest);
                    mBundle.putDouble("monthly_expenses", monthly_expenses);
                    mBundle.putDouble("sum",sumCost);
                    mBundle.putDouble("equity",equityPerCost);
                    mBundle.putDouble("debt",debtPerCost);
                        /*Intent i = new Intent(Retirement.this,Child_Result.class);*/
                    Intent i = new Intent(GoalResult.this,Child_Result.class);
                    i.putExtra("page","2");
                    i.putExtras(mBundle);
                    i.putExtra("calculate", "Retirement");
                    i.putExtra("gold",goldPerCost);
                    i.putExtra("goalData",goalData);
                    i.putExtra("fundLargeCap", fundLargeCap);
                    i.putExtra("fundMultiCap", fundMultiCap);
                    i.putExtra("fundBondFunds", fundBondFunds);
                    i.putExtra("fundMidCap", fundMidCap);
                    i.putExtra("fundGold", fundGold);
                    i.putExtra("fundLiquidCap", fundLiquidCap);
                    i.putExtra("fundUltraSortFund", fundUltraSortFund);
                    i.putExtra("fundCreditOpportunity",fundCreditOpportunity);
                    i.putExtra("fundBalanced", fundBalanced);
                    i.putExtra("fundGlit", fundGlit);
                    i.putExtra("p_equity",equityPerCost);
                    i.putExtra("p_debts", debtPerCost);
                    i.putExtra("p_gold",goldPerCost);
                    startActivity(i);
                }
                else if(page.equals("3")){
                    Bundle mBundle = new Bundle();
                    mBundle.putInt("planYear",planYear);
                    mBundle.putInt("inflate", inflation);
                    mBundle.putInt("currentAge",current_age);
                    mBundle.putInt("year", year);
                    mBundle.putInt("calculatedCost", calculatedCost);
                    mBundle.putDouble("currentCost", currentCost);
                    mBundle.putDouble("investAmount", investAmount);
                    mBundle.putDouble("loanAmount", loanAmount);
                    mBundle.putDouble("downPaymentAmount", downPaymentAmount);
                    mBundle.putDouble("sum",sumCost);
                    mBundle.putDouble("equity",equityPerCost);
                    mBundle.putDouble("debt",debtPerCost);
                       /* Intent i = new Intent(BuyHome.this,Child_Result.class);*/
                    Intent i = new Intent(GoalResult.this,Child_Result.class);
                    i.putExtra("page","3");
                    i.putExtras(mBundle);
                    i.putExtra("calculate", "HousePlan");
                    i.putExtra("gold",goldPerCost);
                    i.putExtra("goalData",goalData);
                    i.putExtra("fundLargeCap", fundLargeCap);
                    i.putExtra("fundMultiCap", fundMultiCap);
                    i.putExtra("fundBondFunds", fundBondFunds);
                    i.putExtra("fundMidCap", fundMidCap);
                    i.putExtra("fundGold", fundGold);
                    i.putExtra("fundLiquidCap", fundLiquidCap);
                    i.putExtra("fundUltraSortFund", fundUltraSortFund);
                    i.putExtra("fundCreditOpportunity",fundCreditOpportunity);
                    i.putExtra("fundBalanced", fundBalanced);
                    i.putExtra("fundGlit", fundGlit);
                    i.putExtra("p_equity",equityPerCost);
                    i.putExtra("p_debts", debtPerCost);
                    i.putExtra("p_gold",goldPerCost);
                    startActivity(i);

                }
                else if(page.equals("4")){
                    Bundle mBundle = new Bundle();
                    mBundle.putString("name",name);
                    mBundle.putInt("inflate", inflation);
                    mBundle.putInt("durationYear", durationYear);
                    mBundle.putDouble("goalAmount", goalAmount);
                    mBundle.putDouble("sum", sumCost);
                    mBundle.putDouble("equity", equityPerCost);
                    mBundle.putDouble("debt", debtPerCost);
                    mBundle.putInt("calculatedCost",calculatedCost);
                    //  Intent i = new Intent(BuyCar.this, Child_Result.class);
                    Intent i = new Intent(GoalResult.this, Child_Result.class);
                    i.putExtra("page","4");
                    i.putExtras(mBundle);
                    i.putExtra("calculate", "CarPlan");
                    i.putExtra("gold", goldPerCost);
                    i.putExtra("goalData", goalData);
                    i.putExtra("fundLargeCap", fundLargeCap);
                    i.putExtra("fundMultiCap", fundMultiCap);
                    i.putExtra("fundBondFunds", fundBondFunds);
                    i.putExtra("fundMidCap", fundMidCap);
                    i.putExtra("fundGold", fundGold);
                    i.putExtra("fundLiquidCap", fundLiquidCap);
                    i.putExtra("fundUltraSortFund", fundUltraSortFund);
                    i.putExtra("fundCreditOpportunity", fundCreditOpportunity);
                    i.putExtra("fundCreditOpportunity",fundCreditOpportunity);
                    i.putExtra("fundBalanced", fundBalanced);
                    i.putExtra("fundGlit", fundGlit);
                    i.putExtra("p_equity", equityPerCost);
                    i.putExtra("p_debts", debtPerCost);
                    i.putExtra("p_gold", goldPerCost);
                    startActivity(i);
                }
                else if(page.equals("5")){
                    Bundle mBundle = new Bundle();
                    mBundle.putInt("marriage_age",marriage_age);
                    mBundle.putInt("inflate", inflation);
                    mBundle.putInt("your_age", current_age);
                    mBundle.putInt("year", year);
                    mBundle.putDouble("budgetCost", budgetCost);
                    mBundle.putDouble("investsumCost",investsumCost);
                    mBundle.putInt("calculatedCost", calculatedCost);
                    mBundle.putDouble("sum", sumCost);
                    mBundle.putDouble("equity", equityPerCost);
                    mBundle.putDouble("debt", debtPerCost);
            /*Intent i = new Intent(Child_Marriage.this, Child_Result.class);*/
                    Intent i = new Intent(GoalResult.this, Child_Result.class);
                    i.putExtra("page","5");
                    i.putExtras(mBundle);
                    i.putExtra("calculate", "ChildMarriage");
                    i.putExtra("gold", goldPerCost);
                    i.putExtra("goalData", goalData);
                    i.putExtra("fundLargeCap", fundLargeCap);
                    i.putExtra("fundMultiCap", fundMultiCap);
                    i.putExtra("fundBondFunds", fundBondFunds);
                    i.putExtra("fundMidCap", fundMidCap);
                    i.putExtra("fundGold", fundGold);
                    i.putExtra("fundLiquidCap", fundLiquidCap);
                    i.putExtra("fundUltraSortFund", fundUltraSortFund);
                    i.putExtra("fundCreditOpportunity", fundCreditOpportunity);
                    i.putExtra("fundBalanced", fundBalanced);
                    i.putExtra("fundGlit", fundGlit);
                    i.putExtra("p_equity", equityPerCost);
                    i.putExtra("p_debts", debtPerCost);
                    i.putExtra("p_gold", goldPerCost);
                    startActivity(i);
                }
                else if(page.equals("7")){
                    Bundle mBundle = new Bundle();
                    mBundle.putString("name", name);
                    mBundle.putInt("inflate", inflation);
                    mBundle.putInt("durationYear", durationYear);
                    mBundle.putInt("planYear", planYear);
                    mBundle.putInt("current_age",current_age);
                    mBundle.putDouble("budgetAmount", budgetAmount);
                    mBundle.putDouble("calculatedCost",calculatedCost);
                    mBundle.putDouble("sum", sumCost);
                    mBundle.putDouble("equity", equityPerCost);
                    mBundle.putDouble("debt", debtPerCost);
                            /*Intent i = new Intent(Tour.this, Child_Result.class);*/
                    Intent i = new Intent(GoalResult.this, Child_Result.class);
                    i.putExtra("page","7");
                    i.putExtras(mBundle);
                    i.putExtra("calculate", "CarPlan");
                    i.putExtra("gold", goldPerCost);
                    i.putExtra("goalData", goalData);
                    i.putExtra("fundLargeCap", fundLargeCap);
                    i.putExtra("fundMultiCap", fundMultiCap);
                    i.putExtra("fundBondFunds", fundBondFunds);
                    i.putExtra("fundMidCap", fundMidCap);
                    i.putExtra("fundGold", fundGold);
                    i.putExtra("fundLiquidCap", fundLiquidCap);
                    i.putExtra("fundUltraSortFund", fundUltraSortFund);
                    i.putExtra("fundCreditOpportunity", fundCreditOpportunity);
                    i.putExtra("fundBalanced", fundBalanced);
                    i.putExtra("fundGlit", fundGlit);
                    i.putExtra("p_equity", equityPerCost);
                    i.putExtra("p_debts", debtPerCost);
                    i.putExtra("p_gold", goldPerCost);
                    startActivity(i);
                }
            }
        });
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

    class CustomerDatePickerDialog extends DatePickerDialog {
        public CustomerDatePickerDialog(Context context, OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth) {
            super(context, callBack, year, monthOfYear, dayOfMonth);
        }

        @Override
        public void onDateChanged(DatePicker view, int year, int month, int day) {
            super.onDateChanged(view, year, month, day);
            //mDialog.setTitle((month + 1) + "-" + day + "-");
            Log.e("Date value",(month + 1) + "-" + day + "-");
        }
    }

    private DatePicker findDatePicker(ViewGroup group) {
        if (group != null) {
            for (int i = 0, j = group.getChildCount(); i < j; i++) {
                View child = group.getChildAt(i);
                if (child instanceof DatePicker) {
                    return (DatePicker) child;
                } else if (child instanceof ViewGroup) {
                    DatePicker result = findDatePicker((ViewGroup) child);
                    if (result != null)
                        return result;
                }
            }
        }
        return null;

    }

    @Override
    public void onBackPressed() {
        ///super.onBackPressed();
        finish();
    }
}
