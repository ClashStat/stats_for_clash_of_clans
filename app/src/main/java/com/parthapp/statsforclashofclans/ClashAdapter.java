package com.parthapp.statsforclashofclans;

import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ClashAdapter{
    private static final String URL = "https://api.clashofclans.com";
    private final static String API_VERSION = "/v1";
    private final static String TAG = "Clash Adapter";
    private static boolean exit = false;

    private final String token;
    private final OkHttpClient http;
    private Response resData;

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


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //function that retrieves data from the api and returns as a Response type res
                    resData = makeAPICall(suffix, gameTag);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        thread.join();
        thread.sleep(50);
        thread.setDaemon(true);
        return resData;
    }

    private static void stopThread() {
        exit = true;
    }

    public String formatTag(String tag){
        return tag.replace("#", "%23");
    }

}
