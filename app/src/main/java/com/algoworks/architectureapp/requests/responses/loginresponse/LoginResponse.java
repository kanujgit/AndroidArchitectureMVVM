package com.algoworks.architectureapp.requests.responses.loginresponse;

import com.google.gson.annotations.SerializedName;


public class LoginResponse {

    @SerializedName("sc")
    private int sc;

    @SerializedName("result")
    private Result result;

    @SerializedName("time")
    private long time;

    public void setSc(int sc) {
        this.sc = sc;
    }

    public int getSc() {
        return sc;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return
                "LoginResponse{" +
                        "sc = '" + sc + '\'' +
                        ",result = '" + result + '\'' +
                        ",time = '" + time + '\'' +
                        "}";
    }
}