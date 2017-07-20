package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ListAddress implements Serializable {

    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("AddressType")
    @Expose
    private String addressType;
    @SerializedName("Address_ID")
    @Expose
    private String addressId;
    @SerializedName("CityID")
    @Expose
    private String cityId;
    @SerializedName("CityName")
    @Expose
    private String cityName;
    @SerializedName("CountryBSECode")
    @Expose
    private String countryBSECode;
    @SerializedName("CountryID")
    @Expose
    private String countryId;
    @SerializedName("CountryName")
    @Expose
    private String countryName;
    @SerializedName("PinCode")
    @Expose
    private String pinCode;
   /* @SerializedName("SateBSECode")
    @Expose
    private String sateBSECode;*/
    @SerializedName("StateID")
    @Expose
    private String stateId;
    @SerializedName("StateName")
    @Expose
    private String stateName;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryBSECode() {
        return countryBSECode;
    }

    public void setCountryBSECode(String countryBSECode) {
        this.countryBSECode = countryBSECode;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

  /*  public String getSateBSECode() {
        return sateBSECode;
    }

    public void setSateBSECode(String sateBSECode) {
        this.sateBSECode = sateBSECode;
    }*/

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
