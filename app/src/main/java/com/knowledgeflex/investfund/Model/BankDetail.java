package com.knowledgeflex.investfund.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BankDetail implements Serializable {

    @SerializedName("BankDetails_ID")
    @Expose
    private String bankDetailsId;
    @SerializedName("User_ID")
    @Expose
    private String userId;
    @SerializedName("Bank_ID")
    @Expose
    private String bankId;
    @SerializedName("Bank_IFSC")
    @Expose
    private String Bank_IFSC;
    @SerializedName("Bank_AccountTypeID")
    @Expose
    private String bankAccountTypeId;
    @SerializedName("Bank_AccountNo")
    @Expose
    private String bankAccountNo;
    @SerializedName("NameAsPerBank")
    @Expose
    private String nameAsPerBank;

    public String getBankDetailsId() {
        return bankDetailsId;
    }

    public void setBankDetailsId(String bankDetailsId) {
        this.bankDetailsId = bankDetailsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBank_IFSC() {
        return Bank_IFSC;
    }

    public void setBank_IFSC(String bank_IFSC) {
        Bank_IFSC = bank_IFSC;
    }

    public String getBankAccountTypeId() {
        return bankAccountTypeId;
    }

    public void setBankAccountTypeId(String bankAccountTypeId) {
        this.bankAccountTypeId = bankAccountTypeId;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getNameAsPerBank() {
        return nameAsPerBank;
    }

    public void setNameAsPerBank(String nameAsPerBank) {
        this.nameAsPerBank = nameAsPerBank;
    }
}
