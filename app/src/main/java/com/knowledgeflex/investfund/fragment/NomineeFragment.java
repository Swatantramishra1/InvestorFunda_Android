package com.knowledgeflex.investfund.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.Model.NomineeDetailsDatum;
import com.knowledgeflex.investfund.Model.NomineeTypeList;
import com.knowledgeflex.investfund.Model.RelationList;
import com.knowledgeflex.investfund.Model.UserDetailResponse;
import com.knowledgeflex.investfund.Portfolio.OnFragmentInteractionListener;
import com.knowledgeflex.investfund.Utils;
import com.knowledgeflex.investfund.adapter.NomineeAdapter;
import com.knowledgeflex.investfund.adapter.NomineeTypeListAdapter;
import com.knowledgeflex.investfund.adapter.RelationListAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class NomineeFragment extends Fragment implements OnFragmentInteractionListener {
    private Context mContext;
    private ListView nominee;
    private ArrayList<NomineeDetailsDatum> mNomineeData;
    private ArrayList<NomineeTypeList> mNomineeList;
    private ArrayList<RelationList> mRelationList;
    private Spinner mSpinRelationType;
    private Spinner mSpinRiskType;
    private UserDetailResponse mUserDetailResponse;
    private Spinner spnSelectRelationType;
    private String riskId;
    private String relation_Id;
    NomineeAdapter adapter;
    private FloatingActionButton fab;
    Dialog mBottomSheetDialog;
    private LayoutInflater inflter;
    String nomineeId[];
    String nomineeName[];
    String relationId[];
    String relationName[];

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNomineeData = new ArrayList<NomineeDetailsDatum>();
        mUserDetailResponse = new UserDetailResponse();
        mNomineeList = new ArrayList<NomineeTypeList>();
        mRelationList = new ArrayList<RelationList>();
        loadCachedData();
    }

    private void loadCachedData() {
        try {
            mUserDetailResponse = (UserDetailResponse) Utils.readObject(mContext, "UserDetails");
            mNomineeData = mUserDetailResponse.getGetUserProfileDetailsInfoResult().getResult().getNomineeDetailsData();
            mNomineeList = (ArrayList) Utils.readObject(this.mContext, "NomineeTypeList");
            mRelationList = (ArrayList) Utils.readObject(this.mContext, "RelationList");
            nomineeId = new String[mNomineeList.size()];
            nomineeName = new String[mNomineeList.size()];
            relationId = new String[mRelationList.size()];
            relationName = new String[mRelationList.size()];
            for(int i=0;i<mNomineeList.size();i++){
                nomineeId[i]=mNomineeList.get(i).getNomineeTypeID();
                nomineeName[i]=mNomineeList.get(i).getNomineeTypeValue();
            }
            for(int i=0;i<mRelationList.size();i++){
                relationId[i]=mRelationList.get(i).getRelationshipID();
                relationName[i]=mRelationList.get(i).getRelationToUser();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nominee_details, container, false);
        inflter = inflater;
        //mBaseLayout = (LinearLayout) view.findViewById(R.id.baseLayout);
      /*  if (mNomineeData != null) {*/
        // LayoutInflater inflat = LayoutInflater.from(this.mContext);
        // for (int index = 0; index < this.mNomineeData.size(); index++) {
        /// View nomineeView = inflat.inflate(R.layout.nominee_layout_item, null);
        fab = (FloatingActionButton)view.findViewById(R.id.fab);
        nominee = (ListView)view.findViewById(R.id.nominee_list);
        adapter = new NomineeAdapter(getContext(),mNomineeData, nomineeId, nomineeName, relationId, relationName);
        nominee.setAdapter(adapter);
        nominee.setDivider(null);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, NomineeUpdate.class);
                i.putExtra("name","");
                i.putExtra("dob","");
                i.putExtra("relation","");
                i.putExtra("relationId","");
                i.putExtra("type","");
                i.putExtra("nomineeId","");
                i.putExtra("alloc","");
               /* i.putExtra("nominee",mNomineeList);
                i.putExtra("relation",mRelationList);*/
                i.putExtra("nId",nomineeId);
                i.putExtra("nName",nomineeName);
                i.putExtra("rId",relationId);
                i.putExtra("rName",relationName);
                mContext.startActivity(i);
                //  Toast.makeText(getContext(),"Data",Toast.LENGTH_LONG).show();
                   /* fab.setVisibility(View.GONE);
                    nominee.setVisibility(View.GONE);
                    openCheckMarkBottomSheet();*/
            }
        });
        //}
        return view;
    }

    private void updateUI() {

            /*this.mEditName = (EditText) nomineeView.findViewById(R.id.accountName);
            this.mEdittDob = (EditText) nomineeView.findViewById(R.id.etDOB);
            this.mEditAlloc = (EditText) nomineeView.findViewById(R.id.alloc);
            this.save = (Button) nomineeView.findViewById(R.id.nominee_save);
            this.mSpinRelationType = (Spinner) nomineeView.findViewById(R.id.spnSelectRelationType);
            this.mSpinRiskType = (Spinner) nomineeView.findViewById(R.id.spnRiskType);
            this.spnSelectRelationType = (Spinner) nomineeView.findViewById(R.id.spnSelectRelationType);*/
           /* this.mEditName.setText(((NomineeDetailsDatum) this.mNomineeData.get(index)).getNomineeName());
            this.mEdittDob.setText(((NomineeDetailsDatum) this.mNomineeData.get(index)).getNomineeDOB());
            this.mEditAlloc.setText(((NomineeDetailsDatum) this.mNomineeData.get(index)).getNomineeAllocationPercentage());
            this.mSpinRiskType.setAdapter(new NomineeTypeListAdapter(this.mContext, this.mNomineeList));
            this.mSpinRelationType.setAdapter(new RelationListAdapter(this.mContext, this.mRelationList));*/
          /*  mSpinRelationType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Object branch = mSpinRelationType.getSelectedItem();
                    Gson gson = new Gson();
                    String json = gson.toJson(branch);
                    Log.e("json",json);
                    try {
                        JSONObject jsonobject = new JSONObject(json);
                        relationId = jsonobject.getString("Relationship_ID");
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                        Log.e("Error", e1.toString());
                    }
                //    Log.e("Nominee_Relationship_ID", relationId);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            mSpinRiskType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Object branch = mSpinRiskType.getSelectedItem();
                    Gson gson = new Gson();
                    String json = gson.toJson(branch);
                    Log.e("json",json);
                    try {
                        JSONObject jsonobject = new JSONObject(json);
                        riskId = jsonobject.getString("NomineeTypeValue");
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                        Log.e("Error", e1.toString());
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });*/
            /*save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("name",mEditName.getText().toString());
                    Log.e("name",mEditAlloc.getText().toString());
                    Log.e("Nominee_Relationship_ID", relationId);
                    Log.e("spnSelectRelationType", riskId);
                }
            });*/

        // mBaseLayout.addView(nomineeView);
    }
    //}

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onFragmentInteraction(Context mContext) {
        this.mContext = mContext;
//        mBaseLayout.removeAllViews();
        loadCachedData();
       /* if (this.mNomineeData != null) {
            updateUI();
        }*/
    }

    /*private void openCheckMarkBottomSheet() {
        View view = inflter.inflate(R.layout.nominee_layout_item, null);
        mEditName = (EditText) view.findViewById(R.id.accountName);
        mEdittDob = (EditText) view.findViewById(R.id.etDOB);
        mEditAlloc = (EditText) view.findViewById(R.id.alloc);
        save = (Button) view.findViewById(R.id.nominee_save);
        cancel = (Button) view.findViewById(R.id.nominee_cancel);
        mSpinRelationType = (Spinner) view.findViewById(R.id.spnSelectRelationType);
        mSpinRiskType = (Spinner) view.findViewById(R.id.spnRiskType);
        spnSelectRelationType = (Spinner) view.findViewById(R.id.spnSelectRelationType);

        mSpinRiskType.setAdapter(new NomineeTypeListAdapter(mContext, mNomineeList));
        mSpinRelationType.setAdapter(new RelationListAdapter(mContext, mRelationList));
        mSpinRelationType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object branch = mSpinRelationType.getSelectedItem();
                Gson gson = new Gson();
                String json = gson.toJson(branch);
                Log.e("json",json);
                try {
                    JSONObject jsonobject = new JSONObject(json);
                    rId = jsonobject.getString("Relationship_ID");
                } catch (JSONException e1) {
                    e1.printStackTrace();
                    Log.e("Error", e1.toString());
                }
                //    Log.e("Nominee_Relationship_ID", relationId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mSpinRiskType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object branch = mSpinRiskType.getSelectedItem();
                Gson gson = new Gson();
                String json = gson.toJson(branch);
                Log.e("json",json);
                try {
                    JSONObject jsonobject = new JSONObject(json);
                    riskId = jsonobject.getString("NomineeTypeValue");
                } catch (JSONException e1) {
                    e1.printStackTrace();
                    Log.e("Error", e1.toString());
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("name",mEditName.getText().toString());
                Log.e("name",mEditAlloc.getText().toString());
                Log.e("Nominee_Relationship_ID", relationId);
                Log.e("spnSelectRelationType", riskId);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.setVisibility(View.VISIBLE);
                nominee.setVisibility(View.VISIBLE);
                mBottomSheetDialog.dismiss();
            }
        });

        mBottomSheetDialog = new Dialog(getContext(), R.style.MaterialDialogSheetAnimation);
        mBottomSheetDialog.setContentView(view);
        mBottomSheetDialog.setCancelable(true);
        mBottomSheetDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottomSheetDialog.getWindow().setGravity(Gravity.CENTER);
        mBottomSheetDialog.show();
    }*/


}
