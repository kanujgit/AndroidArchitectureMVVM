package com.algoworks.architectureapp;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.algoworks.architectureapp.view.CustomEditText;
import com.algoworks.architectureapp.viewmodels.LoginViewModel;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.et_user)
    CustomEditText et_user;

    @BindView(R.id.et_pass)
    CustomEditText et_pass;
    LoginViewModel loginViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

    }

  /*  private void subscribeObservers() {

        loginViewModel.getLoginData(this).observe(this, new Observer<Recipe>() {
            @Override
            public void onChanged(@Nullable Recipe recipe) {
                if(recipe != null){
                    if(recipe.getRecipe_id().equals(mRecipeViewModel.getRecipeId())){
                        setRecipeProperties(recipe);
                        mRecipeViewModel.setRetrievedRecipe(true);
                    }
                }
            }
        });

        mRecipeViewModel.isRecipeRequestTimedOut().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(aBoolean && !mRecipeViewModel.didRetrieveRecipe()){
                    Log.d(TAG, "onChanged: timed out..");
                    displayErrorScreen("Error retrieving data. Check network connection.");
                }
            }
        });
    }*/

    @OnClick(R.id.btn_login)
    public void hitLogin(View view) {

        loginViewModel.setModelData(LoginActivity.this, Objects.requireNonNull(et_user.getText()).toString(), Objects.requireNonNull(et_pass.getText()).toString());
    }
}
