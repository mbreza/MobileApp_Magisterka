package com.example.mbreza.wnb.model;

import android.graphics.Movie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Users {

    @Expose
    @SerializedName("user_id")
    private long user_id;

    @Expose
    @SerializedName("login")
    private String login;

    @Expose
    @SerializedName("password")
    private String password;

    @Expose
    @SerializedName("role")
    private String role;

    @Expose
    @SerializedName("verification_points")
    private int verification_points;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getVerification_points() {
        return verification_points;
    }

    public void setVerification_points(int verification_points) {
        this.verification_points = verification_points;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", verification_points=" + verification_points +
                '}';
    }
}
