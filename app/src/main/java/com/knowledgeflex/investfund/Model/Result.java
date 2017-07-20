package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

public class Result implements Serializable {
    @SerializedName("State_ID")
    @Expose
    private String State_ID;
    @SerializedName("State_Name")
    @Expose
    private String State_Name;
    @SerializedName("BankAccountType")
    @Expose
    private ArrayList<BankAccountType> bankAccountType;
    @SerializedName("BankDetailsData")
    @Expose
    private BankDetailsData bankDetailsData;
    @SerializedName("BankList")
    @Expose
    private ArrayList<BankList> bankList;
    @SerializedName("AddressDetailsData")
    @Expose
    private ArrayList<AddressDetailsData> addressDetailsData;
    @SerializedName("City_ID")
    @Expose
    private String cityID;
    @SerializedName("City_Name")
    @Expose
    private String cityName;
    @SerializedName("Country_ID")
    @Expose
    private String countryID;
    @SerializedName("Country_Name")
    @Expose
    private String countryName;
    @SerializedName("DateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("EmailID")
    @Expose
    private String emailID;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("HoldingNature_ID")
    @Expose
    private String holdingNatureID;
    @SerializedName("Holding_Nature")
    @Expose
    private String holdingNatureName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("LoginID")
    @Expose
    private String loginID;
    @SerializedName("MiddleName")
    @Expose
    private String middleName;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("NomineeDetailsData")
    @Expose
    private ArrayList<NomineeDetailsDatum> nomineeDetailsData;
    @SerializedName("NomineeTypeList")
    @Expose
    private ArrayList<NomineeTypeList> nomineeTypeList;
    @SerializedName("PANNumber")
    @Expose
    private String pANNumber;
    @SerializedName("RelationList")
    @Expose
    private ArrayList<RelationList> relationList;
    @SerializedName("SourceOfWealth_ID")
    @Expose
    private String sourceOfWealthID;
    @SerializedName("SourceOf_Wealth")
    @Expose
    private String sourceOfWealthName;
    @SerializedName("TaxID")
    @Expose
    private String taxID;
    @SerializedName("TaxStatusName")
    @Expose
    private String taxStatusName;
    @SerializedName("UploadDocumentDetailsData")
    @Expose
    private ArrayList<UploadDocumentDetailsDatum> uploadDocumentDetailsData;
    @SerializedName("UserEmail")
    @Expose
    private String userEmail;
    @SerializedName("User_ID")
    @Expose
    private String userID;
    @SerializedName("Username")
    @Expose
    private String userName;
    @SerializedName("UserProfileData")
    @Expose
    private UserProfileData userProfileData;
    @SerializedName("UserRole")
    @Expose
    private String userRole;
    @SerializedName("UserName")
    @Expose
    private String username;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("IsComplete")
    @Expose
    private String isComplete;

    public Result() {
        this.bankAccountType = new ArrayList();
        this.bankList = new ArrayList();
        this.nomineeTypeList = new ArrayList();
        this.relationList = new ArrayList();
        this.nomineeDetailsData = new ArrayList();
        this.uploadDocumentDetailsData = new ArrayList();
    }

    public ArrayList<BankAccountType> getBankAccountType() {
        return this.bankAccountType;
    }

    public void setBankAccountType(ArrayList<BankAccountType> bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public ArrayList<BankList> getBankList() {
        return this.bankList;
    }

    public void setBankList(ArrayList<BankList> bankList) {
        this.bankList = bankList;
    }

    public ArrayList<NomineeTypeList> getNomineeTypeList() {
        return this.nomineeTypeList;
    }

    public void setNomineeTypeList(ArrayList<NomineeTypeList> nomineeTypeList) {
        this.nomineeTypeList = nomineeTypeList;
    }

    public ArrayList<RelationList> getRelationList() {
        return this.relationList;
    }

    public void setRelationList(ArrayList<RelationList> relationList) {
        this.relationList = relationList;
    }

    public String getHoldingNatureID() {
        return this.holdingNatureID;
    }

    public void setHoldingNatureID(String holdingNatureID) {
        this.holdingNatureID = holdingNatureID;
    }

    public String getHoldingNatureName() {
        return this.holdingNatureName;
    }

    public void setHoldingNatureName(String holdingNatureName) {
        this.holdingNatureName = holdingNatureName;
    }

    public String getSourceOfWealthID() {
        return this.sourceOfWealthID;
    }

    public void setSourceOfWealthID(String sourceOfWealthID) {
        this.sourceOfWealthID = sourceOfWealthID;
    }

    public String getSourceOfWealthName() {
        return this.sourceOfWealthName;
    }

    public void setSourceOfWealthName(String sourceOfWealthName) {
        this.sourceOfWealthName = sourceOfWealthName;
    }

    public String getTaxID() {
        return this.taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public String getTaxStatusName() {
        return this.taxStatusName;
    }

    public void setTaxStatusName(String taxStatusName) {
        this.taxStatusName = taxStatusName;
    }

    public String getCountryID() {
        return this.countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public String getState_ID() {
        return this.State_ID;
    }

    public void setState_ID(String state_ID) {
        this.State_ID = state_ID;
    }

    public String getState_Name() {
        return this.State_Name;
    }

    public void setState_Name(String state_Name) {
        this.State_Name = state_Name;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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

    public String getPANNumber() {
        return this.pANNumber;
    }

    public void setPANNumber(String pANNumber) {
        this.pANNumber = pANNumber;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return this.userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getLoginID() {
        return this.loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BankDetailsData getBankDetailsData() {
        return this.bankDetailsData;
    }

    public void setBankDetailsData(BankDetailsData bankDetailsData) {
        this.bankDetailsData = bankDetailsData;
    }

    public ArrayList<NomineeDetailsDatum> getNomineeDetailsData() {
        return this.nomineeDetailsData;
    }

    public void setNomineeDetailsData(ArrayList<NomineeDetailsDatum> nomineeDetailsData) {
        this.nomineeDetailsData = nomineeDetailsData;
    }

    public ArrayList<UploadDocumentDetailsDatum> getUploadDocumentDetailsData() {
        return this.uploadDocumentDetailsData;
    }

    public void setUploadDocumentDetailsData(ArrayList<UploadDocumentDetailsDatum> uploadDocumentDetailsData) {
        this.uploadDocumentDetailsData = uploadDocumentDetailsData;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public UserProfileData getUserProfileData() {
        return this.userProfileData;
    }

    public void setUserProfileData(UserProfileData userProfileData) {
        this.userProfileData = userProfileData;
    }

    public String getpANNumber() {
        return this.pANNumber;
    }

    public void setpANNumber(String pANNumber) {
        this.pANNumber = pANNumber;
    }

    public String getCityID() {
        return this.cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public ArrayList<AddressDetailsData> getAddressDetailsData() {
        return addressDetailsData;
    }

    public void setAddressDetailsData(ArrayList<AddressDetailsData> addressDetailsData) {
        this.addressDetailsData = addressDetailsData;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(String isComplete) {
        this.isComplete = isComplete;
    }
}
