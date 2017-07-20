package com.knowledgeflex.investfund.invest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Vinoth on 6/29/2017.
 */

public class OurFund implements Serializable {

    @SerializedName("Rank")
    @Expose
    private String rank;
    @SerializedName("Scheme_ID")
    @Expose
    private String scheme_ID;
    @SerializedName("SchemeName")
    @Expose
    private String schemeName;
    @SerializedName("ISIN")
    @Expose
    private String isin;
    @SerializedName("BSESchmecode")
    @Expose
    private String bSESchemecode;
    @SerializedName("MinInvst")
    @Expose
    private String minInvst;
    @SerializedName("MFtype")
    @Expose
    private String mfType;
    @SerializedName("Minsip")
    @Expose
    private String minSip;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("multiplier")
    @Expose
    private String multiplier;
    @SerializedName("Discription")
    @Expose
    private List<String> desc;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getScheme_ID() {
        return scheme_ID;
    }

    public void setScheme_ID(String scheme_ID) {
        this.scheme_ID = scheme_ID;
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

    public String getbSESchemecode() {
        return bSESchemecode;
    }

    public void setbSESchemecode(String bSESchemecode) {
        this.bSESchemecode = bSESchemecode;
    }

    public String getMinInvst() {
        return minInvst;
    }

    public void setMinInvst(String minInvst) {
        this.minInvst = minInvst;
    }

    public String getMfType() {
        return mfType;
    }

    public void setMfType(String mfType) {
        this.mfType = mfType;
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

    public List<String> getDesc() {
        return desc;
    }

    public void setDesc(List<String> desc) {
        this.desc = desc;
    }
}
