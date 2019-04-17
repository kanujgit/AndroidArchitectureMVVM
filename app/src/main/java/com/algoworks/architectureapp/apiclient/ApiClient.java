package com.algoworks.architectureapp.apiclient;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static IApiRequest apiRequest;
    private static String HOST = "http://dev.algoworks.com/beno/api/v0/";

    //private static String HOST = "http://192.168.1.75:4000/beno/api/v0/";
//      private static String HOST = "http://35.173.13.99/beno/api/v0/";
//

    public static void init(Class<IApiRequest> requestClass) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        // setup timeout vale offset
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new BenoInterceptor()).addInterceptor(interceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST)
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
                .build();

        Log.d("url", HOST);
        apiRequest = retrofit.create(requestClass);

    }

    public static IApiRequest getRequest() {
        return apiRequest;
    }
}
