package com.knowledgeflex.investfund.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.knowledgeflex.investfund.Model.NomineeDetailsDatum;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.fragment.NomineeUpdate;

import java.util.ArrayList;

public class NomineeAdapter extends BaseAdapter {

    private String n_name;
    private String n_dob;
    private String n_relation;
    private String n_relationId;
    private String n_type;
    private String n_allocation;
    private String nomineeId;
    private Context mContext;
    private ArrayList<NomineeDetailsDatum> mNomineeDataOne;

    private LayoutInflater inflter;
    String nominee_Id[];
    String nomineeName[];
    String relationId[];
    String relationName[];


    class ViewHolder {
        private TextView name;
        private TextView dob;
        private TextView relation;
        private TextView type;
        private TextView allocation;
        private LinearLayout update;
    }

    public NomineeAdapter(Context context, ArrayList<NomineeDetailsDatum> mNomineeData, String[] nomineeId, String[] nomineeName, String[] relationId, String[] relationName) {
        this.mContext = context;
        this.mNomineeDataOne = mNomineeData;
        this.nominee_Id = nomineeId;
        this.nomineeName = nomineeName;
        this.relationId =relationId;
        this.relationName = relationName;
        this.inflter = LayoutInflater.from(mContext);
    }

    public View getView(final int position, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.nominee_text_view, null);

        ViewHolder holder = new ViewHolder();
        //this.delegate = (AsyncResponse)mContext;
        holder.name = (TextView) view.findViewById(R.id.nameNaminee);
        holder.dob = (TextView) view.findViewById(R.id.nominee_dob);
        holder.relation = (TextView) view.findViewById(R.id.relationship);
        holder.type = (TextView) view.findViewById(R.id.selectType);
        holder.allocation = (TextView) view.findViewById(R.id.allocation);
        holder.update = (LinearLayout) view.findViewById(R.id.update);
       // holder.edit = (TextView) view.findViewById(R.id.edit);

            n_name = ((NomineeDetailsDatum) this.mNomineeDataOne.get(position)).getNomineeName().toString();
            holder.name.setText(n_name);
            n_dob = ((NomineeDetailsDatum) this.mNomineeDataOne.get(position)).getNomineeDOB().toString();
            holder.dob.setText(n_dob);
            n_relation = ((NomineeDetailsDatum) this.mNomineeDataOne.get(position)).getNomineeRelationship().toString();
            n_relationId = ((NomineeDetailsDatum) this.mNomineeDataOne.get(position)).getNomineeRelationshipId().toString();
            holder.relation.setText(n_relation);
            n_type = ((NomineeDetailsDatum) this.mNomineeDataOne.get(position)).getNomineeRiskType().toString();
            holder.type.setText(n_type);
            n_allocation = ((NomineeDetailsDatum) this.mNomineeDataOne.get(position)).getNomineeAllocationPercentage().toString();
            holder.allocation.setText(n_allocation);
            nomineeId = ((NomineeDetailsDatum) this.mNomineeDataOne.get(position)).getUrNomineeId().toString();

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mNomineeDataOne!=null) {
                    n_name = ((NomineeDetailsDatum) mNomineeDataOne.get(position)).getNomineeName().toString();
                    n_dob = ((NomineeDetailsDatum) mNomineeDataOne.get(position)).getNomineeDOB().toString();
                    n_relation = ((NomineeDetailsDatum) mNomineeDataOne.get(position)).getNomineeRelationship().toString();
                    n_relationId = ((NomineeDetailsDatum) mNomineeDataOne.get(position)).getNomineeRelationshipId().toString();
                    n_type = ((NomineeDetailsDatum) mNomineeDataOne.get(position)).getNomineeRiskType().toString();
                    n_allocation = ((NomineeDetailsDatum) mNomineeDataOne.get(position)).getNomineeAllocationPercentage().toString();
                    nomineeId = ((NomineeDetailsDatum) mNomineeDataOne.get(position)).getUrNomineeId().toString();

                    Intent i = new Intent(mContext, NomineeUpdate.class);
                    i.putExtra("name", n_name);
                    i.putExtra("dob", n_dob);
                    i.putExtra("relation", n_relation);
                    i.putExtra("relationId", n_relationId);
                    i.putExtra("type", n_type);
                    i.putExtra("nomineeId", nomineeId);
                    i.putExtra("alloc", n_allocation);
                    i.putExtra("nId", nominee_Id);
                    i.putExtra("nName", nomineeName);
                    i.putExtra("rId", relationId);
                    i.putExtra("rName", relationName);
                    mContext.startActivity(i);
                }
                else {
                    Log.e("Position", String.valueOf(position));
                    Log.e("No use", "Layout");

                }
            }
        });

        return view;
    }

    public int getCount() {
        return this.mNomineeDataOne.size();
    }

    public NomineeDetailsDatum getItem(int i) {
        return (NomineeDetailsDatum) this.mNomineeDataOne.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

  /*  @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.update:

                break;
        }
    }*/


}
