package com.knowledgeflex.investfund.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Vinoth on 1/21/2017.
 */

public class CalculatePortfolio {

    public JSONObject CalculatePortfolioAllocation(int Year, int Amount, String Risk, String From,String Type) throws JSONException {
        JSONObject jsonObj = null;
        if (Risk.equals("")) {
            if (From.equals("ChildGoal")) {
                if (Year <= 3) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_Balanced\": \"100\", \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\": \"0\", \"Fund_UltraSortFund\": \"0\", \"Fund_MidCap\": \"0\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_LargeCap\" : \"30\", \"Fund_MultiCap\": \"20\", \"Fund_Balanced\": \"30\", \"Fund_UltraSortFund\": \"20\", \"Fund_MidCap\": \"0\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 3 && Year <= 5) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\" : \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_MultiCap\": \"100\", \"Fund_LargeCap\" : \"0\", \"Fund_Balanced\": \"0\", \"Fund_UltraSortFund\": \"0\", \"Fund_MidCap\": \"0\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000 && Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_LargeCap\" : \"25\", \"Fund_MultiCap\": \"25\", \"Fund_Balanced\": \"25\", \"Fund_CreditOpportunity\": \"25\", \"Fund_LiquidCap\": \"0\", \"Fund_MidCap\": \"0\", \"Fund_UltraSortFund\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_LargeCap\" : \"30\", \"Fund_MultiCap\": \"20\", \"Fund_Balanced\": \"20\", \"Fund_CreditOpportunity\": \"15\", \"Fund_LiquidCap\": \"15\", \"Fund_MidCap\": \"0\", \"Fund_UltraSortFund\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 5 && Year <= 10) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_MultiCap\": \"100\", \"Fund_LargeCap\" : \"0\", \"Fund_Balanced\": \"0\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_MidCap\": \"0\", \"Fund_UltraSortFund\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{\"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\",  \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_LargeCap\" : \"30\", \"Fund_MultiCap\": \"0\", \"Fund_MidCap\": \"20\", \"Fund_Balanced\": \"30\", \"Fund_UltraSortFund\": \"0\", \"Fund_CreditOpportunity\": \"20\", \"Fund_LiquidCap\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 10 && Year <= 15) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\": \"0\", \"Fund_MidCap\" : \"100\", \"Fund_Balanced\": \"0\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_UltraSortFund\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000 && Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_LargeCap\" : \"30\", \"Fund_MultiCap\": \"0\", \"Fund_MidCap\" : \"30\", \"Fund_Balanced\" : \"40\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_UltraSortFund\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_LargeCap\" : \"40\", \"Fund_MultiCap\": \"0\", \"Fund_MidCap\" : \"20\", \"Fund_Balanced\" : \"40\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_UltraSortFund\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }

                else if (Year > 15) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\": \"0\",\"Fund_MidCap\" : \"100\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_UltraSortFund\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000 && Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"10\", \"Fund\": [{ \"Fund_LargeCap\" : \"35\", \"Fund_MultiCap\": \"0\", \"Fund_MidCap\" : \"40\", \"Fund_Balanced\" : \"25\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_UltraSortFund\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"10\", \"Fund\": [{ \"Fund_LargeCap\" : \"40\", \"Fund_MultiCap\": \"0\",\"Fund_MidCap\" : \"40\", \"Fund_Balanced\" : \"20\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_UltraSortFund\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
            }
            else if (From.equals("Retirement")) {
                if (Year <= 5) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\": \"0\",\"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"100\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_UltraSortFund\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000 && Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\": \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"100\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_UltraSortFund\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000 && Amount <= 5000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"55\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"45\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\": \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"80\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_UltraSortFund\" : \"20\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 5000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"55\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"45\", \"Fund\": [{  \"Fund_MultiCap\": \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"50\", \"Fund_LargeCap\" : \"20\", \"Fund_UltraSortFund\" : \"30\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\"  }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year >= 5 && Year <= 10) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_MultiCap\" : \"100\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\"  }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000 && Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_MultiCap\" : \"100\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\"  }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000 && Amount <= 5000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"10\", \"Fund\": [{ \"Fund_MultiCap\" : \"40\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"30\",  \"Fund_LargeCap\" : \"30\", \"Fund_UltraSortFund\" : \"0\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 5000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"10\", \"Fund\": [{ \"Fund_MultiCap\" : \"40\",  \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"20\", \"Fund_LargeCap\" : \"30\", \"Fund_UltraSortFund\" : \"0\", \"Fund_CreditOpportunity\" : \"10\", \"Fund_LiquidCap\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year >= 10) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_MidCap\" : \"100\", \"Fund_MultiCap\" : \"0\",  \"Fund_Balanced\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000 && Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_MidCap\": \"100\", \"Fund_MultiCap\" : \"0\",  \"Fund_Balanced\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\": \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"80\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"20\", \"Fund\": [{ \"Fund_MidCap\" : \"40\", \"Fund_MultiCap\" : \"20\", \"Fund_Balanced\" : \"20\", \"Fund_LargeCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"20\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
            }
            else if (From.equals("ChildMarriage")) {
                if (Year <= 3) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_MidCap\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_Balanced\" : \"100\", \"Fund_LargeCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"30\", \"Fund_MultiCap\" : \"20\", \"Fund_Balanced\" : \"30\", \"Fund_UltraSortFund\" : \"20\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 3 && Year <= 5) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\" : \"100\", \"Fund_Balanced\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_CreditOpportunity\": \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000 && Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"25\", \"Fund_MultiCap\" : \"25\", \"Fund_Balanced\" : \"25\", \"Fund_CreditOpportunity\" : \"25\", \"Fund_UltraSortFund\" : \"0\", \"Fund_LiquidCap\": \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"30\", \"Fund_MultiCap\" : \"20\", \"Fund_Balanced\" : \"20\", \"Fund_LiquidCap\" : \"15\", \"Fund_CreditOpportunity\" : \"15\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 5 && Year <= 10) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\" : \"100\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\",  \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_MidCap\" : \"20\", \"Fund_LargeCap\" : \"30\", \"Fund_MultiCap\" : \"0\", \"Fund_Balanced\" : \"30\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }

                }
                else if (Year > 10 && Year <= 15) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_MidCap\" : \"100\", \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000 && Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_MidCap\" : \"30\", \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\" : \"30\", \"Fund_Balanced\" : \"40\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_MidCap\" : \"40\",  \"Fund_LargeCap\" : \"20\", \"Fund_MultiCap\" : \"0\", \"Fund_Balanced\" : \"40\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 15) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_MidCap\" : \"100\", \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000 && Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_LargeCap\" :35, \"Fund_MidCap\" : \"40\",  \"Fund_MultiCap\" : \"0\", \"Fund_Balanced\" : \"25\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_MidCap\" : \"40\", \"Fund_LargeCap\" : \"40\", \"Fund_MultiCap\" : \"0\", \"Fund_Balanced\" : \"20\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
            }
            else if (From.equals("CarPlan")) {
                if (Year <= 3) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{  \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\" : \"100\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"65\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"35\", \"Fund\": [{ \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"25\", \"Fund_MultiCap\" : \"25\", \"Fund_Balanced\" : \"25\",\"Fund_LiquidCap\" : \"0\",  \"Fund_CreditOpportunity\" : \"25\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }

                }
                else if (Year > 3 && Year <= 5) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\" : \"100\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\",  \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000 && Amount <= 5000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"65\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"35\", \"Fund\": [{ \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"25\", \"Fund_MultiCap\" : \"25\", \"Fund_Balanced\" : \"25\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"25\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"25\", \"Fund_MultiCap\" : \"30\", \"Fund_Balanced\" : \"25\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\"  }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 5 && Year <= 10) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{  \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"0\",  \"Fund_MultiCap\" : \"100\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000 && Amount <= 5000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"10\", \"Fund\": [{ \"Fund_LargeCap\" : \"40\",  \"Fund_MidCap\" : \"35\", \"Fund_MultiCap\" : \"0\", \"Fund_Balanced\" : \"25\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_LargeCap\" : \"30\", \"Fund_MidCap\" : \"30\", \"Fund_MultiCap\" : \"0\", \"Fund_Balanced\" : \"20\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 10 && Year <= 15) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_MidCap\" : \"100\", \"Fund_MultiCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000 && Amount <= 5000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"10\", \"Fund\": [{ \"Fund_LargeCap\" : \"25\",\"Fund_MultiCap\" : \"25\", \"Fund_MidCap\" : \"25\", \"Fund_Balanced\" : \"25\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"10\", \"Fund\": [{ \"Fund_LargeCap\" : \"20\", \"Fund_MultiCap\" : \"25\", \"Fund_Balanced\" : \"25\", \"Fund_MidCap\" : \"30\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 15) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_MidCap\" : \"100\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000 && Amount <= 5000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"10\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\" : \"25\", \"Fund_MidCap\" : \"50\", \"Fund_Balanced\" : \"25\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"10\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\" : \"25\", \"Fund_MidCap\" : \"55\", \"Fund_Balanced\" : \"20\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
            }
             else if (From.equals("HousePlan")) {
                if (Year <= 3) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{  \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\" : \"100\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"55\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"45\", \"Fund\": [{ \"Fund_LargeCap\" : \"25\", \"Fund_MultiCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"25\", \"Fund_Balanced\" : \"50\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 3 && Year <= 5) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\" : \"100\", \"Fund_MidCap\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000 && Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"65\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"35\", \"Fund\": [{ \"Fund_LargeCap\" : \"25\", \"Fund_MultiCap\" : \"25\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"25\", \"Fund_LiquidCap\" : \"0\",  \"Fund_CreditOpportunity\" : \"25\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_LargeCap\" : \"30\", \"Fund_MultiCap\" : \"20\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"30\",  \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year <= 5 && Year <= 10) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_MidCap\" : \"100\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"10\", \"Fund\": [{ \"Fund_LargeCap\" : \"30\", \"Fund_MultiCap\" : \"0\", \"Fund_MidCap\" : \"40\", \"Fund_Balanced\" : \"30\", \"Fund_LiquidCap\" : \"0\",  \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }

                else if (Year > 10 && Year <= 15) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_MidCap\" : \"100\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\",  \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000 && Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"10\", \"Fund\": [{ \"Fund_LargeCap\" : \"25\", \"Fund_MultiCap\" : \"0\", \"Fund_MidCap\" : \"50\", \"Fund_Balanced\" : \"25\", \"Fund_LiquidCap\" : \"0\",  \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"95\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"5\", \"Fund\": [{ \"Fund_LargeCap\" : \"35\", \"Fund_MultiCap\" : \"0\", \"Fund_MidCap\" : \"50\", \"Fund_Balanced\" : \"15\", \"Fund_LiquidCap\" : \"0\",  \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 15) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\" : \"0\",  \"Fund_MidCap\" : \"100\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\",  \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 1000 && Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"40\", \"Fund_MultiCap\" : \"0\", \"Fund_MidCap\" : \"60\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\",  \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"95\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"5\", \"Fund\": [{ \"Fund_LargeCap\" : \"25\", \"Fund_MultiCap\" : \"0\", \"Fund_MidCap\" : \"60\", \"Fund_Balanced\" : \"15\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
            }
        }
        else if (Type.equals("")) {
            //Risk Factor
            if (Risk.equals("Low")) {
                if (Year <= 3) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"0\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"100\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\",  \"Fund_UltraSortFund\" : \"100\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"20\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"80\", \"Fund\": [{ \"Fund_LargeCap\" : \"20\", \"Fund_MultiCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"30\", \"Fund_UltraSortFund\" : \"50\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 5 && Year <= 10) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\" : \"100\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"75\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"25\", \"Fund\": [{  \"Fund_LargeCap\" : \"40\", \"Fund_MultiCap\" : \"35\",  \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_BondFunds\" : \"25\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{  \"Fund_LargeCap\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_MidCap\" : \"100\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"80\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"20\", \"Fund\": [{ \"Fund_LargeCap\" : \"35\", \"Fund_MidCap\" : \"15\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_MultiCap\" : \"30\", \"Fund_UltraSortFund\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_BondFunds\" : \"20\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
            }
            else if (Risk.equals("Moderate")) {
                if (Year <= 3) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_MultiCap\" : \"100\", \"Fund_UltraSortFund\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_LargeCap\" : \"40\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_MultiCap\" : \"30\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_UltraSortFund\" : \"10\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 3 && Year <= 5) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_MultiCap\" : \"100\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_UltraSortFund\" : \"10\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"30\", \"Fund\": [{ \"Fund_LargeCap\" : \"40\",  \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_MultiCap\" : \"30\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_UltraSortFund\" : \"10\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    //else  {
                    //    String json = "{\"data\" : [{
                    //        \"Return_EquityPer\": \"60\",
                    //        \"Returm_DebtPer\": \"30\",
                    //        \"Returm_GoldPer\" : \"10\",
                    //        \"Fund\": Funds[{
                    //            \"Fund_LargeCap\" : \"40\",
                    //            \"Fund_MidCap\" : \"20\",
                    //            \"Fund_CreditOpportunity\" : \"20\",
                    //            \"Fund_LiquidCap\" : \"10\",
                    //            \"Fund_Gold\": \"10\"
                    //        }]
                    //    }]
                    //}

                }
                else if (Year > 5 && Year <= 10) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\",  \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_MultiCap\" : \"100\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"65\", \"Returm_DebtPer\": \"25\", \"Returm_GoldPer\" : \"10\", \"Fund\": [{ \"Fund_LargeCap\" : \"40\", \"Fund_MidCap\" : \"25\", \"Fund_Balanced\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_LiquidCap\" : \"5\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"10\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 10 && Year <= 15) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_MultiCap\" : \"100\", \"Fund_LargeCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_LiquidCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_DebtPer\": \"20\", \"Returm_GoldPer\" : \"10\", \"Fund\": [{ \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"40\", \"Fund_MidCap\" : \"30\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"10\", \"Fund_LiquidCap\" : \"10\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"10\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }

