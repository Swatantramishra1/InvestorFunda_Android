package com.knowledgeflex.investfund.grid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.knowledgeflex.investfund.BuildConfig;
import com.knowledgeflex.investfund.Child_E2;
import com.knowledgeflex.investfund.Child_Result;
import com.knowledgeflex.investfund.GoalResult;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.Retirement_Result;
import com.knowledgeflex.investfund.utils.CalculatePortfolio;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;

import java.text.DecimalFormat;

public class Retirement extends AppCompatActivity {

    float life_expectancy;
    EditText m_current_age;
    EditText m_current_monthly_exp;
    EditText m_annual_invest;
    EditText m_after_percentage;
    EditText m_retirement_age;
    EditText name;
    EditText m_estimated_annual_inflate;
    int annual_invest;
    int monthly_expenses;
    int after_percentage;
    int estimated_percentage;
    int retirement_age;
    int current_age;
    String goalName;
    float riskfreevalue;
    Button submit;
    private String equity;
    private String debts;
    private String gold;
    private String goalData;
    private String fundLargeCap;
    private String fundMultiCap;
    private String fundBondFunds;
    private String fundMidCap;
    private String fundGold;
    private String fundLiquidCap;
    private String fundUltraSortFund;
    private String fundCreditOpportunity;
    private String fundBalanced;
    private String fundGlit;
    double equityPerCost;
    double debtPerCost;
    double sumCost;
    double goldPerCost;
    int year;
    String calculatedCost;

