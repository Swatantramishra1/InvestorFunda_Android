package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UpdateUserDetailsResult implements Serializable{
    @SerializedName("UpdateUserDetailsResult")
    @Expose
    private UserRegistrationResult userRegistrationResult;

    public UserRegistrationResult getUserRegistrationResult() {
        return this.userRegistrationResult;
    }

    public void setUserRegistrationResult(UserRegistrationResult userRegistrationResult) {
        this.userRegistrationResult = userRegistrationResult;
    }
}
