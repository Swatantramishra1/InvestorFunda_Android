package com.knowledgeflex.investfund.invest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.knowledgeflex.investfund.Model.Scheme;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.utils.FundDialog;

import java.util.List;

public class OurTopMutualAdapters extends RecyclerView
        .Adapter<OurTopMutualAdapters
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private List<OurFund> bean;
    //private static MyClickListener myClickListener;
    private Context context;
    String data[] = {"Select","Buy LumpSum","Buy SIP"};
    String compare;

     public OurTopMutualAdapters(OurTopMutualFund ourTopMutualFund, Context context, List<OurFund> listData,String compare) {
         this.context = context;
         this.bean = listData;
         this.compare =compare;
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder {
      //  ImageView analysis;
        TextView title;
       // TextView nav;
      //  TextView returnYear;
      //  TextView option;
        Spinner select;
        //  TextView rateCrisil;
        EditText amount;

        public DataObjectHolder(View itemView) {
            super(itemView);

          //  analysis = (ImageView) itemView.findViewById(R.id.analysis);
            title = (TextView) itemView.findViewById(R.id.title);
         //   nav = (TextView) itemView.findViewById(R.id.nav);
          //  returnYear = (TextView) itemView.findViewById(R.id.returnYear);
          //  option = (TextView)itemView.findViewById(R.id.option);
            //  rateCrisil = (TextView)itemView.findViewById(R.id.rateCrisil);
            select = (Spinner)itemView.findViewById(R.id.select);
            amount = (EditText) itemView.findViewById(R.id.amount);
            Log.i(LOG_TAG, "Adding Listener");
            //itemView.setOnClickListener(this);
        }

    }

    @Override
    public OurTopMutualAdapters.DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.our_list_fund, parent, false);

        OurTopMutualAdapters.DataObjectHolder dataObjectHolder = new OurTopMutualAdapters.DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(final OurTopMutualAdapters.DataObjectHolder holder, final int position) {

            holder.title.setText(bean.get(position).getSchemeName());
            //  holder.option.setText(bean.get(position).getSchemeOption());
            //   holder.nav.setText(String.valueOf(new DecimalFormat("##.##").format(Double.parseDouble(bean.get(position).getNav()))));
            //   holder.returnYear.setText(String.valueOf(new DecimalFormat("##.##").format(Double.parseDouble(bean.get(position).getReturn_3Yr()))));
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, data);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            holder.select.setAdapter(dataAdapter);

            holder.select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String type = data[i];
                    if (!TextUtils.isEmpty(holder.amount.getText().toString())) {
                        showDialog(type, bean.get(position),holder.amount.getText().toString());
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
    }


    private synchronized void showDialog(String type, OurFund scheme, String amount) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("OurFund", scheme);
        Intent i = new Intent(context, FundDialog.class);
        i.putExtras(bundle);
        i.putExtra("amount",amount);
        i.putExtra("type",type);
        i.putExtra("no","1");
        context.startActivity(i);
    }


   /* private synchronized void showDialog(String type) {
        Intent i = new Intent(context, FundDialog.class);
        context.startActivity(i);
    }*/

    @Override
    public int getItemCount() {
        return bean.size();
    }

  /*  public interface MyClickListener {
        public void onItemClick(int position, View v);

    }*/

}