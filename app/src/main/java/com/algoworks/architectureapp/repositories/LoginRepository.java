package com.algoworks.architectureapp.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.algoworks.architectureapp.apiclient.ApiCallback;
import com.algoworks.architectureapp.apiclient.ApiClient;
import com.algoworks.architectureapp.apiclient.IApiRequest;
import com.algoworks.architectureapp.requests.responses.loginresponse.LoginResponse;

public class LoginRepository {
    private static LoginRepository instance;
    private static ApiClient apiClient;
    private static IApiRequest iApiRequest;
    private MutableLiveData<LoginResponse> mLoginResponseData;


    public static LoginRepository getInstance() {
        if (instance == null) {
            instance = new LoginRepository();
        }
        return instance;
    }

    public LiveData<LoginResponse> getLoginApi(Context context, String country,
                                               String key) {
        final MutableLiveData<LoginResponse> data = new MutableLiveData<>();
        iApiRequest.getLoginApi(country, key).enqueue(new ApiCallback<LoginResponse>(context) {
            @Override
            public void onSuccess(LoginResponse loginResponse) {

                if(loginResponse!=null){

                    if(loginResponse.getSc()==1){
                        mLoginResponseData.postValue(loginResponse);
                    }
                }

            }

            @Override
            public void onError(Error msg) {

            }
        });

        return mLoginResponseData;
    }
}
