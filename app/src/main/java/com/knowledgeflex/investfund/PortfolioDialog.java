package com.knowledgeflex.investfund;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PortfolioDialog extends AppCompatActivity {

    Button submit,cancel;
    TextView comment;
    Double cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio_dialog);
        this.setFinishOnTouchOutside(false);
        cost = getIntent().getDoubleExtra("amount",0);
        if (getSupportActionBar() != null) {
            //   getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("")));
            SpannableString s = new SpannableString("Confirmation of Scheme");
            s.setSpan(Utils.returnOpenSansFont(this), 0, s.length(), 33);
            getSupportActionBar().setTitle(s);
        }

        submit = (Button)findViewById(R.id.submit_port);
        cancel = (Button)findViewById(R.id.cancel_port);
        comment = (TextView) findViewById(R.id.commentScheme);
        Double d = new Double(cost);
        int i = d.intValue();
        comment.setText("Do you really want to invest Rs."+ i + " into this scheme");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result","ok");
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
