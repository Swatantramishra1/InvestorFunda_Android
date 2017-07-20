package com.knowledgeflex.investfund;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class Mutual_Fund_Adapter extends Adapter<Mutual_Fund_Adapter.MyViewHolder> {
    ImageView add_icon;
    private ClickListener clicklistener;
    private CardView crdv;
    private LinearLayout ll;
    public Context mContext;
    private List<Mutual_Funds> m_list;

    public class MyViewHolder extends ViewHolder {
        public TextView se;
        public TextView f19x;
        public TextView f20y;
        public TextView f21z;

        /* renamed from: com.ramation.foldingcell.examples.indiainvest.Mutual_Fund_Adapter.MyViewHolder.1 */
        class C02751 implements OnClickListener {
            final /* synthetic */ Mutual_Fund_Adapter val$this$0;

            C02751(Mutual_Fund_Adapter mutual_Fund_Adapter) {
                this.val$this$0 = mutual_Fund_Adapter;
            }

            public void onClick(View v) {
                Toast.makeText(MyViewHolder.this.itemView.getContext(), "Position:" + Integer.toString(MyViewHolder.this.getPosition()), Toast.LENGTH_LONG).show();
                if (Mutual_Fund_Adapter.this.clicklistener != null) {
                    Mutual_Fund_Adapter.this.clicklistener.itemClicked(v, MyViewHolder.this.getAdapterPosition());
                }
            }
        }

        public MyViewHolder(View view) {
            super(view);
            this.f19x = (TextView) view.findViewById(R.id.x1);
            this.f20y = (TextView) view.findViewById(R.id.y1);
            this.f21z = (TextView) view.findViewById(R.id.z1);
            this.se = (TextView) view.findViewById(R.id.se);
            Mutual_Fund_Adapter.this.add_icon = (ImageView) view.findViewById(R.id.plus);
            Mutual_Fund_Adapter.this.ll = (LinearLayout) view.findViewById(R.id.ll);
            Mutual_Fund_Adapter.this.crdv = (CardView) view.findViewById(R.id.card_view);
            Mutual_Fund_Adapter.this.ll.setOnClickListener(new C02751(Mutual_Fund_Adapter.this));
        }
    }

    public Mutual_Fund_Adapter(Context mContext, List<Mutual_Funds> m_list) {
        this.clicklistener = null;
        this.mContext = mContext;
        this.m_list = m_list;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clicklistener = clickListener;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_new, parent, false));
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        Mutual_Funds mutual_funds = (Mutual_Funds) this.m_list.get(position);
        holder.f19x.setText(mutual_funds.getNav());
        holder.f20y.setText(mutual_funds.getAllocation());
        holder.f21z.setText(mutual_funds.getFund_name());
        holder.se.setText(mutual_funds.getInvestment_amt());
    }

    public int getItemCount() {
        return this.m_list.size();
    }
}
