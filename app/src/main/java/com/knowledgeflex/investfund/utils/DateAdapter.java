package com.knowledgeflex.investfund.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.knowledgeflex.investfund.R;

/**
 * Created by Vinoth on 7/13/2017.
 */

public class DateAdapter extends BaseAdapter {
    private Context mContext;
    private String[] value;

    // Constructor
    public DateAdapter(Context c, String[] dataValue) {
        mContext = c;
        this.value = dataValue;
    }

    public int getCount() {
        return value.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        View grid = null;
        LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        if (convertView != null) {
            return convertView;
        }
        grid = inflater.inflate(R.layout.grid_single,parent, false);
        ((TextView) grid.findViewById(R.id.grid_text)).setText(value[position]);
        RelativeLayout linearLayout = (RelativeLayout) grid.findViewById(R.id.dateNumberLayout);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",value[position]);
                ((Activity) mContext).setResult(Activity.RESULT_OK,returnIntent);
                ((Activity) mContext).finish();
            }
        });
        return grid;
    }


}
