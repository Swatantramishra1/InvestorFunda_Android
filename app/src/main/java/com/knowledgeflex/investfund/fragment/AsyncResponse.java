package com.knowledgeflex.investfund.fragment;


public interface AsyncResponse {
    void processFinish(String name, String dob, String relation, String relationId, String risk, String nomineeId, String alloc);
}
