package com.knowledgeflex.investfund.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.Model.NomineeTypeList;
import java.util.ArrayList;

public class NomineeTypeListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflter;
    private ArrayList<NomineeTypeList> itemList;

    class ViewHolder {
        private TextView mName;

        ViewHolder() {
        }
    }

    public NomineeTypeListAdapter(Context context, ArrayList<NomineeTypeList> itemList) {
        this.context = context;
        this.itemList = itemList;
        this.inflter = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.itemList.size();
    }

    public NomineeTypeList getItem(int i) {
        return (NomineeTypeList) this.itemList.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        view = this.inflter.inflate(R.layout.custom_spinner_items, null);
        ViewHolder holder = new ViewHolder();
        holder.mName = (TextView) view.findViewById(R.id.name);
        if (((NomineeTypeList) this.itemList.get(position)).getNomineeTypeValue() != null) {
            holder.mName.setText(((NomineeTypeList) this.itemList.get(position)).getNomineeTypeValue());
        }
        return view;
    }
}
