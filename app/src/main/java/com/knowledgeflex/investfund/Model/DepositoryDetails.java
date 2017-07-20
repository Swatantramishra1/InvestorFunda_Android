package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Vinoth on 2/14/2017.
 */
public class DepositoryDetails implements Serializable {

    @SerializedName("DepositoryDetails_ID")
    @Expose
    private String depositoryDetails_ID;
    @SerializedName("ClientType")
    @Expose
    private String clientType;
    @SerializedName("DepositoryName")
    @Expose
    private String depositoryName;
    @SerializedName("NSDLDP_ID")
    @Expose
    private String ns_DLDP_ID;
    @SerializedName("CDSLBenAcNo")
    @Expose
    private String cd_SLBenAcNo;
    @SerializedName("NSDLBenAcNo")
    @Expose
    private String ns_DLBenAcNo;

    public String getDepositoryDetails_ID() {
        return depositoryDetails_ID;
    }

    public void setDepositoryDetails_ID(String depositoryDetails_ID) {
        this.depositoryDetails_ID = depositoryDetails_ID;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getDepositoryName() {
        return depositoryName;
    }

    public void setDepositoryName(String depositoryName) {
        this.depositoryName = depositoryName;
    }

    public String getNs_DLDP_ID() {
        return ns_DLDP_ID;
    }

    public void setNs_DLDP_ID(String ns_DLDP_ID) {
        this.ns_DLDP_ID = ns_DLDP_ID;
    }

    public String getCd_SLBenAcNo() {
        return cd_SLBenAcNo;
    }

    public void setCd_SLBenAcNo(String cd_SLBenAcNo) {
        this.cd_SLBenAcNo = cd_SLBenAcNo;
    }

    public String getNs_DLBenAcNo() {
        return ns_DLBenAcNo;
    }

    public void setNs_DLBenAcNo(String ns_DLBenAcNo) {
        this.ns_DLBenAcNo = ns_DLBenAcNo;
    }
}
