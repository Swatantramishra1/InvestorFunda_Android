package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {
    @SerializedName("UR_Address1")
    @Expose
    private String uRAddress1;
    @SerializedName("UR_Address2")
    @Expose
    private String uRAddress2;
    @SerializedName("UR_City")
    @Expose
    private String uRCity;
    @SerializedName("UR_Comments")
    @Expose
    private String uRComments;
    @SerializedName("UR_County")
    @Expose
    private String uRCounty;
    @SerializedName("UR_DOB")
    @Expose
    private String uRDOB;
    @SerializedName("UR_Email")
    @Expose
    private String uREmail;
    @SerializedName("UR_First_Name")
    @Expose
    private String uRFirstName;
    @SerializedName("UR_Gender")
    @Expose
    private String uRGender;
    @SerializedName("UR_HoldingNature_ID")
    @Expose
    private String uRHoldingNatureID;
    @SerializedName("UR_Howdidyou")
    @Expose
    private String uRHowdidyou;
    @SerializedName("UR_Income")
    @Expose
    private String uRIncome;
    @SerializedName("UR_Middle_Name")
    @Expose
    private String uRMiddleName;
    @SerializedName("UR_Mobile")
    @Expose
    private String uRMobile;
    @SerializedName("UR_Ocucupation_ID")
    @Expose
    private String uROcucupationID;
    @SerializedName("UR_PanCardNo")
    @Expose
    private String uRPanCardNo;
    @SerializedName("UR_Password")
    @Expose
    private String uRPassword;
    @SerializedName("UR_Phone")
    @Expose
    private String uRPhone;
    @SerializedName("UR_PostCode")
    @Expose
    private String uRPostCode;
    @SerializedName("UR_SourceOfWealth_ID")
    @Expose
    private String uRSourceOfWealthID;
    @SerializedName("UR_Surname")
    @Expose
    private String uRSurname;
    @SerializedName("UR_TaxStatus_ID")
    @Expose
    private String uRTaxStatusID;

    public String getURFirstName() {
        return this.uRFirstName;
    }

    public void setURFirstName(String uRFirstName) {
        this.uRFirstName = uRFirstName;
    }

    public String getURMiddleName() {
        return this.uRMiddleName;
    }

    public void setURMiddleName(String uRMiddleName) {
        this.uRMiddleName = uRMiddleName;
    }

    public String getURSurname() {
        return this.uRSurname;
    }

    public void setURSurname(String uRSurname) {
        this.uRSurname = uRSurname;
    }

    public String getURPanCardNo() {
        return this.uRPanCardNo;
    }

    public void setURPanCardNo(String uRPanCardNo) {
        this.uRPanCardNo = uRPanCardNo;
    }

    public String getURPassword() {
        return this.uRPassword;
    }

    public void setURPassword(String uRPassword) {
        this.uRPassword = uRPassword;
    }

    public String getURGender() {
        return this.uRGender;
    }

    public void setURGender(String uRGender) {
        this.uRGender = uRGender;
    }

    public String getUREmail() {
        return this.uREmail;
    }

    public void setUREmail(String uREmail) {
        this.uREmail = uREmail;
    }

    public String getURMobile() {
        return this.uRMobile;
    }

    public void setURMobile(String uRMobile) {
        this.uRMobile = uRMobile;
    }

    public String getURPhone() {
        return this.uRPhone;
    }

    public void setURPhone(String uRPhone) {
        this.uRPhone = uRPhone;
    }

    public String getURPostCode() {
        return this.uRPostCode;
    }

    public void setURPostCode(String uRPostCode) {
        this.uRPostCode = uRPostCode;
    }

    public String getURAddress1() {
        return this.uRAddress1;
    }

    public void setURAddress1(String uRAddress1) {
        this.uRAddress1 = uRAddress1;
    }

    public String getURAddress2() {
        return this.uRAddress2;
    }

    public void setURAddress2(String uRAddress2) {
        this.uRAddress2 = uRAddress2;
    }

    public String getURCity() {
        return this.uRCity;
    }

    public void setURCity(String uRCity) {
        this.uRCity = uRCity;
    }

    public String getURCounty() {
        return this.uRCounty;
    }

    public void setURCounty(String uRCounty) {
        this.uRCounty = uRCounty;
    }

    public String getURHowdidyou() {
        return this.uRHowdidyou;
    }

    public void setURHowdidyou(String uRHowdidyou) {
        this.uRHowdidyou = uRHowdidyou;
    }

    public String getURComments() {
        return this.uRComments;
    }

    public void setURComments(String uRComments) {
        this.uRComments = uRComments;
    }

    public String getURTaxStatusID() {
        return this.uRTaxStatusID;
    }

    public void setURTaxStatusID(String uRTaxStatusID) {
        this.uRTaxStatusID = uRTaxStatusID;
    }

    public String getURDOB() {
        return this.uRDOB;
    }

    public void setURDOB(String uRDOB) {
        this.uRDOB = uRDOB;
    }

    public String getURSourceOfWealthID() {
        return this.uRSourceOfWealthID;
    }

    public void setURSourceOfWealthID(String uRSourceOfWealthID) {
        this.uRSourceOfWealthID = uRSourceOfWealthID;
    }

    public String getUROcucupationID() {
        return this.uROcucupationID;
    }

    public void setUROcucupationID(String uROcucupationID) {
        this.uROcucupationID = uROcucupationID;
    }

    public String getURIncome() {
        return this.uRIncome;
    }

    public void setURIncome(String uRIncome) {
        this.uRIncome = uRIncome;
    }

    public String getURHoldingNatureID() {
        return this.uRHoldingNatureID;
    }

    public void setURHoldingNatureID(String uRHoldingNatureID) {
        this.uRHoldingNatureID = uRHoldingNatureID;
    }
}
