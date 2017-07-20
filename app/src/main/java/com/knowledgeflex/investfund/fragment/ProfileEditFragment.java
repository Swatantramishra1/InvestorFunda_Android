package com.knowledgeflex.investfund.fragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.knowledgeflex.investfund.ApiService;
import com.knowledgeflex.investfund.Model.BankDetail;
import com.knowledgeflex.investfund.Model.DepositoryDetails;
import com.knowledgeflex.investfund.Model.ListAddress;
import com.knowledgeflex.investfund.Model.NomineeDetailsDatum;
import com.knowledgeflex.investfund.Model.UpdateUserDetailsResult;
import com.knowledgeflex.investfund.Model.UserProfile;
import com.knowledgeflex.investfund.Model.UserProfileInsert;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.Model.GetAllListDetailsResult;
import com.knowledgeflex.investfund.Model.GetCityData;
import com.knowledgeflex.investfund.Model.GetCountryData;
import com.knowledgeflex.investfund.Model.GetHoldingNatureData;
import com.knowledgeflex.investfund.Model.GetSourceOfWealthData;
import com.knowledgeflex.investfund.Model.GetStateData;
import com.knowledgeflex.investfund.Model.GetTaxStatus;
import com.knowledgeflex.investfund.Model.Result;
import com.knowledgeflex.investfund.Model.UserDetailResponse;
import com.knowledgeflex.investfund.Portfolio.OnFragmentInteractionListener;
import com.knowledgeflex.investfund.Utils;
import com.knowledgeflex.investfund.adapter.CountryAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileEditFragment extends Fragment implements OnFragmentInteractionListener, View.OnClickListener {
    private static final String PREFS_NAME = "userdetails";
    private static LinearLayout applicant;
    private static EditText p_address;
    private static EditText p_address_one;
    private static ProgressDialog dialog;
    private static TextView dob;
    private static EditText email;
    private static EditText fname;
    private static EditText lname;
    private static EditText mobile;
    private static EditText pancard;
    private static EditText pincode_one;
    private static EditText pincode;
    private static EditText sa_name;
    private static EditText ta_name;
    private static EditText sa_panCard;
    private static EditText ta_panCard;
    private static EditText sa_address;
    private static EditText ta_address;
    private static Spinner sCity_one;
    private static Spinner sCountry_one;
    private static Spinner sState_one;
    private static Spinner sCity;
    private static Spinner sCountry;
    private static Spinner sState;
    private static Spinner sHoldingNature;
    private static Spinner payMode;
    private static Spinner sSourceOfWealth;
    private static Spinner sTaxStatus;
    private static Spinner gender;
    private static Spinner cMode;
    private CountryAdapter adapter;
    private boolean isNetwork;
    private Context mContext;
    private Context m_context;
    private Button save;
    private OnFragmentInteractionListener mListener;
    private ArrayList<Result> sResult;
    private ArrayList<Result> taxResult;
    private ArrayList<Result> holdResult;
    private ArrayList<Result> sowResult;
    private ArrayList<Result> countryResult;
    private ArrayList<Result> cityResult;
    private ArrayList<Result> stateResult;
    private ArrayList<ListAddress> addressDetailsData;
    private ArrayList<NomineeDetailsDatum> nomineeData;
    private ApiService apiService;
    private UserDetailResponse userDetailResponse;
    UserProfileInsert userProfileData;
    Calendar myCalendar = Calendar.getInstance();
    SimpleDateFormat dateFormatter;
    DatePickerDialog calender;
    private String genderData[] = {"Select","Male","Female","Others"};
    private String payModeData[] = {"Select","CHEQUE","DIRECT CREDIT","ECS","NEFT","RTGS"};
    private String payModeDataId[] = {"Select","01","02","03","04","05"};
    private String communicationData[] = {"Select","Physical","Electronic","Mobile"};
    private String communicationDataId[] = {"0","1","2","3"};
    private String payModeId;
    private String communicationModeId;
    private String taxId;
    private String sowId;
    private String holdId;
    private String holdName;
    private String cityId;
    private String one_cityId;
    private String countryId;
    private String one_countryId;
    private String stateId;
    private String one_stateId;
    ProgressDialog progressDialog;
    private String country;
    private String one_country;
    private String state;
    private String one_state;
    private String countries[];
    private String cities[];
    private String sates[];
    private String tax[];
    private String sows[];
    private String holds[];
    private String countriesId[];
    private String citiesId[];
    private String satesId[];
    private String taxsId[];
    private String sowsId[];
    private String holdsId[];


    class UserDetail implements Callback<UserDetailResponse> {
        public void onResponse(Call<UserDetailResponse> call, Response<UserDetailResponse> response) {
            try {
                userDetailResponse = (UserDetailResponse) response.body();
                Utils.writeObject(m_context, "UserDetails", userDetailResponse);
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("Data response error",e.toString());
            }
            popullateUserDetails();
            apiService.getCountryData().enqueue(new CountryData());
            apiService.getStateResponse().enqueue(new StateData());
            apiService.getCityResponse().enqueue(new CityData());
            apiService.getTaxStatusResponse().enqueue(new TaxData());
            apiService.getHoldingNatureResponse().enqueue(new NatureData());
            apiService.getSourceOfWealthResponse().enqueue(new Wealth());
            apiService.getAllListDetails().enqueue(new AllDetails());
        }

        public void onFailure(Call<UserDetailResponse> call, Throwable t) {
            ProfileEditFragment.dialog.dismiss();
            Toast.makeText(mContext, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }
    }

    class CountryData implements Callback<GetCountryData> {

        public void onResponse(Call<GetCountryData> call, Response<GetCountryData> response) {
            if (((GetCountryData) response.body()).getGetCountryDetailsResult().getResponseCode().intValue() == 0) {
                sResult = ((GetCountryData) response.body()).getGetCountryDetailsResult().getResult();
                countryResult = ((GetCountryData) response.body()).getGetCountryDetailsResult().getResult();
                try {

                    Utils.writeObject(mContext, "CountryDetails", sResult);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                populateSpinner("country");
            }
        }

        public void onFailure(Call<GetCountryData> call, Throwable t) {
        }
    }

    class StateData implements Callback<GetStateData> {
        public void onResponse(Call<GetStateData> call, Response<GetStateData> response) {
            if (((GetStateData) response.body()).getGetStateDetailsResult().getResponseCode().intValue() == 0) {
                sResult = ((GetStateData) response.body()).getGetStateDetailsResult().getResult();
                stateResult = ((GetStateData) response.body()).getGetStateDetailsResult().getResult();
                try {
                    Utils.writeObject(mContext, "StateDetails", sResult);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                populateSpinner("state");
            }
        }

        public void onFailure(Call<GetStateData> call, Throwable t) {
        }
    }

    class CityData implements Callback<GetCityData> {

        public void onResponse(Call<GetCityData> call, Response<GetCityData> response) {
            if (((GetCityData) response.body()).getGetCityDetailsResult().getResponseCode().intValue() == 0) {
                sResult = ((GetCityData) response.body()).getGetCityDetailsResult().getResult();
                cityResult = ((GetCityData) response.body()).getGetCityDetailsResult().getResult();
                try {
                    Utils.writeObject(mContext, "CityDetails", sResult);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                populateSpinner("city");
            }
        }

        public void onFailure(Call<GetCityData> call, Throwable t) {
        }
    }

    class TaxData implements Callback<GetTaxStatus> {

        public void onResponse(Call<GetTaxStatus> call, Response<GetTaxStatus> response) {
            if (((GetTaxStatus) response.body()).getGetTaxStatusResult().getResponseCode().intValue() == 0) {
                sResult = ((GetTaxStatus) response.body()).getGetTaxStatusResult().getResult();
                taxResult = ((GetTaxStatus) response.body()).getGetTaxStatusResult().getResult();
                try {
                    Utils.writeObject(mContext, "TaxDetails", sResult);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                populateSpinner("tax");
            }
        }

        public void onFailure(Call<GetTaxStatus> call, Throwable t) {
        }
    }

    class NatureData implements Callback<GetHoldingNatureData> {

        public void onResponse(Call<GetHoldingNatureData> call, Response<GetHoldingNatureData> response) {
            if (((GetHoldingNatureData) response.body()).getGetHoldingNatureResult().getResponseCode().intValue() == 0) {
                sResult = ((GetHoldingNatureData) response.body()).getGetHoldingNatureResult().getResult();
                holdResult = ((GetHoldingNatureData) response.body()).getGetHoldingNatureResult().getResult();
                try {
                    Utils.writeObject(mContext, "HoldingDetails", sResult);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                populateSpinner("holding");
            }
        }

        public void onFailure(Call<GetHoldingNatureData> call, Throwable t) {
        }
    }

    class Wealth implements Callback<GetSourceOfWealthData> {

        public void onResponse(Call<GetSourceOfWealthData> call, Response<GetSourceOfWealthData> response) {
            if (((GetSourceOfWealthData) response.body()).getGetSourceOfWealthResult().getResponseCode().intValue() == 0) {
                sResult = ((GetSourceOfWealthData) response.body()).getGetSourceOfWealthResult().getResult();
                sowResult = ((GetSourceOfWealthData) response.body()).getGetSourceOfWealthResult().getResult();
                try {
                    Utils.writeObject(mContext, "WealthDetails", sResult);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                populateSpinner("wealth");
            }
        }

        public void onFailure(Call<GetSourceOfWealthData> call, Throwable t) {
        }
    }

    class AllDetails implements Callback<GetAllListDetailsResult> {

        public void onResponse(Call<GetAllListDetailsResult> call, Response<GetAllListDetailsResult> response) {
            if (((GetAllListDetailsResult) response.body()).getGetAllListDetailsResult().getResponseCode().intValue() == 0) {
                Result result = ((GetAllListDetailsResult) response.body()).getGetAllListDetailsResult().getResult();
                try {
                    Utils.writeObject(mContext, "BankAccountType", result.getBankAccountType());
                    Utils.writeObject(mContext, "BankList", result.getBankList());
                    Utils.writeObject(mContext, "NomineeTypeList", result.getNomineeTypeList());
                    Utils.writeObject(mContext, "RelationList", result.getRelationList());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                populateSpinner("wealth");
            }
        }

        public void onFailure(Call<GetAllListDetailsResult> call, Throwable t) {
        }
    }

    public ProfileEditFragment() {
        this.isNetwork = false;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        apiService = (ApiService) ApiService.retrofit.create(ApiService.class);
        dialog = new ProgressDialog(this.mContext);
        dialog.setMessage(getString(R.string.loading));
        dialog.show();
      //  Log.e("UserId",Utils.getStringPref(Utils.UserId));
        if (Utils.isNetworkAvailable(this.mContext)) {
            isNetwork = true;
            apiService.getUserDetail(Utils.getStringPref(Utils.UserId)).enqueue(new UserDetail());
        }

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_edit, container, false);
        if (view != null) {
            progressDialog= new ProgressDialog(getContext());
            fname = (EditText) view.findViewById(R.id.fname);
            lname = (EditText) view.findViewById(R.id.lname);
            dob = (TextView) view.findViewById(R.id.dob);
            pancard = (EditText) view.findViewById(R.id.pancard);
            mobile = (EditText) view.findViewById(R.id.mobile);
            email = (EditText) view.findViewById(R.id.email);
            sCountry = (Spinner) view.findViewById(R.id.country);
            sCity = (Spinner) view.findViewById(R.id.city);
            sState = (Spinner) view.findViewById(R.id.state);
            pincode = (EditText) view.findViewById(R.id.pincode);
            sa_name = (EditText) view.findViewById(R.id.secondApplicant);
            ta_name = (EditText) view.findViewById(R.id.thirdApplicant);
            sa_panCard = (EditText) view.findViewById(R.id.secondApplicantPancard);
            ta_panCard = (EditText) view.findViewById(R.id.thirdApplicantPancard);
            sa_address = (EditText) view.findViewById(R.id.secondApplicantAddress);
            ta_address = (EditText) view.findViewById(R.id.thirdApplicantAddress);
            p_address = (EditText) view.findViewById(R.id.address);
            sCountry_one = (Spinner) view.findViewById(R.id.country_one);
            sCity_one = (Spinner) view.findViewById(R.id.city_one);
            sState_one = (Spinner) view.findViewById(R.id.state_one);
            cMode = (Spinner) view.findViewById(R.id.communicationMode);
            pincode_one = (EditText) view.findViewById(R.id.pincode_one);
            payMode  = (Spinner) view.findViewById(R.id.payMode);
            p_address_one = (EditText) view.findViewById(R.id.address_one);
            sTaxStatus = (Spinner) view.findViewById(R.id.taxstatus);
            sHoldingNature = (Spinner) view.findViewById(R.id.holding_nature);
            applicant = (LinearLayout) view.findViewById(R.id.holdApplicant);
            sSourceOfWealth = (Spinner) view.findViewById(R.id.source_of_wealth);
            gender = (Spinner) view.findViewById(R.id.gender);
            save = (Button) view.findViewById(R.id.profile_save);

            calender = new DatePickerDialog(getContext(),new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    Calendar newDate = Calendar.getInstance();
                    newDate.set(year, monthOfYear, dayOfMonth);
                    dob.setText(dateFormatter.format(newDate.getTime()));
                }

            },myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH));

            dob.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    calender.show();
                }
            });

            sTaxStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int j, long l) {
                    Object branch = sTaxStatus.getSelectedItem();
                    Gson gson = new Gson();
                    String json = gson.toJson(branch);
                    try {
                        JSONObject jsonobject = new JSONObject(json);
                        taxId = jsonobject.getString("TaxID");
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                        Log.e("Error", e1.toString());
                    }
                    Log.e("data", taxId);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            sHoldingNature.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Object branch = sHoldingNature.getSelectedItem();
                    Gson gson = new Gson();
                    String json = gson.toJson(branch);
                    try {
                        JSONObject jsonobject = new JSONObject(json);
                        holdId = jsonobject.getString("HoldingNature_ID");
                        holdName = jsonobject.getString("Holding_Nature");
                        if(holdId.equals("2")){
                            applicant.setVisibility(View.VISIBLE);
                        }
                        else if(holdId.equals("3")){
                            applicant.setVisibility(View.VISIBLE);
                        }
                        else {
                            applicant.setVisibility(View.GONE);
                        }
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                        Log.e("Error", e1.toString());
                    }
                    //Log.e("data 1", holdId);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            sSourceOfWealth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Object branch = sSourceOfWealth.getSelectedItem();
                    Gson gson = new Gson();
                    String json = gson.toJson(branch);
                    try {
                        JSONObject jsonobject = new JSONObject(json);
                        sowId = jsonobject.getString("SourceOfWealth_ID");
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            sCountry_one.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Object branch = sCountry_one.getSelectedItem();
                    Gson gson = new Gson();
                    String json = gson.toJson(branch);
                    try {
                        JSONObject jsonobject = new JSONObject(json);
                        one_countryId = jsonobject.getString("Country_ID");
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                        Log.e("Error", e1.toString());
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            sCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Object branch = sCountry.getSelectedItem();
                    Gson gson = new Gson();
                    String json = gson.toJson(branch);
                    try {
                        JSONObject jsonobject = new JSONObject(json);
                        countryId = jsonobject.getString("Country_ID");
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                        Log.e("Error", e1.toString());
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            sState_one.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Object branch = sState_one.getSelectedItem();
                    Gson gson = new Gson();
                    String json = gson.toJson(branch);
                    try {
                        JSONObject jsonobject = new JSONObject(json);
                        one_stateId = jsonobject.getString("State_ID");
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                        Log.e("Error", e1.toString());
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            sState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Object branch = sState.getSelectedItem();
                    Gson gson = new Gson();
                    String json = gson.toJson(branch);
                    try {
                        JSONObject jsonobject = new JSONObject(json);
                        stateId = jsonobject.getString("State_ID");
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                        Log.e("Error", e1.toString());
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            sCity_one.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Object branch = sCity_one.getSelectedItem();
                    Gson gson = new Gson();
                    String json = gson.toJson(branch);
                    try {
                        JSONObject jsonobject = new JSONObject(json);
                        one_cityId = jsonobject.getString("City_ID");
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                        Log.e("Error", e1.toString());
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            sCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Object branch = sCity.getSelectedItem();
                    Gson gson = new Gson();
                    String json = gson.toJson(branch);
                    try {
                        JSONObject jsonobject = new JSONObject(json);
                        cityId = jsonobject.getString("City_ID");
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                        Log.e("Error", e1.toString());
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            save.setOnClickListener(this);
            m_context = this.getContext();
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(m_context, R.layout.gender_text, genderData);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            gender.setAdapter(dataAdapter);

            ArrayAdapter<String> payAdapter = new ArrayAdapter<String>(m_context, R.layout.gender_text, payModeData);
            payAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            payMode.setAdapter(payAdapter);
            payMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String branch = payMode.getSelectedItem().toString();
                    for(int i=0;i<payModeData.length;i++){
                        if(branch.equals(payModeData[i])){
                            payModeId = payModeDataId[i];
                        }
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            ArrayAdapter<String> communicationAdapter = new ArrayAdapter<String>(m_context, R.layout.gender_text, communicationData);
            communicationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            cMode.setAdapter(communicationAdapter);
            cMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String branch = cMode.getSelectedItem().toString();
                    for(int i=0;i<communicationData.length;i++){
                        if(branch.equals(communicationData[i])){
                            communicationModeId = communicationDataId[i];
                        }
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }
        return view;
    }

    private void checkCachedData() {
        if (!isNetwork) {
            popullateData();
        }
    }

    private void popullateData() {
        try {
            userDetailResponse = (UserDetailResponse) Utils.readObject(mContext, "UserDetails");
            sResult = (ArrayList) Utils.readObject(mContext, "CountryDetails");
            countryResult =  (ArrayList) Utils.readObject(mContext, "CountryDetails");
            countries = new String[countryResult.size()];
            countriesId = new String[countryResult.size()];
            for(int i=0;i<countryResult.size();i++){
                countries[i] = countryResult.get(i).getCountryName();
                countriesId[i] = countryResult.get(i).getCountryID();
            }
            populateSpinner("country");
            sResult = (ArrayList) Utils.readObject(mContext, "CityDetails");
            populateSpinner("city");
            sResult = (ArrayList) Utils.readObject(mContext, "StateDetails");
            populateSpinner("state");
            sResult = (ArrayList) Utils.readObject(mContext, "TaxDetails");
            populateSpinner("tax");
            sResult = (ArrayList) Utils.readObject(mContext, "HoldingDetails");
            populateSpinner("holding");
            sResult = (ArrayList) Utils.readObject(mContext, "WealthDetails");
            populateSpinner("wealth");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        popullateUserDetails();
    }

    private void populateSpinner(String sType) {
        adapter = new CountryAdapter(mContext, sResult);
        Object obj = -1;
        switch (sType) {
            case "wealth":
                if (sType.equals("wealth")) {
                    obj = 5;
                    break;
                }
                break;
            case "tax":
                if (sType.equals("tax")) {
                    obj = 3;
                    break;
                }
                break;
            case "city":
                if (sType.equals("city")) {
                    obj = 1;
                    break;
                }
                break;
            case "state":
                if (sType.equals("state")) {
                    obj = 2;
                    break;
                }
                break;
            case "country":
                if (sType.equals("country")) {
                    obj = 0;
                    break;
                }
                break;
            case "holding":
                if (sType.equals("holding")) {
                    obj = 4;
                    break;
                }
                break;
        }
        try{
            if(obj!=null) {
                switch (Integer.parseInt(String.valueOf(obj))) {
                    case 0:
                        sCountry.setAdapter(adapter);
                        sCountry_one.setAdapter(adapter);
                        break;
                    case 1:
                        sCity.setAdapter(adapter);
                        sCity_one.setAdapter(adapter);
                        break;
                    case 2:
                        sState.setAdapter(adapter);
                        sState_one.setAdapter(adapter);
                        break;
                    case 3:
                        sTaxStatus.setAdapter(adapter);
                        break;
                    case 4:
                        sHoldingNature.setAdapter(adapter);
                        break;
                    case 5:
                        adapter = new CountryAdapter(mContext, sowResult);
                        sSourceOfWealth.setAdapter(adapter);
                        break;
                }
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    public void onResume() {
        super.onResume();
        checkCachedData();
    }

    private void popullateUserDetails() {
        dialog.dismiss();
        if (userDetailResponse != null) {
            fname.getText().clear();
            lname.getText().clear();
           // dob.getText().clear();
            pancard.getText().clear();
            email.getText().clear();
            mobile.getText().clear();
            pincode.getText().clear();
            pincode_one.getText().clear();
            p_address.getText().clear();
            p_address_one.getText().clear();

            fname.append(this.userDetailResponse.getGetUserProfileDetailsInfoResult().getResult().getUserProfileData().getFirstName());
            lname.append(this.userDetailResponse.getGetUserProfileDetailsInfoResult().getResult().getUserProfileData().getLastName());
            dob.append((String) this.userDetailResponse.getGetUserProfileDetailsInfoResult().getResult().getUserProfileData().getDateOfBirth());
            pancard.append(this.userDetailResponse.getGetUserProfileDetailsInfoResult().getResult().getUserProfileData().getPanNumber());
            email.append(this.userDetailResponse.getGetUserProfileDetailsInfoResult().getResult().getUserProfileData().getEmailID());
            mobile.append((String)this.userDetailResponse.getGetUserProfileDetailsInfoResult().getResult().getUserProfileData().getMobileNo());
            pincode.append(this.userDetailResponse.getGetUserProfileDetailsInfoResult().getResult().getAddressDetailsData().get(0).getPinCode());
            pincode_one.append(this.userDetailResponse.getGetUserProfileDetailsInfoResult().getResult().getAddressDetailsData().get(1).getPinCode());
            p_address.append(this.userDetailResponse.getGetUserProfileDetailsInfoResult().getResult().getAddressDetailsData().get(0).getAddress());
            p_address_one.append(this.userDetailResponse.getGetUserProfileDetailsInfoResult().getResult().getAddressDetailsData().get(1).getAddress());
            // country = this.userDetailResponse.getGetUserProfileDetailsInfoResult().getResult().getAddressDetailsData().get(0).getCountryName();
            // countryId = this.userDetailResponse.getGetUserProfileDetailsInfoResult().getResult().getAddressDetailsData().get(0).getCountryID();
            //*Log.e("No ","data coming");
           /* if(country!=null){
                sCountry.setSelection(getCountry(country));
            }*/
        }
        else {
            Log.e("No ","data coming");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.profile_save:
                String holdNature = "";
                Object branch = sHoldingNature.getSelectedItem();
                Gson gson = new Gson();
                String json = gson.toJson(branch);
                try {
                    JSONObject jsonobject = new JSONObject(json);
                    holdNature = jsonobject.getString("Holding_Nature");
                    Log.e("holder",holdNature);

                    if(fname.getText().toString().equals("")) {
                        Toast.makeText(getContext(), "please enter the first name", Toast.LENGTH_LONG).show();
                    }
                    else if(lname.getText().toString().equals("")) {
                        Toast.makeText(getContext(), "please enter the last name", Toast.LENGTH_LONG).show();
                    }
                    else if(gender.getSelectedItem().toString().equals("Select")){
                        Toast.makeText(getContext(), "Please choose your gender", Toast.LENGTH_LONG).show();
                    }
                    else if (pancard.getText().toString().equals("")) {
                        // saveData();
                        Toast.makeText(getContext(), "please enter the pan card number", Toast.LENGTH_LONG).show();
                    }
                    else if (pincode.getText().toString().equals("")) {
                        // saveData();
                        Toast.makeText(getContext(), "please enter your permanent address pin code", Toast.LENGTH_LONG).show();
                    }
                    else if (pincode_one.getText().toString().equals("")) {
                        // saveData();
                        Toast.makeText(getContext(), "please enter your residence address pin code", Toast.LENGTH_LONG).show();
                    }
                    else if (p_address.getText().toString().equals("")) {
                        // saveData();
                        Toast.makeText(getContext(), "please enter your permanent address pin code", Toast.LENGTH_LONG).show();
                    }
                    else if (p_address_one.getText().toString().equals("")) {
                        // saveData();
                        Toast.makeText(getContext(), "please enter your residence address pin code", Toast.LENGTH_LONG).show();
                    }
                    else if(payMode.getSelectedItem().toString().equals("Select")){
                        Toast.makeText(getContext(), "Please choose your Divident Pay Mode", Toast.LENGTH_LONG).show();
                    }
                    else if(cMode.getSelectedItem().toString().equals("Select")){
                        Toast.makeText(getContext(), "Please choose your Communication Mode", Toast.LENGTH_LONG).show();
                    }
                    else if(mobile.getText().toString().equals("")){
                        Toast.makeText(getContext(), "Invalid Email Id", Toast.LENGTH_LONG).show();
                    }
                    else if(email.getText().toString().equals("") && !isValidEmail(email.getText().toString())){
                        Toast.makeText(getContext(), "Invalid Email Id", Toast.LENGTH_LONG).show();
                    }
                    else if(dob.getText().toString().equals("")){
                        Toast.makeText(getContext(), "please select your date of birth", Toast.LENGTH_LONG).show();
                    }
                    else if(holdNature.equals("Single")){
                        checkApplicant(0);
                    }
                    else {
                        checkApplicant(1);
                    }
                }
                catch (Exception e){
                    e.toString();
                }

                break;
        }
    }

    private synchronized void checkApplicant(int i) {
        if(i==1){
            if(sa_name.getText().toString().equals("")){
                Toast.makeText(getContext(), "Please enter second applicant name", Toast.LENGTH_LONG).show();
            }
            else if(sa_panCard.getText().toString().equals("")){
                Toast.makeText(getContext(), "Please enter second applicant pancard number", Toast.LENGTH_LONG).show();
            }
            else if(sa_address.getText().toString().equals("")){
                Toast.makeText(getContext(), "Please enter second applicant address", Toast.LENGTH_LONG).show();
            }
            else if(ta_name.getText().toString().equals("")){
                Toast.makeText(getContext(), "Please enter third applicant name", Toast.LENGTH_LONG).show();
            }
            else if(ta_panCard.getText().toString().equals("")){
                Toast.makeText(getContext(), "Please enter third applicant pancard number", Toast.LENGTH_LONG).show();
            }
            else if(ta_address.getText().toString().equals("")){
                Toast.makeText(getContext(), "Please enter third applicant address", Toast.LENGTH_LONG).show();
            }
            else {
                saveData();
                // Toast.makeText(getContext(), "holder nature save", Toast.LENGTH_LONG).show();
            }
        }
        else {
            saveData();
            // Toast.makeText(getContext(), "without holder nature save", Toast.LENGTH_LONG).show();
        }
    }

    private synchronized void saveData() {
        addressDetailsData = new ArrayList<ListAddress>();
        nomineeData = new ArrayList<NomineeDetailsDatum>();
        userProfileData = new UserProfileInsert();
        userProfileData.setUserId(Utils.getStringPref(Utils.UserId));
        UserProfile userDetail=new UserProfile();
        userDetail.setFirstName(fname.getText().toString());
        userDetail.setLastName(lname.getText().toString());
        userDetail.setGender(gender.getSelectedItem().toString());
        userDetail.setDateOfBirth(dob.getText().toString());
        userDetail.setPanNumber(pancard.getText().toString());
        userDetail.setMobileNo(mobile.getText().toString());
        userDetail.setEmailID(email.getText().toString());
        userDetail.setTaxStatusId(taxId);
        userDetail.setHoldingNature_ID(holdId);
        userDetail.setSowId(sowId);
        userDetail.setDividentPayMode_ID(payModeId);
        userDetail.setCommunicationModeId(communicationModeId);

        ListAddress address=new ListAddress();
        address.setCountryId(countryId);
        address.setStateId(stateId);
        address.setCityId(cityId);
        address.setPinCode(pincode.getText().toString());
        address.setAddress(p_address.getText().toString());
        address.setAddressType("Premanent Address");
        address.setAddressId("11");

        DepositoryDetails details = new DepositoryDetails();
        BankDetail bank = new BankDetail();

        NomineeDetailsDatum nomineeDetails = new NomineeDetailsDatum();
        NomineeDetailsDatum nomineeDetails1 = new NomineeDetailsDatum();

       /* ArrayList<NomineeDetailsDatum> nomineeDetails = new ArrayList<NomineeDetailsDatum>();
        nomineeDetails.add("");*/

        ListAddress address1=new ListAddress();
        address1.setCountryId(one_countryId);
        address1.setStateId(one_stateId);
        address1.setCityId(one_cityId);
        address1.setPinCode(pincode_one.getText().toString());
        address1.setAddress(p_address_one.getText().toString());
        address1.setAddressId("12");
        address1.setAddressType("Residence Address");

        addressDetailsData.add(address);
        addressDetailsData.add(address1);
        nomineeData.add(nomineeDetails);
        nomineeData.add(nomineeDetails1);

        userProfileData.setListAddress(addressDetailsData);
        userProfileData.setUserProfile(userDetail);
        userProfileData.setDepositoryDetails(details);
        userProfileData.setBankDetails(bank);
        userProfileData.setListNomineeDetails(nomineeData);
        if(new Utils().isNetworkAvailable(getContext())){
            progressDialog.setMessage("please wait...");
            progressDialog.show();
        //    apiService = (ApiService) ApiService.retrofit.create(ApiService.class);
            apiService.updateUserDetails(userProfileData).enqueue(new UserUpdate());
        }
        else {
            Toast.makeText(getContext(),"No Internet Connection",Toast.LENGTH_LONG).show();
        }

    }

    public void onDetach() {
        super.onDetach();
        this.mListener = null;
    }

    public void onFragmentInteraction(Context mContext) {
        popullateData();
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private class UserUpdate implements Callback<UpdateUserDetailsResult> {
        @Override
        public void onResponse(Call<UpdateUserDetailsResult> call, Response<UpdateUserDetailsResult> response) {
            if (((UpdateUserDetailsResult) response.body()).getUserRegistrationResult().getResponseCode().intValue() == 0) {
                progressDialog.dismiss();
                Toast.makeText(getContext(),"data saved",Toast.LENGTH_LONG).show();
            }
            else {
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
