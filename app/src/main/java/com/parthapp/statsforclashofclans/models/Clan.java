package com.parthapp.statsforclashofclans.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clan {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("clanLevel")
    @Expose
    private Integer clanLevel;

    @SerializedName("badgeUrls")
    @Expose
    private BadgeUrl badgeUrl;

    //GETTERS
    public String getName()
    {
        return name;
    }

    public Integer getClanLevel()
    {
        return clanLevel;
    }

}
