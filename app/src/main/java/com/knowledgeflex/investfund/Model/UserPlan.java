package com.knowledgeflex.investfund.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserPlan implements Serializable{

    @SerializedName("Plan_ID")
    @Expose
    private String plan_ID;
    @SerializedName("MasterPlan_ID")
    @Expose
    private String masterPlanId;
    @SerializedName("User_ID")
    @Expose
    private String user_ID;
    @SerializedName("GoalName")
    @Expose
    private String goal;
    @SerializedName("PresentAge")
    @Expose
    private String presentAge;
    @SerializedName("GoalTimeToStart")
    @Expose
    private String goalTimeToStart;
    @SerializedName("GoalDuration")
    @Expose
    private String goalDuration;
    @SerializedName("GoalPerYearCost")
    @Expose
    private int goalPerYearCost;
    @SerializedName("GoalPerYearLivingCost")
    @Expose
    private int goalPerYearLivingCost;
    @SerializedName("GoalLumpsum")
    @Expose
    private String goalLumpsum;
    @SerializedName("GoalInflationRate")
    @Expose
    private String goalInflationRate;
    @SerializedName("GoalTotalCost")
    @Expose
    private int goalTotalCost;
    @SerializedName("GoalLivingTotalCost")
    @Expose
    private int goalLivingTotalCost;
    @SerializedName("GoalTotalAmount")
    @Expose
    private int goalTotalAmount;
    @SerializedName("GoalTotalLumpsumAmount")
    @Expose
    private int goalTotalLumpsumAmount;
    @SerializedName("EstimatedInflationRate")
    @Expose
    private String estimatedInflationRate;
    @SerializedName("GoalDateOfSip")
    @Expose
    private String goalDateOfSip;
    @SerializedName("GoalRetirementYear")
    @Expose
    private String goalRetirementYear;
    @SerializedName("GoalRetirementExpense")
    @Expose
    private int goalRetirementExpense;
    @SerializedName("GoalRetirementMonthlyExpenditure")
    @Expose
    private int goalRetirementMonthlyExpenditure;
    @SerializedName("GoalHousePlanYear")
    @Expose
    private String goalHousePlanYear;
    @SerializedName("GoalHouseCurrentCost")
    @Expose
    private int goalHouseCurrentCost;
    @SerializedName("GoalHouseDownPayment")
    @Expose
    private int goalHouseDownPayment;
    @SerializedName("GoalHouseLoanYear")
    @Expose
    private String goalHouseLoanYear;
    @SerializedName("GoalChildMerrageBudgetAmount")
    @Expose
    private int goalChildMerrageBudgetAmount;
    @SerializedName("Risk")
    @Expose
    private String risk;

    public String getPlan_ID() {
        return plan_ID;
    }

    public void setPlan_ID(String plan_ID) {
        this.plan_ID = plan_ID;
    }

    public String getMasterPlanId() {
        return masterPlanId;
    }

    public void setMasterPlanId(String masterPlanId) {
        this.masterPlanId = masterPlanId;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getPresentAge() {
        return presentAge;
    }

    public void setPresentAge(String presentAge) {
        this.presentAge = presentAge;
    }

    public String getGoalTimeToStart() {
        return goalTimeToStart;
    }

    public void setGoalTimeToStart(String goalTimeToStart) {
        this.goalTimeToStart = goalTimeToStart;
    }

    public String getGoalDuration() {
        return goalDuration;
    }

    public void setGoalDuration(String goalDuration) {
        this.goalDuration = goalDuration;
    }

    public int getGoalPerYearCost() {
        return goalPerYearCost;
    }

    public void setGoalPerYearCost(int goalPerYearCost) {
        this.goalPerYearCost = goalPerYearCost;
    }

    public int getGoalPerYearLivingCost() {
        return goalPerYearLivingCost;
    }

    public void setGoalPerYearLivingCost(int goalPerYearLivingCost) {
        this.goalPerYearLivingCost = goalPerYearLivingCost;
    }

    public String getGoalLumpsum() {
        return goalLumpsum;
    }

    public void setGoalLumpsum(String goalLumpsum) {
        this.goalLumpsum = goalLumpsum;
    }

    public String getGoalInflationRate() {
        return goalInflationRate;
    }

    public void setGoalInflationRate(String goalInflationRate) {
        this.goalInflationRate = goalInflationRate;
    }

    public int getGoalTotalCost() {
        return goalTotalCost;
    }

    public void setGoalTotalCost(int goalTotalCost) {
        this.goalTotalCost = goalTotalCost;
    }

    public int getGoalLivingTotalCost() {
        return goalLivingTotalCost;
    }

    public void setGoalLivingTotalCost(int goalLivingTotalCost) {
        this.goalLivingTotalCost = goalLivingTotalCost;
    }

    public int getGoalTotalAmount() {
        return goalTotalAmount;
    }

    public void setGoalTotalAmount(int goalTotalAmount) {
        this.goalTotalAmount = goalTotalAmount;
    }

    public int getGoalTotalLumpsumAmount() {
        return goalTotalLumpsumAmount;
    }

    public void setGoalTotalLumpsumAmount(int goalTotalLumpsumAmount) {
        this.goalTotalLumpsumAmount = goalTotalLumpsumAmount;
    }

    public String getEstimatedInflationRate() {
        return estimatedInflationRate;
    }

    public void setEstimatedInflationRate(String estimatedInflationRate) {
        this.estimatedInflationRate = estimatedInflationRate;
    }

    public String getGoalDateOfSip() {
        return goalDateOfSip;
    }

    public void setGoalDateOfSip(String goalDateOfSip) {
        this.goalDateOfSip = goalDateOfSip;
    }

    public String getGoalRetirementYear() {
        return goalRetirementYear;
    }

    public void setGoalRetirementYear(String goalRetirementYear) {
        this.goalRetirementYear = goalRetirementYear;
    }

    public int getGoalRetirementExpense() {
        return goalRetirementExpense;
    }

    public void setGoalRetirementExpense(int goalRetirementExpense) {
        this.goalRetirementExpense = goalRetirementExpense;
    }

    public int getGoalRetirementMonthlyExpenditure() {
        return goalRetirementMonthlyExpenditure;
    }

    public void setGoalRetirementMonthlyExpenditure(int goalRetirementMonthlyExpenditure) {
        this.goalRetirementMonthlyExpenditure = goalRetirementMonthlyExpenditure;
    }

    public String getGoalHousePlanYear() {
        return goalHousePlanYear;
    }

    public void setGoalHousePlanYear(String goalHousePlanYear) {
        this.goalHousePlanYear = goalHousePlanYear;
    }

    public int getGoalHouseCurrentCost() {
        return goalHouseCurrentCost;
    }

    public void setGoalHouseCurrentCost(int goalHouseCurrentCost) {
        this.goalHouseCurrentCost = goalHouseCurrentCost;
    }

    public int getGoalHouseDownPayment() {
        return goalHouseDownPayment;
    }

    public void setGoalHouseDownPayment(int goalHouseDownPayment) {
        this.goalHouseDownPayment = goalHouseDownPayment;
    }

    public String getGoalHouseLoanYear() {
        return goalHouseLoanYear;
    }

    public void setGoalHouseLoanYear(String goalHouseLoanYear) {
        this.goalHouseLoanYear = goalHouseLoanYear;
    }

    public int getGoalChildMerrageBudgetAmount() {
        return goalChildMerrageBudgetAmount;
    }

    public void setGoalChildMerrageBudgetAmount(int goalChildMerrageBudgetAmount) {
        this.goalChildMerrageBudgetAmount = goalChildMerrageBudgetAmount;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }
}
