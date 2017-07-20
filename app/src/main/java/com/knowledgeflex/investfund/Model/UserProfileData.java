package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class UserProfileData implements Serializable {

    @SerializedName("Comments")
    @Expose
    private Object comments;
    @SerializedName("DateOfBirth")
    @Expose
    private Object dateOfBirth;
    @SerializedName("EmailID")
    @Expose
    private String emailID;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("HoldingNature_ID")
    @Expose
    private String holdingNatureId;
    @SerializedName("HoldingNature_Name")
    @Expose
    private String holdingNatureName;
    @SerializedName("Howdidyou")
    @Expose
    private String howdidyou;
    @SerializedName("Income")
    @Expose
    private String income;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("MiddleName")
    @Expose
    private String middleName;
    @SerializedName("MobileNo")
    @Expose
    private Object mobileNo;
    @SerializedName("PANNumber")
    @Expose
    private String panNumber;
    @SerializedName("SOW_ID")
    @Expose
    private String sOWID;
    @SerializedName("SOW_Name")
    @Expose
    private String sOWName;
    @SerializedName("TaxStatus_Name")
    @Expose
    private Object taxStatusName;
    @SerializedName("TaxStatus_ID")
    @Expose
    private Object taxStatusID;

   /* public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCityID() {
        return this.cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCountryId() {
        return this.countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }*/

    public Object getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Object dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailID() {
        return this.emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIncome() {
        return this.income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Object getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(Object mobileNo) {
        this.mobileNo = mobileNo;
    }

  /*  public String getPANNumber() {
        return this.pANNumber;
    }

    public void setPANNumber(String pANNumber) {
        this.pANNumber = pANNumber;
    }

    public Object getPinCode() {
        return this.pinCode;
    }

    public void setPinCode(Object pinCode) {
        this.pinCode = pinCode;
    }*/

    public String getSOWID() {
        return this.sOWID;
    }

    public void setSOWID(String sOWID) {
        this.sOWID = sOWID;
    }

    public Object getTaxStatusID() {
        return this.taxStatusID;
    }

    public void setTaxStatusID(Object taxStatusID) {
        this.taxStatusID = taxStatusID;
    }


    public Object getComments() {
        return comments;
    }

    public void setComments(Object comments) {
        this.comments = comments;
    }

    public String getHoldingNatureId() {
        return holdingNatureId;
    }

    public void setHoldingNatureId(String holdingNatureId) {
        this.holdingNatureId = holdingNatureId;
    }

    public String getHoldingNatureName() {
        return holdingNatureName;
    }

    public void setHoldingNatureName(String holdingNatureName) {
        this.holdingNatureName = holdingNatureName;
    }

    public String getHowdidyou() {
        return howdidyou;
    }

    public void setHowdidyou(String howdidyou) {
        this.howdidyou = howdidyou;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getsOWID() {
        return sOWID;
    }

    public void setsOWID(String sOWID) {
        this.sOWID = sOWID;
    }

    public String getsOWName() {
        return sOWName;
    }

    public void setsOWName(String sOWName) {
        this.sOWName = sOWName;
    }

    public Object getTaxStatusName() {
        return taxStatusName;
    }

    public void setTaxStatusName(Object taxStatusName) {
        this.taxStatusName = taxStatusName;
    }
}
