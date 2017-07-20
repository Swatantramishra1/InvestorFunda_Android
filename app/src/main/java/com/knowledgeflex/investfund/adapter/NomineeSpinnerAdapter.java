package com.knowledgeflex.investfund.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.knowledgeflex.investfund.Model.NomineeTypeList;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.fragment.NomineeUpdate;

public class NomineeSpinnerAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflter;
    String nomineeId[];
    String nomineeName[];

    public NomineeSpinnerAdapter(NomineeUpdate nomineeUpdate, String[] nominee_id, String[] nominee_name) {
        this.context = nomineeUpdate;
        this.nomineeId = nominee_id;
        this.nomineeName = nominee_name;
        this.inflter = LayoutInflater.from(context);
    }

    class ViewHolder {
        private TextView mName;

        ViewHolder() {
        }
    }

    public int getCount() {
        return nomineeId.length;
    }

    @Override
    public Object getItem(int position) {
        return nomineeId[position];
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        view = this.inflter.inflate(R.layout.custom_spinner_items, null);
        ViewHolder holder = new ViewHolder();
        holder.mName = (TextView) view.findViewById(R.id.name);
        if ( nomineeName[position] != null) {
            holder.mName.setText(nomineeName[position]);
        }
        return view;
    }
}
