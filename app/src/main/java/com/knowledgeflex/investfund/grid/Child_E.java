package com.knowledgeflex.investfund.grid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.knowledgeflex.investfund.GoalResult;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.utils.CalculatePortfolio;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Child_E extends AppCompatActivity {

    public static final String PREFS_NAME = "Result";
    public static final String MASTER_ID = "1";
    public static final String GOAL = "Future Study";
    public static final String SCHEME_ID = "1,2,3";
    double compoundInterest1;
    double compoundInterest2;
    double compoundInterest3;
    double compoundInterest4;
    int current_age;
    double current_cost_edu;
    int duration;
    int higher_edu_age;
    int inflation;
    double living_exp = 0.0;
    EditText m_name;
    EditText m_c_age;
    EditText m_cost_fee;
    Spinner m_go_course;
    EditText m_course_duration;
    Spinner m_inflation;
    // EditText m_living_exp;
    EditText m_saved_sum;
    String name;
    // String myEditValue2;
    String goCourse;
    String c_inflation;
    //String lump_sum;
    double calculatedCost;
    int saved;
    int year;
    SharedPreferences sharedPreferences;
    Button submit;
    String rate[];
    String course[];
    double equityPerCost;
    double debtPerCost;
    double sumCost;
    double goldPerCost;
    double totalCourse;
    double totalLivingCost;
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

   /* class C02601 implements View.OnClickListener {
        public void onClick(View v) {
            startActivity(new Intent(Child_E.this, Child_Result.class));
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child__e);
        getWindow().setSoftInputMode(3);
        sharedPreferences = getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        m_name = (EditText) findViewById(R.id.name);
        m_c_age = (EditText) findViewById(R.id.currentAge);
        m_go_course = (Spinner) findViewById(R.id.goForCourse);
        m_course_duration = (EditText) findViewById(R.id.courseDuration);
        m_cost_fee = (EditText) findViewById(R.id.courseFees);
        //m_living_exp = (EditText) findViewById(R.id.costLiving);
        m_saved_sum = (EditText) findViewById(R.id.lumpSum);
        m_inflation = (Spinner) findViewById(R.id.rateInflation);
        submit = (Button) findViewById(R.id.proceed);
        rate = new String[15];
        course = new String[25];
        for(int i=0;i<15;i++){
            rate[i]= (i+1)+" "+"%";
        }
        for(int i=0;i<25;i++){
            course[i]= (i+1)+" "+"Yrs";
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Child_E.this, android.R.layout.simple_dropdown_item_1line, rate);
        m_inflation.setAdapter(adapter);
        m_inflation.setSelection(5);
        ArrayAdapter<String> years = new ArrayAdapter<String>(Child_E.this, android.R.layout.simple_dropdown_item_1line, course);
        m_go_course.setAdapter(years);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(!m_c_age.getText().toString().equals("")  && !m_course_duration.getText().toString().equals("") && !m_cost_fee.getText().toString().equals("")) {
                        String inflate= m_inflation.getSelectedItem().toString();
                        String go_course = m_go_course.getSelectedItem().toString();
                        if(!inflate.equals("")&& !go_course.equals("")&& !m_saved_sum.getText().toString().equals("")) {
                            name = m_name.getText().toString();
                            c_inflation = split(inflate);
                            goCourse = splitYears(go_course);
                            current_age = Integer.parseInt(m_c_age.getText().toString());
                            higher_edu_age = Integer.parseInt(goCourse);
                            duration = Integer.parseInt(m_course_duration.getText().toString());
                            inflation = Integer.parseInt(c_inflation);
                            current_cost_edu = Double.parseDouble(m_cost_fee.getText().toString());
                            saved = Integer.parseInt(m_saved_sum.getText().toString());
                            totalCourse = (current_cost_edu + living_exp) * duration;
                            totalLivingCost = living_exp * duration;
                            calculatePortfolioAllocation(higher_edu_age,current_age,totalCourse,inflation,saved);
                            Bundle mBundle = new Bundle();
                            mBundle.putString("name",name);
                            mBundle.putInt("inflate",inflation);
                            mBundle.putInt("age",current_age);
                            mBundle.putInt("edu_age",higher_edu_age);
                            mBundle.putInt("duration",duration);
                            mBundle.putDouble("cost",current_cost_edu);
                            mBundle.putDouble("living_cost",living_exp);
                            mBundle.putInt("calculatedCost", (int) calculatedCost);
                            mBundle.putDouble("sum",sumCost);
                            mBundle.putDouble("equity",equityPerCost);
                            mBundle.putDouble("debt",debtPerCost);
                            mBundle.putInt("save",saved);
                            mBundle.putDouble("total",totalCourse);
                            mBundle.putDouble("totalLiving",totalLivingCost);
                           /* Intent i = new Intent(Child_E.this,Child_Result.class);*/
                            Intent i = new Intent(Child_E.this,GoalResult.class);
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
                            i.putExtra("p_equity",equity);
                            i.putExtra("p_debts", debts);
                            i.putExtra("p_gold",gold);
                            startActivity(i);
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext()," Please fill child's current age, course fee and duration",Toast.LENGTH_LONG).show();
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private synchronized void calculatePortfolioAllocation(int go_course, int currentAge, double totalCourseCost, int inflation,int lumpSum) throws JSONException {
        year=go_course-currentAge;
        Log.e("year", String.valueOf(year));
        Log.e("sum", String.valueOf(totalCourseCost));
        Log.e("inflation", String.valueOf(inflation));
        int rog=12;
        double graphTwo = totalCourseCost * Math.pow((1 + (float)inflation / 100), year);
        long future_cost = Math.round(graphTwo);
        int multiplier = 1;
        double mInvst = future_cost * 0.12 / ((Math.pow((1 + 0.12), (year)) - 1) * (1 + 0.12));//change inflation rate dynamic
        mInvst = mInvst * multiplier;
        double oInvst = future_cost - lumpSum;
        mInvst = Math.round(mInvst);
        long Temp1 = (long) (mInvst % 1000);
        long Temp2 = 1000 - Temp1;
        mInvst = mInvst + Temp2;
        //Monthly Investment
        mInvst = Math.round(mInvst / 12);
        double Temp11 = mInvst % 1000;
        double Temp21 = 1000 - Temp11;
        mInvst = mInvst + Temp21;
        double Temp111 = oInvst % 1000;
        double Temp211 = 1000 - Temp111;
        oInvst = oInvst + Temp211;
        oInvst = Math.round(oInvst);
        if(mInvst < 4000) {
            mInvst = 4000;
        }
        sumCost = mInvst;
        calculatedCost = oInvst;
        JSONObject obj= new CalculatePortfolio().CalculatePortfolioAllocation(year,(int)mInvst,"","ChildGoal","no");
        // Log.e("obj", String.valueOf(obj));
        JSONArray res = obj.getJSONArray("data");
        // Log.e("res", String.valueOf(res));
        goalData = obj.toString();
        for(int i=0;i<res.length();i++){
            JSONObject jsonobject = res.getJSONObject(i);
            equity = jsonobject.getString("Return_EquityPer");
            gold = jsonobject.getString("Returm_GoldPer");
            debts = jsonobject.getString("Returm_DebtPer");
            JSONArray jsonArray = jsonobject.getJSONArray("Fund");
            for (int j=0;j<jsonArray.length();j++){
                JSONObject object = jsonArray.getJSONObject(i);
                fundLargeCap = object.getString("Fund_LargeCap");
                fundMultiCap = object.getString("Fund_MultiCap");
                fundBondFunds = object.getString("Fund_BondFunds");
                fundMidCap = object.getString("Fund_MidCap");
                fundGold = object.getString("Fund_Gold");
                fundLiquidCap = object .getString("Fund_LiquidCap");
                fundUltraSortFund = object.getString("Fund_UltraSortFund");
                fundCreditOpportunity = object.getString("Fund_CreditOpportunity");
                fundGlit = object.getString("Fund_GILT");
                fundBalanced = object.getString("Fund_Balanced");
            }
           // Log.e("fundBalanced", fundBalanced);
        }
        equityPerCost = mInvst * Integer.parseInt(equity )/100;
        double equtTemp = equityPerCost % 100;
        if(equtTemp != 0){
            double equtTemp2 = 100 - equtTemp;
            equityPerCost = equityPerCost + equtTemp2;
        }
        debtPerCost = mInvst* Integer.parseInt(debts)/100;
        double debtTemp = debtPerCost % 100;
        if(debtTemp !=0) {
            double debtTemp2 = 100 - debtTemp;
            debtPerCost = debtPerCost + debtTemp2;
        }
        goldPerCost = sumCost * Integer.parseInt(gold) / 100;
        double goldTemp = goldPerCost % 100;
        if (goldTemp != 0) {
            double goldTemp2 = 100 - goldTemp;
            goldPerCost = goldPerCost + goldTemp2;
        }
    }

    private String splitYears(String go_course) {
        String data[]=go_course.split(" ");
        return data[0];
    }

    private synchronized String split(String inflate) {
        String data[]=inflate.split(" ");
        return data[0];
    }

    public double compoundInterest(double start, double interest, int periods) {
        compoundInterest1 = Math.pow((interest / 100.0d) + 1.0d, (double) periods) * start;
        compoundInterest2 = (compoundInterest1 * 10.0d) / 100.0d;
        compoundInterest3 = compoundInterest2 / Math.pow(1.1d, (double) periods);
        compoundInterest4 = compoundInterest3 / 12.0d;
        // Log.d("Size1", compoundInterest1 + BuildConfig.VERSION_NAME);
        // Log.d("Size2", compoundInterest2 + BuildConfig.VERSION_NAME);
        // Log.d("Size3", compoundInterest3 + BuildConfig.VERSION_NAME);
        sharedPreferences.edit().putLong("total1", new Double(compoundInterest1).longValue()).commit();
        sharedPreferences.edit().putLong("total2", new Double(compoundInterest2).longValue()).commit();
        sharedPreferences.edit().putLong("total3", new Double(compoundInterest4).longValue()).commit();
        return Math.pow((interest / 100.0d) + 1.0d, (double) periods) * start;
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
