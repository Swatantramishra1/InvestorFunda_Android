package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class GetStateDetailsResult {
    @SerializedName("ResponseCode")
    @Expose
    private Integer responseCode;
    @SerializedName("ResponseMessage")
    @Expose
    private Object responseMessage;
    @SerializedName("Result")
    @Expose
    private ArrayList<Result> result;
    @SerializedName("Status")
    @Expose
    private String status;

    public GetStateDetailsResult() {
        this.result = new ArrayList();
    }

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public Object getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(Object responseMessage) {
        this.responseMessage = responseMessage;
    }

    public ArrayList<Result> getResult() {
        return this.result;
    }

    public void setResult(ArrayList<Result> result) {
        this.result = result;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
