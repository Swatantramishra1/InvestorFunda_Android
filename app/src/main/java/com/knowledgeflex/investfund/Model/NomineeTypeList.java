package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class NomineeTypeList implements Serializable {
    @SerializedName("NomineeType_ID")
    @Expose
    private String nomineeTypeID;
    @SerializedName("NomineeTypeValue")
    @Expose
    private String nomineeTypeValue;

    public String getNomineeTypeValue() {
        return this.nomineeTypeValue;
    }

    public void setNomineeTypeValue(String nomineeTypeValue) {
        this.nomineeTypeValue = nomineeTypeValue;
    }

    public String getNomineeTypeID() {
        return this.nomineeTypeID;
    }

    public void setNomineeTypeID(String nomineeTypeID) {
        this.nomineeTypeID = nomineeTypeID;
    }
}
