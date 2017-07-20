package com.knowledgeflex.investfund.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Vinoth on 1/23/2017.
 */

public class EquityAndDebt implements Serializable {
    @SerializedName("Return_EquityPer")
    @Expose
    private String returnEquityPer;
    @SerializedName("Returm_GoldPer")
    @Expose
    private String returnGoldPer;
    @SerializedName("Return_DebtPer")
    @Expose
    private String returnDebtPer;
   /* @SerializedName("Fund")
    @Expose
    private List<Funds> funds;*/

    public String getReturnEquityPer() {
        return returnEquityPer;
    }

    public void setReturnEquityPer(String returnEquityPer) {
        this.returnEquityPer = returnEquityPer;
    }

    public String getReturnGoldPer() {
        return returnGoldPer;
    }

    public void setReturnGoldPer(String returnGoldPer) {
        this.returnGoldPer = returnGoldPer;
    }

    public String getReturnDebtPer() {
        return returnDebtPer;
    }

    public void setReturnDebtPer(String returnDebtPer) {
        this.returnDebtPer = returnDebtPer;
    }

   /* public List<Funds> getFunds() {
        return funds;
    }

    public void setFunds(List<Funds> funds) {
        this.funds = funds;
    }*/
}
