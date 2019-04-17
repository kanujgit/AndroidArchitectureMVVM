package com.algoworks.architectureapp.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.algoworks.architectureapp.apiclient.ApiCallback;
import com.algoworks.architectureapp.apiclient.ApiClient;
import com.algoworks.architectureapp.requests.responses.loginresponse.LoginResponse;
import com.algoworks.architectureapp.utils.AppConstant;
import retrofit2.Call;

public class LoginRepository {
    private static LoginRepository instance;
    private MutableLiveData<LoginResponse> mLoginResponseData = new MutableLiveData<>();
    private MutableLiveData<Boolean> mLoginRequestTimeout = new MutableLiveData<>();


    public static LoginRepository getInstance() {
        if (instance == null) {
            instance = new LoginRepository();
        }
        return instance;
    }

    public LiveData<LoginResponse> getLoginData() {
        return mLoginResponseData;
    }


    public LiveData<Boolean> isLoginRequestTimedOut() {
        return mLoginRequestTimeout;
    }

    public void getLoginApi(Context context, String country,
                            String key) {

        final Call<LoginResponse> request = ApiClient.getRequest().getLoginApi(country, key, "12", AppConstant.DEVICE_OS);
        request.enqueue(new ApiCallback<LoginResponse>(context) {
            @Override
            public void onSuccess(LoginResponse loginResponse) {

                if (loginResponse != null) {

                    if (loginResponse.getSc() == 1) {
                        mLoginResponseData.postValue(loginResponse);
                    }
                }

            }

            @Override
            public void onError(Error msg) {

            }
        });

    }
}
