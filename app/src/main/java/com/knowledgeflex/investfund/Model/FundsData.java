package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Vinoth on 1/30/2017.
 */

public class FundsData implements Serializable {
    @SerializedName("Schemelist")
    @Expose
    private SchemeList schemeList;

    public SchemeList getSchemeList() {
        return schemeList;
    }

    public void setSchemeList(SchemeList schemeList) {
        this.schemeList = schemeList;
    }

    public class SchemeList implements Serializable{
        @SerializedName("recordcount")
        @Expose
        private String recordCount;
        @SerializedName("Scheme")
        @Expose
        private List<Scheme> data;

        public String getRecordCount() {
            return recordCount;
        }

        public void setRecordCount(String recordCount) {
            this.recordCount = recordCount;
        }

        public List<Scheme> getData() {
            return data;
        }

        public void setData(List<Scheme> data) {
            this.data = data;
        }
    }
}
