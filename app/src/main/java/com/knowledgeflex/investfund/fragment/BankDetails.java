package com.knowledgeflex.investfund.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.knowledgeflex.investfund.ApiService;
import com.knowledgeflex.investfund.Model.BankAccountType;
import com.knowledgeflex.investfund.Model.BankDetail;
import com.knowledgeflex.investfund.Model.BankDetailsData;
import com.knowledgeflex.investfund.Model.BankList;
import com.knowledgeflex.investfund.Model.UpdateUserDetailsResult;
import com.knowledgeflex.investfund.Model.UserDetailResponse;
import com.knowledgeflex.investfund.Model.UserProfile;
import com.knowledgeflex.investfund.Model.UserProfileInsert;
import com.knowledgeflex.investfund.Portfolio;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.Utils;
import com.knowledgeflex.investfund.adapter.BankAccountTypeAdapter;
import com.knowledgeflex.investfund.adapter.BankListAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BankDetails extends Fragment implements Portfolio.OnFragmentInteractionListener, View.OnClickListener {
    EditText mAccountName;
    EditText mAccountnumber;
    private Button save;
    ProgressDialog progressDialog;
    EditText mDob;
    EditText mIfsc;
    Spinner spnSelectAccountType;
    Spinner spnSelectBank;
    private BankDetailsData mBankData;
    private ArrayList<BankList> mBankList;
    private ArrayList<BankAccountType> mBankType;
    private Context mContext;
    private UserDetailResponse mUserDetailResponse;
    private ApiService apiService;
    UserProfileInsert userProfileData;
    private String bankId;
    private String accountId;
    private String bank_detailId;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBankData = new BankDetailsData();
        mBankList = new ArrayList<BankList>();
        mBankType =   new ArrayList<BankAccountType>();
        //  mUserDetailResponse = new UserDetailResponse();
        retriveData();
    }

    private void retriveData() {
        try {
            mUserDetailResponse = (UserDetailResponse) Utils.readObject(mContext, "UserDetails");
            mBankData = mUserDetailResponse.getGetUserProfileDetailsInfoResult().getResult().getBankDetailsData();
            mBankList = (ArrayList) Utils.readObject(mContext, "BankList");
            mBankType = (ArrayList) Utils.readObject(mContext, "BankAccountType");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bank_details, container, false);
        progressDialog = new ProgressDialog(getContext());
        mAccountName = (EditText) view.findViewById(R.id.nameRecord);
        mIfsc = (EditText) view.findViewById(R.id.etIFSC);
        spnSelectBank = (Spinner) view.findViewById(R.id.spnSelectBank);
        spnSelectAccountType = (Spinner) view.findViewById(R.id.spnSelectAccountType);
        mAccountnumber = (EditText) view.findViewById(R.id.accountNo);
        save = (Button) view.findViewById(R.id.bank_save);
        // mAccountnumber.setText(mBankData.getBankAccountNo().toString());
        spnSelectBank.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int j, long l) {
                Object branch = spnSelectBank.getSelectedItem();
                Gson gson = new Gson();
                String json = gson.toJson(branch);
                try {
                    JSONObject jsonobject = new JSONObject(json);
                    bankId = jsonobject.getString("Bank_ID");
                } catch (JSONException e1) {
                    e1.printStackTrace();
                    Log.e("Error", e1.toString());
                }
                Log.e("bankId", bankId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spnSelectAccountType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int j, long l) {
                Object branch = spnSelectAccountType.getSelectedItem();
                Gson gson = new Gson();
                String json = gson.toJson(branch);
                try {
                    JSONObject jsonobject = new JSONObject(json);
                    accountId = jsonobject.getString("AccountTypeID");
                } catch (JSONException e1) {
                    e1.printStackTrace();
                    Log.e("Error", e1.toString());
                }
                //    Log.e("accountId", accountId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        save.setOnClickListener(this);
        showBankData();
        return view;
    }

    private void showBankData() {
        retriveData();
        if (mBankData != null) {
            mAccountName.setText(mBankData.getNameAsPerBank());
            mIfsc.setText(mBankData.getBankIFSC());
            mAccountnumber.setText(mBankData.getBankAccountNo());
            if (mBankList != null) {
                spnSelectBank.setAdapter(new BankListAdapter(mContext, mBankList));
            }
            if (this.mBankType != null) {
                spnSelectAccountType.setAdapter(new BankAccountTypeAdapter(mContext, mBankType));
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onFragmentInteraction(Context mContext) {
        mContext = mContext;
        showBankData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bank_save:
                if(mIfsc.getText().toString().equals("")){
                    Toast.makeText(getContext(),"Please enter IFSC code",Toast.LENGTH_LONG).show();
                }
                else if(mAccountnumber.getText().toString().equals("")){
                    Toast.makeText(getContext(),"Please enter Account Number",Toast.LENGTH_LONG).show();
                }
                else if(mAccountName.getText().toString().equals("")){
                    Toast.makeText(getContext(),"Please enter Account Holder Name",Toast.LENGTH_LONG).show();
                }
                else {
                    saveData();
                }
                break;
        }
    }

    private void saveData() {
        Log.e("accountId", accountId);
        bank_detailId = mBankData.getBankDetailsID();
        Log.e("bank_detailId", bank_detailId);
        userProfileData = new UserProfileInsert();
        userProfileData.setUserId(Utils.getStringPref(Utils.UserId));
        UserProfile userDetail=new UserProfile();
        userProfileData.setUserProfile(userDetail);
        BankDetail bank = new BankDetail();
        bank.setBank_IFSC(mIfsc.getText().toString());
        bank.setBankDetailsId(bank_detailId);
        bank.setBankAccountNo(mAccountnumber.getText().toString());
        bank.setBankId(bankId);
        bank.setBankAccountTypeId(accountId);
        bank.setNameAsPerBank(mAccountName.getText().toString());
        bank.setUserId(Utils.getStringPref(Utils.UserId));
        userProfileData.setBankDetails(bank);
        if(new Utils().isNetworkAvailable(getContext())){
            progressDialog.setMessage("please wait...");
            progressDialog.show();
            apiService = (ApiService) ApiService.retrofit.create(ApiService.class);
            apiService.updateUserDetails(userProfileData).enqueue(new UserUpdate());
        }
        else {
            Toast.makeText(getContext(),"No Internet Connection",Toast.LENGTH_LONG).show();
        }
    }

    private class UserUpdate implements Callback<UpdateUserDetailsResult> {
        @Override
        public void onResponse(Call<UpdateUserDetailsResult> call, Response<UpdateUserDetailsResult> response) {
            if (((UpdateUserDetailsResult) response.body()).getUserRegistrationResult().getResponseCode().intValue() == 0) {
                progressDialog.dismiss();
                Toast.makeText(getContext(),"data saved",Toast.LENGTH_LONG).show();
            }
            else if (((UpdateUserDetailsResult) response.body()).getUserRegistrationResult().getResponseCode().intValue() == 1) {
                progressDialog.dismiss();
                Toast.makeText(getContext(),((UpdateUserDetailsResult) response.body()).getUserRegistrationResult().getResponseMessage().toString(),Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(Call<UpdateUserDetailsResult> call, Throwable t) {
            Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
        }
    }

}
