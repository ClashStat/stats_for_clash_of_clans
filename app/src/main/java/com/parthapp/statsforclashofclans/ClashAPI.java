package com.parthapp.statsforclashofclans;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class ClashAPI {

    private final static String URL = "https://api.clashofclans.com/";
    private final static String API_VERSION = "v1";

    private final String token;
    private final OkHttpClient http;
    private final Gson gson;

    public ClashAPI(String token)
    {
        this.token = token;
        http = new OkHttpClient();
        gson = new Gson();
    }
    private Request buildReq(String suffix)
    {
        return new Request.Builder()
                .header("authorization", "Bearer " + token)
                .url(URL + API_VERSION + "/" + suffix)
                .build();
    }

}
