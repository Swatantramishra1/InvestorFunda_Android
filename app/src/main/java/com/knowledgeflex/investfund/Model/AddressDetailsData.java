package com.knowledgeflex.investfund.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AddressDetailsData implements Serializable{

    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("AddressType")
    @Expose
    private String addressType;
    @SerializedName("Address_ID")
    @Expose
    private String address_ID;
    @SerializedName("CityID")
    @Expose
    private String cityID;
    @SerializedName("CityName")
    @Expose
    private String cityName;
    @SerializedName("CountryID")
    @Expose
    private String countryID;
    @SerializedName("CountryName")
    @Expose
    private String countryName;
    @SerializedName("PinCode")
    @Expose
    private String pinCode;
    @SerializedName("StateID")
    @Expose
    private String stateID;
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

    public String getAddress_ID() {
        return address_ID;
    }

    public void setAddress_ID(String address_ID) {
        this.address_ID = address_ID;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
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

    public String getStateID() {
        return stateID;
    }

    public void setStateID(String stateID) {
        this.stateID = stateID;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}

