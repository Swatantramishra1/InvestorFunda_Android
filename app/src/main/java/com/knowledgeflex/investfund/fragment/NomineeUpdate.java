package com.knowledgeflex.investfund.fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.knowledgeflex.investfund.ApiService;
import com.knowledgeflex.investfund.Model.BankAccountType;
import com.knowledgeflex.investfund.Model.BankDetail;
import com.knowledgeflex.investfund.Model.NomineeDetailsDatum;
import com.knowledgeflex.investfund.Model.UpdateUserDetailsResult;
import com.knowledgeflex.investfund.Model.UploadDocumentDetailsDatum;
import com.knowledgeflex.investfund.Model.UserProfile;
import com.knowledgeflex.investfund.Model.UserProfileInsert;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.Utils;
import com.knowledgeflex.investfund.adapter.NomineeSpinnerAdapter;
import com.knowledgeflex.investfund.adapter.RelationSpinnerAdapter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NomineeUpdate extends Activity {

    private String n_name;
    private String n_dob;
    private String n_relation;
    private String n_relationId;
    private String n_type;
    private String n_allocation;
    private String rId;
    private String nomineeId;
    private String[] nominee_Id;
    private String[] nominee_Name;
    private String[] relation_Id;
    private String[] relationName;
    //private Spinner spnSelectRelationType;
    private String relationId;
    private ArrayList<NomineeDetailsDatum> mNomineeList;
    private ArrayList<UploadDocumentDetailsDatum> uploadDocumentDetailsData;
    private EditText mEditAlloc;
    private EditText mEditName;
    private Button save;
    private Button cancel;
    private TextView mEdittDob;
    private Spinner mSpinRelationType;
    private Spinner mSpinRiskType;
    Calendar myCalendar = Calendar.getInstance();
    SimpleDateFormat dateFormatter;
    DatePickerDialog calender;
    ProgressDialog progressDialog;
    private ApiService apiService;
    UserProfileInsert userProfileData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nominee_layout_item);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        n_name = getIntent().getStringExtra("name");
        n_dob = getIntent().getStringExtra("dob");
        n_relation = getIntent().getStringExtra("relation");
        n_relationId = getIntent().getStringExtra("relationId");
        n_type = getIntent().getStringExtra("type");
        nomineeId = getIntent().getStringExtra("nomineeId");
        n_allocation = getIntent().getStringExtra("alloc");
        nominee_Id = getIntent().getStringArrayExtra("nId");
        nominee_Name = getIntent().getStringArrayExtra("nName");
        relation_Id = getIntent().getStringArrayExtra("rId");
        relationName = getIntent().getStringArrayExtra("rName");
        progressDialog = new ProgressDialog(this);
        /*mNomineeList = getIntent().getParcelableExtra("nominee");
        mRelationList = getIntent().getParcelableExtra("relation");*/

        mEditName = (EditText) findViewById(R.id.accountName);
        mEdittDob = (TextView)findViewById(R.id.etDOB);
        mEditAlloc = (EditText) findViewById(R.id.alloc);
        save = (Button) findViewById(R.id.nominee_save);
        cancel = (Button) findViewById(R.id.nominee_cancel);
        mSpinRelationType = (Spinner) findViewById(R.id.spnSelectRelationType);
        mSpinRiskType = (Spinner) findViewById(R.id.spnRiskType);
        //spnSelectRelationType = (Spinner) findViewById(R.id.spnSelectRelationType);

        mEditName.setText(n_name);
        mEdittDob.setText(n_dob);
        mEditAlloc.setText(n_allocation);

        mSpinRiskType.setAdapter(new NomineeSpinnerAdapter(this, nominee_Id, nominee_Name));
        mSpinRelationType.setAdapter(new RelationSpinnerAdapter(this, relation_Id, relationName));

        mEdittDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calender.show();
            }
        });

        calender = new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                mEdittDob.setText(dateFormatter.format(newDate.getTime()));
            }

        },myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH));
        /*mSpinRelationType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



               *//* Object branch = mSpinRelationType.getSelectedItem();
                Gson gson = new Gson();
                String json = gson.toJson(branch);
                Log.e("json",json);
                try {
                    JSONObject jsonobject = new JSONObject(json);
                    rId = jsonobject.getString("Relationship_ID");
                } catch (JSONException e1) {
                    e1.printStackTrace();
                    Log.e("Error", e1.toString());
                }*//*
                //    Log.e("Nominee_Relationship_ID", relationId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mSpinRiskType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               *//* Object branch = mSpinRiskType.getSelectedItem();
                Gson gson = new Gson();
                String json = gson.toJson(branch);
                try {
                    JSONObject jsonobject = new JSONObject(json);
                    riskId = jsonobject.getString("NomineeTypeValue");
                } catch (JSONException e1) {
                    e1.printStackTrace();
                    Log.e("Error", e1.toString());
                }*//*

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("name",mEditName.getText().toString());
                Log.e("alloc",mEditAlloc.getText().toString());
                Log.e("relation",mSpinRelationType.getSelectedItem().toString());
                Log.e("relationId ",getRelationId(mSpinRelationType.getSelectedItem().toString()));
                Log.e("Risk ",getRiskId(mSpinRiskType.getSelectedItem().toString()));
                Log.e("Data",mEdittDob.getText().toString());
                if(!mEditName.getText().toString().equals("")){
                    if(!mEdittDob.getText().toString().equals("")){
                        userProfileData = new UserProfileInsert();
                        userProfileData.setUserId(Utils.getStringPref(Utils.UserId));
                        UploadDocumentDetailsDatum upload = new UploadDocumentDetailsDatum();
                        NomineeDetailsDatum nominee = new NomineeDetailsDatum();
                        nominee.setNomineeName(mEditName.getText().toString());
                        nominee.setNomineeDOB(mEdittDob.getText().toString());
                        nominee.setNomineeAllocationPercentage(mEditAlloc.getText().toString());
                        nominee.setNomineeRelationship(mSpinRelationType.getSelectedItem().toString());
                        nominee.setNomineeRelationshipId(getRelationId(mSpinRelationType.getSelectedItem().toString()));
                        nominee.setNomineeRiskType(getRiskId(mSpinRiskType.getSelectedItem().toString()));
                        nominee.setUrNomineeId(nomineeId);
                        mNomineeList = new ArrayList<NomineeDetailsDatum>();
                        uploadDocumentDetailsData = new ArrayList<UploadDocumentDetailsDatum>();
                        mNomineeList.add(nominee);
                        uploadDocumentDetailsData.add(upload);
                        userProfileData.setListNomineeDetails(mNomineeList);
                        BankDetail bankDetail = new BankDetail();
                        userProfileData.setBankDetails(bankDetail);
                        UserProfile userProfile = new UserProfile();
                        userProfileData.setUserProfile(userProfile);
                        userProfileData.setListDocumentDetails(uploadDocumentDetailsData);
                        if(new Utils().isNetworkAvailable(getApplicationContext())){
                            progressDialog.setMessage("please wait...");
                            progressDialog.show();
                            apiService = (ApiService) ApiService.retrofit.create(ApiService.class);
                            apiService.updateUserDetails(userProfileData).enqueue(new UserUpdate());
                        }

                    }
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private class UserUpdate implements Callback<UpdateUserDetailsResult> {
        @Override
        public void onResponse(Call<UpdateUserDetailsResult> call, Response<UpdateUserDetailsResult> response) {
            if (((UpdateUserDetailsResult) response.body()).getUserRegistrationResult().getResponseCode().intValue() == 0) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"data saved",Toast.LENGTH_LONG).show();
                finish();
            }
            else if (((UpdateUserDetailsResult) response.body()).getUserRegistrationResult().getResponseCode().intValue() == 1) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),((UpdateUserDetailsResult) response.body()).getUserRegistrationResult().getResponseMessage().toString(),Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(Call<UpdateUserDetailsResult> call, Throwable t) {
            Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
        }
    }


    private String getRelationId(String s) {
        String rId = "";
        for(int i=0;i<relation_Id.length;i++){
            if(relationName[i].equals(s)){
                rId = relationName[i];
            }
        }

        return rId;
    }

    private String getRiskId(String s) {
        switch (s){
            case "1":
                return  "Major";
            case "2":
                return  "Minor";
        }
        return s;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
