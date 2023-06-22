package com.example.medic;

import com.example.medic.Models.EmailCode;
import com.example.medic.Models.UserToken;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface MedicApi {

    @POST("sendCode")
    Call<EmailCode> sendCode(@Header("email") String email);

    @POST("signin")
    Call<UserToken> signIn(@Header("email") String email, @Header("code") Integer code);

    @GET("news")
    Call<Void> getNews();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://medic.madskill.ru/api/")
            .addConverterFactory(GsonConverterFactory.create()).build();
}
