package com.algoworks.architectureapp.apiclient;

import android.text.TextUtils;
import android.util.Log;

import com.algoworks.architectureapp.utils.AppConstant;
import com.algoworks.architectureapp.utils.PreferenceKeeper;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Class is used to passing user token at central level.
 */
public class BenoInterceptor implements Interceptor {
    private static final String TAG = BenoInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();

        String token = PreferenceKeeper.getInstance().getAccessToken();

        if (TextUtils.isEmpty(token)) {
            return chain.proceed(originalRequest);
        }

        Request newRequest = originalRequest.newBuilder().addHeader("authorization", token)
                .addHeader("deviceOS", AppConstant.DEVICE_OS).build();


        Log.d("Request token ", token);
        Log.d("Request URL ", newRequest.url().toString());

        Response response = chain.proceed(newRequest);
        Log.d("Response ", response.body().source().toString());

        return response;
    }

}
