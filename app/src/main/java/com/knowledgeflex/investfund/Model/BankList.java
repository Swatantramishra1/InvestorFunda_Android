package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class BankList implements Serializable {
    @SerializedName("Bank_ID")
    @Expose
    private String bankID;
    @SerializedName("Bank_Name")
    @Expose
    private String bankName;

    public String getBankID() {
        return this.bankID;
    }

    public void setBankID(String bankID) {
        this.bankID = bankID;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
