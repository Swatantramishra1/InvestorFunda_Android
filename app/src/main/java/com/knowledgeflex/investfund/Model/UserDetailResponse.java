package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class UserDetailResponse implements Serializable {
    @SerializedName("GetUserProfileDetailsInfoResult")
    @Expose
    private GetUserProfileDetailsInfoResult getUserProfileDetailsInfoResult;

    public GetUserProfileDetailsInfoResult getGetUserProfileDetailsInfoResult() {
        return this.getUserProfileDetailsInfoResult;
    }

    public void setGetUserProfileDetailsInfoResult(GetUserProfileDetailsInfoResult getUserProfileDetailsInfoResult) {
        this.getUserProfileDetailsInfoResult = getUserProfileDetailsInfoResult;
    }
}
