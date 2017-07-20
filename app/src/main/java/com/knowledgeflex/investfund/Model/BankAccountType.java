package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class BankAccountType implements Serializable {
    @SerializedName("AccountType")
    @Expose
    private String accountType;
    @SerializedName("AccountTypeID")
    @Expose
    private String accountTypeID;

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountTypeID() {
        return this.accountTypeID;
    }

    public void setAccountTypeID(String accountTypeID) {
        this.accountTypeID = accountTypeID;
    }
}
