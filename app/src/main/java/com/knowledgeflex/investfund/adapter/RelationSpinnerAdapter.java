package com.knowledgeflex.investfund.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.knowledgeflex.investfund.Model.RelationList;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.fragment.NomineeUpdate;

import java.util.ArrayList;

/**
 * Created by Vinoth on 1/9/2017.
 */

public class RelationSpinnerAdapter extends BaseAdapter{

    private Context context;
    private LayoutInflater inflter;
    String relationId[];
    String relationName[];

    public RelationSpinnerAdapter(NomineeUpdate nomineeUpdate, String[] relation_id, String[] relationName) {
        this.context = nomineeUpdate;
        this.relationId = relation_id;
        this.relationName = relationName;
        this.inflter = LayoutInflater.from(context);
    }

    class ViewHolder {
        private TextView mName;

        ViewHolder() {
        }
    }

    @Override
    public int getCount() {
        return relationId.length;
    }

    @Override
    public Object getItem(int position) {
        return relationId[position];
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        view = this.inflter.inflate(R.layout.custom_spinner_items, null);
        ViewHolder holder = new ViewHolder();
        holder.mName = (TextView) view.findViewById(R.id.name);
        if ( relationName[position] != null) {
            holder.mName.setText(relationName[position]);
        }
        return view;
    }
}
