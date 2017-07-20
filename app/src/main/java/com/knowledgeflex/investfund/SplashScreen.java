package com.knowledgeflex.investfund;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends Activity {

    TextView appName;
    TextView slogan;

        class Splash extends Thread {
            Splash() {
            }

            public void run() {
                try {
                   // appName.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade));
                    Splash.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (Utils.getBooleanPref(Utils.LoginSucces)) {
                        SplashScreen.this.startActivity(new Intent(SplashScreen.this, Drawer_Activity.class));
                        finish();
                       // SplashScreen.this.startActivity(new Intent(SplashScreen.this, DashBoard.class));
                    } else {
                        startActivity(new Intent(SplashScreen.this, MainActivity.class));
                        finish();
                    }
                    finish();
                }
            }
        }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        appName = (TextView) findViewById(R.id.text);
        slogan = (TextView) findViewById(R.id.text1);
        appName.setTypeface(Utils.returnAparajita(this));
        slogan.setTypeface(Utils.returnAparajita(this));
        new Splash().start();
    }

    protected void onPause() {
        super.onPause();
        finish();
    }
}
