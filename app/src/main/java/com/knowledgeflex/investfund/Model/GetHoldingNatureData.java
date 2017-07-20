package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetHoldingNatureData {
    @SerializedName("GetHoldingNatureResult")
    @Expose
    private GetHoldingNatureResult getHoldingNatureResult;

    public GetHoldingNatureResult getGetHoldingNatureResult() {
        return this.getHoldingNatureResult;
    }

    public void setGetHoldingNatureResult(GetHoldingNatureResult getHoldingNatureResult) {
        this.getHoldingNatureResult = getHoldingNatureResult;
    }
}
