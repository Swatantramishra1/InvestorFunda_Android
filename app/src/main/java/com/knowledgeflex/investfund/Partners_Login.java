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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.net.HttpURLConnection;

public class Partners_Login extends AppCompatActivity {
    private ApiService apiService;
    private String basicAuth;
    private HttpURLConnection conn;
    private String email;
    private String id;
    Button login;
    private String mEnteredPassword;
    private String mEnteredUserName;
    private ProgressBar mProgressBar;
    EditText password;
    TextView register;
    private String text;
    private String userCredentials;
    EditText username;

    class RegisterClick implements View.OnClickListener {
        RegisterClick() {
        }

        public void onClick(View v) {
            Partners_Login.this.startActivity(new Intent(Partners_Login.this, Registration.class));
        }
    }

    /* renamed from: com.ramation.foldingcell.examples.indiainvest.Partners_Login.2 */
    class LoginClick implements View.OnClickListener {
        LoginClick() {
        }

        public void onClick(View v) {
            Partners_Login.this.mEnteredUserName = Partners_Login.this.username.getText().toString();
            Partners_Login.this.mEnteredPassword = Partners_Login.this.password.getText().toString();
            if (Partners_Login.this.mEnteredUserName.isEmpty()) {
                Toast.makeText(Partners_Login.this.getApplicationContext(), Partners_Login.this.getResources().getString(R.string.empty_email_login), Toast.LENGTH_LONG).show();
            } else if (Partners_Login.this.mEnteredPassword.isEmpty()) {
                Toast.makeText(Partners_Login.this.getApplicationContext(), Partners_Login.this.getResources().getString(R.string.empty_password_login), Toast.LENGTH_LONG).show();
            } else {
                Partners_Login.this.login.setEnabled(false);
            }
        }
    }

    public Partners_Login() {
        this.userCredentials = "Investorfunda";
        this.basicAuth = "Basic " + new String(Base64.encode(this.userCredentials.getBytes(), 0));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(3);
        setContentView(R.layout.activity_partners__login);
        this.login = (Button) findViewById(R.id.btn_login);
        this.username = (EditText) findViewById(R.id.ed_email);
        this.password = (EditText) findViewById(R.id.ed_password);
        this.mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.mProgressBar.setVisibility(8);
        this.register = (TextView) findViewById(R.id.register);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
        }
        this.register.setOnClickListener(new RegisterClick());
        this.login.setOnClickListener(new LoginClick());
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
