package com.knowledgeflex.investfund.invest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.knowledgeflex.investfund.R;

public class Comparison_Dialog extends AppCompatActivity {

    EditText amount;
    Spinner mode;
    Button submit;
    Button cancel;
    String modeType[] = {"Select Type", "SIP", "One Time Investment"};
    String scheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison__dialog);
        scheme = getIntent().getStringExtra("scheme");
        amount = (EditText) findViewById(R.id.amountEdit);
        mode = (Spinner) findViewById(R.id.invesMode);
        submit = (Button) findViewById(R.id.submit_compare);
        cancel = (Button) findViewById(R.id.cancel_compare);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, modeType);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mode.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(amount.getText().toString())) {
                    if (!mode.getSelectedItem().toString().equals("Select Type")) {
                        Intent returnIntent = new Intent();
                        returnIntent.putExtra("amount", amount.getText().toString());
                        returnIntent.putExtra("mode", mode.getSelectedItem().toString());
                        returnIntent.putExtra("scheme",scheme);
                        setResult(Activity.RESULT_OK, returnIntent);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Please select investment mode", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Please enter investment amount", Toast.LENGTH_LONG).show();
                }
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
