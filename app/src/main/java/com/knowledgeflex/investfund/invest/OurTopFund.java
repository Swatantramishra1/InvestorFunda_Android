package com.knowledgeflex.investfund.invest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.knowledgeflex.investfund.Model.FundsResponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Vinoth on 6/29/2017.
 */

public class OurTopFund implements Serializable {

    @SerializedName("OurTopFund")
    @Expose
    private List<OurFund> ourFund;

    public List<OurFund> getOurFund() {
        return ourFund;
    }

    public void setOurFund(List<OurFund> ourFund) {
        this.ourFund = ourFund;
    }
}
