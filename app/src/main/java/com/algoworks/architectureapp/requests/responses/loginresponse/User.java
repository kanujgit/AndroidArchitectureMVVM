package com.algoworks.architectureapp.requests.responses.loginresponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class User {

    @SerializedName("noti_st")
    private boolean notiSt;

    @SerializedName("st")
    private int st;

    @SerializedName("img")
    private Object img;

    @SerializedName("gid")
    private Object gid;

    @SerializedName("p_no")
    private String pNo;

    @SerializedName("roles")
    private List<Integer> roles;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("set_preferences")
    private boolean setPreferences;

    @SerializedName("country_code")
    private int countryCode;

    @SerializedName("uid")
    private int uid;

    @SerializedName("wallet_credit")
    private int walletCredit;

    @SerializedName("sms_st")
    private boolean smsSt;

    @SerializedName("my_ref")
    private String myRef;

    @SerializedName("fbid")
    private Object fbid;

    @SerializedName("pwd")
    private String pwd;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("touch_id")
    private boolean touchId;

    @SerializedName("email")
    private String email;

    public void setNotiSt(boolean notiSt) {
        this.notiSt = notiSt;
    }

    public boolean isNotiSt() {
        return notiSt;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public int getSt() {
        return st;
    }

    public void setImg(Object img) {
        this.img = img;
    }

    public Object getImg() {
        return img;
    }

    public void setGid(Object gid) {
        this.gid = gid;
    }

    public Object getGid() {
        return gid;
    }

    public void setPNo(String pNo) {
        this.pNo = pNo;
    }

    public String getPNo() {
        return pNo;
    }

    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }

    public List<Integer> getRoles() {
        return roles;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setSetPreferences(boolean setPreferences) {
        this.setPreferences = setPreferences;
    }

    public boolean isSetPreferences() {
        return setPreferences;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public void setWalletCredit(int walletCredit) {
        this.walletCredit = walletCredit;
    }

    public int getWalletCredit() {
        return walletCredit;
    }

    public void setSmsSt(boolean smsSt) {
        this.smsSt = smsSt;
    }

    public boolean isSmsSt() {
        return smsSt;
    }

    public void setMyRef(String myRef) {
        this.myRef = myRef;
    }

    public String getMyRef() {
        return myRef;
    }

    public void setFbid(Object fbid) {
        this.fbid = fbid;
    }

    public Object getFbid() {
        return fbid;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setTouchId(boolean touchId) {
        this.touchId = touchId;
    }

    public boolean isTouchId() {
        return touchId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return
                "User{" +
                        "noti_st = '" + notiSt + '\'' +
                        ",st = '" + st + '\'' +
                        ",img = '" + img + '\'' +
                        ",gid = '" + gid + '\'' +
                        ",p_no = '" + pNo + '\'' +
                        ",roles = '" + roles + '\'' +
                        ",last_name = '" + lastName + '\'' +
                        ",set_preferences = '" + setPreferences + '\'' +
                        ",country_code = '" + countryCode + '\'' +
                        ",uid = '" + uid + '\'' +
                        ",wallet_credit = '" + walletCredit + '\'' +
                        ",sms_st = '" + smsSt + '\'' +
                        ",my_ref = '" + myRef + '\'' +
                        ",fbid = '" + fbid + '\'' +
                        ",pwd = '" + pwd + '\'' +
                        ",first_name = '" + firstName + '\'' +
                        ",touch_id = '" + touchId + '\'' +
                        ",email = '" + email + '\'' +
                        "}";
    }
}