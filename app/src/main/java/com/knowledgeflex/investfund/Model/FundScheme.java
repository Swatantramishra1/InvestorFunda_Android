package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Vinoth on 7/1/2017.
 */

public class FundScheme implements Serializable {
    @SerializedName("SchemeID")
    @Expose
    private String schemeID;
    @SerializedName("SchemeName")
    @Expose
    private String schemeName;
    @SerializedName("CategoryCode")
    @Expose
    private String categoryCode;
    @SerializedName("CategoryName")
    @Expose
    private String categoryName;
    @SerializedName("NAV")
    @Expose
    private String nav;
    @SerializedName("Return_3Yr")
    @Expose
    private String return_3Yr;
    @SerializedName("AMCName")
    @Expose
    private String amName;
    @SerializedName("SchemeOption")
    @Expose
    private String schemeOption;
    @SerializedName("SchemeType")
    @Expose
    private String schemeType;
    @SerializedName("mf_cocode")
    @Expose
    private String mf_code;
    @SerializedName("navdate")
    @Expose
    private String navdate;
    @SerializedName("FundName")
    @Expose
    private String fundName;
    @SerializedName("MainCategory")
    @Expose
    private String mainCategory;
    @SerializedName("VCLASS")
    @Expose
    private String vClass;
    @SerializedName("VCLASSCODE")
    @Expose
    private String vClassCode;
    @SerializedName("ISIN")
    @Expose
    private String isin;
    @SerializedName("Return_3Mon")
    @Expose
    private String return_3Mon;
    @SerializedName("Return_6Mon")
    @Expose
    private String return_6Mon;
    @SerializedName("Return_1Yr")
    @Expose
    private String return_1Yr;
    @SerializedName("Return_5Yr")
    @Expose
    private String return_5Yr;
    @SerializedName("objective")
    @Expose
    private String objective;
    @SerializedName("LaunchDate")
    @Expose
    private String launchDate;
    @SerializedName("BenchmarkName")
    @Expose
    private String benchMarkName;
    @SerializedName("AssetSize")
    @Expose
    private String assetSize;
    @SerializedName("MinimumInvestment")
    @Expose
    private String minimumInvestment;
    @SerializedName("DividendPercentage_Latest")
    @Expose
    private String dividendPercentage_Latest;
    @SerializedName("Bonus_Latest")
    @Expose
    private String bonus_Latest;
    @SerializedName("FundManager")
    @Expose
    private String fundManager;
    @SerializedName("ExitLoad")
    @Expose
    private String exitLoad;
    @SerializedName("IncrementalInvestment")
    @Expose
    private String incrementalInvestment;
    @SerializedName("ExpRatio")
    @Expose
    private String expRatio;
    @SerializedName("fiftytwoWHigh")
    @Expose
    private String fiftytwoWHigh;
    @SerializedName("fiftytwoWHighDate")
    @Expose
    private String fiftytwoWHighDate;
    @SerializedName("fiftytwoWLow")
    @Expose
    private String fiftytwoWLow;
    @SerializedName("fiftytwoWLowDate")
    @Expose
    private String fiftytwoWLowDate;
    @SerializedName("RTCode")
    @Expose
    private String rtCode;
    @SerializedName("BSE_SchemeCode")
    @Expose
    private String bse_SchemeCode;

    public String getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

    public String getvClass() {
        return vClass;
    }

    public void setvClass(String vClass) {
        this.vClass = vClass;
    }

    public String getvClassCode() {
        return vClassCode;
    }

    public void setvClassCode(String vClassCode) {
        this.vClassCode = vClassCode;
    }

    public String getNavdate() {
        return navdate;
    }

    public void setNavdate(String navdate) {
        this.navdate = navdate;
    }

    public String getSchemeID() {
        return schemeID;
    }

