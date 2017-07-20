package com.knowledgeflex.investfund.invest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.knowledgeflex.investfund.API;
import com.knowledgeflex.investfund.Model.LoginResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Vinoth on 1/29/2017.
 */

public interface FundAPI {

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
    Retrofit retrofit = new Retrofit.Builder().baseUrl(API.FUND_BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();

    @GET("ListingFunds/{amcode}/{CategoryCode}/{SchemeOption}")
    Call<String> ListFunding(@Path("amcode") String amCode, @Path("CategoryCode") String cateCode,@Path("SchemeOption") String schemeOption);
}
