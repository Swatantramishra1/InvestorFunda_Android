package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Vinoth on 6/21/2017.
 */

public class UserInvestmentSchemeDetailsData implements Serializable {

    @SerializedName("Amount")
    @Expose
    private String amount;
    @SerializedName("BSESchemeCode")
    @Expose
    private String bseSchemeCode;
    @SerializedName("CurrentNav")
    @Expose
    private String currentNav;
    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("Folio")
    @Expose
    private String folio;
    @SerializedName("ISIN")
    @Expose
    private String ISIN;
    @SerializedName("InvestmentSchemePlan_ID")
    @Expose
    private String investmentSchemePlan_ID;
    @SerializedName("InvestmentType")
    @Expose
    private String investmentType;
    @SerializedName("MF_CurrentDate")
    @Expose
    private String mf_CurrentDate;
    @SerializedName("MasterPlanID")
    @Expose
    private String masterPlanID;
    @SerializedName("MasterPlanName")
    @Expose
    private String masterPlanName;
    @SerializedName("Plan_ID")
    @Expose
    private String plan_ID;
    @SerializedName("SchemeName")
    @Expose
    private String schemeName;
    @SerializedName("SchemeNav")
    @Expose
    private String schemeNav;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBseSchemeCode() {
        return bseSchemeCode;
    }

    public void setBseSchemeCode(String bseSchemeCode) {
        this.bseSchemeCode = bseSchemeCode;
    }

    public String getCurrentNav() {
        return currentNav;
    }

    public void setCurrentNav(String currentNav) {
        this.currentNav = currentNav;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getISIN() {
        return ISIN;
    }

    public void setISIN(String ISIN) {
        this.ISIN = ISIN;
    }

    public String getInvestmentSchemePlan_ID() {
        return investmentSchemePlan_ID;
    }

    public void setInvestmentSchemePlan_ID(String investmentSchemePlan_ID) {
        this.investmentSchemePlan_ID = investmentSchemePlan_ID;
    }

    public String getInvestmentType() {
        return investmentType;
    }

    public void setInvestmentType(String investmentType) {
        this.investmentType = investmentType;
    }

    public String getMf_CurrentDate() {
        return mf_CurrentDate;
    }

    public void setMf_CurrentDate(String mf_CurrentDate) {
        this.mf_CurrentDate = mf_CurrentDate;
    }

    public String getMasterPlanID() {
        return masterPlanID;
    }

    public void setMasterPlanID(String masterPlanID) {
        this.masterPlanID = masterPlanID;
    }

    public String getMasterPlanName() {
        return masterPlanName;
    }

    public void setMasterPlanName(String masterPlanName) {
        this.masterPlanName = masterPlanName;
    }

    public String getPlan_ID() {
        return plan_ID;
    }

    public void setPlan_ID(String plan_ID) {
        this.plan_ID = plan_ID;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getSchemeNav() {
        return schemeNav;
    }

    public void setSchemeNav(String schemeNav) {
        this.schemeNav = schemeNav;
    }
}
