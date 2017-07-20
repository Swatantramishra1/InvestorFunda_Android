package com.knowledgeflex.investfund;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class ApplicationIndiainvest extends Application {
    public static SharedPreferences mPrefHelper;

    public void onCreate() {
        super.onCreate();
        if (mPrefHelper == null) {
            mPrefHelper = PreferenceManager.getDefaultSharedPreferences(this);
        }
        FontsOverride.setDefaultFont(this, "DEFAULT", "arial_narrow.ttf");
      //  FontsOverride.setDefaultFont(this, "MONOSPACE", "PT_Sans-Web-Regular.ttf");
      //  FontsOverride.setDefaultFont(this, "SERIF", "PT_Sans-Web-Regular.ttf");
      //  FontsOverride.setDefaultFont(this, "SANS_SERIF", "PT_Sans-Web-Regular.ttf");
    }

    public static SharedPreferences getSharedPref() {
        return mPrefHelper;
    }
}
