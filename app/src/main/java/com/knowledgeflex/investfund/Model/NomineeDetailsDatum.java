package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class NomineeDetailsDatum implements Serializable {
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
    private String nomineeRelationshipId;
    @SerializedName("Nominee_Relationship_Name")
    @Expose
    private String nomineeRelationship;
    @SerializedName("Nominee_RiskType")
    @Expose
    private String nomineeRiskType;
    @SerializedName("UR_Nominee_ID")
    @Expose
    private String urNomineeId;
    @SerializedName("User_ID")
    @Expose
    private String user_Id;

    public String getNomineeAllocationPercentage() {
        return this.nomineeAllocationPercentage;
    }

    public void setNomineeAllocationPercentage(String nomineeAllocationPercentage) {
        this.nomineeAllocationPercentage = nomineeAllocationPercentage;
    }

    public String getNomineeDOB() {
        return this.nomineeDOB;
    }

    public void setNomineeDOB(String nomineeDOB) {
        this.nomineeDOB = nomineeDOB;
    }

    public String getNomineeName() {
        return this.nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getNomineeRelationship() {
        return this.nomineeRelationship;
    }

    public void setNomineeRelationship(String nomineeRelationship) {
        this.nomineeRelationship = nomineeRelationship;
    }

    public String getNomineeRiskType() {
        return this.nomineeRiskType;
    }

    public void setNomineeRiskType(String nomineeRiskType) {
        this.nomineeRiskType = nomineeRiskType;
    }

    public String getNomineeRelationshipId() {
        return nomineeRelationshipId;
    }

    public void setNomineeRelationshipId(String nomineeRelationshipId) {
        this.nomineeRelationshipId = nomineeRelationshipId;
    }

    public String getUrNomineeId() {
        return urNomineeId;
    }

    public void setUrNomineeId(String urNomineeId) {
        this.urNomineeId = urNomineeId;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }
}
