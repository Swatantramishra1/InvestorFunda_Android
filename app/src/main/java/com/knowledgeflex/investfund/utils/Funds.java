package com.knowledgeflex.investfund.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Vinoth on 1/23/2017.
 */

public class Funds implements Serializable {

    @SerializedName("Fund_LargeCap")
    @Expose
    private String fundLargeCap;
    @SerializedName("Fund_MultiCap")
    @Expose
    private String fundMultiCap;
    @SerializedName("Fund_BondFunds")
    @Expose
    private String fundBondFunds;
    @SerializedName("Fund_UltraSortFund")
    @Expose
    private String fundUltraSortFund;
    @SerializedName("Fund_MidCap")
    @Expose
    private String fundMidCap;
    @SerializedName("Fund_CreditOpportunity")
    @Expose
    private String fundCreditOpportunity;
    @SerializedName("Fund_Gold")
    @Expose
    private String fundGold;
    @SerializedName("Fund_LiquidCap")
    @Expose
    private String fundLiquidCap;

    public String getFundLargeCap() {
        return fundLargeCap;
    }

    public void setFundLargeCap(String fundLargeCap) {
        this.fundLargeCap = fundLargeCap;
    }

    public String getFundMultiCap() {
        return fundMultiCap;
    }

    public void setFundMultiCap(String fundMultiCap) {
        this.fundMultiCap = fundMultiCap;
    }

    public String getFundBondFunds() {
        return fundBondFunds;
    }

    public void setFundBondFunds(String fundBondFunds) {
        this.fundBondFunds = fundBondFunds;
    }

    public String getFundUltraSortFund() {
        return fundUltraSortFund;
    }

    public void setFundUltraSortFund(String fundUltraSortFund) {
        this.fundUltraSortFund = fundUltraSortFund;
    }

    public String getFundMidCap() {
        return fundMidCap;
    }

    public void setFundMidCap(String fundMidCap) {
        this.fundMidCap = fundMidCap;
    }

    public String getFundCreditOpportunity() {
        return fundCreditOpportunity;
    }

    public void setFundCreditOpportunity(String fundCreditOpportunity) {
        this.fundCreditOpportunity = fundCreditOpportunity;
    }

    public String getFundGold() {
        return fundGold;
    }

    public void setFundGold(String fundGold) {
        this.fundGold = fundGold;
    }

    public String getFundLiquidCap() {
        return fundLiquidCap;
    }

    public void setFundLiquidCap(String fundLiquidCap) {
        this.fundLiquidCap = fundLiquidCap;
    }
}
