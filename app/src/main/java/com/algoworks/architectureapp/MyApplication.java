package com.algoworks.architectureapp;

import android.app.Application;
import android.content.Context;

import com.algoworks.architectureapp.apiclient.ApiClient;
import com.algoworks.architectureapp.apiclient.IApiRequest;
import com.algoworks.architectureapp.utils.AppConstant;
import com.algoworks.architectureapp.utils.PreferenceKeeper;

public class MyApplication extends Application {

    public static Context context;
    /* Be sure to fill in the two strings below. */

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        PreferenceKeeper.setContext(getApplicationContext());
        ApiClient.init(IApiRequest.class);
        AppConstant.setDeviceId(this);
        MyApplication.context = getApplicationContext();

    }
    public static Context getContext(){
        return MyApplication.context;
    }

}
