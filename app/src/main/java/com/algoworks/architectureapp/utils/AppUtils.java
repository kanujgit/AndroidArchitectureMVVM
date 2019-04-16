package com.algoworks.architectureapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.widget.ListPopupWindow;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Class is used to contain utils method.
 */
public class AppUtils {

    private static final String TAG = AppUtils.class.getName();
    //    public static final String COUNTS = "20";
    public static int imageCount = 0;
    public static int container_height;
    private static ListPopupWindow popupWindow;
    public static List<String> removeId = new ArrayList();

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        boolean isnewtwork = (activeNetworkInfo != null && activeNetworkInfo.isConnected());
        if (!isnewtwork) {
            //DialogManager.showDialog((Activity) context, context.getResources().getString(R.string.app_name), context.getResources().getString(R.string.internet_error));
        }
        return isnewtwork;
    }

    public static Typeface findTypeface(Context context, String initPath,
                                        String typeface) {
        AssetManager assets = context.getAssets();
        return Typeface.createFromAsset(assets, (initPath + File.separator)
                + typeface);
    }

    public static void key(Activity activity) {
        try {
            PackageInfo info = activity.getPackageManager().getPackageInfo(activity.getApplicationContext().getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
            e.printStackTrace();

        }
    }


    public static String getFormatedDateStringInProfileFragment(int day, int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        return formatter.format(cal.getTime());
    }


    public static String getES_SHA_256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (byte aHash : hash) {
                String hex = Integer.toHexString(0xff & aHash);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    public static boolean isValidName(String name) {
        if (!TextUtils.isEmpty(name) && name.matches("([A-Z0-9a-z])+")) {
            Log.i("validator", "is valid name");
            return true;
        }
        return false;
    }


}
