package com.example.mbreza.wnb.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Users {

    @Expose
    @SerializedName("user_id")
    private long user_id;

    @Expose
    @SerializedName("username")
    private String username;

    @Expose
    @SerializedName("password")
    private String password;

    @Expose
    @SerializedName("active")
    private boolean active;

    @Expose
    @SerializedName("login")
    private String login;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", login='" + login + '\'' +
                ", role='" + role + '\'' +
                ", verification_points=" + verification_points +
                '}';
    }
}
