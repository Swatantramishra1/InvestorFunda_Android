package com.knowledgeflex.investfund.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.knowledgeflex.investfund.Model.BankList;
import com.knowledgeflex.investfund.R;

import java.util.ArrayList;

public class BankListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflter;
    private ArrayList<BankList> itemList;

    class ViewHolder {
        private TextView mName;

        ViewHolder() {
        }
    }

    public BankListAdapter(Context context, ArrayList<BankList> itemList) {
        this.context = context;
        this.itemList = itemList;
        this.inflter = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.itemList.size();
    }

    public BankList getItem(int i) {
        return (BankList) this.itemList.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        view = this.inflter.inflate(R.layout.custom_spinner_items, null);
        ViewHolder holder = new ViewHolder();
        holder.mName = (TextView) view.findViewById(R.id.name);
        if (((BankList) this.itemList.get(position)).getBankName() != null) {
            holder.mName.setText(((BankList) this.itemList.get(position)).getBankName());
        }
        return view;
    }
}
