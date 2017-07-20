package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListNomineeDetail {

    @SerializedName("Nominee_AllocationPercentage")
    @Expose
    private String nomineeAllocationPercentage;
    @SerializedName("Nominee_DOB")
    @Expose
    private String nomineeDOB;
    @SerializedName("Nominee_Name")
    @Expose
    private String nomineeName;
    @SerializedName("Nominee_Relationship_ID")
    @Expose
    private String nomineeRelationshipID;
    @SerializedName("Nominee_Relationship_Name")
    @Expose
    private String nomineeRelationshipName;
    @SerializedName("Nominee_RiskType")
    @Expose
    private String nomineeRiskType;
    @SerializedName("UR_Nominee_ID")
    @Expose
    private String urNomineeID;
    @SerializedName("User_ID")
    @Expose
    private String userID;

    public String getNomineeAllocationPercentage() {
        return nomineeAllocationPercentage;
    }

    public void setNomineeAllocationPercentage(String nomineeAllocationPercentage) {
        this.nomineeAllocationPercentage = nomineeAllocationPercentage;
    }

    public String getNomineeDOB() {
        return nomineeDOB;
    }

    public void setNomineeDOB(String nomineeDOB) {
        this.nomineeDOB = nomineeDOB;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getNomineeRelationshipID() {
        return nomineeRelationshipID;
    }

    public void setNomineeRelationshipID(String nomineeRelationshipID) {
        this.nomineeRelationshipID = nomineeRelationshipID;
    }

    public String getNomineeRelationshipName() {
        return nomineeRelationshipName;
    }

    public void setNomineeRelationshipName(String nomineeRelationshipName) {
        this.nomineeRelationshipName = nomineeRelationshipName;
    }

    public String getNomineeRiskType() {
        return nomineeRiskType;
    }

    public void setNomineeRiskType(String nomineeRiskType) {
        this.nomineeRiskType = nomineeRiskType;
    }

    public String getUrNomineeID() {
        return urNomineeID;
    }

    public void setUrNomineeID(String urNomineeID) {
        this.urNomineeID = urNomineeID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
