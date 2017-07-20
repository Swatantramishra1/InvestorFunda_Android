package com.knowledgeflex.investfund.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PortfolioResponse implements Serializable {

    @SerializedName("data")
    @Expose
    private EquityAndDebt data;

    public EquityAndDebt getData() {
        return data;
    }

    public void setData(EquityAndDebt data) {
        this.data = data;
    }
}
