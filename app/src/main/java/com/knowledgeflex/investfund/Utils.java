package com.knowledgeflex.investfund;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import de.hdodenhof.circleimageview.BuildConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.atomic.AtomicInteger;
import static com.knowledgeflex.investfund.ApplicationIndiainvest.getSharedPref;

public class Utils {
    public static String LoginID;
    public static String LoginNAME;
    public static String LoginSucces;
    public static String UserId;
    private static final AtomicInteger sNextGeneratedId;

    static {
        sNextGeneratedId = new AtomicInteger(1);
        LoginID = "LoginID";
        LoginSucces = "loginSuccess";
        LoginNAME = "Name";
        UserId = "userId";
    }

    private static int generateViewId() {
        int result;
        int newValue;
        do {
            result = sNextGeneratedId.get();
            newValue = result + 1;
            if (newValue > ViewCompat.MEASURED_SIZE_MASK) {
                newValue = 1;
            }
        } while (!sNextGeneratedId.compareAndSet(result, newValue));
        return result;
    }

    @SuppressLint({"NewApi"})
    public static int generateId() {
        if (VERSION.SDK_INT < 17) {
            return generateViewId();
        }
        return View.generateViewId();
    }

    public static String getStringPref(String key) {
        return getSharedPref().getString(key, BuildConfig.VERSION_NAME);
    }

    public static void setStringPref(String key, String value) {
        getSharedPref().edit().putString(key, value).commit();
    }

    public static boolean getBooleanPref(String key) {
        return getSharedPref().getBoolean(key, false);
    }

    public static void setBooleanPref(String key, boolean value) {
        getSharedPref().edit().putBoolean(key, value).commit();
    }

    public static void writeObject(Context context, String key, Object object) throws IOException {
        FileOutputStream fos;
        try {
           // fos = context.openFileOutput(key, Context.MODE_PRIVATE);
            String filename = key+".srl";
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(context.getFilesDir(),"")+File.separator+filename));
            out.writeObject(object);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("file error",e.toString());
        }
       /* FileOutputStream fos = context.openFileOutput(key, Context.MODE_PRIVATE);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.close();
        fos.close();*/
    }

    public static Typeface returnPtSansFont(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "PT_Sans-Web-Regular.ttf");
    }

    public static Typeface returnOpenSansFont(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "OpenSans-Regular.ttf");
    }

    public static Typeface returnAparajita(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "aparaji.ttf");
    }

    public static Typeface returnArialNarrow(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "arial_narrow.ttf");
    }

    public static Object readObject(Context context, String key) throws IOException, ClassNotFoundException {
        Object object= null;
        try {
            String filename = key+".srl";
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(new File(new File(context.getFilesDir(), "") + File.separator + filename)));
        /*FileInputStream fis = context.openFileInput(key);
        ObjectInputStream ois = new ObjectInputStream(fis);*/
            object = input.readObject();
        }
        catch (Exception e){
            e.printStackTrace();
            Log.e("file read",e.toString());
        }
        return object;
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService("connectivity");
        if (cm == null) {
            return false;
        }
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo == null || !netInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    public static void clearAll() {
        getSharedPref().edit().clear();
    }
}
