package com.algoworks.architectureapp.apiclient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @param <T> use for api callback
 */

public abstract class ApiCallback<T> implements Callback<T> {
    private final String TAG = ApiCallback.class.getCanonicalName();
    private final Context context;

    public ApiCallback(Context context) {
        this.context = context;
    }

    @SuppressWarnings({"ConstantConditions", "unchecked"})
    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        if (response.body() != null) {
            Log.i(TAG, "RES : " + "Success");
            if (response.isSuccessful()) {
                onSuccess(response.body());
            } else {

                Error error = new Error();
                onError(error);


            }

        } else {
            Log.i(TAG, "ERROR : " + "Success");
            Error error = new Error();
            //  error.setMsg(context.getString(R.string.error_msg));
            onError(error);
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        Log.i(TAG, "ERROR FAIL : " + t.getMessage());


        Error error = new Error();
        if (t.getMessage() != null) {
            if (t.getMessage().contains("Failed to connect")) {
//                error.setMsg(context.getString(R.string.internet_error));
            } else {

                if (t instanceof IOException) {
                    //                  error.setMsg(context.getString(R.string.internet_error));
                    // logging probably not necessary
                } else {

                    //                error.setMsg(t.getMessage());
                }
            }
        } else {
            //      error.setMsg(context.getString(R.string.error_msg));
        }
        onError(error);
    }


    public abstract void onSuccess(T t);

    public abstract void onError(Error msg);

}
