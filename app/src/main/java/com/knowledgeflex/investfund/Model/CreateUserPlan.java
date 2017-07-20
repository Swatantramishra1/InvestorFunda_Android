package com.knowledgeflex.investfund.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CreateUserPlan implements Serializable{

    @SerializedName("User_ID")
    @Expose
    private String userId;
    @SerializedName("userPlan")
    @Expose
    private UserPlan userPlan;
    @SerializedName("userPortfolio")
    @Expose
    private UserPortfolio userPortfolio;
    @SerializedName("InvestmentList")
    @Expose
    private List<InvestmentList> investmentList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserPortfolio getUserPortfolio() {
        return userPortfolio;
    }

    public void setUserPortfolio(UserPortfolio userPortfolio) {
        this.userPortfolio = userPortfolio;
    }

    public UserPlan getUserPlan() {
        return userPlan;
    }

    public void setUserPlan(UserPlan userPlan) {
        this.userPlan = userPlan;
    }

   /* public InvestmentList getInvestmentList() {
        return investmentList;
    }

    public void setInvestmentList(InvestmentList investmentList) {
        this.investmentList = investmentList;
    }*/

    public List<InvestmentList> getInvestmentList() {
        return investmentList;
    }

    public void setInvestmentList(List<InvestmentList> investmentList) {
        this.investmentList = investmentList;
    }
}
