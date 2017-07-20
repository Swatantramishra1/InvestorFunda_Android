package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Vinoth on 1/30/2017.
 */

public class ListFundResponse implements Serializable {

    @SerializedName("response")
    @Expose
    private FundsResponse responseMessage;

    public FundsResponse getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(FundsResponse responseMessage) {
        this.responseMessage = responseMessage;
    }
}
