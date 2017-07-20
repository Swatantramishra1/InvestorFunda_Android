package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.knowledgeflex.investfund.fragment.BankDetails;
import com.knowledgeflex.investfund.fragment.UploadDocument;

import java.io.Serializable;
import java.util.ArrayList;

public class UserProfileInsert implements Serializable {

    @SerializedName("User_ID")
    @Expose
    private String userId;
    @SerializedName("userprofile")
    @Expose
    private UserProfile userProfile;
    @SerializedName("listAddress")
    @Expose
    private ArrayList<ListAddress> listAddress;
    @SerializedName("bankdetails")
    @Expose
    private BankDetail bankDetails;
    @SerializedName("depositorydetails")
    @Expose
    private DepositoryDetails depositoryDetails;
    @SerializedName("listNomineeDetails")
    @Expose
    private ArrayList<NomineeDetailsDatum> listNomineeDetails;
    @SerializedName("listDocumentDetails")
    @Expose
    private ArrayList<UploadDocumentDetailsDatum> listDocumentDetails;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    /*public ListAddress getListAddress() {
        return listAddress;
    }

    public void setListAddress(ListAddress listAddress) {
        this.listAddress = listAddress;
    }*/

    public BankDetail getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankDetail bankDetails) {
        this.bankDetails = bankDetails;
    }

   /* public ListNomineeDetail getListNomineeDetails() {
        return listNomineeDetails;
    }

    public void setListNomineeDetails(ListNomineeDetail listNomineeDetails) {
        this.listNomineeDetails = listNomineeDetails;
    }*/

    /*public ArrayList<ListNomineeDetail> getListNomineeDetails() {
        return listNomineeDetails;
    }

    public void setListNomineeDetails(ArrayList<ListNomineeDetail> listNomineeDetails) {
        this.listNomineeDetails = listNomineeDetails;
    }*/

    public ArrayList<NomineeDetailsDatum> getListNomineeDetails() {
        return listNomineeDetails;
    }

    public void setListNomineeDetails(ArrayList<NomineeDetailsDatum> listNomineeDetails) {
        this.listNomineeDetails = listNomineeDetails;
    }

    public ArrayList<UploadDocumentDetailsDatum> getListDocumentDetails() {
        return listDocumentDetails;
    }

    public void setListDocumentDetails(ArrayList<UploadDocumentDetailsDatum> listDocumentDetails) {
        this.listDocumentDetails = listDocumentDetails;
    }

    public ArrayList<ListAddress> getListAddress() {
        return listAddress;
    }

    public void setListAddress(ArrayList<ListAddress> listAddress) {
        this.listAddress = listAddress;
    }

    public DepositoryDetails getDepositoryDetails() {
        return depositoryDetails;
    }

    public void setDepositoryDetails(DepositoryDetails depositoryDetails) {
        this.depositoryDetails = depositoryDetails;
    }
}
