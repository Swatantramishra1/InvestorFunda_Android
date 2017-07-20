package com.knowledgeflex.investfund.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.knowledgeflex.investfund.R;

public class DepositoryDetail extends Fragment {

    Spinner client;
    Spinner depository;
    private String clientType[] = {"Select","PHYSICAL","DEMAT"};
    private String name[] = {"Select","CDSL","NDSL"};
    EditText csdlNo;
    EditText dsdl_Id;
    EditText nsdlNo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_depository_detail, container, false);
        if (view != null) {
            client = (Spinner) view.findViewById(R.id.clientType);
            depository = (Spinner) view.findViewById(R.id.depositoryName);
            dsdl_Id = (EditText) view.findViewById(R.id.nsdldp_ID);
            nsdlNo = (EditText) view.findViewById(R.id.nsdl_ben);
            csdlNo = (EditText) view.findViewById(R.id.cdsl_ben);
            ArrayAdapter<String> payAdapter = new ArrayAdapter<String>(getContext(), R.layout.gender_text, clientType);
            payAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            client.setAdapter(payAdapter);
            client.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String branch = client.getSelectedItem().toString();
                        if(branch.equals("PHYSICAL")){
                            csdlNo.setVisibility(View.GONE);
                            dsdl_Id.setVisibility(View.GONE);
                            nsdlNo.setVisibility(View.GONE);
                            depository.setVisibility(View.GONE);
                        }
                    else {
                            csdlNo.setVisibility(View.VISIBLE);
                            dsdl_Id.setVisibility(View.VISIBLE);
                            nsdlNo.setVisibility(View.VISIBLE);
                            depository.setVisibility(View.VISIBLE);
                        }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            ArrayAdapter<String> communicationAdapter = new ArrayAdapter<String>(getContext(), R.layout.gender_text, name);
            communicationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            depository.setAdapter(communicationAdapter);
            depository.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
        return view;
    }

}
