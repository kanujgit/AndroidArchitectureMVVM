package com.algoworks.architectureapp.apiclient;


import com.algoworks.architectureapp.requests.responses.loginresponse.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IApiRequest {


    @FormUrlEncoded
    @POST("user/login")
    Call<LoginResponse> getLoginApi(@Field("email") String email,
                                    @Field("pwd") String pwd,
                                    @Field("device_token") String device_token,
                                    @Field("device_type") String device_type);


    interface FIELD {

        String EMAIL = "email";
        String PASSWORD = "password";
        String NAME = "name";
        String DOB = "dob";
        String GENDER = "gender";
        String SUBURBS = "suburbs";
        String DPTDATA = "dptData";
        String DPTOBJ = "dptObj";
        String DPTID = "dptId";
        String DPTFBID = "dptFbId";
        String DPTFBTOKEN = "dptFbToken";
        String DPTTWTID = "dptTwtID";
        String DPTTwtTOKEN = "dptTwtToken";
        String FROM = "from";
        String FEEDID = "feedId";
        String TWORDID = "tWordId";
        String TWORD = "tWord";
        String DPT_USER_NAME = "dptTwtUserName";
        String TWTID = "twtId";
        String CPASSWORD = "cPassword";
        String NPASSWORD = "nPassword";
        String TOKEN = "token";
        String ODER_ID = "oderId";
        String PRODUCT_ID = "productId";
        String PURCHASE_TOKEN = "purchaseToken";
        String PACKAGE_NAME = "packageName";
        String PLATFORM = "plateform";
        String DEVICE_ID = "device_id";
        String SETTING = "settings";
        String ST = "st";
        String TOUCH_ID = "touch_id";
        String AMOUNT = "amount";
        String PHONE_NUMBER = "p_no";

        String FIRST_NAME = "first_name";
        String LAST_NAME = "last_name";
        String PHONE_NO = "p_no";
        String ADDRESS = "address";
        String LANGUAGE = "language";
        String COUNTRY_CODE = "country_code";
        String IMG = "img";
        String CODE = "code";

    }
}