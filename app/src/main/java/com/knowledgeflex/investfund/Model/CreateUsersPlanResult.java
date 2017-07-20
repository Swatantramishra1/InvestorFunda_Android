package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateUsersPlanResult {

    @SerializedName("CreateUsersPlanResult")
    @Expose
    private CreateUsersPlanResult_Response getCreateUsersPlanResult;

    public CreateUsersPlanResult_Response getGetCreateUsersPlanResult() {
        return getCreateUsersPlanResult;
    }

    public void setGetCreateUsersPlanResult(CreateUsersPlanResult_Response getCreateUsersPlanResult) {
        this.getCreateUsersPlanResult = getCreateUsersPlanResult;
    }
}
