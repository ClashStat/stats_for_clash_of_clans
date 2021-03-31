package com.parthapp.statsforclashofclans.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BadgeUrl {

    @SerializedName("medium")
    @Expose
    private String medium;


    public String getMedium()
    {
        return medium;
    }
}
