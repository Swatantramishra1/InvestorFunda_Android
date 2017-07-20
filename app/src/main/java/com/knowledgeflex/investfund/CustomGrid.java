package com.knowledgeflex.investfund;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGrid extends BaseAdapter {
    private final int[] Imageid;
    private Context mContext;
    private final String[] web;

    public CustomGrid(Context c, String[] web, int[] Imageid) {
        this.mContext = c;
        this.Imageid = Imageid;
        this.web = web;
    }

    public int getCount() {
        return this.web.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        if (convertView != null) {
            return convertView;
        }
        View grid = new View(this.mContext);
        grid = inflater.inflate(R.layout.grid_single, null);
       // ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
        ((TextView) grid.findViewById(R.id.grid_text)).setText(this.web[position]);
     //   imageView.setImageResource(Imageid[position]);
        return grid;
    }
}
