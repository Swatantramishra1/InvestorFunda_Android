package com.knowledgeflex.investfund;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.knowledgeflex.investfund.utils.CalculatePortfolio;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class OneTimeInvestment extends AppCompatActivity {

    Spinner years;
    Spinner risk;
    EditText amount;
    String riskType[] = {"Select Risk", "Low", "Moderate", "High"};
    String year[];
    Button invest;
    String yrs;
    String risks;
    int count = 0;
    List<String> data;
    String goalName;
    int goalAmount;
    int achieveYear;
    int estimateinflate;
    int durationYear;
    private int equity;
    private int debts;
    private int gold;
    private String goalData;
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
    double equityPerCost;
    double debtPerCost;
    int sumCost;
    double goldPerCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_time_investment);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
        }

        years = (Spinner)findViewById(R.id.years);
        risk = (Spinner)findViewById(R.id.riskType);
        amount = (EditText) findViewById(R.id.oneInvestAmount);
        invest = (Button) findViewById(R.id.oneTimeInvest);
        loadYear();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.spinner_text, year);
       // dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        years.setAdapter(dataAdapter);
        ArrayAdapter<String> riskAdapter = new ArrayAdapter<String>(this, R.layout.spinner_text, riskType);
      //  dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        risk.setAdapter(riskAdapter);

        invest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amt = amount.getText().toString();
                if(!amt.equals("")){
                    if (Integer.parseInt(amt) >= 500) {
                        if (!years.getSelectedItem().toString().equals("Select Horizon")) {
                            if (!risk.getSelectedItem().toString().equals("Select Risk")) {
                                String split[] = years.getSelectedItem().toString().split(" ");
                                investNow(split[0], risk.getSelectedItem().toString(), amount.getText().toString());
                            } else {
                                Toast.makeText(getApplicationContext(), "Please select risk type", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Please select horizon", Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                            Toast.makeText(getApplicationContext(), "Monthly amount should be minimum Rs.500", Toast.LENGTH_LONG).show();
                        }
                    }
                else {
                    Toast.makeText(getApplicationContext(),"Please enter investment amount",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void investNow(String yrs, String risk, String amount) {
       // Toast.makeText(getApplicationContext(),"Please enter invest amount",Toast.LENGTH_LONG).show();
        Log.e("yrs , risk , amount",yrs +" "+risk +" "+amount);
        try{
            sumCost = Integer.parseInt(amount);
            durationYear = Integer.parseInt(yrs);
            risks =risk;
            Log.e("sumCost", String.valueOf(sumCost));
            Log.e("durationYear", String.valueOf(durationYear));
            Log.e("risk", String.valueOf(risks));
            JSONObject obj = new CalculatePortfolio().CalculatePortfolioAllocation(durationYear, sumCost, risks, "","LUMPSUM");
            // Log.e("obj", String.valueOf(obj));
            JSONArray res = obj.getJSONArray("data");
            // Log.e("res", String.valueOf(res));
            goalData = obj.toString();
            for (int i = 0; i < res.length(); i++) {
                JSONObject jsonobject = res.getJSONObject(i);
                equity = Integer.parseInt(jsonobject.getString("Return_EquityPer"));
                gold = Integer.parseInt(jsonobject.getString("Returm_GoldPer"));
                debts = Integer.parseInt(jsonobject.getString("Returm_DebtPer"));
                JSONArray jsonArray = jsonobject.getJSONArray("Fund");
                for (int j = 0; j < jsonArray.length(); j++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    fundLargeCap = Integer.parseInt(object.getString("Fund_LargeCap"));
                    fundMultiCap = Integer.parseInt(object.getString("Fund_MultiCap"));
                    fundBondFunds = Integer.parseInt(object.getString("Fund_BondFunds"));
                    fundMidCap = Integer.parseInt(object.getString("Fund_MidCap"));
                    fundGold = Integer.parseInt(object.getString("Fund_Gold"));
                    fundLiquidCap = Integer.parseInt(object.getString("Fund_LiquidCap"));
                    fundUltraSortFund = Integer.parseInt(object.getString("Fund_UltraSortFund"));
                    fundCreditOpportunity = Integer.parseInt(object.getString("Fund_CreditOpportunity"));
                    fundGlit = Integer.parseInt(object.getString("Fund_GILT"));
                    fundBalanced = Integer.parseInt(object.getString("Fund_Balanced"));
                }
            }
            equityPerCost = sumCost * equity / 100;
            double equtTemp = equityPerCost % 100;
            if (equtTemp != 0) {
                double equtTemp2 = 100 - equtTemp;
                equityPerCost = equityPerCost + equtTemp2;
            }
            debtPerCost = sumCost * debts / 100;
            double debtTemp = debtPerCost % 100;
            if (debtTemp != 0) {
                double debtTemp2 = 100 - debtTemp;
                debtPerCost = debtPerCost + debtTemp2;
            }
            goldPerCost = sumCost * gold / 100;
            double goldTemp = goldPerCost % 100;
            if (goldTemp != 0) {
                double goldTemp2 = 100 - goldTemp;
                goldPerCost = goldPerCost + goldTemp2;
            }

            Bundle mBundle = new Bundle();
            mBundle.putInt("durationYear", durationYear);
            mBundle.putDouble("sum", sumCost);
            mBundle.putDouble("equity", equityPerCost);
            mBundle.putDouble("debt", debtPerCost);
            mBundle.putString("risk",risks);
            Intent i = new Intent(OneTimeInvestment.this, Child_Result.class);
            i.putExtra("page","9");
            i.putExtras(mBundle);
            i.putExtra("calculate", "LUMPSUM");
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
            Log.e("StartSIP",e.toString());
        }
    }

    private synchronized void loadYear() {
        year = new String[51];
        year[0] = "Select Horizon";
        for(int i=1;i<51;i++){
            year[i] = i+" "+"Year";
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
}
