package com.example.mbreza.wnb.service;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public class CookieStore implements CookieJar {

    private final List<Cookie> cookieStore = new ArrayList<>();
    public static String token = null;

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        if (token == null) {
            String[] temp1 = cookies.get(0).toString().split("=");
            String[] temp2 = temp1[1].split(";");
            token = temp2[0];
        }

        if (cookies.size() != 0 && cookieStore.size() > 0) {
            cookieStore.clear();
        }

        cookieStore.addAll(cookies);
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        if (token != null) {
            Log.e("token", token);
        }
        for (Cookie cookie : cookieStore) {
            Log.e("ciastko", cookie.toString());
        }
        return cookieStore != null ? cookieStore : new ArrayList<Cookie>();
    }
}