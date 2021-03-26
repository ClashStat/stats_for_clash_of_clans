package com.parthapp.statsforclashofclans.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Troop {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("level")
    @Expose
    private Integer level;

    @SerializedName("maxLevel")
    @Expose
    private Integer maxLevel;

    @SerializedName("village")
    @Expose
    private String village;


    public Integer getLevel()
    {
        return level;
    }

    public String getName()
    {
        return name;
    }

    public Integer getMaxLevel()
    {
        return maxLevel;
    }

    /**
     * Returns a <code>String</code> of the village name from which the troop comes from.
     *
     * @return <code>home</code> if the troop is from the main village<br>
     * <code>builderBase</code> if the troop is from the builder base
     */
    public String getVillage()
    {
        return village;
    }
}
