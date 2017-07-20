package com.knowledgeflex.investfund;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.knowledgeflex.investfund.Model.RegistrationRequest;
import com.knowledgeflex.investfund.Model.RegistrationResult;
import com.knowledgeflex.investfund.Model.Request;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends AppCompatActivity {

    String MobilePattern;
    private ApiService apiService;
    private String basicAuth;
    private String confirm;
    EditText confrm_pass;
    private String email;
    String emailPattern;
    EditText email_id;
    EditText f_name;
    private String first;
    EditText l_name;
    private String last;
    private String mob;
    EditText mobile_no;
    private String pass;
    EditText password;
    boolean pstatus;
    Button submit;
    private String userCredentials;

    class ButtonClick implements View.OnClickListener {

        class ApiCall implements Callback<RegistrationResult> {

            public void onResponse(Call<RegistrationResult> call, Response<RegistrationResult> response) {
                if (((RegistrationResult) response.body()).getUserRegistrationResult().getStatus().equalsIgnoreCase("success")) {
                    Registration.this.startActivity(new Intent(Registration.this, MainActivity.class));
                    Registration.this.finish();
                }
                Toast.makeText(Registration.this, ((RegistrationResult) response.body()).getUserRegistrationResult().getResponseMessage(), Toast.LENGTH_LONG).show();
            }

            public void onFailure(Call<RegistrationResult> call, Throwable t) {
                Toast.makeText(Registration.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        }

        public void onClick(View v) {
            Registration.this.f_name = (EditText) Registration.this.findViewById(R.id.first_name);
            Registration.this.l_name = (EditText) Registration.this.findViewById(R.id.last_name);
            Registration.this.password = (EditText) Registration.this.findViewById(R.id.password);
            Registration.this.confrm_pass = (EditText) Registration.this.findViewById(R.id.cnfpassword);
            Registration.this.mobile_no = (EditText) Registration.this.findViewById(R.id.mobile_no);
            Registration.this.email_id = (EditText) Registration.this.findViewById(R.id.email_id);
            Registration.this.first = Registration.this.f_name.getText().toString();
            Registration.this.last = Registration.this.l_name.getText().toString();
            Registration.this.pass = Registration.this.password.getText().toString();
            Registration.this.confirm = Registration.this.confrm_pass.getText().toString();
            Registration.this.mob = Registration.this.mobile_no.getText().toString();
            Registration.this.email = Registration.this.email_id.getText().toString();
            if (!Registration.this.mob.matches(Registration.this.MobilePattern)) {
                Toast.makeText(Registration.this.getApplicationContext(), "Please enter valid 10 digit phone number", Toast.LENGTH_LONG).show();
            }
            if (Registration.this.email.matches(Registration.this.emailPattern)) {
                RegistrationRequest registrationRequestObject = new RegistrationRequest();
                Request req = new Request();
                req.setURFirstName(Registration.this.first);
                req.setURSurname(Registration.this.last);
                req.setURPanCardNo("3423423423");
                req.setURPassword(Registration.this.pass);
                req.setURGender("Male");
                req.setUREmail(Registration.this.email);
                req.setURMobile(Registration.this.mob);
                registrationRequestObject.setRequest(req);
                apiService = (ApiService) ApiService.retrofit.create(ApiService.class);
                apiService.createRegistration(registrationRequestObject).enqueue(new ApiCall());
                return;
            }
            Toast.makeText(Registration.this.getApplicationContext(), "Please Enter Valid Email Address", Toast.LENGTH_LONG).show();
        }
    }

    public Registration() {
        this.userCredentials = "Investorfunda";
        this.basicAuth = "Basic " + new String(Base64.encode(this.userCredentials.getBytes(), 0));
        this.MobilePattern = "[0-9]{10}";
        this.emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getWindow().setSoftInputMode(3);
        this.submit = (Button) findViewById(R.id.btn_register);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
        }
        this.submit.setOnClickListener(new ButtonClick());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        if (item.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

