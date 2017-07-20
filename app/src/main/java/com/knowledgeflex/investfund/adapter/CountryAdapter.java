package com.knowledgeflex.investfund.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.knowledgeflex.investfund.Model.Result;
import com.knowledgeflex.investfund.R;

import java.util.ArrayList;

public class CountryAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflter;
    private ArrayList<Result> itemList;
    private ArrayList<Result> itemListTest;

    class ViewHolder {
        private TextView mName;

        ViewHolder() {
        }
    }

    public CountryAdapter(Context context, ArrayList<Result> itemList) {
        this.context = context;
        this.itemList = itemList;
        this.inflter = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.itemList.size();
    }

    public Result getItem(int i) {
        return (Result) this.itemList.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        view = this.inflter.inflate(R.layout.custom_spinner_items, null);
        ViewHolder holder = new ViewHolder();
        holder.mName = (TextView) view.findViewById(R.id.name);
        if (((Result) this.itemList.get(position)).getCountryName() != null) {
            holder.mName.setText(((Result) this.itemList.get(position)).getCountryName().toString());
        } else if (((Result) this.itemList.get(position)).getState_Name() != null) {
            holder.mName.setText(((Result) this.itemList.get(position)).getState_Name().toString());
        } else if (((Result) this.itemList.get(position)).getCityName() != null) {
            holder.mName.setText(((Result) this.itemList.get(position)).getCityName().toString());
        } else if (((Result) this.itemList.get(position)).getTaxStatusName() != null) {
            holder.mName.setText(((Result) this.itemList.get(position)).getTaxStatusName().toString());
        } else if (((Result) this.itemList.get(position)).getHoldingNatureName() != null) {
            holder.mName.setText(((Result) this.itemList.get(position)).getHoldingNatureName().toString());
        } else if (((Result) this.itemList.get(position)).getSourceOfWealthName() != null) {
            holder.mName.setText(((Result) this.itemList.get(position)).getSourceOfWealthName().toString());
        }
        return view;
    }
}
