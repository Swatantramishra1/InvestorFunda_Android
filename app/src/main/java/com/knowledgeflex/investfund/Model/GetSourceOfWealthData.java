package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetSourceOfWealthData {
    @SerializedName("GetSourceOfWealthResult")
    @Expose
    private GetSourceOfWealthResult getSourceOfWealthResult;

    public GetSourceOfWealthResult getGetSourceOfWealthResult() {
        return this.getSourceOfWealthResult;
    }

    public void setGetSourceOfWealthResult(GetSourceOfWealthResult getSourceOfWealthResult) {
        this.getSourceOfWealthResult = getSourceOfWealthResult;
    }
}
