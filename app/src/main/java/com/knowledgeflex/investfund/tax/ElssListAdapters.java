package com.knowledgeflex.investfund.tax;

import android.app.Activity;
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
import android.widget.Spinner;
import android.widget.TextView;

import com.knowledgeflex.investfund.Model.Scheme;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.invest.FilterPage;
import com.knowledgeflex.investfund.utils.FundDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinoth on 3/19/2017.
 */

public class ElssListAdapters extends RecyclerView
        .Adapter<ElssListAdapters
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private List<Scheme> bean;
    private static ElssListAdapters.MyClickListener myClickListener;
    private Context context;
    String data[] = {"Select","Buy LumpSum","Buy SIP"};

    public ElssListAdapters(ElssTaxSavings allMutualFunds, Context context, List<Scheme> schemeResult) {
        this.context = context;
        this.bean = schemeResult;
    }

    public ElssListAdapters(FilterPage filterPage, Context context, List<Scheme> schemeResult) {
        this.context = filterPage;
        this.bean = schemeResult;
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
       // ImageView analysis;
        TextView title;
       // TextView nav;
        //TextView returnYear;
        TextView option;
        Spinner select;
       // TextView rateCrisil;
        EditText amount;

        public DataObjectHolder(View itemView) {
            super(itemView);

           // analysis = (ImageView) itemView.findViewById(R.id.analysis);
            title = (TextView) itemView.findViewById(R.id.title);
           // nav = (TextView) itemView.findViewById(R.id.nav);
           // returnYear = (TextView) itemView.findViewById(R.id.returnYear);
            option = (TextView) itemView.findViewById(R.id.option);
          //  rateCrisil = (TextView) itemView.findViewById(R.id.rateCrisil);
            select = (Spinner) itemView.findViewById(R.id.select);
            amount = (EditText) itemView.findViewById(R.id.amount);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // myClickListener.onItemClick(getAdapterPosition(), v);
        }

    }

    public void setOnItemClickListener(ElssListAdapters.MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public ElssListAdapters(Activity activity, Context context, ArrayList<Scheme> bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public ElssListAdapters.DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elss_text, parent, false);

        ElssListAdapters.DataObjectHolder dataObjectHolder = new ElssListAdapters.DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(final ElssListAdapters.DataObjectHolder holder, final int position) {

        holder.title.setText(bean.get(position).getSchemeName());
        holder.option.setText(bean.get(position).getSchemeOption());
      //  holder.nav.setText(bean.get(position).getNav());
        //holder.returnYear.setText(bean.get(position).getReturn_3Yr());
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, data);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.select.setAdapter(dataAdapter);

        holder.select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String type = data[i];
                if(!TextUtils.isEmpty(holder.amount.getText().toString())) {
                    showDialog(type, bean.get(position),holder.amount.getText().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private synchronized void showDialog(String type, Scheme scheme, String amount) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("scheme", scheme);
        Intent i = new Intent(context, FundDialog.class);
        i.putExtras(bundle);
        i.putExtra("amount",amount);
        i.putExtra("type",type);
        i.putExtra("no","2");
        context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        return bean.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);

    }
}
