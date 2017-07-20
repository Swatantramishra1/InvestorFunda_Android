package com.knowledgeflex.investfund.invest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.knowledgeflex.investfund.Model.Scheme;
import com.knowledgeflex.investfund.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CompareFundAdapter extends RecyclerView.Adapter<CompareFundAdapter.DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private List<Scheme> bean;
    //private static MyClickListener myClickListener;
    private Context context;
    String data[] = {"Select","Buy LumpSum","Buy SIP"};
    int count = 0;
    int no[] = new int[3];

    public CompareFundAdapter(CompareFund ourTopMutualFund, Context context, List<Scheme> listData) {
        this.context = context;
        this.bean = listData;
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder {
        ImageView analysis;
        TextView title;
        TextView nav;
        TextView returnYear;
        CheckBox selected;

        // TextView option;
       // Spinner select;
       // TextView rateCrisil;
        EditText amount;

        public DataObjectHolder(View itemView) {
            super(itemView);

            analysis = (ImageView) itemView.findViewById(R.id.analysis);
            title = (TextView) itemView.findViewById(R.id.title);
            nav = (TextView) itemView.findViewById(R.id.nav);
            returnYear = (TextView) itemView.findViewById(R.id.returnYear);
            selected = (CheckBox) itemView.findViewById(R.id.selected);
            //option = (TextView)itemView.findViewById(R.id.option);
            // rateCrisil = (TextView)itemView.findViewById(R.id.rateCrisil);
           // select = (Spinner)itemView.findViewById(R.id.select);
            amount = (EditText) itemView.findViewById(R.id.amount);
            Log.i(LOG_TAG, "Adding Listener");
            //itemView.setOnClickListener(this);
        }
    }

    @Override
    public CompareFundAdapter.DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.compare_list_fund, parent, false);
        CompareFundAdapter.DataObjectHolder dataObjectHolder = new CompareFundAdapter.DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(final CompareFundAdapter.DataObjectHolder holder, final int position) {
        holder.title.setText(bean.get(position).getSchemeName());
        //  holder.option.setText(bean.get(position).getSchemeOption());
        holder.nav.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(bean.get(position).getNav()))));
        holder.returnYear.setText(String.valueOf(new DecimalFormat("##.###").format(Double.parseDouble(bean.get(position).getReturn_3Yr()))));

           holder.selected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                            if(count<3) {
                                Log.e("postiion", count + " " + position);
                                no[count] = position;
                                if (count==2) {
                                    Log.e("postiion", count + " " + position);
                                    Intent intent = new Intent("custom-message");
                                    intent.putExtra("position", no);
                                    LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                                }
                                count = count + 1;
                            }
                            else {
                                holder.selected.setChecked(false);
                                Toast.makeText(context, "You can compare only there funds at time",Toast.LENGTH_LONG).show();
                            }
                        }
                         else {
                            if (count == 0) {
                                count = 0;
                            } else {
                                count = count-1;
                            }
                        }
                }
            });
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