    public void setSchemeID(String schemeID) {
        this.schemeID = schemeID;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getNav() {
        return nav;
    }

    public void setNav(String nav) {
        this.nav = nav;
    }

    public String getReturn_3Yr() {
        return return_3Yr;
    }

    public void setReturn_3Yr(String return_3Yr) {
        this.return_3Yr = return_3Yr;
    }

    public String getAmName() {
        return amName;
    }

    public void setAmName(String amName) {
        this.amName = amName;
    }

    public String getSchemeOption() {
        return schemeOption;
    }

    public void setSchemeOption(String schemeOption) {
        this.schemeOption = schemeOption;
    }

    public String getSchemeType() {
        return schemeType;
    }

    public void setSchemeType(String schemeType) {
        this.schemeType = schemeType;
    }

    public String getMf_code() {
        return mf_code;
    }

    public void setMf_code(String mf_code) {
        this.mf_code = mf_code;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getReturn_3Mon() {
        return return_3Mon;
    }

    public void setReturn_3Mon(String return_3Mon) {
        this.return_3Mon = return_3Mon;
    }

    public String getReturn_6Mon() {
        return return_6Mon;
    }

    public void setReturn_6Mon(String return_6Mon) {
        this.return_6Mon = return_6Mon;
    }

    public String getReturn_1Yr() {
        return return_1Yr;
    }

    public void setReturn_1Yr(String return_1Yr) {
        this.return_1Yr = return_1Yr;
    }

    public String getReturn_5Yr() {
        return return_5Yr;
    }

    public void setReturn_5Yr(String return_5Yr) {
        this.return_5Yr = return_5Yr;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getBenchMarkName() {
        return benchMarkName;
    }

    public void setBenchMarkName(String benchMarkName) {
        this.benchMarkName = benchMarkName;
    }

    public String getAssetSize() {
        return assetSize;
    }

    public void setAssetSize(String assetSize) {
        this.assetSize = assetSize;
    }

    public String getMinimumInvestment() {
        return minimumInvestment;
    }

    public void setMinimumInvestment(String minimumInvestment) {
        this.minimumInvestment = minimumInvestment;
    }

    public String getDividendPercentage_Latest() {
        return dividendPercentage_Latest;
    }

    public void setDividendPercentage_Latest(String dividendPercentage_Latest) {
        this.dividendPercentage_Latest = dividendPercentage_Latest;
    }

    public String getBonus_Latest() {
        return bonus_Latest;
    }

    public void setBonus_Latest(String bonus_Latest) {
        this.bonus_Latest = bonus_Latest;
    }

    public String getFundManager() {
        return fundManager;
    }

    public void setFundManager(String fundManager) {
        this.fundManager = fundManager;
    }

    public String getExitLoad() {
        return exitLoad;
    }

    public void setExitLoad(String exitLoad) {
        this.exitLoad = exitLoad;
    }

    public String getIncrementalInvestment() {
        return incrementalInvestment;
    }

    public void setIncrementalInvestment(String incrementalInvestment) {
        this.incrementalInvestment = incrementalInvestment;
    }

    public String getExpRatio() {
        return expRatio;
    }

    public void setExpRatio(String expRatio) {
        this.expRatio = expRatio;
    }

    public String getFiftytwoWHigh() {
        return fiftytwoWHigh;
    }

    public void setFiftytwoWHigh(String fiftytwoWHigh) {
        this.fiftytwoWHigh = fiftytwoWHigh;
    }

    public String getFiftytwoWHighDate() {
        return fiftytwoWHighDate;
    }

    public void setFiftytwoWHighDate(String fiftytwoWHighDate) {
        this.fiftytwoWHighDate = fiftytwoWHighDate;
    }

    public String getFiftytwoWLow() {
        return fiftytwoWLow;
    }

    public void setFiftytwoWLow(String fiftytwoWLow) {
        this.fiftytwoWLow = fiftytwoWLow;
    }

    public String getFiftytwoWLowDate() {
        return fiftytwoWLowDate;
    }

    public void setFiftytwoWLowDate(String fiftytwoWLowDate) {
        this.fiftytwoWLowDate = fiftytwoWLowDate;
    }

    public String getRtCode() {
        return rtCode;
    }

    public void setRtCode(String rtCode) {
        this.rtCode = rtCode;
    }

    public String getBse_SchemeCode() {
        return bse_SchemeCode;
    }

    public void setBse_SchemeCode(String bse_SchemeCode) {
        this.bse_SchemeCode = bse_SchemeCode;
    }
}
