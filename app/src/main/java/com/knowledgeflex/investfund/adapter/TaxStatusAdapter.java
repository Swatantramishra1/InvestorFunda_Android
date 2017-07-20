package com.knowledgeflex.investfund.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.Model.Result;
import java.util.ArrayList;

public class TaxStatusAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflter;
    private ArrayList<Result> itemList;

    class ViewHolder {
        private TextView mName;

        ViewHolder() {
        }
    }

    public TaxStatusAdapter(Context context, ArrayList<Result> itemList) {
        this.context = context;
        this.itemList = itemList;
        this.inflter = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.itemList.size();
    }

    public Object getItem(int i) {
        return this.itemList.get(i);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View view, ViewGroup parent) {
        view = this.inflter.inflate(R.layout.custom_spinner_items, null);
        ViewHolder holder = new ViewHolder();
        holder.mName = (TextView) view.findViewById(R.id.name);
        if (((Result) this.itemList.get(position)).getTaxStatusName() != null) {
            holder.mName.setText(((Result) this.itemList.get(position)).getTaxStatusName());
        }
        return view;
    }
}
