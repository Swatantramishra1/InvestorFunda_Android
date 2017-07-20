package com.knowledgeflex.investfund.invest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.knowledgeflex.investfund.R;

import java.util.List;

/**
 * Created by Vinoth on 6/30/2017.
 */

public class OurTopFilterAdapter extends ArrayAdapter {

    private int selectedPos = -1;
    Context context;

    public OurTopFilterAdapter(Context context, int textViewResourceId,List objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
    }
    public void setSelectedPosition(int pos){selectedPos = pos;
        notifyDataSetChanged();
    }
    public int getSelectedPosition(){
        return selectedPos;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        // only inflate the view if it's null
        // if (v == null) {
        LayoutInflater vi =   (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = vi.inflate(R.layout.our_top_filter, null);
        //  }

        // get text view
        TextView label = (TextView)v.findViewById(R.id.mType);
        RelativeLayout content = (RelativeLayout)v.findViewById(R.id.typeContent);

        // change the row color based on selected state
        if(selectedPos == position){
            label.setBackgroundColor(Color.CYAN);
        }
        else{
            label.setBackgroundColor(Color.WHITE);
        }

        label.setText(this.getItem(position).toString());
        return(v);
    }
}