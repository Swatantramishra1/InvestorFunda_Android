package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Vinoth on 6/21/2017.
 */

public class ResultSchemeData implements Serializable {

    @SerializedName("UserInvestmentSchemeDetailsData")
    @Expose
    private ArrayList<UserInvestmentSchemeDetailsData> UserInvestmentSchemeDetailsData;

    public ArrayList<UserInvestmentSchemeDetailsData> getUserInvestmentSchemeDetailsData() {
        return UserInvestmentSchemeDetailsData;
    }

    public void setUserInvestmentSchemeDetailsData(ArrayList<UserInvestmentSchemeDetailsData> userInvestmentSchemeDetailsData) {
        UserInvestmentSchemeDetailsData = userInvestmentSchemeDetailsData;
    }
}
