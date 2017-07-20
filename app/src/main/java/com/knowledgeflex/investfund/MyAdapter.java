package com.knowledgeflex.investfund;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends Adapter<MyAdapter.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private String email;
    private OnItemClickListener listener;
    private Context mContext;
    private String[] mNavTitles;
    private String name;
    private int profile;

    /* renamed from: com.ramation.foldingcell.examples.indiainvest.MyAdapter.1 */
    class C02761 implements OnClickListener {
        final /* synthetic */ int val$position;

        C02761(int i) {
            this.val$position = i;
        }

        public void onClick(View v) {
            MyAdapter.this.listener.onItemClick(this.val$position, v);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int i, View view);
    }

    public static class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        int Holderid;
        TextView Name;
        TextView email;
        TextView edit;
        ImageView profile;
        TextView textView;

        public ViewHolder(View itemView, int ViewType) {
            super(itemView);
            if (ViewType == MyAdapter.TYPE_ITEM) {
                this.textView = (TextView) itemView.findViewById(R.id.rowText);
                this.Holderid = MyAdapter.TYPE_ITEM;
                return;
            }
            this.Name = (TextView) itemView.findViewById(R.id.name);
            this.email = (TextView) itemView.findViewById(R.id.email);
            this.profile = (ImageView) itemView.findViewById(R.id.profileImage);
            this.edit = (TextView) itemView.findViewById(R.id.edit);
            this.Holderid = MyAdapter.TYPE_HEADER;
        }
    }

    MyAdapter(String[] Titles, String Name, String Email, int Profile, OnItemClickListener listener, Context context) {
        this.mNavTitles = Titles;
        this.mContext = context;
        this.name = Name;
        this.email = Email;
        this.profile = Profile;
        this.listener = listener;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false), viewType);
        }
        if (viewType == 0) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false), viewType);
        }
        return null;
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder.Holderid == TYPE_ITEM) {
            holder.textView.setText(this.mNavTitles[position - 1]);
            holder.textView.setTypeface(Utils.returnPtSansFont(this.mContext));
            holder.textView.setOnClickListener(new C02761(position));
            return;
        }
        holder.profile.setImageResource(this.profile);
        holder.Name.setText(this.name);
      //  holder.Name.setTypeface(Utils.returnPtSansFont(this.mContext));
        holder.email.setText(this.email);
      //  holder.email.setTypeface(Utils.returnPtSansFont(this.mContext));
       /* holder.edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Portfolio.class);
                mContext.startActivity(intent);
            }
        });*/
    }

    public int getItemCount() {
        return this.mNavTitles.length + TYPE_ITEM;
    }

    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }
}
