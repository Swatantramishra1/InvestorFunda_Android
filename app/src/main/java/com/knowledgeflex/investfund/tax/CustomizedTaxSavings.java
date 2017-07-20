package com.knowledgeflex.investfund.tax;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.knowledgeflex.investfund.Child_Result;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.utils.CalculatePortfolio;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CustomizedTaxSavings extends Fragment implements View.OnClickListener {

    LinearLayout knowTax;
    LinearLayout notKnowTax;
    LinearLayout findTax;
    Button know;
    Button notKnow;
    Spinner assessmentYear;
    EditText investAmount;
    Spinner modeOfInvestment;
    Spinner assessmentYear_find;
    EditText investAmount_find;
    Spinner modeOfInvestment_find;
    EditText yourAge;
    Spinner assessment;
    EditText gross;
    EditText epf;
    EditText ppf;
    EditText life;
    EditText deposit;
    EditText principal;
    EditText nsc;
    EditText taxDeduction;
    Button invest_one;
    Button invest_two;
    int totalOtherAmount = 0;
    double taxPayableAmount = 0;
    int Edutax = 0;
    //String year;
    int insurancePremium = 0;
    int fixedDeposite = 0;
    int houseLoan = 0;
    int taxEpf =0;
    int taxPpf =0;
    int taxNsc = 0;
    int otherAmount = 0;
    int salary = 0;
    double taxCalculatorAmount;
    String horizon[];
    String mode[]={"Select Mode", "SIP", "ONE TIME INVESTMENT"};
    double calculatedCost;
    double equityPerCost;
    double debtPerCost;
    int sumCost;
    double goldPerCost;
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
    Button invest_one_find;
    int assess = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_customized_tax_savings, container, false);
        horizon = new String[3];
        horizon[0]="Select Horizon";
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
      //  int plus = year+1;
        horizon[1] = (year-1) + "-" + year;
        horizon[2] = year + "-" + (year+1);
        // Inflate the layout for this fragment
        knowTax = (LinearLayout)root.findViewById(R.id.invest_data);
        notKnowTax = (LinearLayout)root.findViewById(R.id.calculate_data);
        findTax= (LinearLayout)root.findViewById(R.id.invest_data_tax_find);
        know = (Button)root.findViewById(R.id.invest_tax);
        notKnow = (Button)root.findViewById(R.id.calculate);
        assessmentYear = (Spinner)root.findViewById(R.id.assesmentYear);
        investAmount = (EditText)root.findViewById(R.id.investAmount);
        modeOfInvestment = (Spinner)root.findViewById(R.id.modeOfInvestment);
        yourAge = (EditText)root.findViewById(R.id.yourAge);
        gross = (EditText)root.findViewById(R.id.gross);
        assessment = (Spinner) root.findViewById(R.id.assessment_Year);
        epf = (EditText)root.findViewById(R.id.epf);
        ppf = (EditText)root.findViewById(R.id.ppf);
        life = (EditText)root.findViewById(R.id.life);
        deposit = (EditText)root.findViewById(R.id.deposit);
        principal = (EditText)root.findViewById(R.id.principal);
        nsc = (EditText)root.findViewById(R.id.nsc);
        taxDeduction = (EditText)root.findViewById(R.id.taxDeduction);
        invest_one = (Button) root.findViewById(R.id.invest_now);
        invest_two =(Button)root.findViewById(R.id.invest_now_one);

        assessmentYear_find = (Spinner)root.findViewById(R.id.assesmentYear_tax_find);
        investAmount_find = (EditText)root.findViewById(R.id.investAmount_tax_find);
        modeOfInvestment_find = (Spinner)root.findViewById(R.id.modeOfInvestment_tax_find);
        invest_one_find = (Button) root.findViewById(R.id.invest_now_tax_find);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, mode);
        modeOfInvestment.setAdapter(adapter);
        ArrayAdapter<String> years = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, horizon);
        assessmentYear.setAdapter(years);
        assessment.setAdapter(years);
        assessmentYear_find.setAdapter(years);
        modeOfInvestment_find.setAdapter(adapter);
        invest_two.setOnClickListener(this);
        invest_one.setOnClickListener(this);
        know.setOnClickListener(this);
        notKnow.setOnClickListener(this);

        assessment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                assess = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        invest_one_find.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.invest_tax:
                    knowTax.setVisibility(View.VISIBLE);
                    notKnowTax.setVisibility(View.GONE);
                break;
            case R.id.calculate:
                    notKnowTax.setVisibility(View.VISIBLE);
                    knowTax.setVisibility(View.GONE);
                break;
            case R.id.invest_now_one:
                    investNow();
                break;
            case R.id.invest_now:
                    knowCalculate();
                break;
            case R.id.invest_now_tax_find:
                    knowCalculate_tax();
                break;
        }
    }

    private synchronized void knowCalculate_tax() {
        if(!assessmentYear_find.getSelectedItem().toString().equals("Select Horizon")){
            if(!investAmount_find.getText().toString().equals("")){
                if(!modeOfInvestment_find.getSelectedItem().toString().equals("Select Mode")){
                    if(modeOfInvestment_find.getSelectedItem().toString().equals("SIP")){
                        float cost = Integer.parseInt(investAmount_find.getText().toString())/12;
                        try {
                            calculatePortfolioAllocation(1,(int)cost, modeOfInvestment_find.getSelectedItem().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        float cost = Integer.parseInt(investAmount_find.getText().toString());
                        try {
                            calculatePortfolioAllocation(1,(int)cost, "LUMPSUM");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private synchronized void investNow() {
        if(!gross.getText().toString().equals("")) {
            //year = assessment.getText().toString();
            if (!life.getText().toString().equals("")){
                insurancePremium = Integer.parseInt(life.getText().toString());
            }
            if (!deposit.getText().toString().equals("")) {
                fixedDeposite = Integer.parseInt(deposit.getText().toString());
            }
            if (!principal.getText().toString().equals("")) {
                houseLoan = Integer.parseInt(principal.getText().toString());
            }
            if (!epf.getText().toString().equals("")) {
                taxEpf = Integer.parseInt(epf.getText().toString());
            }
            if (!ppf.getText().toString().equals("")) {
                taxPpf = Integer.parseInt(ppf.getText().toString());
            }
            if (!nsc.getText().toString().equals("")) {
                taxNsc = Integer.parseInt(nsc.getText().toString());
            }
            if (!taxDeduction.getText().toString().equals("")) {
                otherAmount = Integer.parseInt(taxDeduction.getText().toString());
            }
            if (!gross.getText().toString().equals("")) {
                salary = Integer.parseInt(gross.getText().toString());
                notKnowCalculate(salary);
            }
        }
    }

    private void knowCalculate() {
        if(!assessmentYear.getSelectedItem().toString().equals("Select Horizon")){
            if(!investAmount.getText().toString().equals("")){
                if(!modeOfInvestment.getSelectedItem().toString().equals("Select Mode")){
                    if(modeOfInvestment.getSelectedItem().toString().equals("SIP")){
                        float cost = Integer.parseInt(investAmount.getText().toString())/12;
                        try {
                            calculatePortfolioAllocation(1,(int)cost, modeOfInvestment.getSelectedItem().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        float cost = Integer.parseInt(investAmount.getText().toString());
                        try {
                            calculatePortfolioAllocation(1,(int)cost, "LUMPSUM");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private void notKnowCalculate(int grossSalary) {

        if (grossSalary <= 500000) {
            totalOtherAmount = insurancePremium + fixedDeposite + houseLoan +  taxEpf + taxNsc + taxPpf + otherAmount;
            taxPayableAmount = grossSalary - totalOtherAmount;
            taxPayableAmount = (taxPayableAmount - 250000) * 0.1;
            Edutax = 600;
            taxPayableAmount = taxPayableAmount + Edutax;
            taxCalculatorAmount = taxPayableAmount;
        }
        else if (grossSalary > 500000 || grossSalary <= 1000000) {
            totalOtherAmount = insurancePremium + fixedDeposite + houseLoan +  taxEpf + taxNsc + taxPpf + otherAmount;
            taxPayableAmount = grossSalary - totalOtherAmount;
            taxPayableAmount = ((taxPayableAmount - 500000) * 0.2) + 25000;
            Edutax = 810;
            taxPayableAmount = taxPayableAmount + Edutax;
            taxCalculatorAmount = taxPayableAmount;
        }
        else {
            totalOtherAmount = insurancePremium + fixedDeposite + houseLoan +  taxEpf + taxNsc + taxPpf + otherAmount;
            taxPayableAmount = grossSalary - totalOtherAmount;
            taxPayableAmount = ((taxPayableAmount - 1000000) * 0.3) + 125000;
            Edutax = 810;
            taxPayableAmount = taxPayableAmount + Edutax;
            taxCalculatorAmount = taxPayableAmount;
        }

     //   boolean investForm = true;
      //  boolean taxCalculator = false;
        if (taxCalculatorAmount > 0)   {
            //$scope.InvestmentKnow.amount = taxCalculatorAmount;
            //$scope.InvestmentKnow.horizone = $scope.TaxStatusVal.assessmentYear;
            //alert("Your Taxable amount is " + $scope.InvestmentKnow.amount);
            Toast.makeText(getContext(),"Your Taxable amount is " + taxCalculatorAmount,Toast.LENGTH_LONG).show();
            knowTax.setVisibility(View.GONE);
            notKnowTax.setVisibility(View.GONE);
            findTax.setVisibility(View.VISIBLE);
            assessmentYear_find.setSelection(assess);
            investAmount_find.setText(String.valueOf((int)taxCalculatorAmount));
        }
        else {
           Toast.makeText(getContext(),"You do not come under Taxable amount",Toast.LENGTH_LONG).show();
        }


    }

    private synchronized void calculatePortfolioAllocation(int year, int totalCost, String type) throws JSONException {
         sumCost = totalCost;
        JSONObject obj= new CalculatePortfolio().CalculatePortfolioAllocation(year,totalCost,"Moderate","",type);
        //Log.e("obj", String.valueOf(obj));
        JSONArray res = obj.getJSONArray("data");
        //Log.e("res", String.valueOf(res));
        goalData = obj.toString();
        for(int i=0;i<res.length();i++){
            JSONObject jsonobject = res.getJSONObject(i);
            equity = Integer.parseInt(jsonobject.getString("Return_EquityPer"));
            gold = Integer.parseInt(jsonobject.getString("Returm_GoldPer"));
            debts = Integer.parseInt(jsonobject.getString("Returm_DebtPer"));
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
                fundGlit = Integer.parseInt(object.getString("Fund_GILT"));
                fundBalanced = Integer.parseInt(object.getString("Fund_Balanced"));
            }
        }
        equityPerCost = totalCost * equity/100;
        double equtTemp = equityPerCost % 100;
        if(equtTemp != 0){
            double equtTemp2 = 100 - equtTemp;
            equityPerCost = equityPerCost + equtTemp2;
        }
        debtPerCost = totalCost * debts/100;
        double debtTemp = debtPerCost % 100;
        if(debtTemp !=0) {
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
        mBundle.putInt("calculatedCost", (int) calculatedCost);
        mBundle.putDouble("sum",sumCost);
        mBundle.putDouble("equity",equityPerCost);
        mBundle.putDouble("debt",debtPerCost);
        mBundle.putString("risk", "Moderate");
        Intent i = new Intent(getContext(),Child_Result.class);
        i.putExtra("page","8");
        i.putExtras(mBundle);
        i.putExtra("calculate",type);
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

}
