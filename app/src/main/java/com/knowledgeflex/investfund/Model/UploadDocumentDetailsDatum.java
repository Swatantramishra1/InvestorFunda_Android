package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class UploadDocumentDetailsDatum implements Serializable {
    @SerializedName("DocumentName")
    @Expose
    private String documentName;
    @SerializedName("DocumentPath")
    @Expose
    private String documentPath;
    @SerializedName("DocumentType")
    @Expose
    private String documentType;
    @SerializedName("DocumentUpload_ID")
    @Expose
    private String documentUploadID;
    @SerializedName("IsMandatory")
    @Expose
    private String isMandatory;

    public String getDocumentName() {
        return this.documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentPath() {
        return this.documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    public String getDocumentType() {
        return this.documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentUploadID() {
        return this.documentUploadID;
    }

    public void setDocumentUploadID(String documentUploadID) {
        this.documentUploadID = documentUploadID;
    }

    public String getIsMandatory() {
        return this.isMandatory;
    }

    public void setIsMandatory(String isMandatory) {
        this.isMandatory = isMandatory;
    }
}
