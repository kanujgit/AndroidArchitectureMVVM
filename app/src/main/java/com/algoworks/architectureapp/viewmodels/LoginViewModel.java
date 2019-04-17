package com.algoworks.architectureapp.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.algoworks.architectureapp.repositories.LoginRepository;
import com.algoworks.architectureapp.requests.responses.loginresponse.LoginResponse;

public class LoginViewModel extends ViewModel {
    private LoginRepository loginRepository;


    public LoginViewModel() {
        loginRepository = LoginRepository.getInstance();
    }

    public void setModelData(Context context, String name, String pass) {

        loginRepository.getLoginApi(context, name, pass);
    }

    public LiveData<LoginResponse> getLoginData(){
        return  loginRepository.getLoginData();
    }
    public LiveData<Boolean> isLoginRequestTimedOut(){
        return loginRepository.isLoginRequestTimedOut();
    }

}
