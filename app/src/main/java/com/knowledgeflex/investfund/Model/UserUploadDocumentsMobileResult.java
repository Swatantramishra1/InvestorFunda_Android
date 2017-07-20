package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Vinoth on 6/15/2017.
 */

public class UserUploadDocumentsMobileResult implements Serializable {
    @SerializedName("UserUploadDocumentsMobileResult")
    @Expose
    private GetUserUploadDocumentsResult getUploadResult;

    public GetUserUploadDocumentsResult getGetUploadResult() {
        return getUploadResult;
    }

    public void setGetUploadResult(GetUserUploadDocumentsResult getUploadResult) {
        this.getUploadResult = getUploadResult;
    }
}
