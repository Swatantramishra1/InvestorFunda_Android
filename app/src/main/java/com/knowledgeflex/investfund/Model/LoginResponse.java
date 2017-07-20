package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginResponse implements Serializable{
    @SerializedName("GetLoginResult")
    @Expose
    private GetLoginResult getLoginResult;

    public GetLoginResult getGetLoginResult() {
        return this.getLoginResult;
    }

    public void setGetLoginResult(GetLoginResult getLoginResult) {
        this.getLoginResult = getLoginResult;
    }
}
