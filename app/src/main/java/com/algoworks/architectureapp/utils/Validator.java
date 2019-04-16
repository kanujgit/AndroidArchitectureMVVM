package com.algoworks.architectureapp.utils;

import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * Class is used to validate email,name, username.
 */
public class Validator {

    private static final String PHONE_REGEX = "[789]{1}\\d{9}";
    private static final String OTP_REGEX = "^[0-9]{6}";
    private static final String EMAIL_REGEX = "[a-zA-Z0-9._-]+@[A-Za-z]+\\.+[A-Za-z]+";
    /*Any one spacial character*/
    private static final String PASSWORD_REGEX = "^[!@#$%^&*()_]";
    /*"^([a-zA-Z+]+[0-9+]+[&@!#+]+)$"*/


    // call this method when you need to ic_success phone number validation
    public static boolean isPhoneNumber(String phoneNumber) {
        return isValueValid(PHONE_REGEX, phoneNumber);
    }

    //call this method when you need to ic_success otp validation
    public static boolean isOTPNumber(String otp) {
        return isValueValid(OTP_REGEX, otp);
    }

    //call this method when you need to ic_success email validation
    public static boolean isValidEmail(String email) {
        return isValueValid(EMAIL_REGEX, email);
    }


    public static boolean isPostalCode(String postalcode) {
        return !TextUtils.isEmpty(postalcode) && postalcode.length() == 6;
    }

    public static boolean isValueValid(String regex, String text) {

        return Pattern.matches(regex, text);
    }

    public static boolean isValidPassword(String password) {


        return !TextUtils.isEmpty(password) && (password.length() > AppConstant.PASSWARD_LENGTH);
    }

    public static boolean isNotNullOrEmpty(String string) {
        return (string != null && string.length() > 0);
    }

    public static boolean isValidNewPassword(String password) {

        int specialChars = password.replaceAll("[^-@#$%!_?&]", "").length();
        int all = password.length();
        return specialChars >= 1;

    }

}
