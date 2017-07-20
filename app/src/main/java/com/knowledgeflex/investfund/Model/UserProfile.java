package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserProfile implements Serializable {
    /*@SerializedName("ClientTypeCode")
    @Expose
    private String clientTypeCode;
    @SerializedName("UR_2ndApplicant")
    @Expose
    private String ur_2ndApplicant;
    @SerializedName("UR_3rdApplicant")
    @Expose
    private String ur_3rdApplicant;
    @SerializedName("ClientTypeID")
    @Expose
    private String clientTypeID;
    @SerializedName("Comments")
    @Expose
    private String comments;
    @SerializedName("CommunicationModeCode")
    @Expose
    private String communicationModeCode;
    @SerializedName("CommunicationModeID")
    @Expose
    private String communicationModeId;*/
    @SerializedName("CommunicationModeCode")
    @Expose
    private String communicationModeCode;
    @SerializedName("CommunicationModeID")
    @Expose
    private String communicationModeId;
    @SerializedName("DateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("DividentPayMode")
    @Expose
    private String dividentPayMode;
    @SerializedName("DividentPayMode_ID")
    @Expose
    private String dividentPayMode_ID;
    @SerializedName("EmailID")
    @Expose
    private String emailID;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("Gender")
    @Expose
    private String gender;
   /* @SerializedName("HoldingNatureBSECode")
    @Expose
    private String holdingNatureBSECode;*/
    @SerializedName("HoldingNature_ID")
    @Expose
    private String holdingNature_ID;
    @SerializedName("HoldingNature_Name")
    @Expose
    private String holdingNature_Name;
   /* @SerializedName("Howdidyou")
    @Expose
    private String howdidyou;
    @SerializedName("Income")
    @Expose
    private String income;*/
    @SerializedName("LastName")
    @Expose
    private String lastName;
   /* @SerializedName("MiddleName")
    @Expose
    private String middleName;*/
    @SerializedName("MobileNo")
    @Expose
    private String mobileNo;
    /*@SerializedName("Occupation_ID")
    @Expose
    private String occupationId;*/
    @SerializedName("PANNumber")
    @Expose
    private String panNumber;
   /* @SerializedName("Phone")
    @Expose
    private String phone;*/
    @SerializedName("RegistrationDate")
    @Expose
    private String registrationDate;
    /*@SerializedName("SOWBSECode")
    @Expose
    private String sowBseCode;*/
    @SerializedName("SOW_ID")
    @Expose
    private String sowId;
    @SerializedName("SOW_Name")
    @Expose
    private String sowName;
    /*@SerializedName("TaxStatusBSECode")
    @Expose
    private String taxStatusBSECode;*/
    @SerializedName("TaxStatus_ID")
    @Expose
    private String taxStatusId;
    @SerializedName("TaxStatus_Name")
    @Expose
    private String taxStatusName;
    @SerializedName("SecondApplicantPanCard")
    @Expose
    private String secondApplicantPanCard;
    @SerializedName("ThirdApplicantPanCard")
    @Expose
    private String thirdApplicantPanCard;
    @SerializedName("UR_2ndApplicant")
    @Expose
    private String secondApplicantName;
    @SerializedName("UR_3rdApplicant")
    @Expose
    private String thirdApplicantName;

/*
    public String getClientTypeCode() {
        return clientTypeCode;
    }
*/

   /* public void setClientTypeCode(String clientTypeCode) {
        this.clientTypeCode = clientTypeCode;
    }

    public String getUr_2ndApplicant() {
        return ur_2ndApplicant;
    }

    public void setUr_2ndApplicant(String ur_2ndApplicant) {
        this.ur_2ndApplicant = ur_2ndApplicant;
    }

    public String getUr_3rdApplicant() {
        return ur_3rdApplicant;
    }

    public void setUr_3rdApplicant(String ur_3rdApplicant) {
        this.ur_3rdApplicant = ur_3rdApplicant;
    }*/

   /* public String getClientTypeID() {
        return clientTypeID;
    }

    public void setClientTypeID(String clientTypeID) {
        this.clientTypeID = clientTypeID;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCommunicationModeCode() {
        return communicationModeCode;
    }

    public void setCommunicationModeCode(String communicationModeCode) {
        this.communicationModeCode = communicationModeCode;
    }

    public String getCommunicationModeId() {
        return communicationModeId;
    }

    public void setCommunicationModeId(String communicationModeId) {
        this.communicationModeId = communicationModeId;
    }*/

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /*public String getHoldingNatureBSECode() {
        return holdingNatureBSECode;
    }

    public void setHoldingNatureBSECode(String holdingNatureBSECode) {
        this.holdingNatureBSECode = holdingNatureBSECode;
    }*/

    public String getCommunicationModeCode() {
        return communicationModeCode;
    }

    public void setCommunicationModeCode(String communicationModeCode) {
        this.communicationModeCode = communicationModeCode;
    }

    public String getCommunicationModeId() {
        return communicationModeId;
    }

    public void setCommunicationModeId(String communicationModeId) {
        this.communicationModeId = communicationModeId;
    }

    public String getDividentPayMode() {
        return dividentPayMode;
    }

    public void setDividentPayMode(String dividentPayMode) {
        this.dividentPayMode = dividentPayMode;
    }

    public String getDividentPayMode_ID() {
        return dividentPayMode_ID;
    }

    public void setDividentPayMode_ID(String dividentPayMode_ID) {
        this.dividentPayMode_ID = dividentPayMode_ID;
    }

    public String getSecondApplicantPanCard() {
        return secondApplicantPanCard;
    }

    public void setSecondApplicantPanCard(String secondApplicantPanCard) {
        this.secondApplicantPanCard = secondApplicantPanCard;
    }

    public String getThirdApplicantPanCard() {
        return thirdApplicantPanCard;
    }

    public void setThirdApplicantPanCard(String thirdApplicantPanCard) {
        this.thirdApplicantPanCard = thirdApplicantPanCard;
    }

    public String getSecondApplicantName() {
        return secondApplicantName;
    }

    public void setSecondApplicantName(String secondApplicantName) {
        this.secondApplicantName = secondApplicantName;
    }

    public String getThirdApplicantName() {
        return thirdApplicantName;
    }

    public void setThirdApplicantName(String thirdApplicantName) {
        this.thirdApplicantName = thirdApplicantName;
    }

    public String getHoldingNature_ID() {
        return holdingNature_ID;
    }

    public void setHoldingNature_ID(String holdingNature_ID) {
        this.holdingNature_ID = holdingNature_ID;
    }

    public String getHoldingNature_Name() {
        return holdingNature_Name;
    }

    public void setHoldingNature_Name(String holdingNature_Name) {
        this.holdingNature_Name = holdingNature_Name;
    }

  /*  public String getHowdidyou() {
        return howdidyou;
    }

    public void setHowdidyou(String howdidyou) {
        this.howdidyou = howdidyou;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }*/

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }*/

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

  /*  public String getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(String occupationId) {
        this.occupationId = occupationId;
    }*/

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    /*public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }*/

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

  /*  public String getSowBseCode() {
        return sowBseCode;
    }

    public void setSowBseCode(String sowBseCode) {
        this.sowBseCode = sowBseCode;
    }*/

    public String getSowId() {
        return sowId;
    }

    public void setSowId(String sowId) {
        this.sowId = sowId;
    }

    public String getSowName() {
        return sowName;
    }

    public void setSowName(String sowName) {
        this.sowName = sowName;
    }

   /* public String getTaxStatusBSECode() {
        return taxStatusBSECode;
    }

    public void setTaxStatusBSECode(String taxStatusBSECode) {
        this.taxStatusBSECode = taxStatusBSECode;
    }
*/
    public String getTaxStatusId() {
        return taxStatusId;
    }

    public void setTaxStatusId(String taxStatusId) {
        this.taxStatusId = taxStatusId;
    }

    public String getTaxStatusName() {
        return taxStatusName;
    }

    public void setTaxStatusName(String taxStatusName) {
        this.taxStatusName = taxStatusName;
    }
}
