package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Vinoth on 6/15/2017.
 */

public class DocumentUpload implements Serializable {

    @SerializedName("documentPath")
    @Expose
    private String documentPath;
    @SerializedName("DocumentUpload_ID")
    @Expose
    private String documentUploadId;

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    public String getDocumentUploadId() {
        return documentUploadId;
    }

    public void setDocumentUploadId(String documentUploadId) {
        this.documentUploadId = documentUploadId;
    }
}
