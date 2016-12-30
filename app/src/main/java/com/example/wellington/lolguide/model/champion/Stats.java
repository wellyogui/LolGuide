
package com.example.wellington.lolguide.model.champion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Stats implements Serializable{

    @SerializedName("armor")
    @Expose
    public Double armor;
    @SerializedName("armorperlevel")
    @Expose
    public Double armorperlevel;
    @SerializedName("attackdamage")
    @Expose
    public Double attackdamage;
    @SerializedName("attackdamageperlevel")
    @Expose
    public Double attackdamageperlevel;
    @SerializedName("attackrange")
    @Expose
    public Double attackrange;
    @SerializedName("attackspeedoffset")
    @Expose
    public Double attackspeedoffset;
    @SerializedName("attackspeedperlevel")
    @Expose
    public Double attackspeedperlevel;
    @SerializedName("crit")
    @Expose
    public Double crit;
    @SerializedName("critperlevel")
    @Expose
    public Double critperlevel;
    @SerializedName("hp")
    @Expose
    public Double hp;
    @SerializedName("hpperlevel")
    @Expose
    public Double hpperlevel;
    @SerializedName("hpregen")
    @Expose
    public Double hpregen;
    @SerializedName("hpregenperlevel")
    @Expose
    public Double hpregenperlevel;
    @SerializedName("movespeed")
    @Expose
    public Double movespeed;
    @SerializedName("mp")
    @Expose
    public Double mp;
    @SerializedName("mpperlevel")
    @Expose
    public Double mpperlevel;
    @SerializedName("mpregen")
    @Expose
    public Double mpregen;
    @SerializedName("mpregenperlevel")
    @Expose
    public Double mpregenperlevel;
    @SerializedName("spellblock")
    @Expose
    public Double spellblock;
    @SerializedName("spellblockperlevel")
    @Expose
    public Double spellblockperlevel;

}
