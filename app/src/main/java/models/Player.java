package com.parthapp.statsforclashofclans;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {

    /*private String name;
    private Integer townHallLevel;
    private Integer townHallWeaponLevel;
    private Integer expLevel;
    private Integer trophies;
    private Integer bestTrophies;
    private Integer warStars;
    private Integer attackWins;
    private Integer defenseWins;
    private Integer builderHallLevel;
    private Integer versusTrophies;
    private Integer bestVersusTrophies;
    private Integer versusBattleWins;
    private String role;
    private String league;*/
    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("townHallLevel")
    @Expose
    private Integer townHallLevel;
    @SerializedName("townHallWeaponLevel")
    @Expose
    private Integer townHallWeaponLevel;
    @SerializedName("expLevel")
    @Expose
    private Integer expLevel;
    @SerializedName("trophies")
    @Expose
    private Integer trophies;
    @SerializedName("bestTrophies")
    @Expose
    private Integer bestTrophies;
    @SerializedName("warStars")
    @Expose
    private Integer warStars;
    @SerializedName("attackWins")
    @Expose
    private Integer attackWins;
    @SerializedName("defenseWins")
    @Expose
    private Integer defenseWins;
    @SerializedName("builderHallLevel")
    @Expose
    private Integer builderHallLevel;
    @SerializedName("versusTrophies")
    @Expose
    private Integer versusTrophies;
    @SerializedName("bestVersusTrophies")
    @Expose
    private Integer bestVersusTrophies;
    @SerializedName("versusBattleWins")
    @Expose
    private Integer versusBattleWins;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("donations")
    @Expose
    private Integer donations;
    @SerializedName("donationsReceived")
    @Expose
    private Integer donationsReceived;
    @SerializedName("clan")
    @Expose
    private Clan clan;
    @SerializedName("league")
    @Expose
    private League league;
    @SerializedName("versusBattleWinCount")
    @Expose
    private Integer versusBattleWinCount;
    @SerializedName("troops")
    @Expose
    private List<Troop> troops = null;
    @SerializedName("heroes")
    @Expose
    private List<Troop> heroes = null;
    @SerializedName("spells")
    @Expose
    private List<Troop> spells = null;

}
