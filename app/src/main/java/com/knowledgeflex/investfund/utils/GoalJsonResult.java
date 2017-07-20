package com.knowledgeflex.investfund.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Vinoth on 1/23/2017.
 */

public class GoalJsonResult implements Serializable  {

    @SerializedName("Rank")
    @Expose
    private String rank;
    @SerializedName("SchemeName")
    @Expose
    private String schemeName;
    @SerializedName("ISIN")
    @Expose
    private String isin;
    @SerializedName("BSESchmecode")
    @Expose
    private String bseSchemeCode;
    @SerializedName("MinInvst")
    @Expose
    private String minInvest;
    @SerializedName("MFtype")
    @Expose
    private String mftype;
    @SerializedName("Minsip")
    @Expose
    private String minSip;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("multiplier")
    @Expose
    private String multiplier;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getBseSchemeCode() {
        return bseSchemeCode;
    }

    public void setBseSchemeCode(String bseSchemeCode) {
        this.bseSchemeCode = bseSchemeCode;
    }

    public String getMinInvest() {
        return minInvest;
    }

    public void setMinInvest(String minInvest) {
        this.minInvest = minInvest;
    }

    public String getMftype() {
        return mftype;
    }

    public void setMftype(String mftype) {
        this.mftype = mftype;
    }

    public String getMinSip() {
        return minSip;
    }

    public void setMinSip(String minSip) {
        this.minSip = minSip;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(String multiplier) {
        this.multiplier = multiplier;
    }
}
