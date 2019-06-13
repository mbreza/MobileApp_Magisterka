package com.example.mbreza.wnb.service;

import com.example.mbreza.wnb.model.ResponseHandler;
import com.example.mbreza.wnb.model.Temp;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginService {

    @FormUrlEncoded
    @POST("/login")
    Observable<ResponseHandler> postLogin(@Field("username") String username, @Field("password") String password);

    @GET("/login")
    Completable getLogin();

    //@FormUrlEncoded
    @POST("/android/user/register")
    Observable<ResponseHandler> postUser(@Body Temp body);

    @GET("/api/status/check")
    Observable<String> getStatus();

}
