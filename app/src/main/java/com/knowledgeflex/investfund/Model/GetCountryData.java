package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetCountryData {
    @SerializedName("GetCountryDetailsResult")
    @Expose
    private GetCountryDetailsResult getCountryDetailsResult;

    public GetCountryDetailsResult getGetCountryDetailsResult() {
        return this.getCountryDetailsResult;
    }

    public void setGetCountryDetailsResult(GetCountryDetailsResult getCountryDetailsResult) {
        this.getCountryDetailsResult = getCountryDetailsResult;
    }
}
