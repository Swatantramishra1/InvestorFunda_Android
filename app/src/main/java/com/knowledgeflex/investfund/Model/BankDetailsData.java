package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class BankDetailsData implements Serializable {
    @SerializedName("BankDetails_ID")
    @Expose
    private String bankDetailsID;
    @SerializedName("BankName")
    @Expose
    private String bankName;
    @SerializedName("Bank_AccountNo")
    @Expose
    private String bankAccountNo;
    @SerializedName("Bank_AccountTypeID")
    @Expose
    private String bankAccountTypeID;
    @SerializedName("Bank_AccountTypeName")
    @Expose
    private String bankAccountTypeName;
    @SerializedName("Bank_ID")
    @Expose
    private Object bankID;
    @SerializedName("Bank_IFSC")
    @Expose
    private String bankIFSC;
    @SerializedName("NameAsPerBank")
    @Expose
    private String nameAsPerBank;

    public String getBankDetailsID() {
        return this.bankDetailsID;
    }

    public void setBankDetailsID(String bankDetailsID) {
        this.bankDetailsID = bankDetailsID;
    }

    public String getBankAccountNo() {
        return this.bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getBankAccountTypeID() {
        return this.bankAccountTypeID;
    }

    public void setBankAccountTypeID(String bankAccountTypeID) {
        this.bankAccountTypeID = bankAccountTypeID;
    }

    public Object getBankID() {
        return this.bankID;
    }

    public void setBankID(Object bankID) {
        this.bankID = bankID;
    }

    public String getBankIFSC() {
        return this.bankIFSC;
    }

    public void setBankIFSC(String bankIFSC) {
        this.bankIFSC = bankIFSC;
    }

    public String getNameAsPerBank() {
        return this.nameAsPerBank;
    }

    public void setNameAsPerBank(String nameAsPerBank) {
        this.nameAsPerBank = nameAsPerBank;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountTypeName() {
        return bankAccountTypeName;
    }

    public void setBankAccountTypeName(String bankAccountTypeName) {
        this.bankAccountTypeName = bankAccountTypeName;
    }
}
