package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RelationList implements Serializable {
    @SerializedName("RelationToUser")
    @Expose
    private String relationToUser;
    @SerializedName("Relationship_ID")
    @Expose
    private String relationshipID;

    public String getRelationToUser() {
        return this.relationToUser;
    }

    public void setRelationToUser(String relationToUser) {
        this.relationToUser = relationToUser;
    }

    public String getRelationshipID() {
        return this.relationshipID;
    }

    public void setRelationshipID(String relationshipID) {
        this.relationshipID = relationshipID;
    }
}