                else if (Year > 15 && Year <= 20) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\",  \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_MultiCap\" : \"100\", \"Fund_LargeCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"75\", \"Returm_DebtPer\": \"15\", \"Returm_GoldPer\" : \"10\", \"Fund\": [{ \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"40\", \"Fund_MidCap\" : \"35\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"10\", \"Fund_LiquidCap\" : \"5\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"10\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
            }
             else if (Risk.equals("High")) {
                if (Year <= 3) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_DebtPer\": \"0\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_MidCap\" : \"100\", \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000 && Amount >= 5000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_DebtPer\": \"0\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"60\", \"Fund_MidCap\" : \"40\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 5000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"10\", \"Fund\": [{ \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"50\", \"Fund_MidCap\" : \"30\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_LiquidCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 3 && Year <= 5) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"50\", \"Fund_MidCap\" : \"100\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000 && Amount >= 5000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"60\", \"Fund_MidCap\" : \"40\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 5000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"10\", \"Fund\": [{ \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"50\", \"Fund_MidCap\" : \"30\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"10\", \"Fund_LiquidCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 5 && Year <= 10) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\",  \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_MidCap\" : \"100\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"10\", \"Fund_LiquidCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"80\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"20\", \"Fund\": [{ \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"50\", \"Fund_MidCap\" : \"30\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_LiquidCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 10) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Returm_DebtPer\": \"0\", \"Fund\": [{ \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_MidCap\" : \"100\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_LiquidCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"80\", \"Returm_DebtPer\": \"20\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{  \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"40\", \"Fund_MidCap\" : \"40\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_LiquidCap\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
            }
        }
        else if (Type.equals("LUMPSUM")) {
            if (Risk.equals("Low")) {
                if (Year <= 1) {
                    if (Amount <= 20000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"0\", \"Returm_DebtPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LiquidCap\" : \"100\", \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 20000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"0\", \"Returm_DebtPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LiquidCap\" : \"100\", \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 1 && Year <= 3) {
                    String json = "{\"data\" : [{ \"Return_EquityPer\": \"0\", \"Returm_DebtPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{  \"Fund_LiquidCap\" : \"50\", \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"50\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                    jsonObj = new JSONObject(json);
                    return jsonObj;
                }
                else if (Year > 3 && Year <= 5) {
                    String json = "{\"data\" : [{ \"Return_EquityPer\": \"20\", \"Returm_DebtPer\": \"80\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LiquidCap\" : \"0\", \"Fund_LargeCap\" : \"20\", \"Fund_MultiCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_UltraSortFund\" : \"40\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"20\" }] }] }";
                    jsonObj = new JSONObject(json);
                    return jsonObj;
                }
                else if (Year > 5 && Year <= 10) {
                    String json = "{\"data\" : [{ \"Return_EquityPer\": \"40\", \"Returm_DebtPer\": \"60\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LiquidCap\" : \"0\", \"Fund_LargeCap\" : \"20\", \"Fund_MultiCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"30\", \"Fund_UltraSortFund\" : \"40\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"30\" }] }] }";
                    jsonObj = new JSONObject(json);
                    return jsonObj;
                }

                else if (Year > 10) {
                    String json = "{\"data\" : [{ \"Return_EquityPer\": \"50\", \"Returm_DebtPer\": \"50\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{  \"Fund_LiquidCap\" : \"0\",  \"Fund_LargeCap\" : \"30\",  \"Fund_MultiCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"30\", \"Fund_UltraSortFund\" : \"0\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"20\" }] }] }";
                    jsonObj = new JSONObject(json);
                    return jsonObj;
                }
            }
            else if (Risk.equals("Moderate")) {
                if (Year <= 1) {
                    if (Amount <= 20000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"0\", \"Returm_DebtPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{  \"Fund_LiquidCap\" : \"100\" , \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 20000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"0\", \"Returm_DebtPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{  \"Fund_LiquidCap\" : \"100\", \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 1 && Year <= 3) {
                    if (Amount <= 50000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"30\", \"Returm_DebtPer\": \"70\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{  \"Fund_LiquidCap\" : \"0\", \"Fund_Balanced\" : \"50\", \"Fund_UltraSortFund\" : \"50\", \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 50000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"50\", \"Returm_DebtPer\": \"50\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{    \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"20\", \"Fund_Balanced\" : \"40\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_UltraSortFund\" : \"20\", \"Fund_MultiCap\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 3 && Year <= 5) {
                    if (Amount <= 50000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"60\", \"Returm_DebtPer\": \"40\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"30\", \"Fund_Balanced\" : \"40\", \"Fund_CreditOpportunity\" : \"30\", \"Fund_UltraSortFund\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 50000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"60\", \"Returm_DebtPer\": \"40\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"30\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"40\", \"Fund_CreditOpportunity\" : \"30\", \"Fund_UltraSortFund\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 5 && Year <= 10) {
                    if (Amount <= 50000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"80\", \"Returm_DebtPer\": \"20\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_MultiCap\" : \"50\", \"Fund_CreditOpportunity\" : \"30\", \"Fund_Balanced\" : \"50\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 50000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"50\", \"Returm_DebtPer\": \"50\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{  \"Fund_LargeCap\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_MultiCap\" : \"50\", \"Fund_CreditOpportunity\" : \"30\", \"Fund_Balanced\" : \"50\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 15) {
                    if (Amount <= 50000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_DebtPer\": \"0\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"50\", \"Fund_MultiCap\" : \"50\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"30\", \"Fund_Balanced\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 50000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_DebtPer\": \"0\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"50\", \"Fund_MultiCap\" : \"50\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"30\", \"Fund_Balanced\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
            }
            else if (Risk.equals("High")) {
                if (Year <= 1) {
                    if (Amount <= 20000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"0\", \"Returm_DebtPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LiquidCap\" : \"100\", \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 20000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"0\", \"Returm_DebtPer\": \"100\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{  \"Fund_LiquidCap\" : \"100\", \"Fund_MultiCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 1 && Year <= 3) {
                    String json = "{\"data\" : [{ \"Return_EquityPer\": \"50\", \"Returm_DebtPer\": \"50\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LiquidCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"40\", \"Fund_MultiCap\" : \"20\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_UltraSortFund\" : \"20\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                    jsonObj = new JSONObject(json);
                    return jsonObj;
                }
                else if (Year > 3 && Year <= 5) {
                    String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_DebtPer\": \"30\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LiquidCap\" : \"0\",  \"Fund_LargeCap\" : \"30\", \"Fund_MidCap\" : \"0\", \"Fund_MultiCap\" : \"30\", \"Fund_Balanced\" : \"20\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                    jsonObj = new JSONObject(json);
                    return jsonObj;
                }
                else if (Year > 5 && Year <= 10) {
                    if (Amount <= 50000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_DebtPer\": \"10\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"50\", \"Fund_LargeCap\" : \"30\", \"Fund_MultiCap\" : \"0\", \"Fund_Balanced\" : \"20\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 50000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_DebtPer\": \"10\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"50\", \"Fund_LargeCap\" : \"30\", \"Fund_MultiCap\" : \"0\", \"Fund_Balanced\" : \"20\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
                else if (Year > 15) {
                    if (Amount <= 50000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_DebtPer\": \"10\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"50\", \"Fund_LargeCap\" : \"0\", \"Fund_Balanced\" : \"20\", \"Fund_MultiCap\" : \"30\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    else if (Amount > 50000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_DebtPer\": \"10\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{  \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"50\", \"Fund_LargeCap\" : \"0\", \"Fund_Balanced\" : \"20\", \"Fund_MultiCap\" : \"30\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
            }
        }
        else if (Type.equals("SIP")) {
            if (Risk.equals("Low")) {
                if (Year <= 3) {
                    if (Amount <= 1000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_DebtPer\": \"30\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_Balanced\" : \"100\", \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    } else if (Amount > 1000 && Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"50\", \"Returm_DebtPer\": \"50\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"50\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\" : \"25\", \"Fund_MultiCap\" : \"0\", \"Fund_UltraSortFund\" : \"25\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    } else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"50\", \"Returm_DebtPer\": \"50\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"50\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_LiquidCap\": \"30\", \"Fund_MultiCap\" : \"0\", \"Fund_UltraSortFund\" : \"20\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                } else if (Year > 3 && Year <= 5) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_DebtPer\": \"30\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_Balanced\" : \"100\", \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    } else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"50\", \"Returm_DebtPer\": \"50\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{   \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"20\", \"Fund_Balanced\" : \"40\", \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_BondFunds\" : \"20\", \"Fund_UltraSortFund\" : \"20\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                } else if (Year > 5 && Year <= 10) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"50\", \"Returm_DebtPer\": \"50\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"30\", \"Fund_LargeCap\" : \"30\", \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"40\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    } else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"60\", \"Returm_DebtPer\": \"40\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"30\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_MultiCap\" : \"20\", \"Fund_Balanced\" : \"20\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"30\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                } else if (Year > 10 && Year <= 15) {
                ///////////////////////////////////////////////////////
                    if (Amount <= 500) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"50\", \"Returm_DebtPer\": \"50\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{  \"Fund_LargeCap\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\", \"Fund_Balanced\" : \"100\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    } else {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_DebtPer\": \"30\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"50\", \"Fund_Balanced\" : \"50\"\"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                    //else {
                    //    String json = "{\"data\" : [{
                    //        \"Return_EquityPer\": \"20\",
                    //        \"Returm_DebtPer\": \"80\",
                    //        \"Returm_GoldPer\" : \"0\",
                    //        \"Fund\": [{
                    //            \"Fund_LiquidCap\" : \"10\",
                    //            \"Fund_BondFunds\" : \"50\",
                    //            \"Fund_LargeCap\" :10,
                    //            \"Fund_Gold\":10,
                    //            \"Fund_CreditOpportunity\" : \"20\"
                    //        }]
                    //    }]
                    //}

                } else if (Year > 15) {
                    if (Amount <= 500) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"50\", \"Returm_DebtPer\": \"50\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_Balanced\" : \"100\", \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    } else if (Amount > 500) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_DebtPer\": \"10\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"60\", \"Fund_Balanced\" : \"40\"\"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
            } else if (Risk.equals("Moderate")) {
                if (Year <= 3) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"70\", \"Returm_DebtPer\": \"30\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"0\", \"Fund_Balanced\" : \"100\", \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    } else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"50\", \"Returm_DebtPer\": \"50\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_MultiCap\" : \"30\", \"Fund_Balanced\" : \"30\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"0\",  \"Fund_CreditOpportunity\" : \"20\", \"Fund_UltraSortFund\" : \"20\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                } else if (Year > 3 && Year <= 5) {
                    if (Amount <= 500) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_DebtPer\": \"0\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"100\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    } else if (Amount > 500 && Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": 85, \"Returm_DebtPer\": \"15\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_Balanced\" : \"50\", \"Fund_MultiCap\" : \"50\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_LargeCap\" : \"0\",   \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    } else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"75\", \"Returm_DebtPer\": \"25\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"35\", \"Fund_Balanced\" : \"15\",  \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_MultiCap\" : \"30\", \"Fund_CreditOpportunity\" : \"20\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                } else if (Year > 5 && Year <= 10) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_DebtPer\": \"0\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{  \"Fund_LargeCap\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_MultiCap\" : \"100\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    } else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"80\", \"Returm_DebtPer\": \"20\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"20\", \"Fund_MultiCap\" : \"50\",  \"Fund_Balanced\" : \"15\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_CreditOpportunity\" : \"15\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                } else if (Year > 10 && Year <= 15) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_DebtPer\": \"0\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_MultiCap\" : \"100\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    } else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": 85, \"Returm_DebtPer\": \"15\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_Balanced\" : \"50\", \"Fund_LiquidCap\" : \"0\", \"Fund_LargeCap\" : \"25\", \"Fund_MidCap\" : \"25\" , \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                } else if (Year > 15) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_DebtPer\": \"0\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_MultiCap\" : \"100\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    } else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": 85, \"Returm_DebtPer\": \"15\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{  \"Fund_LargeCap\" : \"25\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"25\", \"Fund_Balanced\" : \"50\", \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
            } else if (Risk.equals("High")) {
                if (Year <= 3) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_DebtPer\": \"0\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"0\", \"Fund_MultiCap\" : \"100\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    } else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_DebtPer\": \"10\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{\"Fund_LargeCap\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"0\", \"Fund_Balanced\" : \"30\", \"Fund_MultiCap\" : \"70\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                } else if (Year > 3 && Year <= 5) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_DebtPer\": \"0\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"100\", \"Fund_Balanced\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    } else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_DebtPer\": \"10\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"70\", \"Fund_Balanced\" : \"30\", \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                } else if (Year > 5 && Year <= 10) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_DebtPer\": \"0\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"100\", \"Fund_Balanced\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    } else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"90\", \"Returm_DebtPer\": \"10\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"30\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"50\", \"Fund_Balanced\" : \"20\", \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                } else if (Year > 10) {
                    if (Amount <= 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_DebtPer\": \"0\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"0\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"100\", \"Fund_Balanced\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    } else if (Amount > 3000) {
                        String json = "{\"data\" : [{ \"Return_EquityPer\": \"100\", \"Returm_DebtPer\": \"0\", \"Returm_GoldPer\" : \"0\", \"Fund\": [{ \"Fund_LargeCap\" : \"40\", \"Fund_LiquidCap\" : \"0\", \"Fund_MidCap\" : \"60\", \"Fund_Balanced\" : \"0\", \"Fund_MultiCap\" : \"0\", \"Fund_CreditOpportunity\" : \"0\", \"Fund_UltraSortFund\" : \"0\", \"Fund_BondFunds\" : \"0\", \"Fund_Gold\": \"0\", \"Fund_GILT\" : \"0\" }] }] }";
                        jsonObj = new JSONObject(json);
                        return jsonObj;
                    }
                }
            }
        }
        return jsonObj;
    }

    public JSONObject goalJsonStructure() throws JSONException {

        String json = "{ \"data\" : [{ \"Rank\": \"1\", \"SchemeName\": \"SBI Bluechip Fund - Growth\", \"ISIN\": \"INF200K01180\",  \"BSESchmecode\": \"103G\",\"MinInvst\": \"500\",\"MFtype\": \"EQ large cap\",\"Minsip\": \"12\", \"date\": \"1,5,10,15,20,25,30\",\"multiplier\": \"100\"},  {\"Rank\": \"2\",\"SchemeName\": \"Quantum Long-Term Equity Fund - Growth\",\"ISIN\": \"INF082J01036\",\"BSESchmecode\": \"QMFEF-GP\",\"MinInvst\": \"500\",\"MFtype\": \"EQ large cap\",\"Minsip\": \"12\",\"date\": \"5,7,15,21,25,28\",\"multiplier\": \"500\"  },  {\"Rank\": \"3\",\"SchemeName\": \"Tata Equity P/E Fund - Reg - Growth\",\"ISIN\": \"INF277K01451\", \"BSESchmecode\": \"EPEG\",\"MinInvst\": \"500\",\"MFtype\": \"EQ large cap\",\"Minsip\": \"12\",\"date\": \"1-30 all days\",\"multiplier\": \"1\"  },  {\"Rank\": \"4\",\"SchemeName\": \"Templeton India Growth Fund - Growth\",\"ISIN\": \"INF090I01296\",\"BSESchmecode\": \"FTIGF-GR\",\"MinInvst\": \"500\",\"MFtype\": \"EQ large cap\",\"Minsip\": \"12\",\"date\": \"1,7,10,20,25\",\"multiplier\": \"1\"  },  {\"Rank\": \"5\",\"SchemeName\": \"Birla Sun Life India GenNext Fund - Growth\",\"ISIN\": \"INF209K01447\",\"BSESchmecode\": \"B291G\",\"MinInvst\": \"1000\",\"MFtype\": \"EQ large cap\",\"Minsip\": \"6\",\"date\": \"1,7,10,14,20,21, 25, 28\",\"multiplier\": \"1\"  },  {\"Rank\": \"6\",\"SchemeName\": \"DSP BlackRock Focus 25 Fund - Growth\",\"ISIN\": \"INF740K01532\",\"BSESchmecode\": \"DSP349-GR\",\"MinInvst\": \"500\",\"MFtype\": \"EQ large cap\",\"Minsip\": \"12\",\"date\": \"1,7,10,14,20,21, 25, 28\",\"multiplier\": \"1\"  },  {\"Rank\": \"1\",\"SchemeName\": \"ICICI Prudential Value Discovery Fund - Growth\",\"ISIN\": \"INF109K01AF8\",\"BSESchmecode\": \"DFG\",\"MinInvst\": \"1000\",\"MFtype\": \"EQ Multicap\",\"Minsip\": \"6\",\"date\": \"1,7,10,14,15,20,25\",\"multiplier\": \"1\"  },  {\"Rank\": \"2\",\"SchemeName\": \"Franklin India High Growth Companies Fund  - Growth\",\"ISIN\": \"INF090I01981\",\"BSESchmecode\": \"F273-GR\",\"MinInvst\": \"500\",\"MFtype\": \"EQ Multicap\",\"Minsip\": \"12\",\"date\": \"1,7,10,20,25\",\"multiplier\": \"1\"  },  {\"Rank\": \"3\",\"SchemeName\": \"L&T India Value Fund - Reg - Growth\",\"ISIN\": \"INF677K01023\",\"BSESchmecode\": \"FIVFG\",\"MinInvst\": \"500\",\"MFtype\": \"EQ Multicap\",\"Minsip\": \"6\",\"date\": \"1,5,10,15,20,25\",\"multiplier\": \"1\"  },  {\"Rank\": \"4\",\"SchemeName\": \"SBI Magnum Multi Cap Fund - Growth\",\"ISIN\": \"INF200K01222\",\"BSESchmecode\": \"099G\",\"MinInvst\": \"500\",\"MFtype\": \"EQ Multicap\",\"Minsip\": \"12\",\"date\": \"1,5,10,15,20,25,30\",\"multiplier\": \"1\"  },  {\"Rank\": \"5\",\"SchemeName\": \"Kotak Select Focus Fund - Reg - Growth\",\"ISIN\": \"INF174K01336\",\"BSESchmecode\": \"K168SF-GR\",\"MinInvst\": \"500\",\"MFtype\": \"EQ Multicap\",\"Minsip\": \"6\",\"date\": \"1,7,10,14,20,21, 25, 28\",\"multiplier\": \"1\"  },  {\"Rank\": \"6\",\"SchemeName\": \"Birla Sun Life Equity Fund - Growth\",\"ISIN\": \"INF209K01AJ8\",\"BSESchmecode\": \"51\",\"MinInvst\": \"1000\",\"MFtype\": \"EQ Multicap\",\"Minsip\": \"6\",\"date\": \"1,7,10,14,20,21, 25, 28\",\"multiplier\": \"1\"  },  {\"Rank\": \"1\",\"SchemeName\": \"DSP BlackRock Micro Cap Fund - Reg - Growth\",\"ISIN\": \"INF740K01797\",\"BSESchmecode\": \"DSP157-GR\",\"MinInvst\": \"500\",\"MFtype\": \"EQ Mid/small\",\"Minsip\": \"12\",\"date\": \"1,7,10,14,20,21, 25, 28\",\"multiplier\": \"1\"  },  {\"Rank\": \"2\",\"SchemeName\": \"Franklin India Smaller Companies Fund - Growth\",\"ISIN\": \"INF090I01569\",\"BSESchmecode\": \"F219-GR\",\"MinInvst\": \"500\",\"MFtype\": \"EQ Mid/small\",\"Minsip\": \"12\",\"date\": \"1,7,10,20,25\",\"multiplier\": \"1\"  },  {\"Rank\": \"3\",\"SchemeName\": \"Kotak Emerging Equity Scheme - Reg - Growth\",\"ISIN\": \"INF174K01DS9\",\"BSESchmecode\": \"K123-GR\",\"MinInvst\": \"1000\",\"MFtype\": \"EQ Mid/small\",\"Minsip\": \"6\",\"date\": \"1,7,10,14,20,21, 25, 28\",\"multiplier\": \"1\"  },  {\"Rank\": \"4\",\"SchemeName\": \"L&T Midcap Fund - Reg - Growth\",\"ISIN\": \"INF917K01254\", \"BSESchmecode\": \"LT17-GR\",\"MinInvst\": \"1000\",\"MFtype\": \"EQ Mid/small\",\"Minsip\": \"6\",\"date\": \"1,5,10,15,20,25,30\", \"multiplier\": \"1\"  },  {\"Rank\": \"5\",\"SchemeName\": \"Mirae Asset Emerging Bluechip Fund - Growth\",\"ISIN\": \"INF769K01101\",\"BSESchmecode\": \"MAFEBRG-GR\",\"MinInvst\": \"1000\",\"MFtype\": \"EQ Mid/small\",\"Minsip\": \"6\",\"date\": \"1,10,20,25,28\",\"multiplier\": \"1\"  },  {\"Rank\": \"6\",\"SchemeName\": \"Principal Emerging Bluechip Fund - Growth\",\"ISIN\": \"INF173K01155\",\"BSESchmecode\": \"PCEBRGG-GR\",\"MinInvst\": \"2000\",\"MFtype\": \"EQ Mid/small\",\"Minsip\": \"6\",\"date\": \"1,5,10,20\",\"multiplier\": \"1\"  },  {\"Rank\": \"1\",\"SchemeName\": \"Baroda Pioneer Liquid Fund - Plan B - Growth\",\"ISIN\": \"INF955L01AL0\",\"BSESchmecode\": \"BO114-GR\",\"MinInvst\": \"500\",\"MFtype\": \"Debt liquid\",\"Minsip\": \"12\",\"date\": \"1,10,15,25\",\"multiplier\": \"1\"  },  {\"Rank\": \"2\",\"SchemeName\": \"DSP BlackRock Treasury Bill Fund - Direct Plan - Growth\",\"ISIN\": \"INF740K01NU2\",\"BSESchmecode\": \"DS723-GR\",\"MinInvst\": \"500\",\"MFtype\": \"Debt liquid\",\"Minsip\": \"12\",\"date\": \"1,7,10,14,20,21, 25, 28\",\"multiplier\": \"1\"  },  {\"Rank\": \"3\",\"SchemeName\": \"DHFL Pramerica Insta Cash Plus Fund - Growth\",\"ISIN\": \"INF223J01BP6\",\"BSESchmecode\": \"DWSCFSG-GR\",\"MinInvst\": \"1000\",\"MFtype\": \"Debt liquid\",\"Minsip\": \"12\",\"date\": \"1,5,10,15,20,25,30\",\"multiplier\": \"100\"  },  {\"Rank\": \"4\",\"SchemeName\": \"Principal Cash Mgmt Fund - Growth\",\"ISIN\": \"INF173K01DA9\",\"BSESchmecode\": \"PCLFPGG-GR\",\"MinInvst\": \"2000\",\"MFtype\": \"Debt liquid\",\"Minsip\": \"6\",\"date\": \"1,5,10,20,25\",\"multiplier\": \"1\"  },  {\"Rank\": \"3\",\"SchemeName\": \"IDBI ULTRA SHORT TERM FUND REGULAR PLAN - GROWTH\",\"ISIN\": \"INF397L01745\",\"BSESchmecode\": \"IDBI-USGP-GR\",\"MinInvst\": \"500\",\"MFtype\": \"Debt/ ultra short\",\"Minsip\": \"12\",\"date\": \"5,15,25\",\"multiplier\": \"1\"  },  {\"Rank\": \"1\",\"SchemeName\": \"L&T ULTRA SHORT TERM FUND - GROWTH\",\"ISIN\": \"INF917K01AS7\",\"BSESchmecode\": \"LT122-GR\",\"MinInvst\": \"1000\",\"MFtype\": \"Debt/ ultra short\",\"Minsip\": \"6\",\"date\": \"1,5,10,15,20,25\",\"multiplier\": \"1\"  },  {\"Rank\": \"2\",\"SchemeName\": \"ICICI Prudential Ultra Short Term - Growth\",\"ISIN\": \"INF109K01CQ1\",\"BSESchmecode\": \"ICICI1477-GR\",\"MinInvst\": \"1000\",\"MFtype\": \"Debt/ ultra short\",\"Minsip\": \"6\",\"date\": \"1,7,10,15,20,25\",\"multiplier\": \"1\"  },  {\"Rank\": \"1\",\"SchemeName\": \"ICICI Prudential Flexible Income - Growth\",\"ISIN\": \"INF109K01746\",\"BSESchmecode\": \"FLEXI\",\"MinInvst\": \"1000\",\"MFtype\": \"Debt/Income\",\"Minsip\": \"6\",\"date\": \"1,7,10,15,20,25\",\"multiplier\": \"1\"  },  {\"Rank\": \"2\",\"SchemeName\": \"Birla Sun Life Dynamic Bond Fund - Ret - DAP\",\"ISIN\": \"INF209K01793\",\"BSESchmecode\": \"B321G\",\"MinInvst\": \"1000\",\"MFtype\": \"Debt/Income\",\"Minsip\": \"6\",\"date\": \"1,7,10,14,20,21, 25, 28\",\"multiplier\": \"1\"  },  {\"Rank\": \"3\",\"SchemeName\": \"Quantum Dynamic Bond Fund - Growth\",\"ISIN\": \"INF082J01176\",\"BSESchmecode\": \"QDBGP-GR\",\"MinInvst\": \"500\",\"MFtype\": \"Debt/Income\",\"Minsip\": \"6\",\"date\": \"5,7\",\"multiplier\": \"1\"  },  {\"Rank\": \"1\",\"SchemeName\": \"DHFL Pramerica Gilt Fund - Growth\",\"ISIN\": \"INF223J01AQ6\",\"BSESchmecode\": \"DWGFGP-GR\",\"MinInvst\": \"500\",\"MFtype\": \"Debt/ GILT\",\"Minsip\": \"10\",\"date\": \"1,7,10,15,25\",\"multiplier\": \"1\"  },  {\"Rank\": \"2\",\"SchemeName\": \"BNP Paribas G Sec Fund - Growth\",\"ISIN\": \"INF251K01JF9\",\"BSESchmecode\": \"BNP614G-GR\",\"MinInvst\": \"500\",\"MFtype\": \"Debt/ GILT\",\"Minsip\": \"10\",\"date\": \"1,7,10,15,25\",\"multiplier\": \"1\"  },  {\"Rank\": \"3\",\"SchemeName\": \"HDFC GILT FUND  - LONG TERM PLAN - GROWTH OPTION\",\"ISIN\": \"INF179K01756\",\"BSESchmecode\": \"GLG\",\"MinInvst\": \"1000\",\"MFtype\": \"Debt/ GILT\",\"Minsip\": \"10\",\"date\": \"1,7,10,21, 25, 28\",\"multiplier\": \"1\"  },  {\"Rank\": \"1\",\"SchemeName\": \"HDFC Balanced Fund - Growth\",\"ISIN\": \"INF179K01392\",\"BSESchmecode\": \"BFG\",\"MinInvst\": \"1000\",\"MFtype\": \"Balanced\",\"Minsip\": \"6\",\"date\": \"1,5,10,15,20,25\",\"multiplier\": \"100\"  },  {\"Rank\": \"2\",\"SchemeName\": \"Franklin India Balanced Fund - Growth\",\"ISIN\": \"INF090I01817\",\"BSESchmecode\": \"F045-GR\",\"MinInvst\": \"500\",\"MFtype\": \"Balanced\",\"Minsip\": \"12\",\"date\": \"1,7,10,20,25\",\"multiplier\": \"1\"  },  {\"Rank\": \"1\",\"SchemeName\": \"HDFC MF MONTHLY INCOME PLAN - LONG TERM PLAN - GROWTH  OPTION\",\"ISIN\": \"INF179K01AE4\",\"BSESchmecode\": \"MILTG\",\"MinInvst\": \"1000\",\"MFtype\": \"MIP\",\"Minsip\": \"6\",\"date\": \"1,5,10,15,20,25\",\"multiplier\": \"100\"  },  {\"Rank\": \"2\",\"SchemeName\": \"Birla Sun Life MIP II - Savings 5 - Reg - Growth\",\"ISIN\": \"INF209K01XE1\",\"BSESchmecode\": \"BS312GZ-GR\",\"MinInvst\": \"1000\",\"MFtype\": \"MIP\",\"Minsip\": \"6\",\"date\": \"1,7,10,15,20,28\",\"multiplier\": \"1\"  },  {\"Rank\": \"3\",\"SchemeName\": \"SBI Regular Savings Fund - Growth\",\"ISIN\": \"INF200K01636\",\"BSESchmecode\": \"079B\",\"MinInvst\": \"1000\",\"MFtype\": \"MIP\",\"Minsip\": \"12\",\"date\": \"1,5,10,15,20,25,30\",\"multiplier\": \"100\"  },  {\"Rank\": \"1\",\"SchemeName\": \"HDFC Corporate Debt Opportunities Fund\",\"ISIN\": \"INF179KA1GC0\",\"BSESchmecode\": \"CDOGR-GR\",\"MinInvst\": \"500\",\"MFtype\": \"Credit Opportunities\",\"Minsip\": \"12\",\"date\": \"1,5,15,20,25\",\"multiplier\": \"100\"  },  {\"Rank\": \"2\",\"SchemeName\": \"Kotak Income Opportunities Fund\",\"ISIN\": \"INF174K01DY7\",\"BSESchmecode\": \"K190-GR\",\"MinInvst\": \"1000\",\"MFtype\": \"Credit Opportunities\",\"Minsip\": \"6\",\"date\": \"1,7,14,21,25\",\"multiplier\": \"1\"  },  {\"Rank\": \"3\",\"SchemeName\": \"SBI Corporate Bond Fund\",\"ISIN\": \"INF200K01685\",\"BSESchmecode\": \"080B\",\"MinInvst\": \"500\",\"MFtype\": \"Credit Opportunities\",\"Minsip\": \"12\",\"date\": \"1,5,10,15,20,25,30\",\"multiplier\": \"100\"  },  {\"Rank\": \"4\",\"SchemeName\": \"Birla Sun Life Corporate Bond Fund\",\"ISIN\": \"INF209KA1K47\",\"BSESchmecode\": \"BL380B-GR\",\"MinInvst\": \"1000\",\"MFtype\": \"Credit Opportunities\",\"Minsip\": \"6\",\"date\": \"1,7,15,20,28\",\"multiplier\": \"1\"  },  {\"Rank\": \"1\",\"SchemeName\": \"Franklin India Taxshield - Growth\",\"ISIN\": \"INF090I01775\",\"BSESchmecode\": \"034-GR\",\"MinInvst\": \"500\",\"MFtype\": \"ELSS\",\"Minsip\": \"6\",\"date\": \"1,7,10,20,25\",\"multiplier\": \"500\"  },  {\"Rank\": \"2\",\"SchemeName\": \"Axis Long Term Equity Fund - Growth\",\"ISIN\": \"INF846K01131\",\"BSESchmecode\": \"AXFTSGP-GR\",\"MinInvst\": \"500\",\"MFtype\": \"ELSS\",\"Minsip\": \"6\",\"date\": \"1-30 all days\",\"multiplier\": \"500\"  },  {\"Rank\": \"3\",\"SchemeName\": \"Birla Sun Life Tax Relief 96 - Growth\",\"ISIN\": \"INF209K01108\",\"BSESchmecode\": \"02G\",\"MinInvst\": \"500\",\"MFtype\": \"ELSS\",\"Minsip\": \"6\",\"date\": \"1,7,10,14,15,21,20,28\",\"multiplier\": \"1\"  },  {\"Rank\": \"4\",\"SchemeName\": \"ICICI Prudential Long Term Equity Fund (Tax Saving) - Reg - Growth\",\"ISIN\": \"INF109K01464\",\"BSESchmecode\": \"1\",\"MinInvst\": \"500\",\"MFtype\": \"ELSS\",\"Minsip\": \"6\",\"date\": \"1,7,15,20,28\",\"multiplier\": \"1\"  },  {\"Rank\": \"5\",\"SchemeName\": \"HDFC TAXSAVER - GROWTH OPTION\",\"ISIN\": \"INF179K01BB8\",\"BSESchmecode\": \"32\",\"MinInvst\": \"500\",\"MFtype\": \"ELSS\",\"Minsip\": \"12\",\"date\": \"1,5,10,15,20,25\",\"multiplier\": \"500\"  },  {\"Rank\": \"6\",\"SchemeName\": \"LIC MF Tax Plan - Growth\",\"ISIN\": \"INF767K01956\",\"BSESchmecode\": \"LCTPGP-GR\",\"MinInvst\": \"500\",\"MFtype\": \"ELSS\",\"Minsip\": \"12\",\"date\": \"1,7,10,15,25\",\"multiplier\": \"500\"  },  {\"Rank\": \"7\",\"SchemeName\": \"KOTAK TAX SAVER-GROWTH\",\"ISIN\": \"INF174K01369\",\"BSESchmecode\": \"K144TS-GR\",\"MinInvst\": \"500\",\"MFtype\": \"ELSS\",\"Minsip\": \"6\",\"date\": \"1,7,10,14,20,21,25,28\",\"multiplier\": \"500\"  },  {\"Rank\": \"1\",\"SchemeName\": \"Canara Robeco Gold Savings FundDirect GrowthGrowth\",\"ISIN\": \"INF174K01369\",\"BSESchmecode\": \"CAGSDG-GR\",\"MinInvst\": \"500\",\"MFtype\": \"Gold\",\"Minsip\": \"6\",\"date\": \"1,5,15,20,25\",\"multiplier\": \"500\"  },  {\"Rank\": \"2\",\"SchemeName\": \"DSP BLACKROCK WORLD GOLD FUND - REGULAR PLAN - GROWTH\",\"ISIN\": \"INF740K01250\",\"BSESchmecode\": \"DSP179-GR\",\"MinInvst\": \"500\",\"MFtype\": \"Gold\",\"Minsip\": \"6\",\"date\": \"1,7,10,14,20,21,25,28\",\"multiplier\": \"1\"  },  {\"Rank\": \"3\",\"SchemeName\": \"Birla Sun Life Gold Fund Growth\",\"ISIN\": \"INF209K01PF4\",\"BSESchmecode\": \"BSL916G-GR\",\"MinInvst\": \"1000\",\"MFtype\": \"Gold\",\"Minsip\": \"6\",\"date\": \"1,7,10,14,20,21,25,28\",\"multiplier\": \"1\"  },  {\"Rank\": \"4\",\"SchemeName\": \"ICICI Prudential Regular Gold Savings Fund Growth\",\"ISIN\": \"INF109K01TK8\",\"BSESchmecode\": \"ICICI1815-GR\",\"MinInvst\": \"1000\",\"MFtype\": \"Gold\",\"Minsip\": \"6\", \"date\": \"1,5,10,15,20,25\", \"multiplier\": \"1\"  }] }";
        JSONObject jsonObj = new JSONObject(json);
        return jsonObj;
    }
}
