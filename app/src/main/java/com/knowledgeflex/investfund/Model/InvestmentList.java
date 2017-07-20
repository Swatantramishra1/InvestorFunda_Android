package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Vinoth on 3/2/2017.
 */
public class InvestmentList implements Serializable {

    @SerializedName("SchemeName")
    @Expose
    private String schemeName;
    @SerializedName("BSESchemeCode")
    @Expose
    private String bseSchemeCode;
    @SerializedName("ISIN")
    @Expose
    private String isIn;
    @SerializedName("DueDate")
    @Expose
    private String dueDate;
    @SerializedName("Amount")
    @Expose
    private int amount;
    @SerializedName("DateString")
    @Expose
    private String dateString;
    @SerializedName("Scheme_ID")
    @Expose
    private String scheme_ID;
    @SerializedName("InvestmentType")
    @Expose
    private String investmentType;

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getBseSchemeCode() {
        return bseSchemeCode;
    }

    public void setBseSchemeCode(String bseSchemeCode) {
        this.bseSchemeCode = bseSchemeCode;
    }

    public String getIsIn() {
        return isIn;
    }

    public void setIsIn(String isIn) {
        this.isIn = isIn;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getScheme_ID() {
        return scheme_ID;
    }

    public void setScheme_ID(String scheme_ID) {
        this.scheme_ID = scheme_ID;
    }

    public String getInvestmentType() {
        return investmentType;
    }

    public void setInvestmentType(String investmentType) {
        this.investmentType = investmentType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
