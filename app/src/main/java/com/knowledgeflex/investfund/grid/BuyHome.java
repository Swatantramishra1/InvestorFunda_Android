package com.knowledgeflex.investfund.grid;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.knowledgeflex.investfund.GoalResult;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.utils.CalculatePortfolio;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.Calendar;

public class BuyHome extends AppCompatActivity implements View.OnClickListener {

    EditText plan;
    EditText dream;
    EditText down;
    EditText repay;
    EditText age;
    EditText invest;
    EditText inflate;
    Button save;
    int planYear;
    int currentCost;
    float drownPayment;
    int repayment;
    int currentAge;
    int investAmount;
    int estimateInflate;
    //var presentyear = d.getFullYear();
    int global_houseloanrepaymentperiod = 3;
    int global_houseloanrepaymentdurationVal;
    int global_homeloanrate = 11;
    int GoalRounding = -4;
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
    double totalAmount;
    double HouseLoanAmount;
    double HouseDownPaymentAmount;
    int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_home);
        getWindow().setSoftInputMode(3);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
        }

        plan = (EditText) findViewById(R.id.plan);
        dream = (EditText) findViewById(R.id.currentCost);
        down = (EditText) findViewById(R.id.downPayment);
        repay = (EditText) findViewById(R.id.repaymentPeriod);
        age = (EditText) findViewById(R.id.CurrentAge);
        invest = (EditText) findViewById(R.id.invest);
        inflate = (EditText) findViewById(R.id.estimatedInflationHome);
        save = (Button) findViewById(R.id.proceedHome);
        save.setOnClickListener(this);
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
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.proceedHome:
                    if (plan.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(),"Please enter year which you to wish to buy",Toast.LENGTH_LONG).show();
                    }
                    else if(dream.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"Please enter current cost of the house",Toast.LENGTH_LONG).show();
                    }
                    else if(repay.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"Please enter repayment period",Toast.LENGTH_LONG).show();
                    }
                    else if(age.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"Please enter your age",Toast.LENGTH_LONG).show();
                    }
                    else if (invest.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"Please enter your investment amount",Toast.LENGTH_LONG).show();
                    }else {
                        sentData();
                    }
                break;
        }
    }

    private void sentData() {
        try {
            planYear = Integer.parseInt(plan.getText().toString());
            currentCost = Integer.parseInt(dream.getText().toString());
            drownPayment = Float.parseFloat(down.getText().toString());
            repayment = Integer.parseInt(repay.getText().toString());
            currentAge = Integer.parseInt(age.getText().toString());
            investAmount = Integer.parseInt(invest.getText().toString());
            estimateInflate = Integer.parseInt(inflate.getText().toString());
            double amount = CalculateHouseAmount(planYear, estimateInflate, drownPayment, repayment);
            Log.e("amount", BigDecimal.valueOf(amount).toPlainString());
            if(amount < 4000) {
                amount = 4000;
                //sumCost = amount;
            }
            sumCost = amount;

            JSONObject obj = new CalculatePortfolio().CalculatePortfolioAllocation(year, (int)sumCost, "", "HousePlan","no");
            // Log.e("obj", String.valueOf(obj));
            JSONArray res = obj.getJSONArray("data");
            // Log.e("res", String.valueOf(res));
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
            equityPerCost = amount * Integer.parseInt(equity) / 100;
            double equtTemp = equityPerCost % 100;
            if (equtTemp != 0) {
                double equtTemp2 = 100 - equtTemp;
                equityPerCost = equityPerCost + equtTemp2;
            }
            debtPerCost = amount * Integer.parseInt(debts) / 100;
            double debtTemp = debtPerCost % 100;
            if (debtTemp != 0) {
                double debtTemp2 = 100 - debtTemp;
                debtPerCost = debtPerCost + debtTemp2;
            }
            goldPerCost = amount * Integer.parseInt(gold) / 100;
            double goldTemp = goldPerCost % 100;
            if (goldTemp != 0) {
                double goldTemp2 = 100 - goldTemp;
                goldPerCost = goldPerCost + goldTemp2;
            }
            Bundle mBundle = new Bundle();
            mBundle.putInt("planYear",planYear);
            mBundle.putInt("inflate",estimateInflate);
            mBundle.putInt("currentAge",currentAge);
            mBundle.putInt("year", year);
            mBundle.putInt("calculatedCost", (int) amount);
            mBundle.putDouble("currentCost", (double) currentCost);
            mBundle.putDouble("investAmount", (double) investAmount);
            mBundle.putDouble("loanAmount", HouseLoanAmount);
            mBundle.putDouble("downPaymentAmount", HouseDownPaymentAmount);
            mBundle.putDouble("sum",sumCost);
            mBundle.putDouble("equity",equityPerCost);
            mBundle.putDouble("debt",debtPerCost);
                           /* Intent i = new Intent(BuyHome.this,Child_Result.class);*/
            Intent i = new Intent(BuyHome.this,GoalResult.class);
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
            i.putExtra("p_equity",equity);
            i.putExtra("p_debts", debts);
            i.putExtra("p_gold",gold);
            startActivity(i);
        }
        catch (Exception e){
            Log.e("buy home",e.toString());
        }
    }

    public double GetFutureValue(double PrinAmt, int Years, float Rate) {
        return rounding(Math.round(PrinAmt * Math.pow((1 + Rate / 100), (Years + (float)1 / 365))), -3);   /// changed - prasad. (rounding everything)
    }

    public double rounding(double a, int b) {
        if (b > 0) {
            double d = Math.round(a * Math.pow(10, b)) / Math.pow(10, b);
            Log.e("math a", BigDecimal.valueOf(d).toPlainString());
            return Math.round(a * Math.pow(10, b)) / Math.pow(10, b);
        }
        else {
            double d = Math.round(Math.round(a * Math.pow(10, b)) / Math.pow(10, b));
            Log.e("math b", BigDecimal.valueOf(d).toPlainString());
            return Math.round(Math.round(a * Math.pow(10, b)) / Math.pow(10, b));
        }
    }

    public double GetPrincipalValue(double FutureValue, int Years, int Rate) {
        // return Math.round(FutureValue / Math.pow((1 + Rate / 100), Years));
        return rounding(Math.round(FutureValue / Math.pow((1 + (float) Rate / 100), (Years + (float) 1 / 365))), -3); /// changed - prasad. (rounding everything)
    }

    public double GetEMIAmount(double loanAmount, int Years, int Rate) {
        return (loanAmount * (float) Rate / (12 * 100) * Math.pow((1 + ((float) Rate / (12 * 100))), Years * 12)) / (Math.pow((1 + ((float)Rate / (12 * 100))), 12 * Years) - 1);
    }

    public synchronized double CalculateHouseAmount(int planBoughtYear, int InflationRate, float downPaymentPercentage, int loanPeriodYear) {
        int  houseCost = currentCost;
        global_houseloanrepaymentdurationVal = loanPeriodYear;
        Calendar calendar = Calendar.getInstance();
        int presentYear = calendar.get(Calendar.YEAR);
        if (String.valueOf(planBoughtYear)==null)  {
            planBoughtYear = presentYear + 3;
        }
        year = planBoughtYear - presentYear;
        double HouseFutureValue = GetFutureValue(houseCost, year, InflationRate);///car
        Log.e("HouseFutureValue",BigDecimal.valueOf(HouseFutureValue).toPlainString());
        double HouseDownPayment = HouseFutureValue * ((float)downPaymentPercentage / 100);
        Log.e("HouseDownPayment",BigDecimal.valueOf(HouseDownPayment).toPlainString());
        double HouseAmount = (rounding(GetPrincipalValue(HouseDownPayment, year, InflationRate), GoalRounding));
        Log.e("HouseAmount",BigDecimal.valueOf(HouseAmount).toPlainString());
        HouseDownPaymentAmount = GetFutureValue(HouseAmount, year, InflationRate);
        Log.e("HouseDownPayment2",BigDecimal.valueOf(HouseDownPaymentAmount).toPlainString());
        HouseLoanAmount = HouseFutureValue - HouseDownPaymentAmount;
        double HouseLoanEMIAmount = GetEMIAmount(HouseLoanAmount, global_houseloanrepaymentdurationVal, global_homeloanrate);
        double tempFirstAmount = HouseLoanEMIAmount % 1000;
        double tempSecondAmount = 1000 - tempFirstAmount;
        HouseLoanEMIAmount = HouseLoanEMIAmount + tempSecondAmount;
        double TotalMonthlyInvestment = HouseLoanEMIAmount;
        Log.e("TotalMonthlyInvestment",BigDecimal.valueOf(TotalMonthlyInvestment).toPlainString());
        return TotalMonthlyInvestment;
    }
}