    public Retirement() {
        this.riskfreevalue = 10.0f;
        this.life_expectancy = 80.0f;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retirement);
        getWindow().setSoftInputMode(3);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
        }
        name = (EditText) findViewById(R.id.name);
        m_current_age = (EditText) findViewById(R.id.currentAge);
        m_retirement_age = (EditText) findViewById(R.id.retirementAge);
        m_after_percentage = (EditText) findViewById(R.id.afterRetire);
        m_estimated_annual_inflate = (EditText) findViewById(R.id.estimatedInflation);
        m_annual_invest = (EditText) findViewById(R.id.investAmount);
        m_current_monthly_exp = (EditText) findViewById(R.id.expenditure);
        submit = (Button) findViewById(R.id.proceed);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(!m_current_age.getText().toString().equals("") && !m_retirement_age.getText().toString().equals("")){
                        if(!m_annual_invest.getText().toString().equals("") && !m_current_monthly_exp.getText().toString().equals("")&&!m_after_percentage.getText().toString().equals("")){
                            goalName = name.getText().toString();
                            annual_invest = Integer.parseInt(m_annual_invest.getText().toString());
                            monthly_expenses = Integer.parseInt(m_current_monthly_exp.getText().toString());
                            after_percentage = Integer.parseInt(m_after_percentage.getText().toString());
                            estimated_percentage = Integer.parseInt(m_estimated_annual_inflate.getText().toString());
                            retirement_age = Integer.parseInt(m_retirement_age.getText().toString());
                            current_age = Integer.parseInt(m_current_age.getText().toString());
                            sentData();
                        }
                        else {
                            Toast.makeText(getApplicationContext()," Please fill monthly expanses, investment amount and after retirement percentage",Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext()," Please fill current and retirement age",Toast.LENGTH_LONG).show();
                    }
                }
        });


        // this.ll_c = (LinearLayout) findViewById(R.id.ll_c);
        //  this.ll_c.setOnClickListener(new C02822());
    }

    private synchronized void sentData() {
        try {
            year = retirement_age - current_age;
            //  Log.e("monthly_expenses", String.valueOf(monthly_expenses));
            //  Log.e("estimated_percentage", String.valueOf(estimated_percentage));
            calculatedCost = calculateRetirementAmount(monthly_expenses, estimated_percentage, retirement_age, current_age, after_percentage);
            //   Log.e("amount", calculatedCost);
            int mInvst = annual_invest / 12;
            if (mInvst < 4000) {
                mInvst = 4000;
            }
            Log.e("mInvst", String.valueOf(mInvst));
            sumCost = mInvst;
            JSONObject obj = new CalculatePortfolio().CalculatePortfolioAllocation(year, mInvst, "", "Retirement", "no");
            // Log.e("obj", String.valueOf(obj));
            JSONArray res = obj.getJSONArray("data");
            //  Log.e("res", String.valueOf(res));
            goalData = obj.toString();
            for (int i = 0; i < res.length(); i++) {
                JSONObject jsonobject = res.getJSONObject(i);
                equity = jsonobject.getString("Return_EquityPer");
                gold = jsonobject.getString("Returm_GoldPer");
                debts = jsonobject.getString("Returm_DebtPer");
                JSONArray jsonArray = jsonobject.getJSONArray("Fund");
                for (int j = 0; j < jsonArray.length(); j++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    fundLargeCap = object.getString("Fund_LargeCap");
                    fundMultiCap = object.getString("Fund_MultiCap");
                    fundBondFunds = object.getString("Fund_BondFunds");
                    fundMidCap = object.getString("Fund_MidCap");
                    fundGold = object.getString("Fund_Gold");
                    fundLiquidCap = object.getString("Fund_LiquidCap");
                    fundUltraSortFund = object.getString("Fund_UltraSortFund");
                    fundCreditOpportunity = object.getString("Fund_CreditOpportunity");
                    fundGlit = object.getString("Fund_GILT");
                    fundBalanced = object.getString("Fund_Balanced");
                }
            }
            equityPerCost = mInvst * Integer.parseInt(equity) / 100;
            double equtTemp = equityPerCost % 100;
            if (equtTemp != 0) {
                double equtTemp2 = 100 - equtTemp;
                equityPerCost = equityPerCost + equtTemp2;
            }
            debtPerCost = mInvst * Integer.parseInt(debts) / 100;
            double debtTemp = debtPerCost % 100;
            if (debtTemp != 0) {
                double debtTemp2 = 100 - debtTemp;
                debtPerCost = debtPerCost + debtTemp2;
            }
            goldPerCost = mInvst * Integer.parseInt(gold) / 100;
            double goldTemp = goldPerCost % 100;
            if (goldTemp != 0) {
                double goldTemp2 = 100 - goldTemp;
                goldPerCost = goldPerCost + goldTemp2;
            }

            Bundle mBundle = new Bundle();
            mBundle.putString("name", goalName);
            mBundle.putInt("inflate", after_percentage);
            mBundle.putInt("current_age", current_age);
            mBundle.putInt("estimated", estimated_percentage);
            mBundle.putInt("retirement_age", retirement_age);
            mBundle.putInt("calculatedCost", Integer.parseInt(calculatedCost));
            mBundle.putDouble("annual_invest", (double) (annual_invest * 1000));
            mBundle.putDouble("monthly_expenses", (double) monthly_expenses);
            mBundle.putDouble("sum", sumCost);
            mBundle.putDouble("equity", equityPerCost);
            mBundle.putDouble("debt", debtPerCost);
                        /*Intent i = new Intent(Retirement.this,Child_Result.class);*/
            Intent i = new Intent(Retirement.this, GoalResult.class);
            i.putExtra("page", "2");
            i.putExtras(mBundle);
            i.putExtra("calculate", "Retirement");
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
            i.putExtra("p_equity", equity);
            i.putExtra("p_debts", debts);
            i.putExtra("p_gold", gold);
            startActivity(i);
        }
        catch (Exception e){
            Log.e("error retrie",e.toString());
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

    public String calculateRetirementAmount(int monthly_expenses, int estimated_percentage, int retirement_age, int current_age, int after_percentage) {
        int investedTillYear = retirement_age - current_age;
        double amt = RequiredRetirementAmount(monthly_expenses, after_percentage, retirement_age, current_age, estimated_percentage);
        double goalamt = rounding(GetPrincipalValue(amt, investedTillYear, estimated_percentage), -4);
        double RetirementInflatedAmount = GetFutureValue(goalamt, investedTillYear, estimated_percentage);
        return BigDecimal.valueOf(RetirementInflatedAmount).toPlainString();
    }

    public double  RequiredRetirementAmount(double curamt, int after_percentage, int retirement_age, int current_age, int estimated_percentage) {
        int riskfreerate = 10;
        int lifeExpectancyValue = 80;
        double amt = curamt * 12 * (1 + (float)after_percentage / 100);
        int YearsToRetire = retirement_age - current_age;
        double infval = (1 + (float) estimated_percentage/100);
        double inflat = Double.parseDouble(new DecimalFormat("##.##").format(infval));
        double rfrval = (1 + (float) riskfreerate/100);
        double rinflat = Double.parseDouble(new DecimalFormat("##.##").format(rfrval));
        amt = Math.round(amt) * Math.pow(inflat, YearsToRetire);
        long amtround = Math.round(amt);
        if (infval != rfrval) {
            amt = amtround * ((1 - Math.pow(infval / rfrval, (lifeExpectancyValue - retirement_age))) / (1 - (infval / rfrval)));
        }
        else {
            amt = amt * (lifeExpectancyValue - retirement_age);
        }
        return amt;
    }

    public double GetFutureValue(double PrinAmt, int Years, float Rate) {
        return rounding(Math.round(PrinAmt * Math.pow((1 + Rate / 100), (Years + (float)1 / 365))), -3);   /// changed - prasad. (rounding everything)
    }

    public double rounding(double a, int b) {
        if (b > 0) {
            double d = Math.round(a * Math.pow(10, b)) / Math.pow(10, b);
            return Math.round(a * Math.pow(10, b)) / Math.pow(10, b);
        }
        else {
            double d = Math.round(Math.round(a * Math.pow(10, b)) / Math.pow(10, b));
            return Math.round(Math.round(a * Math.pow(10, b)) / Math.pow(10, b));
        }
    }

    public double GetPrincipalValue(double FutureValue, int Years, int Rate) {
        // return Math.round(FutureValue / Math.pow((1 + Rate / 100), Years));
        return rounding(Math.round(FutureValue / Math.pow((1 + (float) Rate / 100), (Years + (float) 1 / 365))), -3); /// changed - prasad. (rounding everything)
    }
}
