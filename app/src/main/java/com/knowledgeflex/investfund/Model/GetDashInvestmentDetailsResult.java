package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Vinoth on 6/21/2017.
 */

public class GetDashInvestmentDetailsResult implements Serializable {

    @SerializedName("ResponseCode")
    @Expose
    private Integer responseCode;
    @SerializedName("ResponseMessage")
    @Expose
    private String responseMessage;
    @SerializedName("Result")
    @Expose ResultSchemeData resultSchemeData;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public ResultSchemeData getResultSchemeData() {
        return resultSchemeData;
    }

    public void setResultSchemeData(ResultSchemeData resultSchemeData) {
        this.resultSchemeData = resultSchemeData;
    }
}
