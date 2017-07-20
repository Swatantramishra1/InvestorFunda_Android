package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserPortfolio implements Serializable{

    @SerializedName("Portfolio_ID")
    @Expose
    private String portfolio_ID;
    @SerializedName("Plan_ID")
    @Expose
    private String plan_ID;
    @SerializedName("User_ID")
    @Expose
    private String user_ID;
    @SerializedName("Equity")
    @Expose
    private int equity;
    @SerializedName("Debt")
    @Expose
    private int debt;
    @SerializedName("Gold")
    @Expose
    private int gold;
    @SerializedName("EstimatedTotalSIPAmt")
    @Expose
    private int estimatedTotalSIPAmt;
    @SerializedName("Scheme_IDs")
    @Expose
    private String schemeId;

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }

    public String getPortfolio_ID() {
        return portfolio_ID;
    }

    public void setPortfolio_ID(String portfolio_ID) {
        this.portfolio_ID = portfolio_ID;
    }

    public String getPlan_ID() {
        return plan_ID;
    }

    public void setPlan_ID(String plan_ID) {
        this.plan_ID = plan_ID;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public int getEquity() {
        return equity;
    }

    public void setEquity(int equity) {
        this.equity = equity;
    }

    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getEstimatedTotalSIPAmt() {
        return estimatedTotalSIPAmt;
    }

    public void setEstimatedTotalSIPAmt(int estimatedTotalSIPAmt) {
        this.estimatedTotalSIPAmt = estimatedTotalSIPAmt;
    }
}
