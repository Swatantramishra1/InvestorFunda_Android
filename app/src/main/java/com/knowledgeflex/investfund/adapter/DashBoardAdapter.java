package com.knowledgeflex.investfund.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.knowledgeflex.investfund.DashBoard;
import com.knowledgeflex.investfund.Model.ResultSchemeData;
import com.knowledgeflex.investfund.Model.UserInvestmentSchemeDetailsData;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.Utils;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Vinoth on 6/22/2017.
 */

public class DashBoardAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflter;
   // private ArrayList<UserInvestmentSchemeDetailsData> itemList;
    int count=0;
    String[] name;
    double[] units;
    double[] cNav;
    double[] amountTotal;
    String[] folio;
    TextView currentValue;
    TextView profitLoss;
    double value = 0.0;
    double profits = 0.0;

    public DashBoardAdapter(DashBoard dashBoard, String[] name, double[] units, double[] cNav, double[] amountTotal, String[] folio, TextView currentValue, TextView profitLoss) {
        this.context = dashBoard;
        this.name = name;
        this.units = units;
        this.cNav = cNav;
        this.amountTotal = amountTotal;
        this.folio = folio;
        this.inflter = LayoutInflater.from(context);
        this.currentValue = currentValue;
        this.profitLoss = profitLoss;
    }

    class ViewHolder {
        private TextView profit;
        private TextView unit;
        private TextView name;
        private TextView show;
        private TextView nav;
        private TextView value;
        private TextView total;
        RelativeLayout showLayout;

        ViewHolder() {
        }
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public String getItem(int i) {
        return name[i];
    }

    public long getItemId(int i) {
        return (long) i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = this.inflter.inflate(R.layout.dash_board_list, null);
        final ViewHolder holder = new ViewHolder();
        holder.profit = (TextView)view.findViewById(R.id.profitLoss);
        holder.unit = (TextView)view.findViewById(R.id.unitsCost);
        holder.name = (TextView)view.findViewById(R.id.schemeName);
        holder.show = (TextView)view.findViewById(R.id.show);
        holder.nav = (TextView)view.findViewById(R.id.navCost);
        holder.value = (TextView)view.findViewById(R.id.valueCost);
        holder.total = (TextView)view.findViewById(R.id.totalCost);
        holder.showLayout = (RelativeLayout)view.findViewById(R.id.showLayout);
        holder.profit.setTypeface(Utils.returnPtSansFont(context));
        holder.unit.setTypeface(Utils.returnPtSansFont(context));
        holder.name.setTypeface(Utils.returnPtSansFont(context));
        holder.show.setTypeface(Utils.returnPtSansFont(context));
        holder.nav.setTypeface(Utils.returnPtSansFont(context));
        holder.value.setTypeface(Utils.returnPtSansFont(context));
        holder.total.setTypeface(Utils.returnPtSansFont(context));
        holder.unit.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(units[position])));
        holder.name.setText(name[position]);
        //holder.show.setText("");
        holder.nav.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(cNav[position])));
        double c_value = units[position] * cNav[position];
        holder.value.setText(String.valueOf(new DecimalFormat("##,##,##,###.###").format(c_value)));
        double profit = c_value - amountTotal[position];
        holder.profit.setText(new DecimalFormat("##,##,##,###.###").format(profit));
        holder.total.setText(new DecimalFormat("##,##,##,###.###").format(amountTotal[position]));
        holder.show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count==0){
                    holder.showLayout.setVisibility(View.VISIBLE);
                    holder.show.setText("HIDE");
                    count = 1;
                }
                else if(count==1){
                    holder.showLayout.setVisibility(View.GONE);
                    holder.show.setText("SHOW");
                    count = 0;
                }
            }
        });
        if(name.length-1==position){
            value = value + c_value;
            profits = profits + profit;
            currentValue.setText(new DecimalFormat("##,##,##,###.###").format(value));
            profitLoss.setText(new DecimalFormat("##,##,##,###.###").format(profits));
        }
        else {
            value = value + c_value;
            profits = profits + profit;
        }

        return view;
    }
}
