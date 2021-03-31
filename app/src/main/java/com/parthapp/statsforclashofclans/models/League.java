package com.parthapp.statsforclashofclans.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class League {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("iconUrls")
    @Expose
    private IconUrl iconUrls;

    public Integer getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public IconUrl getIconUrls() {
        return iconUrls;
    }
}
