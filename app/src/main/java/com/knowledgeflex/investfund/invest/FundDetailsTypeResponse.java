package com.knowledgeflex.investfund.invest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.knowledgeflex.investfund.Model.FundsData;

import java.io.Serializable;

/**
 * Created by Vinoth on 7/1/2017.
 */

public class FundDetailsTypeResponse implements Serializable {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("data")
    @Expose
    private FundDetailsSchemeResponse data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FundDetailsSchemeResponse getData() {
        return data;
    }

    public void setData(FundDetailsSchemeResponse data) {
        this.data = data;
    }
}

