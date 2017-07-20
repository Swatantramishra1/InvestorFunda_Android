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

public class BuyCar extends AppCompatActivity implements View.OnClickListener {

    EditText name;
    EditText amount;
    EditText year;
    // EditText month;
    EditText inflate;
    Button save;
    String goalName;
    int goalAmount;
    int achieveYear;
    int estimateinflate;
    int durationYear;
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
    double calculatedCost;
    double sumCost;
    double goldPerCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_car);
        getWindow().setSoftInputMode(3);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
        }

        name = (EditText) findViewById(R.id.goalName);
        amount = (EditText) findViewById(R.id.goalAmount);
        year = (EditText) findViewById(R.id.year);
        // month = (EditText) findViewById(R.id.month);
        inflate = (EditText) findViewById(R.id.estimatedInflationCar);
        save = (Button) findViewById(R.id.proceedCar);
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
            case R.id.proceedCar:
                if(amount.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter your goal amount",Toast.LENGTH_LONG).show();
                }
                else if(year.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter your goal year",Toast.LENGTH_LONG).show();
                }
                else {
                    sentData();
                }
                break;
        }
    }

    private void sentData() {
        goalName = name.getText().toString();
        goalAmount = Integer.parseInt(amount.getText().toString());
        achieveYear = Integer.parseInt(year.getText().toString());
        // achieveMonth = Integer.parseInt(month.getText().toString());
        estimateinflate = Integer.parseInt(inflate.getText().toString());
        Calendar calendar = Calendar.getInstance();
        int presentYear = calendar.get(Calendar.YEAR);
        if(achieveYear >  presentYear) {
            try {
                durationYear = achieveYear - presentYear;
                calculatedCost = GetFutureValue(goalAmount, durationYear, estimateinflate);
                double mInvst = calculatedCost * 0.12 / ((Math.pow((1 + 0.12), (durationYear)) - 1) * (1 + 0.12));//change inflation rate dynamic
                //mInvst = mInvst * multiplier;
                Log.e("mInvst ", String.valueOf(mInvst));
                mInvst = Math.round(mInvst);
                long Temp1 = (long) (mInvst % 1000);
                long Temp2 = 1000 - Temp1;
                mInvst = mInvst + Temp2;
                //Monthly Investment
                sumCost = Math.round(mInvst / 12);
                if (sumCost < 4000) {
                    sumCost = 4000;
                }
                Log.e("mInvst ", String.valueOf(sumCost));
                JSONObject obj = new CalculatePortfolio().CalculatePortfolioAllocation(durationYear, (int) sumCost, "", "CarPlan","no");
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
                equityPerCost = sumCost * Integer.parseInt(equity) / 100;
                double equtTemp = equityPerCost % 100;
                if (equtTemp != 0) {
                    double equtTemp2 = 100 - equtTemp;
                    equityPerCost = equityPerCost + equtTemp2;
                }
                debtPerCost = sumCost * Integer.parseInt(debts) / 100;
                double debtTemp = debtPerCost % 100;
                if (debtTemp != 0) {
                    double debtTemp2 = 100 - debtTemp;
                    debtPerCost = debtPerCost + debtTemp2;
                }
                goldPerCost = sumCost * Integer.parseInt(gold) / 100;
                double goldTemp = goldPerCost % 100;
                if (goldTemp != 0) {
                    double goldTemp2 = 100 - goldTemp;
                    goldPerCost = goldPerCost + goldTemp2;
                }

                Bundle mBundle = new Bundle();
                mBundle.putString("name",goalName);
                mBundle.putInt("inflate", estimateinflate);
                mBundle.putInt("durationYear", durationYear);
                mBundle.putDouble("goalAmount", (double) goalAmount);
                mBundle.putDouble("sum", sumCost);
                mBundle.putDouble("equity", equityPerCost);
                mBundle.putDouble("debt", debtPerCost);
                mBundle.putInt("calculatedCost",(int) calculatedCost);
                //  Intent i = new Intent(BuyCar.this, Child_Result.class);
                Intent i = new Intent(BuyCar.this, GoalResult.class);
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
                i.putExtra("p_equity", equity);
                i.putExtra("p_debts", debts);
                i.putExtra("p_gold", gold);
                startActivity(i);
            }
            catch (Exception e){
                Log.e("buy car",e.toString());
            }
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
}
