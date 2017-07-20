package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetCityData {
    @SerializedName("GetCityDetailsResult")
    @Expose
    private GetCityDetailsResult getCityDetailsResult;

    public GetCityDetailsResult getGetCityDetailsResult() {
        return this.getCityDetailsResult;
    }

    public void setGetCityDetailsResult(GetCityDetailsResult getCityDetailsResult) {
        this.getCityDetailsResult = getCityDetailsResult;
    }
}
