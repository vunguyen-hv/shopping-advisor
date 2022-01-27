package com.example.seminarmobileprojectexam.API.client;

import com.example.seminarmobileprojectexam.API.model.loginAuth;
import com.example.seminarmobileprojectexam.API.model.registerAuth;
import com.example.seminarmobileprojectexam.API.model.updateAuth;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @POST("/signin")
    @FormUrlEncoded
    Call<loginAuth> login(@Field("email") String email,
                          @Field("password") String password);

    @POST("/signup")
    @FormUrlEncoded
    Call<registerAuth> register(@Field("email") String email,
                                @Field("username") String username,
                                @Field("password") String password);

    ;

    @POST("/update")
    @FormUrlEncoded
    Call<updateAuth> update(@Field("email") String email,
                            @Field("password") String password,
                            @Field("token") String token);
}