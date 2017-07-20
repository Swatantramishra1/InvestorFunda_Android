package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class GetAllListDetailsResult implements Serializable {
    @SerializedName("GetAllListDetailsResult")
    @Expose
    private GetAllListDetailsResult_ getAllListDetailsResult;

    public GetAllListDetailsResult_ getGetAllListDetailsResult() {
        return this.getAllListDetailsResult;
    }

    public void setGetAllListDetailsResult(GetAllListDetailsResult_ getAllListDetailsResult) {
        this.getAllListDetailsResult = getAllListDetailsResult;
    }
}
