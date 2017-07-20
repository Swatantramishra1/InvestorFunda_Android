package com.knowledgeflex.investfund.grid;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Base64;
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
import java.net.HttpURLConnection;
import java.util.Calendar;

public class Child_Marriage extends AppCompatActivity implements View.OnClickListener {

    EditText childAge;
   // EditText yourAge;
    EditText whatAge;
    EditText budget;
    EditText invest;
    EditText inflate;
    Button save;
    int child_age;
   // int your_age;
    int marriage_age;
    int budgetCost;
    int investsumCost;
    int estimateInflate;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(3);
        setContentView(R.layout.activity_child__marriage);
        getWindow().setSoftInputMode(3);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
        }

        childAge = (EditText) findViewById(R.id.childAge);
        //yourAge = (EditText) findViewById(R.id.yourAge);
        whatAge = (EditText) findViewById(R.id.planing);
        budget= (EditText) findViewById(R.id.budget);
        invest = (EditText) findViewById(R.id.investRight);
        inflate = (EditText) findViewById(R.id.estimatedInflation);
        save = (Button) findViewById(R.id.proceedMrg);
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
            case R.id.proceedMrg:
                if(!childAge.getText().toString().equals("")&&!whatAge.getText().toString().equals("")&&!budget.getText().toString().equals("")&&!invest.getText().toString().equals("")&& !inflate.getText().toString().equals("")) {
                    child_age = Integer.parseInt(childAge.getText().toString());
                    //your_age = Integer.parseInt(yourAge.getText().toString());
                    marriage_age = Integer.parseInt(whatAge.getText().toString());
                    budgetCost = Integer.parseInt(budget.getText().toString());
                    investsumCost = Integer.parseInt(invest.getText().toString());
                    estimateInflate = Integer.parseInt(inflate.getText().toString());
                    calculateMarriagesumCost();
                }
                else {
                    Toast.makeText(getApplicationContext()," Please fill child's current age, marriage age, budget and investment amount",Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    private synchronized void calculateMarriagesumCost() {
        try {
            year = marriage_age - child_age;
            int rog = 12;
            Calendar calendar = Calendar.getInstance();
            int presentYear = calendar.get(Calendar.YEAR);
            double MarriageInflatedsumCost = GetFutureValue(budgetCost * 100000, year, estimateInflate);
            //Log.e("MarriageInflatedsumCost ", String.valueOf(MarriageInflatedsumCost));
            double mInvst = MarriageInflatedsumCost * (float) rog / 100 / ((Math.pow((1 + (float) rog / 100), (year)) - 1) * (1 + (float) rog / 100));
            Log.e("mInvst ", String.valueOf(mInvst));
            mInvst = Math.round(mInvst / 12);
            double Temp11 = (float) mInvst % 1000;
            double Temp21 = 1000 - Temp11;
            mInvst = mInvst + Temp21;
            if (mInvst >= 4000) {
                sumCost = mInvst;
            } else {
                sumCost = 4000;
            }
            Log.e("sumCost", String.valueOf(sumCost));
            JSONObject obj = new CalculatePortfolio().CalculatePortfolioAllocation(year, (int) sumCost, "", "ChildMarriage","no");
            JSONArray res = obj.getJSONArray("data");
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
            mBundle.putInt("marriage_age",marriage_age);
            mBundle.putInt("inflate", estimateInflate);
            mBundle.putInt("your_age", 0);
            mBundle.putInt("year", year);
            mBundle.putDouble("budgetCost", (double) budgetCost * 100000);
            mBundle.putDouble("investsumCost", (double) investsumCost);
            mBundle.putInt("calculatedCost", (int) MarriageInflatedsumCost);
            mBundle.putDouble("sum", sumCost);
            mBundle.putDouble("equity", equityPerCost);
            mBundle.putDouble("debt", debtPerCost);
            /*Intent i = new Intent(Child_Marriage.this, Child_Result.class);*/
            Intent i = new Intent(Child_Marriage.this, GoalResult.class);
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
            i.putExtra("p_equity", equity);
            i.putExtra("p_debts", debts);
            i.putExtra("p_gold", gold);
            startActivity(i);
        }
        catch (Exception e){
            Log.e("Exception", e.toString());
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
