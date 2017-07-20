package com.knowledgeflex.investfund.invest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.knowledgeflex.investfund.Model.FundsResponse;

import java.io.Serializable;

/**
 * Created by Vinoth on 7/1/2017.
 */

public class FundDetailsResponse implements Serializable {

    @SerializedName("response")
    @Expose
    private FundDetailsTypeResponse responseMessage;

    public FundDetailsTypeResponse getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(FundDetailsTypeResponse responseMessage) {
        this.responseMessage = responseMessage;
    }
}
