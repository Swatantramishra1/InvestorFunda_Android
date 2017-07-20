package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Vinoth on 6/22/2017.
 */

public class DashBoardDetailsResult implements Serializable {

    @SerializedName("GetDashInvestmentDetailsResult")
    @Expose
    private GetDashInvestmentDetailsResult GetDashInvestmentDetailsResult;

    public GetDashInvestmentDetailsResult getGetDashInvestmentDetailsResult() {
        return GetDashInvestmentDetailsResult;
    }

    public void setGetDashInvestmentDetailsResult(GetDashInvestmentDetailsResult getDashInvestmentDetailsResult) {
        GetDashInvestmentDetailsResult = getDashInvestmentDetailsResult;
    }
}
