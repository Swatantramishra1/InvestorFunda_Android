package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationResult {
    @SerializedName("UserRegistrationResult")
    @Expose
    private UserRegistrationResult userRegistrationResult;

    public UserRegistrationResult getUserRegistrationResult() {
        return this.userRegistrationResult;
    }

    public void setUserRegistrationResult(UserRegistrationResult userRegistrationResult) {
        this.userRegistrationResult = userRegistrationResult;
    }
}
