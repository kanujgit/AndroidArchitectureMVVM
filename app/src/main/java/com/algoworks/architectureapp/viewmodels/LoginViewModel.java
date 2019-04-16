package com.algoworks.architectureapp.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.algoworks.architectureapp.repositories.LoginRepository;
import com.algoworks.architectureapp.requests.responses.loginresponse.LoginResponse;

public class LoginViewModel extends ViewModel {
    LoginRepository loginRepository;


    public LoginViewModel() {

    }

    public LiveData<LoginResponse> setModelData(Context context,String name,String pass) {
        return loginRepository.getLoginApi(context,name,pass);
    }
}
