package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Vinoth on 1/30/2017.
 */

public class FundsResponse implements Serializable {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("data")
    @Expose
    private FundsData data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FundsData getData() {
        return data;
    }

    public void setData(FundsData data) {
        this.data = data;
    }
}
