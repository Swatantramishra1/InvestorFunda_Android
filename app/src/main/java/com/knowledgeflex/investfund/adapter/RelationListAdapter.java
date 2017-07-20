package com.knowledgeflex.investfund.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.Model.RelationList;
import java.util.ArrayList;

public class RelationListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflter;
    private ArrayList<RelationList> itemList;

    class ViewHolder {
        private TextView mName;

        ViewHolder() {
        }
    }

    public RelationListAdapter(Context context, ArrayList<RelationList> itemList) {
        this.context = context;
        this.itemList = itemList;
        this.inflter = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.itemList.size();
    }

    public RelationList getItem(int i) {
        return (RelationList) this.itemList.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        view = this.inflter.inflate(R.layout.custom_spinner_items, null);
        ViewHolder holder = new ViewHolder();
        holder.mName = (TextView) view.findViewById(R.id.name);
        if (((RelationList) this.itemList.get(position)).getRelationToUser() != null) {
            holder.mName.setText(((RelationList) this.itemList.get(position)).getRelationToUser());
        }
        return view;
    }
}
