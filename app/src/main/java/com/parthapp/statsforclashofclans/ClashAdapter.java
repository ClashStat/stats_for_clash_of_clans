package com.parthapp.statsforclashofclans;

import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ClashAdapter extends Thread{
    private static final String URL = "https://api.clashofclans.com";
    private final static String API_VERSION = "/v1";
    private final static String TAG = "Clash Adapter";

    private final String token;
    private final OkHttpClient http;

    private String gameTag = "";
    private String suffix = "";
    Response resData;



    public ClashAdapter(String token) {
        this.token = token;
        http = new OkHttpClient();
    }

    private  Request buildReq(String suffix, String gameTag){
        return new Request.Builder()
                .header("authorization", "Bearer " + token)
                .url(URL + API_VERSION + "/" + suffix + gameTag)
                .build();
    }

    private Response makeAPICall(String suffix, String gameTag) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Response resData = client.newCall(buildReq(suffix, formatTag(gameTag))).execute();
        if (!resData.isSuccessful())
        {
            switch(resData.code())
            {
                case 400:
                    Log.e(TAG, "400");
                    break;
                case 403:
                    Log.e(TAG, "403");
                    break;
                case 404:
                    Log.e(TAG, "404");
                    break;
                case 429:
                    Log.e(TAG, "429");
                    break;
                case 503:
                    Log.e(TAG, "503");
                    break;
                default:
                    Log.e(TAG, "500");
                    break;
            }
        }
        return resData;
    }

    public Response makeThreadAPICall(String gameTag, String suffix) throws InterruptedException {
        this.gameTag = gameTag;
        this.suffix = suffix;

        Thread thread = new Thread(this);
        thread.start();
        thread.join();

        return resData;

    }

    public String formatTag(String tag){
        return tag.replace("#", "%23");
    }



    public void run() {

        try {
            resData = makeAPICall(suffix, gameTag);

//            json = new JSONObject(resData);
//            Log.i(TAG, "Here: " + json.toString());
        } catch (IOException e/*| JSONException e*/) {
            e.printStackTrace();
        }

    }
}
