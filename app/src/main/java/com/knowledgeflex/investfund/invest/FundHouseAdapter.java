package com.knowledgeflex.investfund.invest;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.knowledgeflex.investfund.Model.NomineeDetailsDatum;
import com.knowledgeflex.investfund.Model.Scheme;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.adapter.NomineeAdapter;
import com.knowledgeflex.investfund.fragment.NomineeUpdate;

import java.util.List;


public class FundHouseAdapter extends BaseAdapter {

    private List<Scheme> bean;
    Context context;
    private LayoutInflater inflter;
    House delegate = null;
    String fund;

    class ViewHolder {
        private CheckBox checkBox;
    }


    public FundHouseAdapter(Context mcontext, List<Scheme> resource) {
        this.bean = resource;
        this.context = mcontext;
        this.inflter = LayoutInflater.from(context);
        delegate = (House)context;
    }

    public View getView(final int position, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.fund_house_list, viewGroup, false);
        final ViewHolder holder = new ViewHolder();
        //this.delegate = (AsyncResponse)mContext;
        holder.checkBox = (CheckBox) view.findViewById(R.id.checkboxName);

        holder.checkBox.setText(bean.get(position).getFundName());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                fund = holder.checkBox.getText().toString();
                if(b) {
                    String code = getCode(fund);
                    Log.e("code", code);
                    delegate.houseFinish(code);
                }
            }
        });
        return view;
    }

    public int getCount() {
        return bean.size();
    }

    public Scheme getItem(int i) {
        return bean.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    private synchronized String getCode(String fund) {
        String code = "";
        for (int i=0;i<bean.size();i++){
            if(bean.get(i).getFundName().equals(fund)){
                code = bean.get(i).getMf_code();
            }
        }

        return code;
    }

}
