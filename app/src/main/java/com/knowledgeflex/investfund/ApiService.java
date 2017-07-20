package com.knowledgeflex.investfund;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.knowledgeflex.investfund.Model.CreateUserPlan;
import com.knowledgeflex.investfund.Model.CreateUsersPlanResult;
import com.knowledgeflex.investfund.Model.DashBoardDetailsResult;
import com.knowledgeflex.investfund.Model.DocumentUpload;
import com.knowledgeflex.investfund.Model.GetAllListDetailsResult;
import com.knowledgeflex.investfund.Model.GetCityData;
import com.knowledgeflex.investfund.Model.GetCountryData;
import com.knowledgeflex.investfund.Model.GetDashInvestmentDetailsResult;
import com.knowledgeflex.investfund.Model.GetHoldingNatureData;
import com.knowledgeflex.investfund.Model.GetSourceOfWealthData;
import com.knowledgeflex.investfund.Model.GetStateData;
import com.knowledgeflex.investfund.Model.GetTaxStatus;
import com.knowledgeflex.investfund.Model.LoginResponse;
import com.knowledgeflex.investfund.Model.RegistrationRequest;
import com.knowledgeflex.investfund.Model.RegistrationResult;
import com.knowledgeflex.investfund.Model.UpdateUserDetailsResult;
import com.knowledgeflex.investfund.Model.UserDetailResponse;
import com.knowledgeflex.investfund.Model.UserProfileInsert;
import com.knowledgeflex.investfund.Model.UserUploadDocumentsMobileResult;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static okhttp3.logging.HttpLoggingInterceptor.*;

public interface ApiService {

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();

    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(Level.BODY)).connectTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES)
            .readTimeout(2, TimeUnit.MINUTES).build();

    Retrofit retrofit = new Builder().baseUrl(API.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create(gson)).build();

    @GET("Login/{username}/{password}")
    Call<LoginResponse> createLogin(@Path("username") String email, @Path("password") String pass);

    @POST("UserRegistration")
    Call<RegistrationResult> createRegistration(@Body RegistrationRequest registrationRequest);

    @POST("CreateUsersPlan")
    Call<CreateUsersPlanResult> createUserPlan(@Body CreateUserPlan createUserPlan);

    @GET("GetAllListDetails ")
    Call<GetAllListDetailsResult> getAllListDetails();

    @GET("GetCityDetails")
    Call<GetCityData> getCityResponse();

    @GET("GetCountryDetails")
    Call<GetCountryData> getCountryData();

    @GET("HoldingNature")
    Call<GetHoldingNatureData> getHoldingNatureResponse();

    @GET("GetSourceOfWealth")
    Call<GetSourceOfWealthData> getSourceOfWealthResponse();

    @GET("GetStateDetails")
    Call<GetStateData> getStateResponse();

    @GET("GetTaxStatus")
    Call<GetTaxStatus> getTaxStatusResponse();

    @GET("GetUserProfileDetailsInfo/{userID}")
    Call<UserDetailResponse> getUserDetail(@Path("userID") String str);

    @POST("UpdateUserDetails")
    Call<UpdateUserDetailsResult> updateUserDetails(@Body UserProfileInsert userProfileInsert);

    @POST("UserUploadDocumentsMobile")
    Call<UserUploadDocumentsMobileResult> userUploadDocuments(@Body DocumentUpload documentUpload);

    @GET("GetDashInvestmentDetails/{userId}")
    Call<DashBoardDetailsResult> getDashBoard(@Path("userId") String str);

}
