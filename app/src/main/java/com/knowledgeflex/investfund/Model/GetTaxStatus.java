package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTaxStatus {
    @SerializedName("GetTaxStatusResult")
    @Expose
    private GetTaxStatusResult getTaxStatusResult;

    public GetTaxStatusResult getGetTaxStatusResult() {
        return this.getTaxStatusResult;
    }

    public void setGetTaxStatusResult(GetTaxStatusResult getTaxStatusResult) {
        this.getTaxStatusResult = getTaxStatusResult;
    }
}
