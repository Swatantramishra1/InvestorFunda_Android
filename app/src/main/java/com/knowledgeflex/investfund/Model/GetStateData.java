package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetStateData {
    @SerializedName("GetStateDetailsResult")
    @Expose
    private GetStateDetailsResult getStateDetailsResult;

    public GetStateDetailsResult getGetStateDetailsResult() {
        return this.getStateDetailsResult;
    }

    public void setGetStateDetailsResult(GetStateDetailsResult getStateDetailsResult) {
        this.getStateDetailsResult = getStateDetailsResult;
    }
}
