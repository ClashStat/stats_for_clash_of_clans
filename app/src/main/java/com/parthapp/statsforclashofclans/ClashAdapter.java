package com.parthapp.statsforclashofclans;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ClashAdapter {

    private static final String URL = "https://api.clashofclans.com";
    private final static String API_VERSION = "/v1";
    private final static String TAG = "Clash Adapter";

    private final String token;
    private final OkHttpClient http;
    public final Gson gson;

    public ClashAdapter(String token){
        this.token = token;
        http = new OkHttpClient();
        gson = new Gson();
    }

    private  Request buildReq(String suffix){
        return new Request.Builder()
                .header("authorization", "Bearer " + token)
                .url(URL + API_VERSION + "/" + suffix)
                .build();
    }

    private Response makeAPICall(String suffix) throws IOException {
        OkHttpClient client = new OkHttpClient();

        client.newCall(buildReq(suffix)).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    Log.i(TAG, response.body().string());
                }
            }
        });

    }


    public String formatTag(String tag){
        return tag.replace("#", "%23");
    }

    public void getPlayer(String playerTag) throws IOException {
        /*Response response = */makeAPICall("players/" + formatTag(playerTag));
//        Log.i(TAG, response.body().string());
    }

}
