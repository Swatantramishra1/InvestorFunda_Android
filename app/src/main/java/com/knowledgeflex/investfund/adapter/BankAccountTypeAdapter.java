package com.knowledgeflex.investfund.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.knowledgeflex.investfund.Model.BankAccountType;
import com.knowledgeflex.investfund.R;

import java.util.ArrayList;

public class BankAccountTypeAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflter;
    private ArrayList<BankAccountType> itemList;

    class ViewHolder {
        private TextView mName;

        ViewHolder() {
        }
    }

    public BankAccountTypeAdapter(Context context, ArrayList<BankAccountType> itemList) {
        this.context = context;
        this.itemList = itemList;
        this.inflter = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.itemList.size();
    }

    public BankAccountType getItem(int i) {
        return (BankAccountType) this.itemList.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        view = this.inflter.inflate(R.layout.custom_spinner_items, null);
        ViewHolder holder = new ViewHolder();
        holder.mName = (TextView) view.findViewById(R.id.name);
        if (((BankAccountType) this.itemList.get(position)).getAccountType() != null) {
            holder.mName.setText(((BankAccountType) this.itemList.get(position)).getAccountType());
        }
        return view;
    }
}
