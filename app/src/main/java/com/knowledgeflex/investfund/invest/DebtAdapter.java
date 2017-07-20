package com.knowledgeflex.investfund.invest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.knowledgeflex.investfund.Model.Scheme;
import com.knowledgeflex.investfund.R;

import java.util.List;

/**
 * Created by Vinoth on 2/1/2017.
 */

public class DebtAdapter extends BaseAdapter {

    private List<Scheme> bean;
    Context context;
    private LayoutInflater inflter;
    Debts delegate = null;
    String fund;

    class ViewHolder {
        private CheckBox checkBox;
    }


    public DebtAdapter(Context mcontext, List<Scheme> resource) {
        this.bean = resource;
        this.context = mcontext;
        this.inflter = LayoutInflater.from(context);
        delegate = (Debts)context;
    }

    public View getView(final int position, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.fund_house_list, viewGroup, false);
        final ViewHolder holder = new ViewHolder();
        //this.delegate = (AsyncResponse)mContext;
        holder.checkBox = (CheckBox) view.findViewById(R.id.checkboxName);

        holder.checkBox.setText(bean.get(position).getvClass());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                fund = holder.checkBox.getText().toString();
                if(b) {
                    String code = getCode(fund);
                    Log.e("code", code);
                    delegate.debtFinish(code);
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
            if(bean.get(i).getvClass().equals(fund)){
                code = bean.get(i).getvClassCode();
            }
        }

        return code;
    }

}

