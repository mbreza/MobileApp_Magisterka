package com.example.mbreza.wnb.service;

import com.example.mbreza.wnb.model.Users;

import java.util.List;
import io.reactivex.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Headers;


public interface  UsersService {

    @GET("/api/users/getall")
    Observable<List<Users>> getUsers();
}
