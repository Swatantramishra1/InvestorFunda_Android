package com.knowledgeflex.investfund;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.knowledgeflex.investfund.Model.LoginResponse;

import java.io.File;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;
    private ApiService apiService;
    private String basicAuth;
    private HttpURLConnection conn;
    private String email;
    private String id;
    Button login;
    private String mEnteredPassword;
    private String mEnteredUserName;
    private ProgressBar mProgressBar;
    Button partner_login;
    EditText password;
    TextView register;
    private String text;
    private String userCredentials;
    EditText username;

    class Register implements View.OnClickListener {
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, Registration.class));
        }
    }

    class Login implements View.OnClickListener {

        class LoginCall implements Callback<LoginResponse> {

            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (((LoginResponse) response.body()).getGetLoginResult().getResponseMessage().equalsIgnoreCase("success")) {
                    Utils.setStringPref("email",mEnteredUserName);
                    Utils.setStringPref("pass",mEnteredPassword);
                    Toast.makeText(MainActivity.this, ((LoginResponse) response.body()).getGetLoginResult().getStatus(), Toast.LENGTH_SHORT).show();
                    Utils.setStringPref(Utils.LoginID, ((LoginResponse) response.body()).getGetLoginResult().getResult().getUsername());
                    Utils.setStringPref(Utils.UserId, ((LoginResponse) response.body()).getGetLoginResult().getResult().getLoginID());
                    Utils.setStringPref(Utils.LoginNAME, ((LoginResponse) response.body()).getGetLoginResult().getResult().getName());
                    Utils.setBooleanPref(Utils.LoginSucces, true);
                    login.setVisibility(View.VISIBLE);
                    mProgressBar.setVisibility(View.GONE);
                    try
                    {
                        File listnames = new File(getFilesDir() + File.separator + "UserDetails");
                        if( !listnames.exists() )
                            listnames.mkdirs();
                        else if( !listnames.isDirectory() && listnames.canWrite() ){
                            listnames.delete();
                            listnames.mkdirs();
                        }
                        else{
                            //you can't access there with write permission.
                            //Try other way.
                            //Log.e("File name 2",listnames.toString());
                        }
                       // Log.e("File name",listnames.toString());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    startActivity(new Intent(MainActivity.this, Drawer_Activity.class));
                   // startActivity(new Intent(MainActivity.this, DashBoard.class));
                    finish();
                    return;
                }
                Toast.makeText(MainActivity.this, ((LoginResponse) response.body()).getGetLoginResult().getStatus(), Toast.LENGTH_SHORT).show();
              // mProgressBar.setVisibility(8);
               mProgressBar.setVisibility(View.GONE);
               login.setVisibility(View.VISIBLE);
               //username.setText(BuildConfig.VERSION_NAME);
              // password.setText(BuildConfig.VERSION_NAME);
            }

            public void onFailure(Call<LoginResponse> call, Throwable t) {
               Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
               mProgressBar.setVisibility(View.GONE);
               login.setVisibility(View.VISIBLE);

            }
        }

        public void onClick(View v) {
           mEnteredUserName =username.getText().toString();
           mEnteredPassword =password.getText().toString();
            if (MainActivity.this.mEnteredUserName.isEmpty()) {
                Toast.makeText(MainActivity.this.getApplicationContext(),getResources().getString(R.string.empty_email_login), Toast.LENGTH_LONG).show();
            } else if (MainActivity.this.mEnteredPassword.isEmpty()) {
                Toast.makeText(MainActivity.this.getApplicationContext(),getResources().getString(R.string.empty_password_login), Toast.LENGTH_LONG).show();
            } else {
               mEnteredUserName=mEnteredUserName.trim();
               login.setVisibility(View.GONE);
               mProgressBar.setVisibility(View.VISIBLE);
               mEnteredUserName=mEnteredUserName.trim();
                if(new Utils().isNetworkAvailable(getApplicationContext())) {
                    apiService = (ApiService) ApiService.retrofit.create(ApiService.class);
                    apiService.createLogin(mEnteredUserName, mEnteredPassword).enqueue(new LoginCall());
                }
                else {
                    Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    class PartLogin implements View.OnClickListener {

        public void onClick(View v) {
           startActivity(new Intent(MainActivity.this, Partners_Login.class));
        }
    }

    public MainActivity() {
        this.userCredentials = "Investorfunda";
        this.basicAuth = "Basic " + new String(Base64.encode(this.userCredentials.getBytes(), 0));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(3);
        setContentView(R.layout.in_login);
        if(checkAndRequestPermissions()) {
            // carry on the normal flow, as the case of  permissions  granted.
        }
        login = (Button) findViewById(R.id.btn_login);
        partner_login = (Button) findViewById(R.id.partner_login);
        username = (EditText) findViewById(R.id.ed_email);
        password = (EditText) findViewById(R.id.ed_password);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        register = (TextView) findViewById(R.id.register);
       /* if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660033")));
        }*/
        register.setOnClickListener(new Register());
        login.setOnClickListener(new Login());
        partner_login.setOnClickListener(new PartLogin());
    }

    private  boolean checkAndRequestPermissions() {
        int readPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int folderPermission=ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        List<String> listPermissionsNeeded = new ArrayList<>();
        if (readPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_PHONE_STATE);
        }
        if(folderPermission != PackageManager.PERMISSION_GRANTED){
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        Log.d("LoginPage", "Permission callback called-------");
        switch (requestCode) {
            case REQUEST_ID_MULTIPLE_PERMISSIONS: {

                Map<String, Integer> perms = new HashMap<>();
                // Initialize the map with both permissions
                perms.put(Manifest.permission.READ_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.WRITE_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                // Fill with actual results from user
                if (grantResults.length > 0) {
                    for (int i = 0; i < permissions.length; i++)
                        perms.put(permissions[i], grantResults[i]);
                    // Check for both permissions
                    if (perms.get(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED && perms.get(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        Log.d("Login", "folder, phone & location services permission granted");
                        // process the normal flow
                        //else any one or both the permissions are not granted
                    } else {
                        Log.d("Login", "Some permissions are not granted ask again ");
                        //permission is denied (this is the first time, when "never ask again" is not checked) so ask again explaining the usage of permission
//                        // shouldShowRequestPermissionRationale will return true
                        //show the dialog or snackbar saying its necessary and try again otherwise proceed with setup.
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE) || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                            showDialogOK("SMS and Location Services Permission required for this app",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            switch (which) {
                                                case DialogInterface.BUTTON_POSITIVE:
                                                    checkAndRequestPermissions();
                                                    break;
                                                case DialogInterface.BUTTON_NEGATIVE:
                                                    // proceed with logic by disabling the related features or quit the app.
                                                    break;
                                            }
                                        }
                                    });
                        }
                        //permission is denied (and never ask again is  checked)
                        //shouldShowRequestPermissionRationale will return false
                        else {
                            Toast.makeText(this, "Go to settings and enable permissions", Toast.LENGTH_LONG)
                                    .show();
                            //                            //proceed with logic by disabling the related features or quit the app.
                        }
                    }
                }
            }
        }

    }

    private void showDialogOK(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", okListener)
                .create()
                .show();
    }

}

