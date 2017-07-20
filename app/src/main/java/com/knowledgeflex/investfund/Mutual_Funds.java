package com.knowledgeflex.investfund;

public class Mutual_Funds {
    String allocation;
    String fund_name;
    String investment_amt;
    String nav;

    public Mutual_Funds(String fund_name, String nav, String allocation, String investment_amt) {
        this.fund_name = fund_name;
        this.nav = nav;
        this.allocation = allocation;
        this.investment_amt = investment_amt;
    }

    public String getNav() {
        return this.nav;
    }

    public void setNav(String nav) {
        this.nav = nav;
    }

    public String getAllocation() {
        return this.allocation;
    }

    public void setAllocation(String allocation) {
        this.allocation = allocation;
    }

    public String getInvestment_amt() {
        return this.investment_amt;
    }

    public void setInvestment_amt(String investment_amt) {
        this.investment_amt = investment_amt;
    }

    public String getFund_name() {
        return this.fund_name;
    }

    public void setFund_name(String fund_name) {
        this.fund_name = fund_name;
    }
}
