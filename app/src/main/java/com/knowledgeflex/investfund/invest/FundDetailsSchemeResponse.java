package com.knowledgeflex.investfund.invest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.knowledgeflex.investfund.Model.FundScheme;
import com.knowledgeflex.investfund.Model.FundsData;
import com.knowledgeflex.investfund.Model.Scheme;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Vinoth on 7/1/2017.
 */

public class FundDetailsSchemeResponse implements Serializable {
    @SerializedName("Schemelist")
    @Expose
    private SchemeList schemeList;

    public SchemeList getSchemeList() {
        return schemeList;
    }

    public void setSchemeList(SchemeList schemeList) {
        this.schemeList = schemeList;
    }

    public class SchemeList implements Serializable {
        @SerializedName("recordcount")
        @Expose
        private String recordCount;
        @SerializedName("Scheme")
        @Expose
        private FundScheme fundScheme;

        public FundScheme getFundScheme() {
            return fundScheme;
        }

        public void setFundScheme(FundScheme fundScheme) {
            this.fundScheme = fundScheme;
        }

        public String getRecordCount() {
            return recordCount;
        }

        public void setRecordCount(String recordCount) {
            this.recordCount = recordCount;
        }

    }
}
