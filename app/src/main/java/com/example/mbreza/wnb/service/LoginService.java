package com.example.mbreza.wnb.service;

import com.example.mbreza.wnb.model.Users;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginService {

    @FormUrlEncoded
    @POST("/login")
    Completable postLogin(@Field("_csrf") String csrf, @Field("username") String username, @Field("password") String password);

    @GET("/login")
    Completable getLogin();

    @GET("/api/status/check")
    Observable<String> getStatus();

}
